/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Date;

/**
 * Julian date class
 * 
 * @author paul
 */
public class JulianDate implements Comparable<JulianDate> {
    private static final double MS_IN_A_DAY = 86400000.0;
    private static final double EPOCH_J2000 = 2451545.0;
    private static final double DAYS_IN_CENTURY = 36525;
    private static final long TS_J2000;
    
    private final double jdate;
    
    static {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(2000, 0, 1, 12, 0, 0);
        TS_J2000 = cal.getTime().getTime();
    }
    
    private static double jdate_from_date(final Date d) {
        return EPOCH_J2000 + ((d.getTime() - TS_J2000) / MS_IN_A_DAY);
    }
    
    public JulianDate() {
        jdate = jdate_from_date(Calendar.getInstance().getTime());
    }
    
    public JulianDate(final Date date) {
        jdate = jdate_from_date(date);
    }
    
    public double getJulianDate() {
        return jdate;
    }
    
    public double daysSinceJ2000() {
        return jdate - EPOCH_J2000;
    }
    
    public double centuriesSinceJ2000() {
        return daysSinceJ2000() / DAYS_IN_CENTURY;
    }
    
    /**
     * Overriden equals method.
     * 
     * JulianDate objects can be compared to each other, and to
     * Double objects.
     * 
     * @param obj   The comparison object
     * @return      True if they are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        else if ( obj == null ) {
            return false;
        }
        else if ( obj instanceof JulianDate ) {
            if ( getJulianDate() == ((JulianDate) obj).getJulianDate() ) {
                return true;
            }
        }
        else if ( obj instanceof Double ) {
            if ( getJulianDate() == ((Double) obj) ) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Override hash code method.
     * 
     * This provides a terrible hash. Revise at some point.
     * 
     * @return  The hash code 
     */
    @Override
    public int hashCode() {
        return ((int) getJulianDate()) % 100;
    }
    
    @Override
    public int compareTo(JulianDate date) {
        if ( getJulianDate() < date.getJulianDate() ) {
            return -1;
        }
        else if ( getJulianDate() > date.getJulianDate() ) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
