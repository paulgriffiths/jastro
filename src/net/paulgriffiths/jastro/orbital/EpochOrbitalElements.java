/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

/**
 * Base class for orbital elements at a specified epoch.
 * 
 * @author  Paul Griffiths
 */
abstract class EpochOrbitalElements extends PointOrbitalElements {
    protected EpochOrbitalElements(final double sma,
                                   final double ecc,
                                   final double inc,
                                   final double ml,
                                   final double lp,
                                   final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
