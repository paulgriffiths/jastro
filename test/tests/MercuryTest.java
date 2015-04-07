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
 * Mercury position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class MercuryTest {
    
    public MercuryTest() {
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
    public void testMercuryOne() {
        PlanetPosition pos = getPosition(Planet.MERCURY,
                                         getUTCDate(1980, 5, 5, 20, 23, 0));
        
        assertEquals(35.0765,
                     normalizeDegrees(pos.getRightAscension()), 0.1);
        assertEquals(12.7926666666667,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(1.30377991344909, pos.getDistance(), 0.0001);
        
    }
}
