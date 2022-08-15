import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBueno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBueno extends World
{

    /**
     * Constructor for objects of class FinalBueno.
     * 
     */
    public FinalBueno()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("FinalBueno.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    public void act(){
        if(Greenfoot.isKeyDown("ENTER") || Greenfoot.isKeyDown("SPACE")){
            //se inicia el juego
            Greenfoot.setWorld(new MyWorld()); 
            }
    }
}
