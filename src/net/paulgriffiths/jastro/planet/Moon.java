/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.planet;

import java.util.Date;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.hypot;
import static java.lang.Math.atan2;
import static java.lang.Math.toRadians;
import net.paulgriffiths.jastro.orbital.DateOrbitalElements;
import net.paulgriffiths.jastro.utils.RectangularCoords;

/**
 * Moon planet class.
 * 
 * @author  Paul Griffiths
 */
final class Moon extends PlanetEarthOrbit {
    Moon(final Date date) {
        super(Planet.MOON, date);
    }

    @Override
    protected RectangularCoords geoEclCoords() {
        final RectangularCoords hec = helioEclCoords();
        final RectangularCoords hoc = helioOrbCoords();
        //final PlanetPosition sfm = PlanetPosition.getPosition(Planet.EMBARY, getDate());
        final PlanetPosition sfm = new EarthMoonBarycenter(getDate());
        final DateOrbitalElements mOes = getElements();
        final DateOrbitalElements sOes = sfm.getElements();
        //  Calculate mean elongation and argument
        //  of latitude for the moon.
        final double mel = mOes.getMl() - sOes.getMl();
        final double arl = mOes.getMl() - sOes.getLan();
        //  Adjust for longitude perturbations
        double dlon = -1.274 * sin(mOes.getMan() - 2 * mel);
        dlon += 0.658 * sin(2 * mel);
        dlon -= 0.186 * sin(sOes.getMan());
        dlon -= 0.059 * sin(2 * mOes.getMan() - 2 * mel);
        dlon -= 0.057 * sin(mOes.getMan() - 2 * mel + sOes.getMan());
        dlon += 0.053 * sin(mOes.getMan() + 2 * mel);
        dlon += 0.046 * sin(2 * mOes.getMl() - sOes.getMan());
        dlon += 0.041 * sin(mOes.getMan() - sOes.getMan());
        dlon -= 0.035 * sin(mOes.getMl());
        dlon -= 0.031 * sin(mOes.getMan() + sOes.getMan());
        dlon -= 0.015 * sin(2 * arl - 2 * mel);
        dlon += 0.011 * sin(mOes.getMan() - 4 * mel);
        final double lon = atan2(hec.getY(), hec.getX()) + toRadians(dlon);
        //  Adjust for latitude perturbations
        double dlat = -0.173 * sin(arl - 2 * mel);
        dlat -= 0.055 * sin(mOes.getMan() - arl - 2 * mel);
        dlat -= 0.046 * sin(mOes.getMan() + arl - 2 * mel);
        dlat += 0.033 * sin(arl + 2 * mel);
        dlat += 0.017 * sin(2 * mOes.getMan() + arl);
        final double lat = atan2(hec.getZ(), hypot(hec.getX(), hec.getY())) + toRadians(dlat);
        //  Adjust for rhc perturbations
        final double rhc = hoc.getZ() - 0.58 * cos(mOes.getMan() - 2 * mel) - 0.46 * cos(2 * mel);
        return new RectangularCoords(rhc * cos(lon) * cos(lat), rhc * sin(lon) * cos(lat), rhc * sin(lat));
    }
}
