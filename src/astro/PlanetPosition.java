/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

import java.util.Date;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

/**
 * Planet position class.
 * 
 * @author Paul Griffiths
 */
abstract public class PlanetPosition {
    
    /**  Obliguity of the ecliptic  */
    static protected final double OBLIQUITY = toRadians(23.43928);
    
    /**  The planet  */
    private final Planet planet;
    
    /**  The orbital elements  */
    private final OrbitalElements elems;
    
    /**  The position date  */
    private final Date date;
    
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
                pos = new MercuryJ2000(date);
                break;
                
            case VENUS:
                pos = new VenusJ2000(date);
                break;
                
            case EARTH:
                pos = new EarthJ2000(date);
                break;
                
            case SUN:
                pos = new SunJ2000(date);
                break;
                
            case MARS:
                pos = new MarsJ2000(date);
                break;
                
            case JUPITER:
                pos = new JupiterJ2000(date);
                break;
                
            case SATURN:
                pos = new SaturnJ2000(date);
                break;
                
            case URANUS:
                pos = new UranusJ2000(date);
                break;
                
            case NEPTUNE:
                pos = new NeptuneJ2000(date);
                break;
                
            case PLUTO:
                pos = new PlutoJ2000(date);
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
        this.elems = this.planet.getDateElements(this.date);
    }
    
    /**
     * Gets the planet's right ascension.
     * 
     * @return  The planet's right ascension 
     */
    public double getRightAscension() {
        return geo_equ_coords().toSpherical().getRightAscension();
    }
    
    /**
     * Gets the planet's declination.
     * 
     * @return  The planet's declination 
     */
    public double getDeclination() {
        return geo_equ_coords().toSpherical().getDeclination();
    }
    
    /**
     * Gets the planet's distance.
     * 
     * @return  The planet's distance 
     */
    public double getDistance() {
        return geo_equ_coords().toSpherical().getDistance();
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
    protected OrbitalElements getElements() {
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
    abstract protected RectangularCoords helio_orb_coords();
    
    /**
     * Calculates the heliocentric ecliptic coordinates of this position.
     * 
     * @return  The heliocentric ecliptic coordinates of this position
     */
    abstract protected RectangularCoords helio_ecl_coords();
    
    /**
     * Calculates the geocentric ecliptic coordinates of this position.
     * 
     * @return  The geocentric ecliptic coordinates of this position 
     */
    abstract protected RectangularCoords geo_ecl_coords();
    
    /**
     * Calculates the geocentric equatorial coordinates of this position.
     * 
     * @return  The geocentric equatorial coordinates of this position 
     */
    abstract protected RectangularCoords geo_equ_coords();
}

/**
 * Planet position using J2000 epoch class.
 * 
 * @author Paul Griffiths
 */
abstract class PlanetJ2000 extends PlanetPosition {
    
    /**
     * Class constructor.
     * 
     * Abstract class, so constructor should only be called from subclasses.
     * 
     * @param planet    The planet for which to calculate position
     * @param date      The date for which to calculate position
     * @param elems     The orbital elements
     */
    protected PlanetJ2000(final Planet planet,
                          final Date date) {
        super(planet, date);
    }
    
    @Override
    protected RectangularCoords helio_orb_coords() {
        return getElements().helio_orb_coords();
    }
    
    @Override
    protected RectangularCoords helio_ecl_coords() {
        return getElements().helio_ecl_coords();
    }
    
    @Override
    protected RectangularCoords geo_ecl_coords() {
        RectangularCoords hec = helio_ecl_coords();
        hec.subtract(getPosition(Planet.EARTH, getDate()).helio_ecl_coords());
        return hec;
    }
    
    @Override
    protected RectangularCoords geo_equ_coords() {
        final RectangularCoords gec = geo_ecl_coords();
        return new RectangularCoords(gec.getX(),
            gec.getY() * cos(OBLIQUITY) - gec.getZ() * sin(OBLIQUITY),
            gec.getY() * sin(OBLIQUITY) + gec.getZ() * cos(OBLIQUITY));
    }
}

final class MercuryJ2000 extends PlanetJ2000 {
    MercuryJ2000(final Date date) {
        super(Planet.MERCURY, date);
    }
}

final class VenusJ2000 extends PlanetJ2000 {
    VenusJ2000(final Date date) {
        super(Planet.VENUS, date);
    }
}

final class EarthJ2000 extends PlanetJ2000 {
    EarthJ2000(final Date date) {
        super(Planet.EARTH, date);
    }
    
    @Override
    public RectangularCoords geo_ecl_coords() {
        return new RectangularCoords(0, 0, 0);
    }
    
    @Override
    public RectangularCoords geo_equ_coords() {
        return new RectangularCoords(0, 0, 0);
    }   
}

final class SunJ2000 extends PlanetJ2000 {
    SunJ2000(final Date date) {
        super(Planet.SUN, date);
    }
    
    @Override
    public RectangularCoords helio_ecl_coords() {
        return new RectangularCoords(0, 0, 0);
    }
    
    @Override
    public RectangularCoords helio_orb_coords() {
        return new RectangularCoords(0, 0, 0);
    }
}

final class MarsJ2000 extends PlanetJ2000 {
    MarsJ2000(final Date date) {
        super(Planet.MARS, date);
    }
}

final class JupiterJ2000 extends PlanetJ2000 {
    JupiterJ2000(final Date date) {
        super(Planet.JUPITER, date);
    }
}

final class SaturnJ2000 extends PlanetJ2000 {
    SaturnJ2000(final Date date) {
        super(Planet.SATURN, date);
    }
}

final class UranusJ2000 extends PlanetJ2000 {
    UranusJ2000(final Date date) {
        super(Planet.URANUS, date);
    }
}

final class NeptuneJ2000 extends PlanetJ2000 {
    NeptuneJ2000(final Date date) {
        super(Planet.NEPTUNE, date);
    }
}

final class PlutoJ2000 extends PlanetJ2000 {
    PlutoJ2000(final Date date) {
        super(Planet.PLUTO, date);
    }
}
