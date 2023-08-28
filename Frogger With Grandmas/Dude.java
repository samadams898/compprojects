import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * This Code is trash sorry bout it
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dude extends Actor

{
     private int x, initialX;
     private int y, initialY;
     private int speed = 3;
     public static boolean leveladvance = false;
     private int sprintTimer;
     
     
     
     // String direction is used in grandma class to check which direction dude is goin
     private String direction = "";
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dude() {
     
        
        
    }
    public void addedToWorld(World world) {
        initialX = getX();
        initialY = getY();
        
    }
    public void reset() {
     setLocation(initialX, initialY);   
        
        
    }
    
 
    public void act() 
    {
       moveCheck();
       
       gameOver();
       nextLevel();
       sprintCheck();
       
       //sprintTimer++;  
    }
    public void moveCheck(){
        x  =  getX();
       y = getY();
       speed = 3;
       if(speed >= 6) {
         speed = 6; 
           
        }
      if (Greenfoot.isKeyDown("left")){
          sprintCheck();
         setLocation(x - speed, y);
         direction = "left";
     }
      if (Greenfoot.isKeyDown("right")){
         sprintCheck();
         setLocation(x + speed, y);
         direction = "right";
     }
     if (Greenfoot.isKeyDown("up")){
         sprintCheck();
         setLocation(x, y - speed);
         direction = "up";
        }
     if (Greenfoot.isKeyDown("down")){
         sprintCheck();
         setLocation(x, y + speed);
         direction = "down";
        }
     
    }
    public void sprintCheck(){
        
        
         
        if(Greenfoot.isKeyDown("shift")){
             speed = speed + 1;
             
             
        
    }
    
       
    }
    // if he touches the car, game will be over.
    public void gameOver() {
        List<explosion> f = getObjectsInRange(50, explosion.class);
     if(isTouching(Car.class)){
        resetWorld();
        
         
        }
        if(isTouching(Alligator.class)){
            resetWorld();  
            
        }
     if ((f.size() > 0)) {
         resetWorld();
         
         
        }
    }
    public void resetWorld(){
        Actor gameOver = new gameOver();
       
        Grandma g = new Grandma();
        Level1 level = (Level1) getWorld();
        getWorld().addObject(gameOver,x, y);
        playDeathSound();
        Greenfoot.delay(40);
        Greenfoot.stop();
        getWorld().removeObject(gameOver);
        Greenfoot.start();
         level.resetEverything();
        
     
        
        
        
    }
    
    public String getDirection() {
        
     return direction;   
    }
    //method finds list of grandmas in world, if there are no grandmas, level advances
    public void nextLevel() {
     List<Grandma> grandmas = getWorld().getObjects(Grandma.class);
        if (grandmas.isEmpty()) {
            //grandmaCount++;
            Score.addToScore();
            Greenfoot.setWorld(new Level1());
            
        }
        
    }
   
    public void playDeathSound() {
        int randomSound = Greenfoot.getRandomNumber(3);
        switch(randomSound)
       {
         //int of 1 is blue
         case 0:
         Greenfoot.playSound("dude_ow.wav");
         break;
         //int 2 is green
         case 1:
         Greenfoot.playSound("dude_ow2.wav");
         break;
         
         case 2:
         Greenfoot.playSound("gma_ohno.wav");
         break;
         default:
         break;
       
        }
        
        
    }
    public int getSpeed() {
        
        
     return speed;   
    }
    
  
    
}
