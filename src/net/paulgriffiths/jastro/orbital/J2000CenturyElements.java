/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import static java.lang.Math.toRadians;
import net.paulgriffiths.jastro.utils.Planet;

/**
 * Class for change in orbital elements over a Julian century.
 * 
 * @author  Paul Griffiths
 */
final class J2000CenturyElements extends DeltaOrbitalElements {
    static J2000CenturyElements getElementsForPlanet(final Planet planet) {
        switch ( planet ) {
            case MERCURY:
                return new J2000CenturyElements(0.00000037,
                                                0.00001906,
                                                toRadians(-0.00594749),
                                                toRadians(149472.67411175),
                                                toRadians(0.16047689),
                                                toRadians(-0.12534081));
                
            case VENUS:
                return new J2000CenturyElements(0.00000390,
                                                -0.00004107,
                                                toRadians(-0.00078890),
                                                toRadians(58517.81538729),
                                                toRadians(0.00268329),
                                                toRadians(-0.27769418));
                
            case EARTH:
                return new J2000CenturyElements(0.00000562,
                                                -0.00004392,
                                                toRadians(-0.01294668),
                                                toRadians(35999.37244981),
                                                toRadians(0.32327364),
                                                toRadians(0.0));
                
            case SUN:
                return new J2000CenturyElements(0.00000562,
                                                -0.00004392,
                                                toRadians(-0.01294668),
                                                toRadians(35999.37244981),
                                                toRadians(0.32327364),
                                                toRadians(0.0));
                
            case MARS:
                return new J2000CenturyElements(0.00001847,
                                                0.00007882,
                                                toRadians(-0.00813131),
                                                toRadians(19140.30268499),
                                                toRadians(0.44441088),
                                                toRadians(-0.29257343));
                
            case JUPITER:
                return new J2000CenturyElements(-0.00011607,
                                                -0.00013253,
                                                toRadians(-0.00183714),
                                                toRadians(3034.74612775),
                                                toRadians(0.21252668),
                                                toRadians(0.20469106));
                
            case SATURN:
                return new J2000CenturyElements(-0.00125060,
                                                -0.00050991,
                                                toRadians(0.00193609),
                                                toRadians(1222.49362201),
                                                toRadians(-0.41897216),
                                                toRadians(-0.28867794));
                
            case URANUS:
                return new J2000CenturyElements(-0.00196176,
                                                -0.00004397,
                                                toRadians(-0.00242939),
                                                toRadians(428.48202785),
                                                toRadians(0.40805281),
                                                toRadians(0.04240589));
                
            case NEPTUNE:
                return new J2000CenturyElements(0.00026291,
                                                0.00005105,
                                                toRadians(0.00035372),
                                                toRadians(218.45945325),
                                                toRadians(-0.32241464),
                                                toRadians(-0.00508664));
                
            case PLUTO:
                return new J2000CenturyElements(-0.00031596,
                                                0.00005170,
                                                toRadians(0.00004818),
                                                toRadians(145.20780515),
                                                toRadians(-0.04062942),
                                                toRadians(-0.01183482));
                
            default:
                throw new UnsupportedOperationException("unsupported planet");
        }
    }
    
    private J2000CenturyElements(final double sma,
                                 final double ecc,
                                 final double inc,
                                 final double ml,
                                 final double lp,
                                 final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
