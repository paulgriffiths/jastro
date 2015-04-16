/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;

/**
 * Pluto planet class.
 * 
 * @author  Paul Griffiths
 */
final class Pluto extends PlanetSolarOrbit {
    Pluto(final Date date) {
        super(Planet.PLUTO, date);
    } 
}
