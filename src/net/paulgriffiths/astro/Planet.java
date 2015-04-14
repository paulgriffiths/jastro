/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.paulgriffiths.astro;

import java.util.Date;

/**
 * Planets enumeration class.
 * 
 * @author Paul Griffiths
 */
public enum Planet {
    
    /**  Mercury  *//**  Mercury  *//**  Mercury  *//**  Mercury  */
    MERCURY ("Mercury",
             OrbitalElements.newJ2000Elements(0.387009927, 0.20563593,
                                              7.00497902, 252.25032350,
                                              77.45779628, 48.33076593),
             OrbitalElements.newJ2000Elements(0.00000037, 0.00001906,
                                              -0.00594749, 149472.67411175,
                                              0.16047689, -0.12534081)),

    /**  Venus  */
    VENUS ("Venus",
           OrbitalElements.newJ2000Elements(0.72333566, 0.00677672,
                                            3.39467605, 181.97909950,
                                            131.60246718, 76.67984255),
           OrbitalElements.newJ2000Elements(0.00000390, -0.00004107,
                                            -0.00078890, 58517.81538729,
                                            0.00268329, -0.27769418)),
    
    /**  Earth  */
    EARTH ("Earth",
           OrbitalElements.newJ2000Elements(1.00000261, 0.01671123,
                                            -0.00001531, 100.46457166,
                                            102.93768193, 0.0),
           OrbitalElements.newJ2000Elements(0.00000562, -0.00004392,
                                            -0.01294668, 35999.37244981,
                                            0.32327364, 0.0)),
    
    /**  Sun  */
    SUN ("Sun",
         OrbitalElements.newJ2000Elements(1.00000261, 0.01671123,
                                          -0.00001531, 100.46457166,
                                          102.93768193, 0.0),
         OrbitalElements.newJ2000Elements(0.00000562, -0.00004392,
                                          -0.01294668, 35999.37244981,
                                          0.32327364, 0.0)),
    
    /**  Mars  */
    MARS ("Mars",
          OrbitalElements.newJ2000Elements(1.52371034, 0.09339410,
                                           1.84969142, -4.55343205,
                                           -23.94362959, 49.55953891),
          OrbitalElements.newJ2000Elements(0.00001847, 0.00007882,
                                           -0.00813131, 19140.30268499,
                                           0.44441088, -0.29257343)),
    
    /**  Jupiter  */
    JUPITER ("Jupiter",
             OrbitalElements.newJ2000Elements(5.20288700, 0.04838624,
                                              1.30439695, 34.39644051,
                                              14.72847983, 100.47390909),
             OrbitalElements.newJ2000Elements(-0.00011607, -0.00013253,
                                              -0.00183714, 3034.74612775,
                                              0.21252668, 0.20469106)),
    
    /**  Saturn  */
    SATURN ("Saturn",
            OrbitalElements.newJ2000Elements(9.53667594, 0.05386179,
                                             2.48599187, 49.95424423,
                                             92.59887831, 113.66242448),
            OrbitalElements.newJ2000Elements(-0.00125060, -0.00050991,
                                             0.00193609, 1222.49362201,
                                             -0.41897216, -0.28867794)),
    
    /**  Uranus  */
    URANUS ("Uranus",
            OrbitalElements.newJ2000Elements(19.18916464, 0.04725744,
                                             0.77263783, 313.23810451,
                                             170.95427630, 74.01692503),
            OrbitalElements.newJ2000Elements(-0.00196176, -0.00004397,
                                             -0.00242939, 428.48202785,
                                             0.40805281, 0.04240589)),
    
    /**  Neptune  */
    NEPTUNE ("Neptune",
             OrbitalElements.newJ2000Elements(30.06992276, 0.00859048,
                                              1.77004347, -55.12002969,
                                              44.96476227, 131.78422574),
             OrbitalElements.newJ2000Elements(0.00026291, 0.00005105,
                                              0.00035372, 218.45945325,
                                              -0.32241464, -0.00508664)),
    
    /**  Pluto  */
    PLUTO ("Pluto",
           OrbitalElements.newJ2000Elements(39.48211675, 0.24882730,
                                            17.14001206, 238.92903833,
                                            224.06891629, 110.30393684),
           OrbitalElements.newJ2000Elements(-0.00031596, 0.00005170,
                                            0.00004818, 145.20780515,
                                            -0.04062942, -0.01183482)),
    
    /**  Moon  */
    MOON ("Moon",
          OrbitalElements.newY2000Elements(60.2666, 0.0549,
                                           5.1454, 198.5516,
                                           83.1862, 125.1228),
          OrbitalElements.newY2000Elements(0, 0,
                                           0, 13.1763964649,
                                           0.111403514, -0.0529538083)),
    
    /**  Sun for Moon  */
    EMBARY("Sun For Moon",
           OrbitalElements.newY2000Elements(1, 0.016709,
                                            0, 278.9874,
                                            -77.0596, 0),
           OrbitalElements.newY2000Elements(0, -0.000000001151,
                                            0, 0.98564735200,
                                            0.00004709350, 0));
    
    /**  The planet's name  */
    private final String name;
    
    /**  The planet's orbital elements at the relevant epoch  */
    private final OrbitalElements epochElems;
    
    /**  The planet's orbital elements delta for the relevant time period  */
    private final OrbitalElements periodElems;
    
    /**
     * Class constructor.
     * 
     * @param name          The planet's name
     * @param epochElems    The orbital elements at the relevant epoch
     * @param periodElems   The orbital elements delta for the relevant period
     */
    private Planet(final String name,
                   final OrbitalElements epochElems,
                   final OrbitalElements periodElems) {
        this.name = name;
        this.epochElems = epochElems;
        this.periodElems = periodElems;
    }
    
    /**
     * Gets this planet's name.
     * 
     * @return  This planet's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the orbital elements at the specified date.
     * 
     * @param date  The date for which to return the elements
     * @return      The orbital elements at the specified date
     */
    public OrbitalElements getDateElements(final Date date) {
        return epochElems.getDateElements(periodElems, date);
    }
}
