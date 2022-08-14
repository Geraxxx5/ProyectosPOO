import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class GatoMaze1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GatoMaze1 extends Actor
{
    /**
     * Act - do whatever the GatoMaze1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage derecha1 = new GreenfootImage("GatoParaLaDerecha.png");
    GreenfootImage derecha2 = new GreenfootImage("GatoParaLaDerecha2.png");
    GreenfootImage derechaStop = new GreenfootImage("GatoParaLaDerechaParado.png");
    GreenfootImage izquierda1 = new GreenfootImage("GatoParaLaIzquierda.png");
    GreenfootImage izquierda2 = new GreenfootImage("GatoParaLaIzquierda2.png");
    GreenfootImage izquierdaStop = new GreenfootImage("GatoParaLaIzquierdaParado.png");
    GreenfootImage arriba1 = new GreenfootImage("GatoParaArriba.png");
    GreenfootImage arriba2 = new GreenfootImage("GatoParaArriba2.png");
    GreenfootImage arribaStop = new GreenfootImage("GatoParaArribaParado.png");
    GreenfootImage abajo1 = new GreenfootImage("GatoParaAbajo.png");
    GreenfootImage abajo2 = new GreenfootImage("GatoParaAbajo2.png");
    GreenfootImage abajoStop = new GreenfootImage("GatoParaAbajoParado.png");
    
    int gatoMove = 3;
    boolean disparo;
    boolean isKeyPress = false;
    String viendoDireccion = "arriba";
    int frame;
    char dir = 'a';
    
    public GatoMaze1(){
        getImage().scale(22,22);
        this.disparo = false;
        
    }
    
    public void act()
    {
        // Add your action code here.
        isKeyPress = false;
        if(Greenfoot.isKeyDown("up")){
            if(!revisarAguaHorizontal('u')){
                if(!revisarParedes('u')){
                    caminarArriba();
                    setLocation(getX(), getY()-gatoMove);
                    setRotation(270);
                    isKeyPress = true;
                } 
            }else{
                Maze1.contVidas.add(-1);
            }
        }
        if(Greenfoot.isKeyDown("right")){
            if(!revisarAguaHorizontal('r')){
                if(!revisarParedes('r')){
                    caminarDerecha();
                    setLocation(getX()+gatoMove, getY());
                    setRotation(0);
                    isKeyPress = true;
                }
            }else{
                if(Maze1.contVidas.getValue() == 0){
                    
                }
                Maze1.contVidas.add(-1);
            }
        }
        if(Greenfoot.isKeyDown("left")){
            if(!revisarParedes('l')){
                caminarIzquierda();
                setLocation(getX()-gatoMove, getY());
                setRotation(180);
                isKeyPress = true;
            }
        }
        if(Greenfoot.isKeyDown("down")){
            if(!revisarParedes('d')){
                caminarAbajo();
                setLocation(getX(), getY()+gatoMove);
                setRotation(90);
                isKeyPress = true;
            }
        }
        if(!(isKeyPress)){
            //terminar de caminar
            pararCaminar();
        }
        
        if(!this.disparo){
            Arma bP = (Arma) getOneIntersectingObject(Arma.class);
            if(bP != null){
                getWorld().removeObject(bP);
                this.disparo = true;
            }
        }
        
        
        if("space".equals(Greenfoot.getKey())){
            if(this.disparo){
                disparar();
            }
        }
    }

    public boolean revisarAguaHorizontal(char dir){
        ObstaculoFacil oF = null;
        if (dir == 'l'){
            oF = (ObstaculoFacil) getOneObjectAtOffset(-gatoMove,0,ObstaculoFacil.class);
        }
        if (dir == 'r'){
            oF = (ObstaculoFacil) getOneObjectAtOffset(gatoMove,0,ObstaculoFacil.class);
        }
        if (dir == 'u'){
            oF = (ObstaculoFacil) getOneObjectAtOffset(0,-gatoMove,ObstaculoFacil.class);
        }
        if (dir == 'd'){
            oF = (ObstaculoFacil) getOneObjectAtOffset(0,gatoMove,ObstaculoFacil.class);
        }
        if (oF != null){
            return true;
        }
        return false;
    }
    
    public void disparar(){
        int rotacion = getRotation();
        Arma bola = new Arma();
        getWorld().addObject(bola, getX(), getY()); 
        if(getRotation() == 270){
            dir='u';
        }
        if(getRotation() == 90){
            dir='d';
        }
        if(getRotation() == 180){
            //System.out.println("entro");
            dir='l';
        }
        if(getRotation() == 0){
            dir='r';
        }
        bola.disparar(dir);       
    }
    
    public void pararCaminar(){
        switch(viendoDireccion){
            case "derecha":
                setImage(derechaStop);
                break;
            case "izquierda":
                setImage(izquierdaStop);
                break;
            case "abajo":
                setImage(abajoStop);
                break;
            case "arriba":
                setImage(arribaStop);
                setRotation(270);
                break;
        }
    }
    
    public void caminarAbajo(){
        frame ++;
        viendoDireccion = "abajo";
        if(frame==1)
        {
            setImage(abajo1);
        }
        else if(frame==2)
        {
            setImage(abajo2);
        }
        else if(frame==3)
        {
            setImage(abajoStop);
        }
        else if(frame==4)
        {
            frame = 0;
            return;
        }
    }
    
    public void caminarArriba(){
        frame ++;
        viendoDireccion = "arriba";
        if(frame==1)
        {
            setImage(arriba1);
        }
        else if(frame==2)
        {
            setImage(arribaStop);
        }
        else if(frame==3)
        {
            setImage(arriba2);
        }
        else if(frame==4)
        {
            frame = 0;
            return;
        }
    }
    
    public void caminarIzquierda(){
        frame ++;
        viendoDireccion = "izquierda";
        if(frame==1)
        {
            setImage(izquierda1);
        }
        else if(frame==2)
        {
            setImage(izquierdaStop);
        }
        else if(frame==3)
        {
            setImage(izquierda2);
        }
        else if(frame==4)
        {
            frame = 0;
            return;
        }
    }
    
    public void caminarDerecha(){
        frame ++;
        viendoDireccion = "derecha";
        if(frame==1)
        {
            setImage(derecha1);
        }
        else if(frame==2)
        {
            setImage(derechaStop);
        }
        else if(frame==3)
        {
            setImage(derecha2);
        }
        else if(frame==4)
        {
            frame = 0;
            return;
        }
    }
    
    
    public boolean revisarParedes(char dir){
        Color c = null;
        
        if(dir == 'l'){
            c = getWorld().getBackground().getColorAt(getX()-gatoMove, getY());
        }
        if(dir == 'r'){
            c = getWorld().getBackground().getColorAt(getX()+gatoMove, getY());
        }
        if(dir == 'u'){
            c = getWorld().getBackground().getColorAt(getX(), getY()-gatoMove);
        }
        if(dir == 'd'){
            c = getWorld().getBackground().getColorAt(getX(), getY()+gatoMove);
        }
        
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        
        
        if((r<30)&&(g<30)&&(b<30)){
            return true;
        }
        
        return false;
    }
}
