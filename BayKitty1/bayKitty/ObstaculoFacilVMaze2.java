import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstaculoFacilVMaze2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstaculoFacilVMaze2 extends Actor
{
    /**
     * Act - do whatever the ObstaculoFacilVMaze2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cont = 10;
    int posx = 0;
    int posy = 0;
    int x = 0;
    int y = 0;
    boolean primeravez = false;;
    int timer = 0;
    
    public ObstaculoFacilVMaze2(int x, int y, int posx, int posy){
        getImage().scale(x, y);
        this.x = x;
        this.y = y;
        this.posx = posx;
        this.posy = posy;
        primeravez = false;
        timer = 0;
    }
    
    public void act()
    {
        
    }
}
