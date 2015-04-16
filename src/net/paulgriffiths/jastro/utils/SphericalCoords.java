/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.utils;

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

/**
 * Spherical coordinates class.
 * 
 * @author paul
 */
public class SphericalCoords {
    private double azimuth;         //  Right ascension
    private double inclination;     //  Declination
    private double radius;          //  Distance
    
    /**
     * Default class constructor.
     */
    public SphericalCoords() {
        this(0.0, 0.0, 0.0);
    }
    
    /**
     * Class constructor specifying coordinates.
     * 
     * @param azimuth       Azimuth
     * @param inclination   Inclination
     * @param radius        Radius
     */
    public SphericalCoords(final double azimuth,
                           final double inclination,
                           final double radius) {
        this.azimuth = azimuth;
        this.inclination = inclination;
        this.radius = radius;
    }
    
    /**
     * Class copy constructor.
     * @param other The object from which to copy
     */
    public SphericalCoords(final SphericalCoords other) {
        this(other.azimuth, other.inclination, other.radius);
    }
    
    /**
     * Class constructor from rectangular coordinates.
     * @param other The rectangular coordinates.
     */
    public SphericalCoords(final RectangularCoords other) {
        this(other.toSpherical());
    }
    
   /**
     * Gets the azimuth.
     * @return  The azimuth
     */
    public double getAzimuth() {
        return azimuth;
    }
    
    /**
     * Gets the inclination.
     * @return  The inclination 
     */
    public double getInclination() {
        return inclination;
    }
    
    /**
     * Gets the radius.
     * @return  The radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Gets the right ascension.
     * 
     * Right ascension is equivalent to the azimuth.
     * 
     * @return  The right ascension
     */
    public double getRightAscension() {
        return getAzimuth();
    }
    
    /**
     * Gets the declination.
     * 
     * Declination, or elevation angle, is measured upwards from the
     * reference plane, whereas the inclination is measured from a fixed
     * fixed zenith direction (notionally straight up, meaning the
     * inclination angle is always downwards).
     * 
     * @return  The declination 
     */
    public double getDeclination() {
        return 90.0 - getInclination();
    }
    
    /**
     * Gets the distance.
     * 
     * Distance is equivalent to the radius.
     * 
     * @return  The distance
     */
    public double getDistance() {
        return getRadius();
    }
    
    /**
     * Sets the coordinates.
     * @param azimuth       Azimuth
     * @param inclination   Inclination
     * @param radius        Radius
    */
    public void set(final double azimuth,
                    final double inclination,
                    final double radius) {
        setAzimuth(azimuth);
        setInclination(inclination);
        setRadius(radius);
    }
    
    /**
     * Sets the coordinates by copying another object.
     * @param other The object to copy.
     */
    public void set(final SphericalCoords other) {
        set(other.azimuth, other.inclination, other.radius);
    }
    
    /**
     * Sets the coordinates by from rectangular coordinates.
     * @param other The rectangular coordinates
     */
    public void set(final RectangularCoords other) {
        set(other.toSpherical());
    }
    
    /**
     * Sets the azimuth.
     * @param azimuth   The new azimuth
     */
    public void setAzimuth(final double azimuth) {
        this.azimuth = azimuth;
    }
    
    /**
     * Sets the inclination.
     * @param inclination   The new inclination
     */
    public void setInclination(final double inclination) {
        this.inclination = inclination;
    }
    
    /**
     * Sets the radius.
     * @param radius    The new radius
     */
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    /**
     * Sets the right ascension.
     * 
     * Right ascension is equivalent to the azimuth.
     * 
     * @param ra    The new ight ascension
     */
    public void setRightAscension(final double ra) {
        setAzimuth(ra);
    }
    
    /**
     * Sets the declination.
     * 
     * Declination, or elevation angle, is measured upwards from the
     * reference plane, whereas the inclination is measured from a fixed
     * fixed zenith direction (notionally straight up, meaning the
     * inclination angle is always downwards).
     * 
     * @param decl  THe new declination
     */
    public void setDeclination(final double decl) {
        setInclination(90.0 - decl);
    }
    
    /**
     * Sets the distance.
     * 
     * Distance is equivalent to the radius.
     * 
     * @param dist  THe new distance
     */
    public void setDistance(final double dist) {
        setRadius(dist);
    }
    
    /**
     * Converts to rectangular Cartesian coordinates.
     * @return The rectangular coordinates corresponding to the object
     */
    public RectangularCoords toRectangular() {
        return new RectangularCoords(
                radius * sin(toRadians(inclination)) * cos(toRadians(azimuth)),
                radius * sin(toRadians(inclination)) * sin(toRadians(azimuth)),
                radius * cos(toRadians(inclination)));
    }
}
