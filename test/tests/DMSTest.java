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

import net.paulgriffiths.jastro.utils.DMS;

/**
 *
 * @author paul
 */
public class DMSTest {
    private static final double accuracy = 1e-6;
    
    public DMSTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConstruct() {
        DMS dms = new DMS();
        assertEquals(0, dms.getDegrees());
        assertEquals(0, dms.getMinutes());
        assertEquals(0, dms.getSeconds());
        assertEquals(0.0, dms.toDegrees(), accuracy);
        
        dms = new DMS(90.0);
        assertEquals(90, dms.getDegrees());
        assertEquals(0, dms.getMinutes());
        assertEquals(0, dms.getSeconds());
        assertEquals(90.0, dms.toDegrees(), accuracy);
        
        dms = new DMS(-90.0);
        assertEquals(-90, dms.getDegrees());
        assertEquals(0, dms.getMinutes());
        assertEquals(0, dms.getSeconds());
        assertEquals(-90.0, dms.toDegrees(), accuracy);
        
        dms = new DMS(90.5);
        assertEquals(90, dms.getDegrees());
        assertEquals(30, dms.getMinutes());
        assertEquals(0, dms.getSeconds());
        assertEquals(90.5, dms.toDegrees(), accuracy);
        
        dms = new DMS(-90.5);
        assertEquals(-90, dms.getDegrees());
        assertEquals(-30, dms.getMinutes());
        assertEquals(0, dms.getSeconds());
        assertEquals(-90.5, dms.toDegrees(), accuracy);
        
        dms = new DMS(111.374);
        assertEquals(111, dms.getDegrees());
        assertEquals(22, dms.getMinutes());
        assertEquals(26, dms.getSeconds());
        assertEquals(111.374, dms.toDegrees(), accuracy);
        
        dms = new DMS(-111.374);
        assertEquals(-111, dms.getDegrees());
        assertEquals(-22, dms.getMinutes());
        assertEquals(-26, dms.getSeconds());
        assertEquals(-111.374, dms.toDegrees(), accuracy);
        
        dms = new DMS(504.892);
        assertEquals(504, dms.getDegrees());
        assertEquals(53, dms.getMinutes());
        assertEquals(31, dms.getSeconds());
        assertEquals(504.892, dms.toDegrees(), accuracy);
        
        dms = new DMS(-504.892);
        assertEquals(-504, dms.getDegrees());
        assertEquals(-53, dms.getMinutes());
        assertEquals(-31, dms.getSeconds());
        assertEquals(-504.892, dms.toDegrees(), accuracy);
    }
    
    @Test
    public void testToString() {
        DMS dms = new DMS();
        assertEquals(dms.toString(), "+00d 00m 00s");
        
        dms = new DMS(11.374);
        assertEquals(dms.toString(), "+11d 22m 26s");
    
        dms = new DMS(-11.374);
        assertEquals(dms.toString(), "-11d 22m 26s");
        
        dms = new DMS(54.892);
        assertEquals(dms.toString(), "+54d 53m 31s");
    
        dms = new DMS(-54.892);
        assertEquals(dms.toString(), "-54d 53m 31s");
        
        dms = new DMS(222.222);
        assertEquals(dms.toString(), "+222d 13m 19s");
    
        dms = new DMS(-222.222);
        assertEquals(dms.toString(), "-222d 13m 19s");
    }
}
