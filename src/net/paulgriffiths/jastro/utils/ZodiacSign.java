/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.utils;

/**
 * Zodiac sign enumeration class.
 * 
 * @author  Paul Griffiths
 */
public enum ZodiacSign {
    ARIES ("Aries", "AR"),
    TAURUS ("Taurus", "TA"),
    GEMINI ("Gemini", "GE"),
    CANCER ("Cancer", "CN"),
    LEO ("Leo", "LE"),
    VIRGO ("Virgo", "VI"),
    LIBRA ("Libra", "LI"),
    SCORPIO ("Scorpio", "SC"),
    SAGITTARIUS ("Sagittarius", "SG"),
    CAPRICORN ("Capricorn", "CP"),
    AQUARIUS ("Aquarius", "AQ"),
    PISCES ("Pisces", "PI");
    
    private final String longName;
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
    
    @Override
    public String toString() {
        return getLongName();
    }
}
