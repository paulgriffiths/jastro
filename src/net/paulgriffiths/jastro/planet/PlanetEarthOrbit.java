/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;

/**
 * Planet position base class for Earth orbiting bodies.
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
    protected PlanetEarthOrbit(final Planet planet, final Date date) {
        super(planet, date);
    }
}
