/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import astro.RectangularCoords;
import astro.SphericalCoords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paul
 */
public class RectCoordsTest {
    private static final double accuracy = 1e-6;
    
    public RectCoordsTest() {
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
    public void testDefaultConstructor() {
        final RectangularCoords sc = new RectangularCoords();
        assertEquals(0.0, sc.getX(), accuracy);
        assertEquals(0.0, sc.getY(), accuracy);
        assertEquals(0.0, sc.getX(), accuracy);
    }
    
    @Test
    public void testArgumentConstructor() {
        final RectangularCoords sc = new RectangularCoords(1, -2, 33042);
        assertEquals(1, sc.getX(), accuracy);
        assertEquals(-2, sc.getY(), accuracy);
        assertEquals(33042, sc.getZ(), accuracy);
    }
    
    @Test
    public void testCopyConstructor() {
        final RectangularCoords rcC = new RectangularCoords(-55, 102, -33.8);
        final RectangularCoords rcT = new RectangularCoords(rcC);
        assertEquals(-55, rcT.getX(), accuracy);
        assertEquals(102, rcT.getY(), accuracy);
        assertEquals(-33.8, rcT.getZ(), accuracy);
    }
    
    @Test
    public void testSphericalConstructor() {
        SphericalCoords sc = new SphericalCoords(45, 30, 10);
        RectangularCoords rc = new RectangularCoords(sc);
        assertEquals(3.535533906, rc.getX(), accuracy);
        assertEquals(3.535533906, rc.getY(), accuracy);
        assertEquals(8.660254038, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(25, 15, -7);
        rc = new RectangularCoords(sc);
        assertEquals(-1.641988012, rc.getX(), accuracy);
        assertEquals(-0.7656715846, rc.getY(), accuracy);
        assertEquals(-6.761480784, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(4, -3, 9.3);
        rc = new RectangularCoords(sc);
        assertEquals(-0.4855387569, rc.getX(), accuracy);
        assertEquals(-0.03395217735, rc.getY(), accuracy);
        assertEquals(9.287254673, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-43.8, 7, 64);
        rc = new RectangularCoords(sc);
        assertEquals(5.629468486, rc.getX(), accuracy);
        assertEquals(-5.398466185, rc.getY(), accuracy);
        assertEquals(63.52295371, rc.getZ(), accuracy);
        
        sc = new SphericalCoords(70, -55, -12);
        rc = new RectangularCoords(sc);
        assertEquals(3.361997995, rc.getX(), accuracy);
        assertEquals(9.237013576, rc.getY(), accuracy);
        assertEquals(-6.882917236, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-13.4, -22, 18);
        rc = new RectangularCoords(sc);
        assertEquals(-6.559348642, rc.getX(), accuracy);
        assertEquals(1.562657268, rc.getY(), accuracy);
        assertEquals(16.68930938, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-11.1, -23.2, -19);
        rc = new RectangularCoords(sc);
        assertEquals(7.344873812, rc.getX(), accuracy);
        assertEquals(-1.441006951, rc.getY(), accuracy);
        assertEquals(-17.46357145, rc.getZ(), accuracy);
    }
    
    @Test
    public void testSetXAndGetters() {
        RectangularCoords rc = new RectangularCoords();
        rc.setX(100);
        assertEquals(100.0, rc.getX(), accuracy);
        assertEquals(0.0, rc.getY(), accuracy);
        assertEquals(0.0, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testSetYAndGetters() {
        RectangularCoords rc = new RectangularCoords();
        rc.setY(-100);
        assertEquals(0.0, rc.getX(), accuracy);
        assertEquals(-100.0, rc.getY(), accuracy);
        assertEquals(0.0, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testSetZAndGetters() {
        RectangularCoords rc = new RectangularCoords();
        rc.setZ(-30);
        assertEquals(0.0, rc.getX(), accuracy);
        assertEquals(0.0, rc.getY(), accuracy);
        assertEquals(-30.0, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testSetAndGetters() {
        RectangularCoords rc = new RectangularCoords();
        rc.set(-25, 11, 13);
        assertEquals(-25.0, rc.getX(), accuracy);
        assertEquals(11.0, rc.getY(), accuracy);
        assertEquals(13.0, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testSetCopyAndGetters() {
        final RectangularCoords rcControl = new RectangularCoords(1, 2, 3);
        RectangularCoords rc = new RectangularCoords();
        rc.set(rcControl);
        assertEquals(1.0, rc.getX(), accuracy);
        assertEquals(2.0, rc.getY(), accuracy);
        assertEquals(3.0, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testSetSphericalAndGetters() {
        final SphericalCoords sc = new SphericalCoords(15, 30, 100);
        RectangularCoords rc = new RectangularCoords();
        rc.set(sc);
        assertEquals(48.29629131, rc.getX(), accuracy);
        assertEquals(12.94095226, rc.getY(), accuracy);
        assertEquals(86.60254038, rc.getZ(), accuracy);   
    }
    
    @Test
    public void testToSpherical() {
        RectangularCoords rc = new RectangularCoords(3, 4, 5);
        SphericalCoords sc = rc.toSpherical();
        assertEquals(53.130102354, sc.getAzimuth(), accuracy);
        assertEquals(45.0, sc.getInclination(), accuracy);
        assertEquals(7.071067811, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-2, 8, 99);
        sc = rc.toSpherical();
        assertEquals(104.036243468, sc.getAzimuth(), accuracy);
        assertEquals(4.761464086, sc.getInclination(), accuracy);
        assertEquals(99.342840708, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(25, -17, 6);
        sc = rc.toSpherical();
        assertEquals(-34.21570213, sc.getAzimuth(), accuracy);
        assertEquals(78.7748043, sc.getInclination(), accuracy);
        assertEquals(30.82207001, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(18, 51, -72);
        sc = rc.toSpherical();
        assertEquals(70.55996517, sc.getAzimuth(), accuracy);
        assertEquals(143.0877173, sc.getInclination(), accuracy);
        assertEquals(90.04998612, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(14, -33, -6);
        sc = rc.toSpherical();
        assertEquals(-67.0112832, sc.getAzimuth(), accuracy);
        assertEquals(99.50200069, sc.getInclination(), accuracy);
        assertEquals(36.34556369, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-61, -12, 59);
        sc = rc.toSpherical();
        assertEquals(-168.8708107, sc.getAzimuth(), accuracy);
        assertEquals(46.49820389, sc.getInclination(), accuracy);
        assertEquals(85.70880935, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-10, -31, -17);
        sc = rc.toSpherical();
        assertEquals(-107.8786966, sc.getAzimuth(), accuracy);
        assertEquals(117.5602689, sc.getInclination(), accuracy);
        assertEquals(36.74234614, sc.getRadius(), accuracy);
    }
    
    @Test
    public void testToCelestial() {
        RectangularCoords rc = new RectangularCoords(3, 4, 5);
        SphericalCoords sc = rc.toSpherical();
        assertEquals(53.130102354, sc.getRightAscension(), accuracy);
        assertEquals(45.0, sc.getDeclination(), accuracy);
        assertEquals(7.071067811, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(-2, 8, 99);
        sc = rc.toSpherical();
        assertEquals(104.036243468, sc.getRightAscension(), accuracy);
        assertEquals(90 - 4.761464086, sc.getDeclination(), accuracy);
        assertEquals(99.342840708, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(25, -17, 6);
        sc = rc.toSpherical();
        assertEquals(-34.21570213, sc.getRightAscension(), accuracy);
        assertEquals(90 - 78.7748043, sc.getDeclination(), accuracy);
        assertEquals(30.82207001, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(18, 51, -72);
        sc = rc.toSpherical();
        assertEquals(70.55996517, sc.getRightAscension(), accuracy);
        assertEquals(90 - 143.0877173, sc.getDeclination(), accuracy);
        assertEquals(90.04998612, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(14, -33, -6);
        sc = rc.toSpherical();
        assertEquals(-67.0112832, sc.getRightAscension(), accuracy);
        assertEquals(90 - 99.50200069, sc.getDeclination(), accuracy);
        assertEquals(36.34556369, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(-61, -12, 59);
        sc = rc.toSpherical();
        assertEquals(-168.8708107, sc.getRightAscension(), accuracy);
        assertEquals(90 - 46.49820389, sc.getDeclination(), accuracy);
        assertEquals(85.70880935, sc.getDistance(), accuracy);
        
        rc = new RectangularCoords(-10, -31, -17);
        sc = rc.toSpherical();
        assertEquals(-107.8786966, sc.getRightAscension(), accuracy);
        assertEquals(90 - 117.5602689, sc.getDeclination(), accuracy);
        assertEquals(36.74234614, sc.getDistance(), accuracy);
    }
}
