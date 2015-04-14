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

import static net.paulgriffiths.astro.Astro.getUTCDate;
import static net.paulgriffiths.astro.Astro.normalizeDegrees;
import net.paulgriffiths.astro.Planet;
import net.paulgriffiths.astro.PlanetPosition;
import static net.paulgriffiths.astro.PlanetPosition.getPosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Jupiter position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class JupiterTest {
    
    public JupiterTest() {
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
    public void testJupiterOne() {
        PlanetPosition pos = getPosition(Planet.JUPITER,
                                         getUTCDate(1991, 6, 17, 0, 0, 0));
        
        assertEquals(134.511875,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(17.9471666666667,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(5.9852047799159, pos.getDistance(), 0.01);
    }
}
