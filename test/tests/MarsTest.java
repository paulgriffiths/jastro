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

import astro.Planet;
import astro.PlanetPosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static astro.Astro.getUTCDate;
import static astro.Astro.normalizeDegrees;
import static astro.PlanetPosition.getPosition;

/**
 * Mars position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class MarsTest {
    
    public MarsTest() {
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
    public void testMarsOne() {
        PlanetPosition pos = getPosition(Planet.MARS,
                                         getUTCDate(1997, 6, 21, 0, 0, 0));
        
        assertEquals(180.840541666667,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(0.03566666666667,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(1.18174124286972, pos.getDistance(), 0.0001);
        
    }
}
