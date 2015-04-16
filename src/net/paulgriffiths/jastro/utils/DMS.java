/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.utils;

import java.util.Formatter;

/**
 * Degrees, wholeMinutes and wholeSeconds class.
 * 
 * @author Paul Griffiths
 */
public class DMS {
    private static final int SECS_IN_A_DEG = 3600;
    private static final int SECS_IN_A_MIN = 60;
    private static final int SECS_IN_A_CIRC = 1296000;
    
    private final double degrees;
    private final int wholeMinutes;
    private final int wholeSeconds;
    private final int wholeDegrees;
    
    /**
     * Class constructor taking angle in degrees.
     * 
     * @param degrees   The angle in degrees
     */
    public DMS(final double degrees) {
        this.degrees = degrees;
        final long totalSecs = Math.round(Math.abs(this.degrees) / 360 *
                                          SECS_IN_A_CIRC);
        final int sign = (int) Math.signum(degrees);
        final int d = (int) (totalSecs / SECS_IN_A_DEG);
        final int m = (int) ((totalSecs - d * SECS_IN_A_DEG) /
                              SECS_IN_A_MIN);
        final int s = (int) (totalSecs - d * SECS_IN_A_DEG -
                                         m * SECS_IN_A_MIN);
        wholeDegrees = d * sign;
        wholeMinutes = m * sign;
        wholeSeconds = s * sign;
    }
    
    /**
     * Default class constructor.
     * 
     * Initializes angle to zero degrees.
     */
    public DMS() {
        this(0.0);
    }
    
    /**
     * Returns the integral number of degrees.
     * 
     * @return  The integeral number of degrees 
     */
    public int getDegrees() {
        return wholeDegrees;
    }
    
    /**
     * Returns the integral number of wholeMinutes.
     * 
     * @return  The integral number of wholeMinutes 
     */
    public int getMinutes() {
        return wholeMinutes;
    }
    
    /**
     * Returns the integral number of wholeSeconds.
     * 
     * @return  The integral number of wholeSeconds 
     */
    public int getSeconds() {
        return wholeSeconds;
    }
    
    /**
     * Returns the angle in degrees.
     * 
     * @return  The angle in degrees 
     */
    public double toDegrees() {
        return degrees;
    }
    
    /**
     * Returns the angle in radians.
     * 
     * @return  The angle in radians 
     */
    public double toRadians() {
        return Math.toRadians(toDegrees());
    }
    
    /**
     * Returns a string representation in the form "+00d 00m 00s".
     * 
     * @return  A string representation of the degrees, wholeMinutes and wholeSeconds 
     */
    @Override
    public String toString() {
        return String.format("%c%02dd %02dm %02ds", degrees < 0 ? '-' : '+',
                             Math.abs(wholeDegrees),
                             Math.abs(wholeMinutes),
                             Math.abs(wholeSeconds));
    }    
}
