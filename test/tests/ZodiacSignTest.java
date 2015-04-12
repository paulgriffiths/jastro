/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import astro.ZodiacSign;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import astro.ZodiacSign;

/**
 * Zodiac sign enumeration class unit tests class.
 * 
 * @author Paul Griffiths
 */
public class ZodiacSignTest {
    
    public ZodiacSignTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLongName() {
        assertEquals(ZodiacSign.ARIES.getLongName(), "Aries");
        assertEquals(ZodiacSign.TAURUS.getLongName(), "Taurus");
        assertEquals(ZodiacSign.GEMINI.getLongName(), "Gemini");
        assertEquals(ZodiacSign.CANCER.getLongName(), "Cancer");
        assertEquals(ZodiacSign.LEO.getLongName(), "Leo");
        assertEquals(ZodiacSign.VIRGO.getLongName(), "Virgo");
        assertEquals(ZodiacSign.LIBRA.getLongName(), "Libra");
        assertEquals(ZodiacSign.SCORPIO.getLongName(), "Scorpio");
        assertEquals(ZodiacSign.SAGITTARIUS.getLongName(), "Sagittarius");
        assertEquals(ZodiacSign.CAPRICORN.getLongName(), "Capricorn");
        assertEquals(ZodiacSign.AQUARIUS.getLongName(), "Aquarius");
        assertEquals(ZodiacSign.PISCES.getLongName(), "Pisces");
    }
    
    @Test
    public void testShortName() {
        assertEquals(ZodiacSign.ARIES.getShortName(), "AR");
        assertEquals(ZodiacSign.TAURUS.getShortName(), "TA");
        assertEquals(ZodiacSign.GEMINI.getShortName(), "GE");
        assertEquals(ZodiacSign.CANCER.getShortName(), "CN");
        assertEquals(ZodiacSign.LEO.getShortName(), "LE");
        assertEquals(ZodiacSign.VIRGO.getShortName(), "VI");
        assertEquals(ZodiacSign.LIBRA.getShortName(), "LI");
        assertEquals(ZodiacSign.SCORPIO.getShortName(), "SC");
        assertEquals(ZodiacSign.SAGITTARIUS.getShortName(), "SG");
        assertEquals(ZodiacSign.CAPRICORN.getShortName(), "CP");
        assertEquals(ZodiacSign.AQUARIUS.getShortName(), "AQ");
        assertEquals(ZodiacSign.PISCES.getShortName(), "PI");
    }
    
    @Test
    public void testSignForDegrees() {
        assertEquals(ZodiacSign.getSignForDegrees(0.0).getShortName(), "AR");
        assertEquals(ZodiacSign.getSignForDegrees(29.9).getShortName(), "AR");
        assertEquals(ZodiacSign.getSignForDegrees(30.0).getShortName(), "TA");
        assertEquals(ZodiacSign.getSignForDegrees(59.9).getShortName(), "TA");
        assertEquals(ZodiacSign.getSignForDegrees(60.0).getShortName(), "GE");
        assertEquals(ZodiacSign.getSignForDegrees(89.9).getShortName(), "GE");
        assertEquals(ZodiacSign.getSignForDegrees(90.0).getShortName(), "CN");
        assertEquals(ZodiacSign.getSignForDegrees(119.9).getShortName(), "CN");
        assertEquals(ZodiacSign.getSignForDegrees(120.0).getShortName(), "LE");
        assertEquals(ZodiacSign.getSignForDegrees(149.9).getShortName(), "LE");
        assertEquals(ZodiacSign.getSignForDegrees(150.0).getShortName(), "VI");
        assertEquals(ZodiacSign.getSignForDegrees(179.9).getShortName(), "VI");
        assertEquals(ZodiacSign.getSignForDegrees(180.0).getShortName(), "LI");
        assertEquals(ZodiacSign.getSignForDegrees(209.9).getShortName(), "LI");
        assertEquals(ZodiacSign.getSignForDegrees(210.0).getShortName(), "SC");
        assertEquals(ZodiacSign.getSignForDegrees(239.9).getShortName(), "SC");
        assertEquals(ZodiacSign.getSignForDegrees(240.0).getShortName(), "SG");
        assertEquals(ZodiacSign.getSignForDegrees(269.9).getShortName(), "SG");
        assertEquals(ZodiacSign.getSignForDegrees(270.0).getShortName(), "CP");
        assertEquals(ZodiacSign.getSignForDegrees(299.9).getShortName(), "CP");
        assertEquals(ZodiacSign.getSignForDegrees(300.0).getShortName(), "AQ");
        assertEquals(ZodiacSign.getSignForDegrees(329.9).getShortName(), "AQ");
        assertEquals(ZodiacSign.getSignForDegrees(330.0).getShortName(), "PI");
        assertEquals(ZodiacSign.getSignForDegrees(359.9).getShortName(), "PI");
        assertEquals(ZodiacSign.getSignForDegrees(-15.0).getShortName(), "PI");
        assertEquals(ZodiacSign.getSignForDegrees(380.0).getShortName(), "AR");   
    }
}
