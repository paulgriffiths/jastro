/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.atan2;
import static java.lang.Math.hypot;
import static java.lang.Math.toRadians;
import java.util.Calendar;
import net.paulgriffiths.jastro.orbital.DateOrbitalElements;
import net.paulgriffiths.jastro.utils.RectangularCoords;
import net.paulgriffiths.jastro.utils.ZodiacCoords;

/**
 * Planet position base class.
 * 
 * @author Paul Griffiths
 */
abstract public class PlanetPosition {
    static protected final double OBLIQUITY = toRadians(23.43928);
    
    private final Planet planet;
    private final DateOrbitalElements elems;
    private final Date date;
    
    /**
     * Planet position object factory function for current time.
     * 
     * @param planet    The planet for which to calculate position
     * @return          A planet position object
     */
    public static PlanetPosition getPosition(final Planet planet) {
        return getPosition(planet, Calendar.getInstance().getTime());
    }
    
    /**
     * Planet position object factory function with date.
     * 
     * @param planet    The planet for which to calculate position
     * @param date      The date for which to calculate position
     * @return          A planet position object
     */
    public static PlanetPosition getPosition(final Planet planet,
                                             final Date date) {
        PlanetPosition pos;
        
        switch ( planet ) {
            case MERCURY:
                pos = new Mercury(date);
                break;
                
            case VENUS:
                pos = new Venus(date);
                break;
                
            case EARTH:
                pos = new Earth(date);
                break;
                
            case SUN:
                pos = new Sun(date);
                break;
                
            case MARS:
                pos = new Mars(date);
                break;
                
            case JUPITER:
                pos = new Jupiter(date);
                break;
                
            case SATURN:
                pos = new Saturn(date);
                break;
                
            case URANUS:
                pos = new Uranus(date);
                break;
                
            case NEPTUNE:
                pos = new Neptune(date);
                break;
                
            case PLUTO:
                pos = new Pluto(date);
                break;
                
            case MOON:
                pos = new Moon(date);
                break;
                
            case EMBARY:
                pos = new EarthMoonBarycenter(date);
                break;
                
            default:
                throw new IllegalArgumentException("Bad planet");
        }
        
        return pos;
    }
    
    /**
     * Class constructor.
     * 
     * Abstract class, so constructor should only be called from subclasses.
     * 
     * @param planet    The planet for which to calculate position
     * @param date      The date for which to calculate position
     */
    protected PlanetPosition(final Planet planet,
                             final Date date) {
        this.planet = planet;
        this.date = new Date(date.getTime());
        this.elems = DateOrbitalElements.getElementsForPlanet(planet, this.date);
    }
    
    /**
     * Gets the planet's right ascension.
     * 
     * @return  The planet's right ascension 
     */
    public double getRightAscension() {
        return geoEquCoords().toSpherical().getRightAscension();
    }
    
    /**
     * Gets the planet's declination.
     * 
     * @return  The planet's declination 
     */
    public double getDeclination() {
        return geoEquCoords().toSpherical().getDeclination();
    }
    
    /**
     * Gets the planet's distance.
     * 
     * @return  The planet's distance 
     */
    public double getDistance() {
        return geoEquCoords().toSpherical().getDistance();
    }
    
    /**
     * Gets the zodiacal coordinates of the planet position.
     * 
     * @return  The zodiacal coordinates of the planet position
     */
    public ZodiacCoords getZodiacCoords() {
        return new ZodiacCoords(getRightAscension());
    }
    
    /**
     * Gets the planet associated with this position.
     * 
     * @return  The planet associated with this position 
     */
    protected Planet getPlanet() {
        return planet;
    }
    
    /**
     * Gets the orbital elements associated with this position.
     * 
     * @return  The orbital elements associated with this position 
     */
    protected DateOrbitalElements getElements() {
        return elems;
    }
    
    /**
     * Gets the date associated with this position.
     * 
     * @return  The date associated with this position 
     */
    protected Date getDate() {
        return new Date(date.getTime());
    }
    
    /**
     * Calculates the heliocentric orbital coordinates of this position.
     * 
     * @return  The heliocentric orbital coordinates of this position
     */
    protected RectangularCoords helioOrbCoords() {
        return getElements().helioOrbCoords();
    }
    
    /**
     * Calculates the heliocentric ecliptic coordinates of this position.
     * 
     * @return  The heliocentric ecliptic coordinates of this position
     */
    protected RectangularCoords helioEclCoords() {
        return getElements().helioEclCoords();
    }
    
    /**
     * Calculates the geocentric ecliptic coordinates of this position.
     * 
     * @return  The geocentric ecliptic coordinates of this position 
     */
    abstract protected RectangularCoords geoEclCoords();
    
    /**
     * Calculates the geocentric equatorial coordinates of this position.
     * 
     * @return  The geocentric equatorial coordinates of this position 
     */
    protected RectangularCoords geoEquCoords() {
        final RectangularCoords gec = geoEclCoords();
        return new RectangularCoords(gec.getX(),
            gec.getY() * cos(OBLIQUITY) - gec.getZ() * sin(OBLIQUITY),
            gec.getY() * sin(OBLIQUITY) + gec.getZ() * cos(OBLIQUITY));
    }
}