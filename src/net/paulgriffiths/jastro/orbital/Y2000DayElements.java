/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import static java.lang.Math.toRadians;
import net.paulgriffiths.jastro.planet.Planet;

/**
 * Class for change in orbital elements over a day.
 * 
 * @author  Paul Griffiths
 */
public final class Y2000DayElements extends DeltaOrbitalElements {
    static Y2000DayElements getElementsForPlanet(final Planet planet) {
        switch ( planet ) {
            case MOON:
                return new Y2000DayElements(0.0,
                                            0.0,
                                            toRadians(0.0),
                                            toRadians(13.1763964649),
                                            toRadians(0.111403514),
                                            toRadians(-0.0529538083));
                
            case EMBARY:
                return new Y2000DayElements(0.0,
                                            -0.000000001151,
                                            toRadians(0.0),
                                            toRadians(0.98564735200),
                                            toRadians(0.00004709350),
                                            toRadians(0.0));
                
            default:
                throw new UnsupportedOperationException("unsupported planet");
        }
    }
    
    private Y2000DayElements(final double sma,
                             final double ecc,
                             final double inc,
                             final double ml,
                             final double lp,
                             final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
