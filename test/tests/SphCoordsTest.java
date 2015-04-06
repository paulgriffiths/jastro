/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import astro.SphericalCoords;
import astro.RectangularCoords;
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
public class SphCoordsTest {
    private static final double accuracy = 1e-6;
    
    public SphCoordsTest() {
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
        final SphericalCoords sc = new SphericalCoords();
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
    }
    
    @Test
    public void testArgumentConstructor() {
        final SphericalCoords sc = new SphericalCoords(1, -2, 33042);
        assertEquals(1, sc.getAzimuth(), accuracy);
        assertEquals(-2, sc.getInclination(), accuracy);
        assertEquals(33042, sc.getRadius(), accuracy);
    }
    
    @Test
    public void testCopyConstructor() {
        final SphericalCoords scControl = new SphericalCoords(-6, 5.4, 20.7);
        final SphericalCoords scTest = new SphericalCoords(scControl);
        assertEquals(-6, scTest.getAzimuth(), accuracy);
        assertEquals(5.4, scTest.getInclination(), accuracy);
        assertEquals(20.7, scTest.getRadius(), accuracy);
    }
    
    @Test
    public void testRectangularConstructor() {
        RectangularCoords rc = new RectangularCoords(3, 4, 5);
        SphericalCoords sc = new SphericalCoords(rc);
        assertEquals(53.130102354, sc.getAzimuth(), accuracy);
        assertEquals(45.0, sc.getInclination(), accuracy);
        assertEquals(7.071067811, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-2, 8, 99);
        sc = new SphericalCoords(rc);
        assertEquals(104.036243468, sc.getAzimuth(), accuracy);
        assertEquals(4.761464086, sc.getInclination(), accuracy);
        assertEquals(99.342840708, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(25, -17, 6);
        sc = new SphericalCoords(rc);
        assertEquals(-34.21570213, sc.getAzimuth(), accuracy);
        assertEquals(78.7748043, sc.getInclination(), accuracy);
        assertEquals(30.82207001, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(18, 51, -72);
        sc = new SphericalCoords(rc);
        assertEquals(70.55996517, sc.getAzimuth(), accuracy);
        assertEquals(143.0877173, sc.getInclination(), accuracy);
        assertEquals(90.04998612, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(14, -33, -6);
        sc = new SphericalCoords(rc);
        assertEquals(-67.0112832, sc.getAzimuth(), accuracy);
        assertEquals(99.50200069, sc.getInclination(), accuracy);
        assertEquals(36.34556369, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-61, -12, 59);
        sc = new SphericalCoords(rc);
        assertEquals(-168.8708107, sc.getAzimuth(), accuracy);
        assertEquals(46.49820389, sc.getInclination(), accuracy);
        assertEquals(85.70880935, sc.getRadius(), accuracy);
        
        rc = new RectangularCoords(-10, -31, -17);
        sc = new SphericalCoords(rc);
        assertEquals(-107.8786966, sc.getAzimuth(), accuracy);
        assertEquals(117.5602689, sc.getInclination(), accuracy);
        assertEquals(36.74234614, sc.getRadius(), accuracy);
    }
    
    @Test
    public void testSetCoordsAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.set(100, 50, 70);
        assertEquals(100.0, sc.getAzimuth(), accuracy);
        assertEquals(50.0, sc.getInclination(), accuracy);
        assertEquals(70.0, sc.getRadius(), accuracy);
        assertEquals(100.0, sc.getRightAscension(), accuracy);
        assertEquals(40.0, sc.getDeclination(), accuracy);
        assertEquals(70.0, sc.getDistance(), accuracy);
    
        sc.set(-100, -50, -70);
        assertEquals(-100.0, sc.getAzimuth(), accuracy);
        assertEquals(-50.0, sc.getInclination(), accuracy);
        assertEquals(-70.0, sc.getRadius(), accuracy);
        assertEquals(-100.0, sc.getRightAscension(), accuracy);
        assertEquals(140.0, sc.getDeclination(), accuracy);
        assertEquals(-70.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetCopyAndGetters() {
        final SphericalCoords scControl1 = new SphericalCoords(100, 50, 70);
        final SphericalCoords scControl2 = new SphericalCoords(-100, -50, -70);
        
        SphericalCoords sc = new SphericalCoords();
        sc.set(scControl1);
        assertEquals(100.0, sc.getAzimuth(), accuracy);
        assertEquals(50.0, sc.getInclination(), accuracy);
        assertEquals(70.0, sc.getRadius(), accuracy);
        assertEquals(100.0, sc.getRightAscension(), accuracy);
        assertEquals(40.0, sc.getDeclination(), accuracy);
        assertEquals(70.0, sc.getDistance(), accuracy);
    
        sc.set(scControl2);
        assertEquals(-100.0, sc.getAzimuth(), accuracy);
        assertEquals(-50.0, sc.getInclination(), accuracy);
        assertEquals(-70.0, sc.getRadius(), accuracy);
        assertEquals(-100.0, sc.getRightAscension(), accuracy);
        assertEquals(140.0, sc.getDeclination(), accuracy);
        assertEquals(-70.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetRectangularAndGetters() {
        final RectangularCoords rcControl = new RectangularCoords(11, 15, 19);
        SphericalCoords sc = new SphericalCoords();
        sc.set(rcControl);
        assertEquals(53.74616226, sc.getAzimuth(), accuracy);
        assertEquals(44.39214909, sc.getInclination(), accuracy);
        assertEquals(26.5894716, sc.getRadius(), accuracy);
    }
    
    @Test
    public void testSetAzimuthAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setAzimuth(100);
        assertEquals(100.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(100.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setAzimuth(-100);
        assertEquals(-100.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(-100.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetInclinationAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setInclination(100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(100.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(-10.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setInclination(-100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(-100.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(190.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetRadiusAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setRadius(100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(100.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(100.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setRadius(-100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(-100.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(-100.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetRightAscensionAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setRightAscension(100);
        assertEquals(100.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(100.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setRightAscension(-100);
        assertEquals(-100.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(-100.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetDeclinationAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setDeclination(100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(-10.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(100.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setDeclination(-100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(190.0, sc.getInclination(), accuracy);
        assertEquals(0.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(-100.0, sc.getDeclination(), accuracy);
        assertEquals(0.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testSetDistanceAndGetters() {
        SphericalCoords sc = new SphericalCoords();
        sc.setDistance(100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(100.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(100.0, sc.getDistance(), accuracy);
    
        sc = new SphericalCoords();
        sc.setDistance(-100);
        assertEquals(0.0, sc.getAzimuth(), accuracy);
        assertEquals(0.0, sc.getInclination(), accuracy);
        assertEquals(-100.0, sc.getRadius(), accuracy);
        assertEquals(0.0, sc.getRightAscension(), accuracy);
        assertEquals(90.0, sc.getDeclination(), accuracy);
        assertEquals(-100.0, sc.getDistance(), accuracy);
    }
    
    @Test
    public void testToRectangular() {
        SphericalCoords sc = new SphericalCoords(45, 30, 10);
        RectangularCoords rc = sc.toRectangular();
        assertEquals(3.535533906, rc.getX(), accuracy);
        assertEquals(3.535533906, rc.getY(), accuracy);
        assertEquals(8.660254038, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(25, 15, -7);
        rc = sc.toRectangular();
        assertEquals(-1.641988012, rc.getX(), accuracy);
        assertEquals(-0.7656715846, rc.getY(), accuracy);
        assertEquals(-6.761480784, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(4, -3, 9.3);
        rc = sc.toRectangular();
        assertEquals(-0.4855387569, rc.getX(), accuracy);
        assertEquals(-0.03395217735, rc.getY(), accuracy);
        assertEquals(9.287254673, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-43.8, 7, 64);
        rc = sc.toRectangular();
        assertEquals(5.629468486, rc.getX(), accuracy);
        assertEquals(-5.398466185, rc.getY(), accuracy);
        assertEquals(63.52295371, rc.getZ(), accuracy);
        
        sc = new SphericalCoords(70, -55, -12);
        rc = sc.toRectangular();
        assertEquals(3.361997995, rc.getX(), accuracy);
        assertEquals(9.237013576, rc.getY(), accuracy);
        assertEquals(-6.882917236, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-13.4, -22, 18);
        rc = sc.toRectangular();
        assertEquals(-6.559348642, rc.getX(), accuracy);
        assertEquals(1.562657268, rc.getY(), accuracy);
        assertEquals(16.68930938, rc.getZ(), accuracy);
    
        sc = new SphericalCoords(-11.1, -23.2, -19);
        rc = sc.toRectangular();
        assertEquals(7.344873812, rc.getX(), accuracy);
        assertEquals(-1.441006951, rc.getY(), accuracy);
        assertEquals(-17.46357145, rc.getZ(), accuracy);
    }
}
