/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import net.paulgriffiths.jastro.utils.Planet;

/**
 * Planets enumeration class unit tests class.
 * 
 * @author Paul Griffiths
 */
public class PlanetTest {
    
    public PlanetTest() {
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
    public void testPlanetName() {
        assertEquals(Planet.EARTH.getName(), "Earth");
        assertEquals(Planet.SUN.getName(), "Sun");
        assertEquals(Planet.MERCURY.getName(), "Mercury");
        assertEquals(Planet.VENUS.getName(), "Venus");
        assertEquals(Planet.MARS.getName(), "Mars");
        assertEquals(Planet.JUPITER.getName(), "Jupiter");
        assertEquals(Planet.SATURN.getName(), "Saturn");
        assertEquals(Planet.URANUS.getName(), "Uranus");
        assertEquals(Planet.NEPTUNE.getName(), "Neptune");
        assertEquals(Planet.PLUTO.getName(), "Pluto");
        assertEquals(Planet.MOON.getName(), "Moon");
    }
}
