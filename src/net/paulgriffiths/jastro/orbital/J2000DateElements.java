/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import java.util.Calendar;
import java.util.Date;
import net.paulgriffiths.jastro.utils.JulianDate;
import net.paulgriffiths.jastro.planet.Planet;

/**
 * Class for orbital elements at a specified Julian date.
 * 
 * @author  Paul Griffiths
 */
final class J2000DateElements extends DateOrbitalElements {
    public static J2000DateElements getElementsForPlanet(final Planet planet,
                                                         final Date date) {
        return new J2000DateElements(
                J2000EpochElements.getElementsForPlanet(planet),
                J2000CenturyElements.getElementsForPlanet(planet),
                date
        );
    }
    
    private J2000DateElements(final J2000EpochElements epochElements,
                              final J2000CenturyElements deltaElements,
                              final Date date) {
        super(epochElements, deltaElements,
              new JulianDate(date).centuriesSinceJ2000());
    }
}
