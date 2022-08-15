import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalMalo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalMalo extends World
{

    /**
     * Constructor for objects of class FinalMalo.
     * 
     */
    public FinalMalo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("finJuegoMalo1.png");
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
