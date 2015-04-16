/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;

/**
 * Mercury planet class.
 * 
 * @author  Paul Griffiths
 */
final class Mercury extends PlanetSolarOrbit {
    Mercury(final Date date) {
        super(Planet.MERCURY, date);
    }
}
