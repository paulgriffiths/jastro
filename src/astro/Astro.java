/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.abs;
import static java.lang.Math.floor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * General astronomical class
 * 
 * @author Paul Griffiths
 */
public class Astro {
    
    /**
     * Returns a Date object for a specified UTC time.
     * 
     * @param year      The year
     * @param month     The month, 1 - 12
     * @param day       The day, 1 - 31
     * @param hour      The hour, 0 - 23
     * @param minute    The minute, 0 - 59
     * @param second    The second, 0 - 59
     * @return          The corresponding date object
     */
    public static Date getUTCDate(final int year, final int month,
                                  final int day, final int hour,
                                  final int minute, final int second) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(year, month - 1, day, hour, minute, second);
        return cal.getTime();
    }
    
    /**
     * Solves Kepler's equation.
     * 
     * @param mAnom     Mean anomaly, in radians
     * @param ecc       Eccentricity
     * @return          The eccentric anomaly, in radians
     */
    public static double kepler(final double mAnom, final double ecc) {
        final double desiredAccuracy = 1e-6;
        
        if ( ecc < 0 ) {
            throw new IllegalArgumentException("eccentricity < 0");
        }
        else if ( ecc > 1 ) {
            throw new IllegalArgumentException("eccenticity > 1");
        }
        
        double eAnom = mAnom;
        double diff;
        
        do {
            diff = eAnom - ecc * sin(eAnom) - mAnom;
            eAnom -= diff / (1 - ecc * cos(eAnom));
        } while ( abs(diff) > desiredAccuracy );
        
        return eAnom;
    }
    
    /**
     * Normalizes an angle in degrees so that {@literal 0 <= angle < 360}.
     * 
     * @param angle The angle to normalize
     * @return      The normalized angle
     */
    public static double normalizeDegrees(final double angle) {
        return angle - 360.0 * floor(angle / 360.0);
    }
}
