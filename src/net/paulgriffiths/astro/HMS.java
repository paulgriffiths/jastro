/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.astro;

import java.util.Formatter;

/**
 * Hours, minutes and seconds class.
 * 
 * @author Paul Griffiths
 */
public class HMS {
    
    /**  Seconds in a day constant  */
    private static final int SECS_IN_A_DAY = 86400;
    
    /**  Seconds in an hour constant  */
    private static final int SECS_IN_A_HOUR = 3600;
    
    /**  Seconds in a minute constant  */
    private static final int SECS_IN_A_MIN = 60;
    
    /*  Angle in normalized degrees  */
    private final double degrees;
    
    /*  Integral number of hours  */
    private final int hours;
    
    /*  Integral number of minutes  */
    private final int minutes;
    
    /*  Integral number of seconds  */
    private final int seconds;
    
    /**
     * Class constructor taking angle in degrees.
     * 
     * Degrees will be normalized, i.e. put in the range
     * {@literal 0 <= degrees < 360}
     * 
     * @param degrees   The angle in degrees
     */
    public HMS(final double degrees) {
        this.degrees = Astro.normalizeDegrees(degrees);
        final long totalSecs = Math.round(this.degrees / 360 * SECS_IN_A_DAY);
        hours = (int) (totalSecs / SECS_IN_A_HOUR);
        minutes = (int) ((totalSecs - hours * SECS_IN_A_HOUR) /
                          SECS_IN_A_MIN);
        seconds = (int) (totalSecs - hours * SECS_IN_A_HOUR -
                                     minutes * SECS_IN_A_MIN);
    }
    
    /**
     * Default class constructor.
     * 
     * Initializes angle to zero degrees.
     */
    public HMS() {
        this(0.0);
    }
    
    /**
     * Returns the integral number of hours.
     * 
     * @return  The integeral number of hours 
     */
    public int getHours() {
        return hours;
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
     * Returns a string representation in the form "00h 00m 00s".
     * 
     * @return  A string representation of the hours, minutes and seconds 
     */
    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("%02dh %02dm %02ds", hours, minutes, seconds);
        return fmt.toString();
    }
}
