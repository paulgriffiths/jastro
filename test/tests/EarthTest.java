/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Unit tests for Earth planetary positions.
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
 * Earth position unit tests class.
 * 
 * @author Paul Griffiths
 */
public class EarthTest {
    
    public EarthTest() {
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
    public void testEarthOne() {
        PlanetPosition pos = getPosition(Planet.EARTH,
                                         getUTCDate(2015, 4, 6, 8, 27, 0));
        
        assertEquals(0.0,
                     normalizeDegrees(pos.getRightAscension()), 0.00001);
        assertEquals(90.0,
                     normalizeDegrees(pos.getDeclination()), 0.00001);
        assertEquals(0.0, pos.getDistance(), 0.00001);
        
    }
}
