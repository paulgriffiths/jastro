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
import net.paulgriffiths.jastro.planet.Planet;
import net.paulgriffiths.jastro.planet.PlanetPosition;
import static net.paulgriffiths.jastro.planet.PlanetPosition.getPosition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pluto position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class PlutoTest {
    
    public PlutoTest() {
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
    public void testPlutoOne() {
        PlanetPosition pos = getPosition(Planet.PLUTO,
                                         getUTCDate(2001, 9, 11, 14, 0, 0));
        
        assertEquals(252.494583333333,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(360 - 12.1994722222222,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(30.5130260187628, pos.getDistance(), 0.01);
    }
}
