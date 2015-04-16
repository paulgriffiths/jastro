/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import java.util.Date;
import net.paulgriffiths.jastro.planet.Planet;
     
/**
 * Base class for orbital elements at a specified date.
 * 
 * @author  Paul Griffiths
 */
public abstract class DateOrbitalElements extends PointOrbitalElements {
    public static DateOrbitalElements getElementsForPlanet(final Planet planet,
                                                           final Date date) {
        switch ( planet ) {
            case MERCURY:
            case VENUS:
            case EARTH:
            case SUN:
            case MARS:
            case JUPITER:
            case SATURN:
            case URANUS:
            case NEPTUNE:
            case PLUTO:
                return J2000DateElements.getElementsForPlanet(planet, date);
                
            case MOON:
            case EMBARY:
                return Y2000DateElements.getElementsForPlanet(planet, date);
                
            default:
                throw new UnsupportedOperationException("unsupported planet");
        }
    }
    
    protected DateOrbitalElements(final EpochOrbitalElements epochElements,
                                  final DeltaOrbitalElements deltaElements,
                                  final double periods) {
        super(epochElements.getSma() + deltaElements.getSma() * periods,
              epochElements.getEcc() + deltaElements.getEcc() * periods,
              epochElements.getInc() + deltaElements.getInc() * periods,
              epochElements.getMl()  + deltaElements.getMl()  * periods,
              epochElements.getLp()  + deltaElements.getLp()  * periods,
              epochElements.getLan() + deltaElements.getLan() * periods);
    }
}
