import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arma extends Actor
{
    /**
     * Act - do whatever the Arma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int movePistola = 3;
    public Arma(){
        getImage().scale(22, 22);
    }
    
    public void disparar(char dir){
        ObstaculoFacil nuevo = null;
        boolean flagBala = true;
        int contBala = 2;
        while(flagBala){
            ObstaculoFacil oF = (ObstaculoFacil) getOneIntersectingObject(ObstaculoFacil.class);
            ObstaculoFacilV oFv = (ObstaculoFacilV) getOneIntersectingObject(ObstaculoFacilV.class);
            if(oF != null){
                getWorld().removeObject(oF);
                getWorld().removeObject(this);
                flagBala = false;
            }
            if(oFv != null){
                getWorld().removeObject(oFv);
                getWorld().removeObject(this);
                flagBala = false;
            }
            if(flagBala){
                if(dir == 'l'){
                    if(!revisar(dir)){
                        setLocation(getX()-movePistola, getY());
                    }else{
                        flagBala = false;
                        getWorld().removeObject(this);
                    }
                }
                if(dir == 'd'){
                    if(!revisar(dir)){
                        setLocation(getX(), getY()+movePistola);
                    }else{
                        flagBala = false;
                        getWorld().removeObject(this);
                    }
                }
                if(dir == 'u'){
                    if(!revisar(dir)){
                        setLocation(getX(), getY()-movePistola);
                    }else{
                        flagBala = false;
                        getWorld().removeObject(this);
                    }
                }
                if(dir == 'r'){
                    if(!revisar(dir)){
                        setLocation(getX()+movePistola, getY());
                    }else{
                        flagBala = false;
                        getWorld().removeObject(this);
                    }
                }
            }
            Greenfoot.delay(1);
        }
    }
    
    public boolean revisar(char dir){
        Color c = null;
        
        if(dir == 'l'){
            c = getWorld().getBackground().getColorAt(getX()-movePistola, getY());
        }
        if(dir == 'r'){
            c = getWorld().getBackground().getColorAt(getX()+movePistola, getY());
        }
        if(dir == 'u'){
            c = getWorld().getBackground().getColorAt(getX(), getY()-movePistola);
        }
        if(dir == 'd'){
            c = getWorld().getBackground().getColorAt(getX(), getY()+movePistola);
        }
        
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        
        
        if((r<30)&&(g<30)&&(b<30)){
            return true;
        }
        
        return false;
    }

    public void act()
    {
        // Add your action code here.
    }
    
    
}
