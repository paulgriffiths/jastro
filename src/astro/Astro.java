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
 * Astronomical class
 * 
 * @author paul
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
     * @param m_anom    Mean anomaly, in radians
     * @param ecc       Eccentricity
     * @return          The eccentric anomaly, in radians
     */
    public static double kepler(final double m_anom, final double ecc) {
        final double desired_accuracy = 1e-6;
        
        if ( ecc < 0 ) {
            throw new IllegalArgumentException("eccentricity < 0");
        }
        else if ( ecc > 1 ) {
            throw new IllegalArgumentException("eccenticity > 1");
        }
        
        double e_anom = m_anom;
        double diff;
        
        do {
            diff = e_anom - ecc * sin(e_anom) - m_anom;
            e_anom -= diff / (1 - ecc * cos(e_anom));
        } while ( abs(diff) > desired_accuracy );
        
        return e_anom;
    }
    
    public static double normalize_degrees(final double angle) {
        return angle - 360.0 * floor(angle / 360.0);
    }
}