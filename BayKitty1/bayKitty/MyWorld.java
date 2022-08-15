import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Cuadro seleccionar = new Cuadro();
    private int opcion = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(seleccionar, 140, 280);
        Greenfoot.playSound("Fondo.mp3");
    }
    public void act(){
        //funcion para Que el cuadro suba y bajo y pueda interactuar
        
        if((Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up"))&&(opcion != 0)){
            opcion++;
        }
        if((Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down"))&&(opcion != 1)){
            opcion--;
        }
        if(opcion >= 2){
            opcion =0;
        }
        if(opcion<0){
            opcion = 1;
        }
        seleccionar.setLocation(140, 280+(opcion*55));
        if(Greenfoot.isKeyDown("ENTER") || Greenfoot.isKeyDown("SPACE")){
            switch(opcion){
                case 0:
                    //se inicia el juego
                    Greenfoot.setWorld(new Escena1());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
            }
        }
    }
}
