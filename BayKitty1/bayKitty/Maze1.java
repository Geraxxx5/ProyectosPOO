import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze1 extends World
{
    GatoMaze1 gato =  new GatoMaze1();
    public static Counter contVidas = new Counter();
    /**
     * Constructor for objects of class Maze1.
     * 
     */
    public Maze1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("Laberinto1.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        addObject(gato, 30, 380);
        addObject(new ObstaculoFacil(80,40), 380, 350);
        addObject(new ObstaculoFacil(80,50), 150, 290);
        addObject(new Arma(), 480, 20);
        addObject(new ObstaculoFacilV(100,80), 510, 300);
        addObject(new ObstaculoFacilV(90,80), 100, 200);
        addObject(new ObstaculoFacilV(90,80), 390, 180);
        addObject(new Maceta(), 400, 20);
        
        addObject(contVidas, 50, 20);
        contVidas.setValue(8);
    }
}
