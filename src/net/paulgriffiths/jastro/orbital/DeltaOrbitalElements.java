/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.jastro.orbital;

/**
 * Base class for change in orbital elements over a time period.
 * 
 * @author  Paul Griffiths
 */
abstract class DeltaOrbitalElements extends OrbitalElements {
    protected DeltaOrbitalElements(final double sma,
                                   final double ecc,
                                   final double inc,
                                   final double ml,
                                   final double lp,
                                   final double lan) {
        super(sma, ecc, inc, ml, lp, lan);
    }
}
