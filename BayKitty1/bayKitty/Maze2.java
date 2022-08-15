import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze2 extends World
{
    GatoMaze2 gato = new GatoMaze2();
    public static Counter contVidas = new Counter();
    ObstaculoFacilVMaze2 uno = new ObstaculoFacilVMaze2(100, 80, 570, 50);
    ObstaculoFacilVMaze2 dos = new ObstaculoFacilVMaze2(100, 80, 570, 50);
    ObstaculoFacilVMaze2 tres = new ObstaculoFacilVMaze2(100, 80, 570, 50);
    ObstaculoFacilVMaze2 cuatro = new ObstaculoFacilVMaze2(100, 80, 570, 50);
    ObstaculoFacilVMaze2 cinc = new ObstaculoFacilVMaze2(100, 80, 570, 50);
    
    ObstaculoFacilMaze2 unoH = new ObstaculoFacilMaze2(50,30);
    ObstaculoFacilMaze2 dosH = new ObstaculoFacilMaze2(50,30);
    ObstaculoFacilMaze2 tresH = new ObstaculoFacilMaze2(50,30);
    ObstaculoFacilMaze2 cuaH = new ObstaculoFacilMaze2(50,30);
    ObstaculoFacilMaze2 cinH = new ObstaculoFacilMaze2(50,30);
    ObstaculoFacilMaze2 sixH = new ObstaculoFacilMaze2(50,30);
    
    int cont = 10;
    int timer = 0;
    /**
     * Constructor for objects of class Maze2.
     * 
     */
    public Maze2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("Laberinto2.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        setPaintOrder(Caja.class,GatoMaze2.class,ObstaculoFacilVMaze2.class);
        addObject(new Arma(), 510, 15);
        
        timer = 0;
        addObject(gato, 80, 385);
        addObject(new Caja(), 590, 340);
        addObject(new Caja(), 560, 200);
        addObject(new Caja(), 560, 80);
        addObject(new Caja(), 430, 255);
        addObject(cinH, 400, 303);
        addObject(sixH, 450, 303);
        addObject(new Caja(), 350, 290);
        addObject(contVidas, 50, 20);
        addObject(new ObstaculoFacil(70,60), 455, 120);
        addObject(new ObstaculoFacil(70,60), 200, 160);
        addObject(new ObstaculoFacilV(55, 40), 148,170);
        addObject(new ObstaculoFacilV(55, 40), 70,240);
        addObject(new ObstaculoFacilV(55, 40), 70,140);
        addObject(new ObstaculoFacil(70,60), 250, 40);
        addObject(new Maceta(), 150, 16);
        
        addObject(new Caja(), 50, 350);
        
        addObject(new ObstaculoFacil(50,35), 250,330);
        contVidas.setValue(8);
        
    }
    public void act(){
        if(timer == 0){
            addObject(uno, 570, 50);
            addObject(unoH, 200, 303);
        }
        if(timer == 20){
            addObject(dos, 570, 130);
            addObject(dosH, 250, 303);
        }
        if(timer == 40){
            addObject(tres, 570, 210);
            addObject(tresH, 300, 303);
        }
        if(timer == 80){
            addObject(cuatro, 570, 290);
            addObject(cuaH, 350, 303);
        }
        if(timer == 120){
            addObject(cinc, 570, 370);
        }
        if(timer == 240){
            removeObject(cinc);
        }
        if(timer == 280){
            removeObject(cuatro);
            removeObject(cuaH);
        }
        if(timer == 320){
            removeObject(tres);
            removeObject(tresH);
        }
        if(timer == 360){
            removeObject(dos);
            removeObject(dosH);
        }
        if(timer == 400){
            removeObject(uno);
            removeObject(unoH);
        }
        if(timer == 450){
            timer = -1;
        }
        timer++;
    }
    
}
