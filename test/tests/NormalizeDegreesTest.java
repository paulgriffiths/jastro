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
import static astro.Astro.normalizeDegrees;

/**
 * Normalize degrees function unit tests.
 * 
 * @author Paul Griffiths
 */
public class NormalizeDegreesTest {
    
    /**  Desired accuracy for floating point unit tests  */
    private static final double accuracy = 1e-6;
    
    public NormalizeDegreesTest() {
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
    public void testNormalizeDegrees() {
        double test_result = normalizeDegrees(50);
        assertEquals(50, test_result, accuracy);

        test_result = normalizeDegrees(400);
        assertEquals(40, test_result, accuracy);

        test_result = normalizeDegrees(-60);
        assertEquals(300, test_result, accuracy);

        test_result = normalizeDegrees(-460);
        assertEquals(260, test_result, accuracy);

        test_result = normalizeDegrees(500);
        assertEquals(140, test_result, accuracy);

        test_result = normalizeDegrees(360);
        assertEquals(0, test_result, accuracy);

        test_result = normalizeDegrees(0);
        assertEquals(0, test_result, accuracy);
    }
}
