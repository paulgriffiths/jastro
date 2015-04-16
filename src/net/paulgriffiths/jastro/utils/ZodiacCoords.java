/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.utils;

import java.util.Formatter;

/**
 *
 * @author paul
 */
public class ZodiacCoords {
    private final ZodiacSign sign;
    private final DMS position;
    
    /**
     * Class constructor.
     * 
     * @param degrees   Position in ecliptic in degrees
     */
    public ZodiacCoords(final double degrees) {
        sign = ZodiacSign.getSignForDegrees(degrees);
        position = new DMS(Astro.normalizeDegrees(degrees));
    }
    
    /**
     * Returns a string representation of the coordinates in the form
     * "14AR35", meaning the 35th minute of the 14th degree of Aries.
     * 
     * @return  A string representation of the zodiacal coordinates
     */
    @Override
    public String toString() {
        return String.format("%02d%s%02d", position.getDegrees() % 30,
                             sign.getShortName(), position.getMinutes());
    }
}
