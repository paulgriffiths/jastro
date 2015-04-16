/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import static java.lang.Math.cos;
import static java.lang.Math.hypot;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import net.paulgriffiths.jastro.utils.Astro;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Base orbital (Keplerian) elements class.
 * 
 * @author Paul Griffiths
 */
abstract class OrbitalElements {
    private final double sma;       //  Semi-major axis
    private final double ecc;       //  Eccentricity
    private final double inc;       //  Inclination
    private final double ml;        //  Mean longitude
    private final double lp;        //  Longitude perihelion
    private final double lan;       //  Longitude ascending node
    private final double man;       //  Mean anomaly
    private final double arp;       //  Argument of perihelion
    
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
        this.inc = inc;
        this.ml = ml;
        this.lp = lp;
        this.lan = lan;
        this.man = ml - lp;
        this.arp = lp - lan;
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
        return man;
    }
    
    /**
     * Gets the argument of perihelion.
     * 
     * @return  The argument of perihelion 
     */
    public double getArp() {
        return arp;
    }
    
    /**
     * Calculates the heliocentric orbital coordinates.
     * 
     * @return  The heliocentric orbital coordinates
     */
    public RectangularCoords helioOrbCoords() {
        final double eAnom = Astro.kepler(man, ecc);
        final double x = sma * (cos(eAnom) - ecc);
        final double y = sma * sqrt(1 - pow(ecc, 2)) * sin(eAnom);
        return new RectangularCoords(x, y, hypot(x, y));
    }
    
    /**
     * Calculates the heliocentric ecliptic coordinates.
     * 
     * @return  The heliocentric ecliptic coordinates 
     */
    public RectangularCoords helioEclCoords() {
        final RectangularCoords hoc = helioOrbCoords();
        RectangularCoords hec = new RectangularCoords();
        
        return new RectangularCoords(
            ( ( cos(arp) * cos(lan)   - sin(arp) *
                sin(lan) * cos(inc) ) * hoc.getX() ) +
            ( (-sin(arp) * cos(lan)   - cos(arp) *
                sin(lan) * cos(inc) ) * hoc.getY() ),
            ( ( cos(arp) * sin(lan)   + sin(arp) *
                cos(lan) * cos(inc) ) * hoc.getX() ) +
            ( (-sin(arp) * sin(lan)   + cos(arp) *
                 cos(lan) * cos(inc) ) * hoc.getY() ),
            ( sin(arp) * sin(inc) * hoc.getX() ) +
            ( cos(arp) * sin(inc) * hoc.getY() )
        );
    }
}