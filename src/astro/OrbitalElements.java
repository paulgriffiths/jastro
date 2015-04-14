/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

import static java.lang.Math.cos;
import static java.lang.Math.hypot;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Orbital (Keplerian) elements class.
 * 
 * @author Paul Griffiths
 */
public abstract class OrbitalElements {
    
    /**  Semi-major axis  */
    private final double sma;
    
    /**  Eccentricity  */
    private final double ecc;
    
    /**  Inclination  */
    private final double inc;
    
    /**  Mean longitude  */
    private final double ml;
    
    /**  Longitude perihelion  */
    private final double lp;
    
    /**  Longitude ascending node  */
    private final double lan;
    
    /**
     * Factory function for J2000 epoch elements
     * 
     * @param sma   Semi-major axis
     * @param ecc   Eccentricity
     * @param inc   Inclination
     * @param ml    Mean longitude
     * @param lp    Longitude perihelion
     * @param lan   Longitude of ascending node
     * @return      The newly created orbital elements object
     */
    public static OrbitalElements newJ2000Elements(final double sma,
                                                   final double ecc,
                                                   final double inc,
                                                   final double ml,
                                                   final double lp,
                                                   final double lan) {
        return new OrbitalElementsJ2000(sma, ecc, inc, ml, lp, lan);                 
    }
    
    /**
     * Factory function for Y2000 epoch elements
     * 
     * @param sma   Semi-major axis
     * @param ecc   Eccentricity
     * @param inc   Inclination
     * @param ml    Mean longitude
     * @param lp    Longitude perihelion
     * @param lan   Longitude of ascending node
     * @return      The newly created orbital elements object
     */
    public static OrbitalElements newY2000Elements(final double sma,
                                                   final double ecc,
                                                   final double inc,
                                                   final double ml,
                                                   final double lp,
                                                   final double lan) {
        return new OrbitalElementsY2000(sma, ecc, inc, ml, lp, lan);                 
    }
    
    /**
     * Class constructor.
     * 
     * Protected constructor, objects created solely through factory functions.
     * 
     * @param sma   Semi-major axis
     * @param ecc   Eccentricity
     * @param inc   Inclination
     * @param ml    Mean longitude
     * @param lp    Longitude perihelion
     * @param lan   Longitude of ascending node
     */
    protected OrbitalElements(final double sma,
                              final double ecc,
                              final double inc,
                              final double ml,
                              final double lp,
                              final double lan) {
        this.sma = sma;
        this.ecc = ecc;
        this.inc = toRadians(inc);
        this.ml = toRadians(ml);
        this.lp = toRadians(lp);
        this.lan = toRadians(lan);
    }
    
    /**
     * Class constructor for point-in-time.
     * 
     * @param epoch     Orbital elements at an epoch
     * @param periodic  Orbital elements delta per change in period
     * @param periods   Number of periods
     */
    protected OrbitalElements(final OrbitalElements epoch,
                              final OrbitalElements periodic,
                              final double periods) {
        sma = epoch.sma + periodic.sma * periods;
        ecc = epoch.ecc + periodic.ecc * periods;
        inc = epoch.inc + periodic.inc * periods;
        ml = epoch.ml + periodic.ml * periods;
        lp = epoch.lp + periodic.lp * periods;
        lan = epoch.lan + periodic.lan * periods;
    }
    
    /**
     * Returns a new element object at the specified date.
     * 
     * @param periodElems   The orbital elements delta for the relevant period
     * @param date          The date at which to create
     * @return              The orbital elements object at the specified date
     */
    public abstract OrbitalElements getDateElements(final OrbitalElements periodElems,
                                                    final Date date);
    
    /**
     * Gets the semi-major axis.
     * 
     * @return  The semi-major axis 
     */
    public double getSma() {
        return sma;
    }
    
    /**
     * Gets the eccentricity.
     * 
     * @return  The eccentricity 
     */
    public double getEcc() {
        return ecc;
    }
    
    /**
     * Gets the inclination.
     * 
     * @return  The inclination
     */
    public double getInc() {
        return inc;
    }
    
    /**
     * Gets the mean longitude.
     * 
     * @return  The mean longitude 
     */
    public double getMl() {
        return ml;
    }
    
    /**
     * Gets the longitude perihelion.
     * 
     * @return  The longitude perihelion
     */
    public double getLp() {
        return lp;
    }
    
