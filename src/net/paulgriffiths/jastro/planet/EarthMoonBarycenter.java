/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Earth-Moon Barycenter class.
 * 
 * @author  Paul Griffiths
 */
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
