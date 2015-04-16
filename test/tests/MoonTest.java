/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * Moon position unit tests class.
 * 
 * @author  Paul Griffiths
 */
public class MoonTest {
    
    public MoonTest() {
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
    public void testMoonOne() {
        PlanetPosition pos = getPosition(Planet.MOON,
                                         getUTCDate(1988, 8, 10, 0, 0, 0));
        
        assertEquals(112.130708333333,
                     normalizeDegrees(pos.getRightAscension()), 0.3);
        assertEquals(26.1949444444444,
                     normalizeDegrees(pos.getDeclination()), 0.1);      
    }
}
