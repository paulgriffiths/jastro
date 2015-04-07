/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.Math.toRadians;
import static astro.Astro.kepler;

/**
 * Keplerian function unit tests class.
 * 
 * @author Paul Griffiths
 */
public class KeplerTest {
    
    /**  Desired accuracy for floating point unit tests  */
    private static final double accuracy = 1e-6;
    
    @Test
    public void testKepler() {
        double expected = toRadians(37.40006);
        double result = kepler(toRadians(20), 0.5);
        assertEquals(expected, result, accuracy);
        
        expected = toRadians(48.43418);
        result = kepler(toRadians(27), 0.5);
        assertEquals(expected, result, accuracy);

        expected = toRadians(226.66512);
        result = kepler(toRadians(235), 0.2);
        assertEquals(expected, result, accuracy);

        expected = toRadians(0);
        result = kepler(toRadians(0), 0);
        assertEquals(expected, result, accuracy);

        expected = toRadians(360);
        result = kepler(toRadians(360), 0);
        assertEquals(expected, result, accuracy);

        expected = toRadians(300);
        result = kepler(toRadians(300), 0);
        assertEquals(expected, result, accuracy);

        expected = toRadians(96.25884);
        result = kepler(toRadians(45), 0.9);
        assertEquals(expected, result, accuracy);
    }
}
