/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

import java.util.Date;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.hypot;
import static java.lang.Math.pow;

/**
 *
 * @author paul
 */
public class PlanetPosition {
    private final Planet planet;
    private final OrbitalElements elems;
    private final Date date;
    
    public PlanetPosition(final Planet planet, final Date date) {
        this.planet = planet;
        this.date = date;
        elems = OrbitalElements.getJulianEpochElements(planet, date);
    }
    
    
}
