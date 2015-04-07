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
 * Saturn position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class SaturnTest {
    
    public SaturnTest() {
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
    public void testSaturnOne() {
        PlanetPosition pos = getPosition(Planet.SATURN,
                                         getUTCDate(1947, 12, 1, 12, 0, 0));
        
        assertEquals(146.079125,
                     normalizeDegrees(pos.getRightAscension()), 0.02);
        assertEquals(14.6949444444444,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(8.84280824210253, pos.getDistance(), 0.01);
    }
}
