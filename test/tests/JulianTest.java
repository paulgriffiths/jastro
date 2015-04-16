/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import net.paulgriffiths.jastro.utils.JulianDate;
import static net.paulgriffiths.jastro.utils.Astro.getUTCDate;

/**
 * Julian date unit tests class.
 * 
 * @author Paul Griffiths
 */
public class JulianTest {
    
    /**  Desired accuracy for floating point unit tests  */
    private static final double accuracy = 1e-3;
    
    public JulianTest() {
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
    public void testJulianDate() {
        JulianDate jd = new JulianDate(getUTCDate(2013, 6, 2, 0, 0, 0));
        double test_date = jd.getJulianDate();
        assertEquals(2456445.5, test_date, accuracy);
        
        jd = new JulianDate(getUTCDate(1980, 1, 1, 0, 0, 0));
        test_date = jd.getJulianDate();
        assertEquals(2444239.5, test_date, accuracy);
        
        jd = new JulianDate(getUTCDate(1918, 11, 11, 11, 11, 0));
        test_date = jd.getJulianDate();
        assertEquals(2421908.9661, test_date, accuracy);    
    }
    
    @Test
    public void testCompare() {
        final JulianDate jd1 = new JulianDate(getUTCDate(2012, 6, 2, 0, 0, 0));
        final JulianDate jd2 = new JulianDate(getUTCDate(2013, 6, 2, 0, 0, 0));
        final JulianDate jd3 = new JulianDate(getUTCDate(2013, 6, 2, 0, 0, 0));
        final JulianDate jd4 = new JulianDate(getUTCDate(2014, 6, 2, 0, 0, 0));
    
        assertTrue(jd1.compareTo(jd2) < 0);
        assertTrue(jd2.compareTo(jd1) > 0);
        assertFalse(jd1.equals(jd2));
        assertFalse(jd2.equals(jd1));
        assertTrue(jd1.compareTo(jd3) < 0);
        assertTrue(jd3.compareTo(jd1) > 0);
        assertFalse(jd1.equals(jd3));
        assertFalse(jd3.equals(jd1));
        assertTrue(jd1.compareTo(jd4) < 0);
        assertTrue(jd4.compareTo(jd1) > 0);
        assertFalse(jd1.equals(jd4));
        assertFalse(jd4.equals(jd1));
        
        assertTrue(jd2.compareTo(jd3) == 0);
        assertTrue(jd3.compareTo(jd2) == 0);
        assertTrue(jd2.equals(jd3));
        assertTrue(jd3.equals(jd2));
        assertTrue(jd2.compareTo(jd4) < 0);
        assertTrue(jd4.compareTo(jd2) > 0);
        assertFalse(jd2.equals(jd4));
        assertFalse(jd4.equals(jd2));
        
        assertTrue(jd3.compareTo(jd4) < 0);
        assertTrue(jd4.compareTo(jd3) > 0);
        assertFalse(jd3.equals(jd4));
        assertFalse(jd4.equals(jd3));
    }
}
