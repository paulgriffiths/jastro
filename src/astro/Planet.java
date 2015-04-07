/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astro;

/**
 * Planets enumeration class.
 * 
 * @author Paul Griffiths
 */
public enum Planet {
    
    /**  Mercury  */
    MERCURY ("Mercury"),
    
    /**  Venus  */
    VENUS ("Venus"),
    
    /**  Earth  */
    EARTH ("Earth"),
    
    /**  Sun  */
    SUN ("Sun"),
    
    /**  Mars  */
    MARS ("Mars"),
    
    /**  Jupiter  */
    JUPITER ("Jupiter"),
    
    /**  Saturn  */
    SATURN ("Saturn"),
    
    /**  Uranus  */
    URANUS ("Uranus"),
    
    /**  Neptune  */
    NEPTUNE ("Neptune"),
    
    /**  Pluto  */
    PLUTO ("Pluto"),
    
    /**  Moon  */
    MOON ("Moon");
    
    /**  The planet's name  */
    private final String name;
    
    /**
     * Class constructor.
     * 
     * @param name  The planet's name
     */
    private Planet(final String name) {
        this.name = name;
    }
    
    /**
     * Gets this planet's name.
     * 
     * @return  This planet's name
     */
    public String getName() {
        return name;
    }
}
