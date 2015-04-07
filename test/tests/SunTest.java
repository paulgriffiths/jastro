/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Unit tests for planetary positions.
 *
 *  Test cases were taken from:
 *
 *    http://ssd.jpl.nasa.gov/?horizons
 *
 *  on August 4, 2013.
 */
package tests;

import static astro.Astro.getUTCDate;
import static astro.Astro.normalizeDegrees;
import astro.Planet;
import astro.PlanetPosition;
import static astro.PlanetPosition.getPosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Sun position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class SunTest {
    
    public SunTest() {
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
    public void testSunOne() {
        PlanetPosition pos = getPosition(Planet.SUN,
                                         getUTCDate(2013, 6, 4, 1, 15, 0));
        
        assertEquals(72.0135416666667,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(22.4078888888889,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(1.01447036664534, pos.getDistance(), 0.0001);
    }
}