    /**
     * Gets the longitude of the ascending node.
     * 
     * @return  The longitude of the ascending node 
     */
    public double getLan() {
        return lan;
    }
    
    /**
     * Gets the mean anomaly.
     * 
     * @return  The mean anomaly 
     */
    public double getMan() {
        return ml - lp;
    }
    
    /**
     * Gets the argument of perihelion.
     * 
     * @return  The argument of perihelion 
     */
    public double getArp() {
        return lp - lan;
    }
    
    /**
     * Calculates the heliocentric orbital coordinates.
     * 
     * @return  The heliocentric orbital coordinates
     */
    public RectangularCoords helioOrbCoords() {
        RectangularCoords hoc = new RectangularCoords();
        
        final double eAnom = Astro.kepler(getMan(), getEcc());
        hoc.setX(getSma() * (cos(eAnom) - getEcc()));
        hoc.setY(getSma() * sqrt(1 - pow(getEcc(), 2)) * sin(eAnom));
        hoc.setZ(hypot(hoc.getX(), hoc.getY()));
        
        return hoc;
    }
    
    /**
     * Calculates the heliocentric ecliptic coordinates.
     * 
     * @return  The heliocentric ecliptic coordinates 
     */
    public RectangularCoords helioEclCoords() {
        final RectangularCoords hoc = helioOrbCoords();
        RectangularCoords hec = new RectangularCoords();
        
        hec.setX( ( (cos(getArp()) * cos(getLan()) - sin(getArp()) *
                     sin(getLan()) * cos(getInc()) ) * hoc.getX() ) +
                  ( (-sin(getArp()) * cos(getLan()) - cos(getArp()) *
                     sin(getLan()) * cos(getInc()) ) * hoc.getY() ) );
        hec.setY( ( (cos(getArp()) * sin(getLan()) + sin(getArp()) *
                     cos(getLan()) * cos(getInc()) ) * hoc.getX() ) +
                  ( (-sin(getArp()) * sin(getLan()) + cos(getArp()) *
                     cos(getLan()) * cos(getInc()) ) * hoc.getY() ) );
        hec.setZ( ( sin(getArp()) * sin(getInc()) * hoc.getX() ) +
                  ( cos(getArp()) * sin(getInc()) * hoc.getY() ) );
        
        return hec;
    }
}

/**
 * J2000 epoch orbital elements class.
 * 
 * @author Paul Griffiths
 */
class OrbitalElementsJ2000 extends OrbitalElements {
    
    /**
     * Class constructor.
     * 
     * @param sma   Semi-major axix
     * @param ecc   Eccentricity
     * @param inc   Inclination
     * @param ml    Mean longitude
     * @param lp    Longitude perihelion
     * @param lan   Longitude of ascending node
     */
    OrbitalElementsJ2000(final double sma,
                         final double ecc,
                         final double inc,
                         final double ml,
                         final double lp,
                         final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
    
    OrbitalElementsJ2000(final OrbitalElements epoch,
                         final OrbitalElements periodic,
                         final double periods) {
        super(epoch, periodic, periods);
    }
    
    @Override
    public OrbitalElementsJ2000 getDateElements(final OrbitalElements periodElems,
                                                final Date date) {
        return new OrbitalElementsJ2000(this, periodElems,
                                        new JulianDate(date).centuriesSinceJ2000());
    }
}

/**
 * Y2000 epoch orbital elements class.
 * 
 * @author Paul Griffiths
 */
class OrbitalElementsY2000 extends OrbitalElements {
    
    private static final long TS_Y2000;
    private static final long MSECS_IN_A_DAY = 86400000;
    
    static {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(1999, 11, 31, 0, 0, 0);
        TS_Y2000 = cal.getTime().getTime();
    }
    
    OrbitalElementsY2000(final double sma,
                         final double ecc,
                         final double inc,
                         final double ml,
                         final double lp,
                         final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
    
    OrbitalElementsY2000(final OrbitalElements epoch,
                         final OrbitalElements periodic,
                         final double periods) {
        super(epoch, periodic, periods);
    }
    
    //  BROKEN!! Implement with Y2000 epoch
    
    @Override
    public OrbitalElementsY2000 getDateElements(final OrbitalElements periodElems,
                                                final Date date) {
        final double days = (date.getTime() - TS_Y2000) / (double) MSECS_IN_A_DAY;
        return new OrbitalElementsY2000(this, periodElems, days);
    }
}