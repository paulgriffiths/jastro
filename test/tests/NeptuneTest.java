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
 * Neptune position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class NeptuneTest {
    
    public NeptuneTest() {
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
    public void testNeptuneOne() {
        PlanetPosition pos = getPosition(Planet.NEPTUNE,
                                         getUTCDate(1966, 9, 15, 9, 0, 0));
        
        assertEquals(228.44925,
                     normalizeDegrees(pos.getRightAscension()), 0.01);
        assertEquals(360 - 16.2009444444444,
                     normalizeDegrees(pos.getDeclination()), 0.01);
        assertEquals(30.8457020366069, pos.getDistance(), 0.01);
    }
}
