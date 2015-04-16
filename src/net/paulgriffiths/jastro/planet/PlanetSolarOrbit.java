/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Planet position based class for solar orbiting bodies.
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
    protected PlanetSolarOrbit(final Planet planet, final Date date) {
        super(planet, date);
    }

    @Override
    protected RectangularCoords geoEclCoords() {
        RectangularCoords hec = helioEclCoords();
        hec.subtract(getPosition(Planet.EARTH, getDate()).helioEclCoords());
        return hec;
    }
}
