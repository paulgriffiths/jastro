/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.astro;

/**
 * Zodiac sign enumeration class.
 * 
 * @author  Paul Griffiths
 */
public enum ZodiacSign {
    
    /**  Aries  */
    ARIES ("Aries", "AR"),
    
    /**  Taurus  */
    TAURUS ("Taurus", "TA"),
    
    /**  Gemini  */
    GEMINI ("Gemini", "GE"),
    
    /**  Cancer  */
    CANCER ("Cancer", "CN"),
    
    /**  Leo  */
    LEO ("Leo", "LE"),
    
    /**  Virgo  */
    VIRGO ("Virgo", "VI"),
    
    /**  Libra  */
    LIBRA ("Libra", "LI"),
    
    /**  Scorpio  */
    SCORPIO ("Scorpio", "SC"),
    
    /**  Sagittarius  */
    SAGITTARIUS ("Sagittarius", "SG"),
    
    /**  Capricorn  */
    CAPRICORN ("Capricorn", "CP"),
    
    /**  Aquarius  */
    AQUARIUS ("Aquarius", "AQ"),
    
    /**  Pisces  */
    PISCES ("Pisces", "PI");
    
    /**  Long name of sign  */
    private final String longName;
    
    /**  Abbreviated short name of sign  */
    private final String shortName;
    
    /**
     * Returns the sign corresponding to the specified position in the
     * ecliptic in degrees.
     * 
     * @param degrees   The position in the ecliptic, in degrees
     * @return          The corresponding sign of the Zodiac
     */
    public static ZodiacSign getSignForDegrees(final double degrees) {
        return values()[(int) (Astro.normalizeDegrees(degrees) / 30)];
    }
    
    /**
     * Class constructor.
     * 
     * @param longName      Full name of sign
     * @param shortName     Short, abbreviated name of sign
     */
    ZodiacSign(final String longName, final String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }
    
    /**
     * Returns the full, long name of the sign.
     * 
     * @return  The full, long name of the sign 
     */
    public String getLongName() {
        return longName;
    }
    
    /**
     * Returns the short, abbreviated name of the sign.
     * 
     * @return  The short, abbreviated name of the sign 
     */
    public String getShortName() {
        return shortName;
    }
}
