/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

import java.util.Date;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.atan2;
import static java.lang.Math.hypot;
import static java.lang.Math.toRadians;
import java.util.Calendar;

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
        this.elems = this.planet.getDateElements(this.date);
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

/**
 * Planet position for solar orbiting bodies.
 * 
 * @author Paul Griffiths
 */
abstract class PlanetSolarOrbit extends PlanetPosition {
    
    /**
     * Class constructor.
     * 
     * Abstract class, so constructor should only be called from subclasses.
     * 
     * @param planet    The planet for which to calculate position
     * @param date      The date for which to calculate position
     * @param elems     The orbital elements
     */
    protected PlanetSolarOrbit(final Planet planet,
                          final Date date) {
        super(planet, date);
    }
    
    @Override
    protected RectangularCoords geoEclCoords() {
        RectangularCoords hec = helioEclCoords();
        hec.subtract(getPosition(Planet.EARTH, getDate()).helioEclCoords());
        return hec;
    }
}

final class Mercury extends PlanetSolarOrbit {
    Mercury(final Date date) {
        super(Planet.MERCURY, date);
    }
}

final class Venus extends PlanetSolarOrbit {
    Venus(final Date date) {
        super(Planet.VENUS, date);
    }
}

final class Earth extends PlanetSolarOrbit {
    Earth(final Date date) {
        super(Planet.EARTH, date);
    }
    
    @Override
    public RectangularCoords geoEclCoords() {
        return new RectangularCoords(0, 0, 0);
    }
    
    @Override
    public RectangularCoords geoEquCoords() {
        return new RectangularCoords(0, 0, 0);
    }   
}

final class Sun extends PlanetSolarOrbit {
    Sun(final Date date) {
        super(Planet.SUN, date);
    }
    
    @Override
    public RectangularCoords helioEclCoords() {
        return new RectangularCoords(0, 0, 0);
    }
    
    @Override
    public RectangularCoords helioOrbCoords() {
        return new RectangularCoords(0, 0, 0);
    }
}

final class Mars extends PlanetSolarOrbit {
    Mars(final Date date) {
        super(Planet.MARS, date);
    }
}

final class Jupiter extends PlanetSolarOrbit {
    Jupiter(final Date date) {
        super(Planet.JUPITER, date);
    }
}

final class Saturn extends PlanetSolarOrbit {
    Saturn(final Date date) {
        super(Planet.SATURN, date);
    }
}

final class Uranus extends PlanetSolarOrbit {
    Uranus(final Date date) {
        super(Planet.URANUS, date);
    }
}

final class Neptune extends PlanetSolarOrbit {
    Neptune(final Date date) {
        super(Planet.NEPTUNE, date);
    }
}

final class Pluto extends PlanetSolarOrbit {
    Pluto(final Date date) {
        super(Planet.PLUTO, date);
    }
}

/**
 * Planet position for Earth orbiting bodies.
 * 
 * @author Paul Griffiths
 */
abstract class PlanetEarthOrbit extends PlanetPosition {
    
    /**
     * Class constructor.
     * 
     * Abstract class, so constructor should only be called from subclasses.
     * 
     * @param planet    The planet for which to calculate position
     * @param date      The date for which to calculate position
     * @param elems     The orbital elements
     */
    protected PlanetEarthOrbit(final Planet planet,
                          final Date date) {
        super(planet, date);
    }
}

final class Moon extends PlanetEarthOrbit {
    Moon(final Date date) {
        super(Planet.MOON, date);
    }
    
    @Override
    protected RectangularCoords geoEclCoords() {
        final RectangularCoords hec = helioEclCoords();
        final RectangularCoords hoc = helioOrbCoords();
        
        final PlanetPosition sfm = PlanetPosition.getPosition(Planet.EMBARY, getDate());
        final OrbitalElements mOes = getElements();
        final OrbitalElements sOes = sfm.getElements();
        
        //  Calculate mean elongation and argument
        //  of latitude for the moon.
        
        final double mel = mOes.getMl() - sOes.getMl();
        final double arl = mOes.getMl() - sOes.getLan();
        
        //  Adjust for longitude perturbations
        
        double dlon = -1.274 * sin(mOes.getMan() - 2 * mel);
        dlon += 0.658 * sin(2 * mel);
        dlon -= 0.186 * sin(sOes.getMan());
        dlon -= 0.059 * sin(2 * mOes.getMan() - 2 * mel);
        dlon -= 0.057 * sin(mOes.getMan() - 2 * mel + sOes.getMan());
        dlon += 0.053 * sin(mOes.getMan() + 2 * mel);
        dlon += 0.046 * sin(2 * mOes.getMl() - sOes.getMan());
        dlon += 0.041 * sin(mOes.getMan() - sOes.getMan());
        dlon -= 0.035 * sin(mOes.getMl());
        dlon -= 0.031 * sin(mOes.getMan() + sOes.getMan());
        dlon -= 0.015 * sin(2 * arl - 2 * mel);
        dlon += 0.011 * sin(mOes.getMan() - 4 * mel);
        
        final double lon = atan2(hec.getY(), hec.getX()) + toRadians(dlon);

        //  Adjust for latitude perturbations

        double dlat = -0.173 * sin(arl - 2 * mel);
        dlat -= 0.055 * sin(mOes.getMan() - arl - 2 * mel);
        dlat -= 0.046 * sin(mOes.getMan() + arl - 2 * mel);
        dlat += 0.033 * sin(arl + 2 * mel);
        dlat += 0.017 * sin(2 * mOes.getMan() + arl);
        
        final double lat = atan2(hec.getZ(), hypot(hec.getX(), hec.getY())) +
                           toRadians(dlat);

        //  Adjust for rhc perturbations

        double rhc = hoc.getZ() - 0.58 * cos(mOes.getMan() - 2 * mel);
        rhc -= 0.46 * cos(2 * mel);
        
        return new RectangularCoords(rhc * cos(lon) * cos(lat),
                                     rhc * sin(lon) * cos(lat),
                                     rhc * sin(lat));
    } 
}

final class EarthMoonBarycenter extends PlanetEarthOrbit {
    EarthMoonBarycenter(final Date date) {
        super(Planet.EMBARY, date);
    }
    
    @Override
    protected RectangularCoords helioOrbCoords() {
        throw new UnsupportedOperationException("Position must not be taken");
    }
    
    @Override
    protected RectangularCoords helioEclCoords() {
        throw new UnsupportedOperationException("Position must not be taken");
    }
    
    @Override
    protected RectangularCoords geoEclCoords() {
        throw new UnsupportedOperationException("Position must not be taken");
    }
    
    @Override
    protected RectangularCoords geoEquCoords() {
        throw new UnsupportedOperationException("Position must not be taken");
    }
}