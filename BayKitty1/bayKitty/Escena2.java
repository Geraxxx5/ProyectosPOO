import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escena2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escena2 extends World
{

    /**
     * Constructor for objects of class Escena2.
     * 
     */
    public Escena2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("QuintaPantalla.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    public void act(){
        if(Greenfoot.isKeyDown("ENTER") || Greenfoot.isKeyDown("SPACE")){
            //se inicia el juego
            Greenfoot.setWorld(new Maze2()); 
            }
    }
}
