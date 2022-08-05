import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * MyCat is your own cat. Get it to do things by writing code in its act method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyCat extends Cat
{
    /**
     * Act - do whatever the MyCat wants to do.
     */
    Scanner sc = new Scanner(System.in);
    String menu;
    public void act()
    {
        if(isBored()){
            dance();
        }
        if(isHungry()){
            eat();
        }
        if(isSleepy()){
            sleep(5);
            shoutHooray();
        }else{
            shoutHooray();
        }
        if(isAlone()){
            sleep(2);
        }else{
            shoutHooray();
        }
        System.out.println("Seleccione una opcion");
        System.out.println("1) Comer\n2) Bailar\n3) Domir\n4) rutina");
        menu = sc.next();
        switch(menu){
            case "1":
                eat();
                break;
            case "2":
                dance();
                break;
            case "3":
                sleep(5);
                break;
            case "4":
                walkLeft(10);
                walkRight(20);
                walkLeft(10);
                sleep(5);
                break;
        }
    }    
}
