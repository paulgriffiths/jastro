/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Earth planet class.
 * 
 * @author  Paul Griffiths
 */
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
