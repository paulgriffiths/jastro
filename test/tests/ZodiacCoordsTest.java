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

import astro.ZodiacCoords;

/**
 * Zodiac coordinates class unit tests class.
 * 
 * @author Paul Griffiths
 */
public class ZodiacCoordsTest {
    
    public ZodiacCoordsTest() {
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
    public void testToString() {
        ZodiacCoords zc = new ZodiacCoords(0.0);
        assertEquals("00AR00", zc.toString());
        
        zc = new ZodiacCoords(29.39);
        assertEquals("29AR23", zc.toString());
    
        zc = new ZodiacCoords(133.41);
        assertEquals("13LE24", zc.toString());
        
        zc = new ZodiacCoords(255.88);
        assertEquals("15SG52", zc.toString());
    
        zc = new ZodiacCoords(359.92);
        assertEquals("29PI55", zc.toString());
        
        zc = new ZodiacCoords(407.08);
        assertEquals("17TA04", zc.toString());
        
        zc = new ZodiacCoords(-80.73);
        assertEquals("09CP16", zc.toString());
    }
}
