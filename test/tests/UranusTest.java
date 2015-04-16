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

import static net.paulgriffiths.jastro.utils.Astro.getUTCDate;
import static net.paulgriffiths.jastro.utils.Astro.normalizeDegrees;
import net.paulgriffiths.jastro.utils.Planet;
import net.paulgriffiths.jastro.utils.PlanetPosition;
import static net.paulgriffiths.jastro.utils.PlanetPosition.getPosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Uranus position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class UranusTest {
    
    public UranusTest() {
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
    public void testUranusOne() {
        PlanetPosition pos = getPosition(Planet.URANUS,
                                         getUTCDate(1975, 10, 31, 8, 0, 0));
        
        assertEquals(211.38025,
                     normalizeDegrees(pos.getRightAscension()), 0.02);
        assertEquals(360 - 12.21186111111110,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(19.4873488102392, pos.getDistance(), 0.01);
    }
}
