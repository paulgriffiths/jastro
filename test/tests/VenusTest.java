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
 * Venus position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class VenusTest {
    
    public VenusTest() {
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
    public void testVenusOne() {
        PlanetPosition pos = getPosition(Planet.VENUS,
                                         getUTCDate(1982, 6, 14, 8, 30, 0));
        
        assertEquals(45.2389583333333,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(15.0340277777778,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(1.23214680691694, pos.getDistance(), 0.001);
        
    }
}
