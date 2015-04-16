/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import static java.lang.Math.toRadians;
import net.paulgriffiths.jastro.planet.Planet;

/**
 * Class for orbital elements at the J2000 epoch.
 * 
 * @author  Paul Griffiths
 */
final class J2000EpochElements extends EpochOrbitalElements {
    static J2000EpochElements getElementsForPlanet(final Planet planet) {
        switch ( planet ) {
            case MERCURY:
                return new J2000EpochElements(0.387009927,
                                              0.20563593,
                                              toRadians(7.00497902),
                                              toRadians(252.25032350),
                                              toRadians(77.45779628),
                                              toRadians(48.33076593));
                
            case VENUS:
                return new J2000EpochElements(0.72333566,
                                              0.00677672,
                                              toRadians(3.39467605),
                                              toRadians(181.97909950),
                                              toRadians(131.60246718),
                                              toRadians(76.67984255));
                
            case EARTH:
                return new J2000EpochElements(1.00000261,
                                              0.01671123,
                                              toRadians(-0.00001531),
                                              toRadians(100.46457166),
                                              toRadians(102.93768193),
                                              toRadians(0.0));
                
            case SUN:
                return new J2000EpochElements(1.00000261,
                                              0.01671123,
                                              toRadians(-0.00001531),
                                              toRadians(100.46457166),
                                              toRadians(102.93768193),
                                              toRadians(0.0));
                
            case MARS:
                return new J2000EpochElements(1.52371034,
                                              0.09339410,
                                              toRadians(1.84969142),
                                              toRadians(-4.55343205),
                                              toRadians(-23.94362959),
                                              toRadians(49.55953891));
                
            case JUPITER:
                return new J2000EpochElements(5.20288700,
                                              0.04838624,
                                              toRadians(1.30439695),
                                              toRadians(34.39644051),
                                              toRadians(14.72847983),
                                              toRadians(100.47390909));
                
            case SATURN:
                return new J2000EpochElements(9.53667594,
                                              0.05386179,
                                              toRadians(2.48599187),
                                              toRadians(49.95424423),
                                              toRadians(92.59887831),
                                              toRadians(113.66242448));
                
            case URANUS:
                return new J2000EpochElements(19.18916464,
                                              0.04725744,
                                              toRadians(0.77263783),
                                              toRadians(313.23810451),
                                              toRadians(170.95427630),
                                              toRadians(74.01692503));
                
            case NEPTUNE:
                return new J2000EpochElements(30.06992276,
                                              0.00859048,
                                              toRadians(1.77004347),
                                              toRadians(-55.12002969),
                                              toRadians(44.96476227),
                                              toRadians(131.78422574));
                
            case PLUTO:
                return new J2000EpochElements(39.48211675,
                                              0.24882730,
                                              toRadians(17.14001206),
                                              toRadians(238.92903833),
                                              toRadians(224.06891629),
                                              toRadians(110.30393684));
                
            default:
                throw new UnsupportedOperationException("unsupported planet");
        }
    }
       
    private J2000EpochElements(final double sma,
                               final double ecc,
                               final double inc,
                               final double ml,
                               final double lp,
                               final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
