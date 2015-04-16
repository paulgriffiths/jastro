/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.astro;

import java.util.Formatter;

/**
 * Degrees, minutes and seconds class.
 * 
 * @author Paul Griffiths
 */
public class DMS {
    
    /**  Seconds in a degree constant  */
    private static final int SECS_IN_A_DEG = 3600;
    
    /**  Seconds in a minute constant  */
    private static final int SECS_IN_A_MIN = 60;
    
    /**  Seconds in a circle constant  */
    private static final int SECS_IN_A_CIRC = 1296000;
    
    /*  Angle in degrees  */
    private final double degrees;
    
    /*  Integral number of degrees  */
    private final int degs;
    
    /*  Integral number of minutes  */
    private final int minutes;
    
    /*  Integral number of seconds  */
    private final int seconds;
    
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
        degs = d * sign;
        minutes = m * sign;
        seconds = s * sign;
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
        return degs;
    }
    
    /**
     * Returns the integral number of minutes.
     * 
     * @return  The integral number of minutes 
     */
    public int getMinutes() {
        return minutes;
    }
    
    /**
     * Returns the integral number of seconds.
     * 
     * @return  The integral number of seconds 
     */
    public int getSeconds() {
        return seconds;
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
     * @return  A string representation of the degrees, minutes and seconds 
     */
    @Override
    public String toString() {
        return String.format("%c%02dd %02dm %02ds", degrees < 0 ? '-' : '+',
                   Math.abs(degs), Math.abs(minutes), Math.abs(seconds));
    }    
}
