/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.utils;

import static java.lang.Math.pow;
import static java.lang.Math.atan2;
import static java.lang.Math.hypot;
import static java.lang.Math.sqrt;
import static java.lang.Math.toDegrees;


/**
 * Three dimensional rectangular Cartesian coordinates class.
 * @author paul
 */
public class RectangularCoords {
    private double x;
    private double y;
    private double z;
    
    /**
     * Default class constructor.
     */
    public RectangularCoords() {
        this(0.0, 0.0, 0.0);
    }
    
    /**
     * Class constructor with coordinate arguments.
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     */
    public RectangularCoords(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Class copy constructor.
     * @param other The rectangular coordinates to copy
     */
    public RectangularCoords(final RectangularCoords other) {
        this(other.x, other.y, other.z);
    }
    
    /**
     * Class constructor with spherical coordinates.
     * @param other The spherical coordinates
     */
    public RectangularCoords(final SphericalCoords other) {
        this(other.toRectangular());
    }
    
    /**
     * Gets the X coordinate.
     * @return  The X coordinate
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the Y coordinate.
     * @return  The Y coordinate
     */
    public double getY() {
        return y;
    }
    
    /**
     * Gets the Z coordinate.
     * @return  The Z coordinate
     */
    public double getZ() {
        return z;
    }
    
    /**
     * Sets the coordinates.
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     */
    public void set(final double x, final double y, final double z) {
        setX(x);
        setY(y);
        setZ(z);
    }
    
    /**
     * Sets the coordinates by copying another rectangular coordinates object.
     * @param other The rectangular coordinates object to copy
     */
    public void set(final RectangularCoords other) {
        set(other.x, other.y, other.z);
    }
    
    /**
     * Sets the coordinates from spherical coordinates.
     * @param other The spherical coordinates object from which to set
     */
    public void set(final SphericalCoords other) {
        set(other.toRectangular());
    }
    
    /**
     * Sets the X coordinate
     * @param x The new value of the X coordinate
     */
    public void setX(final double x) {
        this.x = x;
    }
    
    /**
     * Sets the Y coordinate
     * @param y The new value of the Y coordinate
     */
    public void setY(final double y) {
        this.y = y;
    }
    
    /**
     * Sets the Z coordinate
     * @param z The new value of the Z coordinate
     */
    public void setZ(final double z) {
        this.z = z;
    }
    
    /**
     * Adds another set of rectangular coordinates.
     * @param other The set of rectangular coordinates to add
     */
    public void add(final RectangularCoords other) {
        setX(getX() + other.getX());
        setY(getY() + other.getY());
        setZ(getZ() + other.getZ());
    }
    
    /**
     * Subtracts another set of rectangular coordinates.
     * @param other The set of rectangular coordinates to subtract
     */
    public void subtract(final RectangularCoords other) {
        setX(getX() - other.getX());
        setY(getY() - other.getY());
        setZ(getZ() - other.getZ());
    }
    
    /**
     * Converts to spherical coordinates.
     * @return  A spherical coordinate object corresponding to the object
     */
    public SphericalCoords toSpherical() {
        return new SphericalCoords(toDegrees(atan2(y, x)),
                                   toDegrees(atan2(hypot(x, y), z)),
                                   sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2)));
    }
    
    @Override
    public String toString() {
        return String.format("(%.3f, %.3f, %.3f)", x, y, z);
    }
}
