/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Sun planet class.
 * 
 * @author  Paul Griffiths
 */
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
