import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class GatoMaze2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GatoMaze2 extends Actor
{
    /**
     * Act - do whatever the GatoMaze2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Importaciones de imagenes para el moviemiento del gato
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
    
    //variables a utilizar
    int gatoMove = 3;
    boolean disparo;
    boolean isKeyPress = false;
    String viendoDireccion = "arriba";
    int frame;
    char dir = 'a';
    int cont = 10;
    
    
    //Constructor
    public GatoMaze2(){
        getImage().scale(22,22);
        this.disparo = false;
        
    }
    
    public void act()
    {
        // Add your action code here.
        isKeyPress = false;
        //Interactuar con las flechas
        if(Greenfoot.isKeyDown("up")){
            if(!revisarCaja('u')){
                if(!revisarAguaHorizontal('u') && !revisarAguaVertical('u') && !revisarAguaVertical2('u') && !revisarAguaHorizontal2('u')){
                    if(!revisarParedes('u')){
                        caminarArriba();
                        setLocation(getX(), getY()-gatoMove);
                        setRotation(270);
                        isKeyPress = true;
                    } 
                }else{
                    Maze2.contVidas.add(-1);
                    if(Maze2.contVidas.getValue() == -1){
                        Greenfoot.setWorld(new FinalMalo());
                    }
                    Greenfoot.delay(1);
                }
            }else{
                caminarArriba();
                setLocation(getX(), getY()-gatoMove);
                setRotation(270);
                isKeyPress = true;
            }
        }
        
        if(Greenfoot.isKeyDown("right")){
            if(!revisarCaja('r')){
                if(!revisarAguaHorizontal('r') && !revisarAguaVertical('r') && !revisarAguaVertical2('r') && !revisarAguaHorizontal2('r')){
                    if(!revisarParedes('r')){
                        caminarDerecha();
                        setLocation(getX()+gatoMove, getY());
                        setRotation(0);
                        isKeyPress = true;
                    }
                }else{
                    Maze2.contVidas.add(-1);
                    if(Maze2.contVidas.getValue() == -1){
                        Greenfoot.setWorld(new FinalMalo());
                    }
                    Greenfoot.delay(1);
                }
            }else{
                caminarDerecha();
                setLocation(getX()+gatoMove, getY());
                setRotation(0);
                isKeyPress = true;
            }
        }
        
        if(Greenfoot.isKeyDown("left")){
            if(!revisarCaja('l')){
                if(!revisarAguaHorizontal('l') && !revisarAguaVertical('l')&& !revisarAguaVertical2('l') && !revisarAguaHorizontal2('l')){
                    if(!revisarParedes('l')){
                        caminarIzquierda();
                        setLocation(getX()-gatoMove, getY());
                        setRotation(180);
                        isKeyPress = true;
                    }
                }else{
                    Maze2.contVidas.add(-1);
                    if(Maze2.contVidas.getValue() == -1){
                        Greenfoot.setWorld(new FinalMalo());
                    }
                    Greenfoot.delay(1);
                }
            }else{
                caminarIzquierda();
                setLocation(getX()-gatoMove, getY());
                setRotation(180);
                isKeyPress = true;
            }
        }
        
        if(Greenfoot.isKeyDown("down")){
            if(!revisarCaja('d')){
                if(!revisarAguaHorizontal('d') && !revisarAguaVertical('d') && !revisarAguaVertical2('d') && !revisarAguaHorizontal2('d')){
                    if(!revisarParedes('d')){
                        caminarAbajo();
                        setLocation(getX(), getY()+gatoMove);
                        setRotation(90);
                        isKeyPress = true;
                    }
                }else{
                    Maze2.contVidas.add(-1);
                    if(Maze2.contVidas.getValue() == -1){
                        Greenfoot.setWorld(new FinalMalo());
                    }
                    Greenfoot.delay(1);
                }
            }else{
                caminarAbajo();
                setLocation(getX(), getY()+gatoMove);
                setRotation(90);
                isKeyPress = true;
            }
        }
        
        //funcion para el movimiento del gato
        if(!(isKeyPress)){
            //terminar de caminar
            pararCaminar();
        }
        //Cuando obtenga la bola de pelo pueda disparar
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
        
        Maceta m = (Maceta) getOneIntersectingObject(Maceta.class);
        if(m != null){
            Greenfoot.setWorld(new FinalBueno());
        }
        
    }
    
    public boolean revisarCaja(char dir){
        Caja oF = null;
        if (dir == 'l'){
            oF = (Caja) getOneObjectAtOffset(-gatoMove,0,Caja.class);
        }
        if (dir == 'r'){
            oF = (Caja) getOneObjectAtOffset(gatoMove,0,Caja.class);
        }
        if (dir == 'u'){
            oF = (Caja) getOneObjectAtOffset(0,-gatoMove,Caja.class);
        }
        if (dir == 'd'){
            oF = (Caja) getOneObjectAtOffset(0,gatoMove,Caja.class);
        }
        if (oF != null){
            return true;
        }
        return false;
    }
    //Esta funcion es para revisar el agua que esta horizontal
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
    
    public boolean revisarAguaHorizontal2(char dir){
        ObstaculoFacilMaze2 oF = null;
        if (dir == 'l'){
            oF = (ObstaculoFacilMaze2) getOneObjectAtOffset(-gatoMove,0,ObstaculoFacilMaze2.class);
        }
        if (dir == 'r'){
            oF = (ObstaculoFacilMaze2) getOneObjectAtOffset(gatoMove,0,ObstaculoFacilMaze2.class);
        }
        if (dir == 'u'){
            oF = (ObstaculoFacilMaze2) getOneObjectAtOffset(0,-gatoMove,ObstaculoFacilMaze2.class);
        }
        if (dir == 'd'){
            oF = (ObstaculoFacilMaze2) getOneObjectAtOffset(0,gatoMove,ObstaculoFacilMaze2.class);
        }
        if (oF != null){
            return true;
        }
        return false;
    }
    
     public boolean revisarAguaVertical(char dir){
        ObstaculoFacilVMaze2 oF = null;
        if (dir == 'l'){
            oF = (ObstaculoFacilVMaze2) getOneObjectAtOffset(-gatoMove,0,ObstaculoFacilVMaze2.class);
        }
        if (dir == 'r'){
            oF = (ObstaculoFacilVMaze2) getOneObjectAtOffset(gatoMove,0,ObstaculoFacilVMaze2.class);
        }
        if (dir == 'u'){
            oF = (ObstaculoFacilVMaze2) getOneObjectAtOffset(0,-gatoMove,ObstaculoFacilVMaze2.class);
        }
        if (dir == 'd'){
            oF = (ObstaculoFacilVMaze2) getOneObjectAtOffset(0,gatoMove,ObstaculoFacilVMaze2.class);
        }
        if (oF != null){
            return true;
        }
        return false;
    }
    public boolean revisarAguaVertical2(char dir){
        ObstaculoFacilV oF = null;
        if (dir == 'l'){
            oF = (ObstaculoFacilV) getOneObjectAtOffset(-gatoMove,0,ObstaculoFacilV.class);
        }
        if (dir == 'r'){
            oF = (ObstaculoFacilV) getOneObjectAtOffset(gatoMove,0,ObstaculoFacilV.class);
        }
        if (dir == 'u'){
            oF = (ObstaculoFacilV) getOneObjectAtOffset(0,-gatoMove,ObstaculoFacilV.class);
        }
        if (dir == 'd'){
            oF = (ObstaculoFacilV) getOneObjectAtOffset(0,gatoMove,ObstaculoFacilV.class);
        }
        if (oF != null){
            return true;
        }
        return false;
    }
    //Esta funcion es para disparar
    public void disparar(){
        int rotacion = getRotation();
        Arma bola = new Arma();
        getWorld().addObject(bola, getX(), getY());
        //Depende de la rotacion se le asinara una posicion
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
        //se llamara a un metodo de la clase Arma
        bola.disparar(dir);       
    }
    //Para que el gato se quede parado visualmente
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
    //Camina para abajo el gato visulamente
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
    //Camina para arriba visualmente
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
    
    //revisa el color del fondo para que si detecta gris este no pueda traspasar las barreras
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
