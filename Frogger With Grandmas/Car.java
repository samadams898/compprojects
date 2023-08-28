
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class  here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    //private variables
    private int x, initialX;
    private int y, initialY;
    private int color, initialColor;
    private int direction, initialD;
    private int speed, initialSpeed;
    private GreenfootImage image;
    
    //Constructor
    public Car(int colorIn, int directionIn){
     setColor(colorIn);
     setDirection(directionIn);
        if (direction == 1) {
         getImage().mirrorVertically();   
        }
     
    }
    /**
     * Act - do whatever the Dude wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void addedToWorld(World world){
    initialX = getX();
    initialY = getY();
    initialColor = color;
    initialD = getDirection();
    initialSpeed = getSpeed();
        
    }
    public void reset() {
   
    setLocation(initialX, initialY);
    setColor(initialColor);
    //setDirection(initialD);
    setSpeed(initialSpeed);
        
    }
    
    
    public void act() 
    {
        // Add your action code here.
        beACar();
        randomAction();
    }
    public void randomAction() {
     if(Score.getScore() >= 6){
        if(Greenfoot.getRandomNumber(10000) < randomSpeed()){   
        
        explode();
        
     }  
    }
        
    }
    public int randomSpeed() {
       
       //int multiplier =  level.level;
        speed = Greenfoot.getRandomNumber(3) +(Score.getScore() / 6);
       return speed;
    }
    public void beACar(){
        x = getX();
        y = getY();
        
        setLocation(x, y + ((direction) * randomSpeed()));
        
        if (isAtEdge()) {
            setLocation(x, 0);
            if(direction == -1){
                
                setLocation(x, 428);
            }
             
        }
        if (this.isTouching(Car.class)) {
                    getWorld().removeObject(this);
                    
        }
        //if(this.isTouching(){
            //getWorld().removeObject(this);
            
            
            
        //}
        
        
   
    }
    // sets color of car based on parameter set in. Use file name in \Images folder
    //of project to set which color is which
    public void setColor(int color) {
       switch(color)
       {
         //int of 1 is blue
         case 1:
         setImage("car01-n.png");
         break;
         //int 2 is green
         case 2:
         setImage("car03-n.png");
         break;
         // int 3 is orange
         case 3:
         setImage("car02-n.png");
         default:
         break;
       
        }
    }
    public void setDirection(int directionIn){
        switch (directionIn){
            // int 0 would be down
         case 0:
         direction = 1;
         //setImage(mirrorVertically());
         break;
            // int 1 would be up
         case 1:
         direction = -1;
         break;
            
        }
    
    }
    public int getSpeed(){
     return speed;   
    }
    public void setSpeed(int speedIn){
        speed = speedIn;
        
    }
    public int getDirection(){
        
     return direction;   
    }
    public void explode() {
        if(getWorld() != null) {
        //Actor all = getOneIntersectingObject(Alligator.class);
        Actor explosion = new explosion();
        
            
            getWorld().addObject(explosion,x, y);
          setLocation(x, 0);
          
            if(direction == -1){
                
                setLocation(x, 428);
            }
             
            
        }
        
    
   
    }
}
