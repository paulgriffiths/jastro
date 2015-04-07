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
import java.util.Date;

/**
 * Orbital (Keplerian) elements class.
 * 
 * @author Paul Griffiths
 */
public final class OrbitalElements {
    
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
     * Factory function for planetary elements at J2000 epoch.
     * 
     * @param planet    The planet
     * @return          The planetary elements at the J2000 epoch
     */
    public static OrbitalElements getJ2000Elements(final Planet planet) {
        OrbitalElements elems;
        
        switch ( planet ) {
            case MERCURY:
                elems = new OrbitalElements(0.387009927, 0.20563593,
                                            7.00497902, 252.25032350,
                                            77.45779628, 48.33076593);
                break;
                
            case VENUS:
                elems = new OrbitalElements(0.72333566, 0.00677672,
                                            3.39467605, 181.97909950,
                                            131.60246718, 76.67984255);
                break;
                
            case EARTH:
                elems = new OrbitalElements(1.00000261, 0.01671123,
                                            -0.00001531, 100.46457166,
                                            102.93768193, 0.0);
                break;
                
            case MARS:
                elems = new OrbitalElements(1.52371034, 0.09339410,
                                            1.84969142, -4.55343205,
                                            -23.94362959, 49.55953891);
                break;
                
            case JUPITER:
                elems = new OrbitalElements(5.20288700, 0.04838624,
                                            1.30439695, 34.39644051,
                                            14.72847983, 100.47390909);
                break;
                
            case SATURN:
                elems = new OrbitalElements(9.53667594, 0.05386179,
                                            2.48599187, 49.95424423,
                                            92.59887831, 113.66242448);
                break;
                
            case URANUS:
                elems = new OrbitalElements(19.18916464, 0.04725744,
                                            0.77263783, 313.23810451,
                                            170.95427630, 74.01692503);
                break;
                
            case NEPTUNE:
                elems = new OrbitalElements(30.06992276, 0.00859048,
                                            1.77004347, -55.12002969,
                                            44.96476227, 131.78422574);
                break;
                
            case PLUTO:
                elems = new OrbitalElements(39.48211675, 0.24882730,
                                            17.14001206, 238.92903833,
                                            224.06891629, 110.30393684);
                break;
                
            case SUN:
                throw new IllegalArgumentException(
                            "No J2000 elements available for the Sun");
                
            case MOON:
                throw new IllegalArgumentException(
                            "No J2000 elements available for the Moon");
                
            default:
                throw new IllegalArgumentException("Unrecognized planet");
        }
        
        return elems;
    }
    
    /**
     * Factory function for planetary elements representing change over a
     * Julian Century.
     * 
     * @param planet    The planet
     * @return          The planetary elements delta over a Julian century
     */
    public static OrbitalElements getJCenturyElements(final Planet planet) {
        OrbitalElements elems;
        
        switch ( planet ) {
            case MERCURY:
                elems = new OrbitalElements(0.00000037, 0.00001906,
                                            -0.00594749, 149472.67411175,
                                            0.16047689, -0.12534081);
                break;
                
            case VENUS:
                elems = new OrbitalElements(0.00000390, -0.00004107,
                                            -0.00078890, 58517.81538729,
                                            0.00268329, -0.27769418);
                break;
                
            case EARTH:
                elems = new OrbitalElements(0.00000562, -0.00004392,
                                            -0.01294668, 35999.37244981,
                                            0.32327364, 0.0);
                break;
                
            case MARS:
                elems = new OrbitalElements(0.00001847, 0.00007882,
                                            -0.00813131, 19140.30268499,
                                            0.44441088, -0.29257343);
                break;
                
            case JUPITER:
                elems = new OrbitalElements(-0.00011607, -0.00013253,
                                            -0.00183714, 3034.74612775,
                                            0.21252668, 0.20469106);
                break;
                
            case SATURN:
                elems = new OrbitalElements(-0.00125060, -0.00050991,
                                            0.00193609, 1222.49362201,
                                            -0.41897216, -0.28867794);
                break;
                
            case URANUS:
                elems = new OrbitalElements(-0.00196176, -0.00004397,
                                            -0.00242939, 428.48202785,
                                            0.40805281, 0.04240589);
                break;
                
            case NEPTUNE:
                elems = new OrbitalElements(0.00026291, 0.00005105,
                                            0.00035372, 218.45945325,
                                            -0.32241464, -0.00508664);
                break;
                
            case PLUTO:
                elems = new OrbitalElements(-0.00031596, 0.00005170,
                                            0.00004818, 145.20780515,
                                            -0.04062942, -0.01183482);
                break;
                
            case SUN:
                throw new IllegalArgumentException(
                            "No Julian century elements available for the Sun");
                
            case MOON:
                throw new IllegalArgumentException(
                            "No Julian century elements available for the Moon");
                
            default:
                throw new IllegalArgumentException("Unrecognized planet");       
        }
        
        return elems;
    }
    
    /**
     * Factory function for planetary elements representing change over a
     * Julian Century.
     * 
     * @param planet    The planet
     * @param date      The date
     * @return          The planetary elements delta over a Julian century
     */
    public static OrbitalElements getJulianEpochElements(final Planet planet,
                                                         final Date date) {
        return new OrbitalElements(getJ2000Elements(planet),
                                   getJCenturyElements(planet),
                                   new JulianDate(date).centuriesSinceJ2000());
    }
    
    /**
     * Class constructor.
     * 
     * Private constructor, objects created solely through factory functions.
     * 
     * @param sma   Semi-major axis
     * @param ecc   Eccentricity
     * @param inc   Inclination
     * @param ml    Mean longitude
     * @param lp    Longitude perihelion
     * @param lan   Longitude of ascending node
     */
    private OrbitalElements(final double sma,
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
    private OrbitalElements(final OrbitalElements epoch,
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
    public RectangularCoords helio_orb_coords() {
        RectangularCoords hoc = new RectangularCoords();
        
        final double e_anom = Astro.kepler(getMan(), getEcc());
        hoc.setX(getSma() * (cos(e_anom) - getEcc()));
        hoc.setY(getSma() * sqrt(1 - pow(getEcc(), 2)) * sin(e_anom));
        hoc.setZ(hypot(hoc.getX(), hoc.getY()));
        
        return hoc;
    }
    
    /**
     * Calculates the heliocentric ecliptic coordinates.
     * 
     * @return  The heliocentric ecliptic coordinates 
     */
    public RectangularCoords helio_ecl_coords() {
        final RectangularCoords hoc = helio_orb_coords();
        RectangularCoords hec = new RectangularCoords();
        
        hec.setX(((cos(getArp()) * cos(getLan()) - sin(getArp()) *
                  sin(getLan()) * cos(getInc())) * hoc.getX()) +
                 ((-sin(getArp()) * cos(getLan()) - cos(getArp()) *
                  sin(getLan()) * cos(getInc())) * hoc.getY()));
        hec.setY(((cos(getArp()) * sin(getLan()) + sin(getArp()) *
                  cos(getLan()) * cos(getInc())) * hoc.getX()) +
                 ((-sin(getArp()) * sin(getLan()) + cos(getArp()) *
                  cos(getLan()) * cos(getInc())) * hoc.getY()));
        hec.setZ((sin(getArp()) * sin(getInc()) * hoc.getX()) +
                 (cos(getArp()) * sin(getInc()) * hoc.getY()));
        
        return hec;
    }

}
