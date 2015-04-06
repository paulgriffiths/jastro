/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

/**
 *
 * @author paul
 */
public enum Planet {
    MERCURY ("Mercury"),
    VENUS ("Venus"),
    EARTH ("Earth"),
    SUN ("Sun"),
    MARS ("Mars"),
    JUPITER ("Jupiter"),
    SATURN ("Saturn"),
    URANUS ("Uranus"),
    NEPTUNE ("Neptune"),
    PLUTO ("Pluto"),
    MOON ("Moon");
    
    private final String name;
    
    Planet(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
