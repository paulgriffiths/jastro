/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.paulgriffiths.jastro.planet.Planet;

/**
 * Class for orbital elements at a specified date.
 * 
 * @author  Paul Griffiths
 */
public final class Y2000DateElements extends DateOrbitalElements {
    private static final long TS_Y2000;
    private static final double MSECS_IN_A_DAY = 86400000;
    
    static {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(1999, 11, 31, 0, 0, 0);
        TS_Y2000 = cal.getTime().getTime();
    }
    
    public static Y2000DateElements getElementsForPlanet(final Planet planet,
                                                         final Date date) {
        return new Y2000DateElements(
                Y2000EpochElements.getElementsForPlanet(planet),
                Y2000DayElements.getElementsForPlanet(planet),
                date
        );
    }
    
    private Y2000DateElements(final Y2000EpochElements epochElements,
                              final Y2000DayElements deltaElements,
                              final Date date) {
        super(epochElements, deltaElements,
              (date.getTime() - TS_Y2000) / MSECS_IN_A_DAY);
    }
}
