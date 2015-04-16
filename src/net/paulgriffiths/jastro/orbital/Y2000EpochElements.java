/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import static java.lang.Math.toRadians;
import net.paulgriffiths.jastro.planet.Planet;

/**
 * Class for orbital elements at the Y2000 epoch.
 * 
 * @author  Paul Griffiths
 */
public final class Y2000EpochElements extends EpochOrbitalElements {
    static Y2000EpochElements getElementsForPlanet(final Planet planet) {
        switch ( planet ) {
            case MOON:
                return new Y2000EpochElements(60.2666,
                                              0.0549,
                                              toRadians(5.1454),
                                              toRadians(198.5516),
                                              toRadians(83.1862),
                                              toRadians(125.1228));
                
            case EMBARY:
                return new Y2000EpochElements(1,
                                              0.016709,
                                              toRadians(0.0),
                                              toRadians(278.9874),
                                              toRadians(-77.0596),
                                              toRadians(0.0));
                
            default:
                throw new UnsupportedOperationException("unsupported planet");
        }
    }
    
    private Y2000EpochElements(final double sma,
                               final double ecc,
                               final double inc,
                               final double ml,
                               final double lp,
                               final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
