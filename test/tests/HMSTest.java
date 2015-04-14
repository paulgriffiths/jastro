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
import net.paulgriffiths.astro.HMS;

/**
 * Hours, minutes and seconds class unit tests class.
 * 
 * @author Paul Griffiths
 */
public class HMSTest {
    
    private static final double accuracy = 1e-6;
    
    public HMSTest() {
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
    public void testGetHMS() {
        HMS hms = new HMS();
        assertEquals(0, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(0.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(90.0);
        assertEquals(6, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(90.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(100.0);
        assertEquals(6, hms.getHours());
        assertEquals(40, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(100.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(107.4);
        assertEquals(7, hms.getHours());
        assertEquals(9, hms.getMinutes());
        assertEquals(36, hms.getSeconds());
        assertEquals(107.4, hms.toDegrees(), accuracy);
        
        hms = new HMS(110.0);
        assertEquals(7, hms.getHours());
        assertEquals(20, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(110.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(360.0);
        assertEquals(0, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(0.0, hms.toDegrees(), accuracy);
     
        hms = new HMS(389.62);
        assertEquals(1, hms.getHours());
        assertEquals(58, hms.getMinutes());
        assertEquals(29, hms.getSeconds());
        assertEquals(29.62, hms.toDegrees(), accuracy);
     
        hms = new HMS(450.0);
        assertEquals(6, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(90.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(-100.0);
        assertEquals(17, hms.getHours());
        assertEquals(20, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(260.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(-107.4);
        assertEquals(16, hms.getHours());
        assertEquals(50, hms.getMinutes());
        assertEquals(24, hms.getSeconds());
        assertEquals(252.6, hms.toDegrees(), accuracy);
        
        hms = new HMS(-110.0);
        assertEquals(16, hms.getHours());
        assertEquals(40, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(250.0, hms.toDegrees(), accuracy);
        
        hms = new HMS(-360.0);
        assertEquals(0, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(0.0, hms.toDegrees(), accuracy);
     
        hms = new HMS(-389.62);
        assertEquals(22, hms.getHours());
        assertEquals(1, hms.getMinutes());
        assertEquals(31, hms.getSeconds());
        assertEquals(330.38, hms.toDegrees(), accuracy);
     
        hms = new HMS(-450.0);
        assertEquals(18, hms.getHours());
        assertEquals(0, hms.getMinutes());
        assertEquals(0, hms.getSeconds());
        assertEquals(270.0, hms.toDegrees(), accuracy);
    }
    
    @Test
    public void testToString() {
        HMS hms = new HMS(90.0);
        assertEquals(hms.toString(), "06h 00m 00s");
        
        hms = new HMS(-90.0);
        assertEquals(hms.toString(), "18h 00m 00s");
        
        hms = new HMS(389.62);
        assertEquals(hms.toString(), "01h 58m 29s");
     
        hms = new HMS(-389.62);
        assertEquals(hms.toString(), "22h 01m 31s");
    }
}
