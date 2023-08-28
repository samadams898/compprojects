import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Grandma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Grandma extends Actor
{
    private int initialX;
    private int initialY;
    /**
     * Act - do whatever the Grandma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void act() 
    {
        follow();
        gameOver();
        gettoFinish();
        // Add your action code here.
    }  
    public void addedToWorld(World world) {
     initialX = getX();
     initialY = getY();
    
        
    }
    public void reset() {
        setLocation(initialX, initialY);
        
    }
    public void follow() {
        
        List<Dude> f = getObjectsInRange(60, Dude.class);
        
             if ((f.size() > 0)) {
                Dude guy = f.get(0);
                int x = guy.getX();
                 int y = guy.getY();
                //turnTowards(x, y);
                String dir = guy.getDirection();
                switch (dir)
                {
                    case "right":
                     setLocation(x - 40, y); 
                     break;
                    case "left":
                     setLocation(x + 40, y);
                    break;
                    case "up":
                    setLocation(x, y + 40);
                    break;
                    case "down":
                    setLocation(x, y - 40);
                    break;
                     default:
                     break;
                    }
        
        }
        
    }
    public void gameOver() {
     if(isTouching(Car.class)){
        Actor gameOver = new gameOver();
        //List<Dude> f = getObjectsInRange(60, Dude.class);
       // Dude d = f.get(0);
        //Car c = new Car(1,1);
        Level1 level = (Level1) getWorld();
        getWorld().addObject(gameOver,getX(), getY());
        playDeathSound();
        Score.grandmaDead();
        Greenfoot.delay(40);
        Greenfoot.stop();
        Greenfoot.start();
        level.resetEverything();
        level.removeObject(gameOver);
        //d.reset();
        //c.reset();
        //reset();
        //Greenfoot.setWorld(new Level1());
        
       
         
        }
        
    
    }
    public boolean gettoFinish() {
        if (isTouching(FinishLine.class)) {
          getWorld().removeObject(this);
          playFinishSound();
          return true;
        }
        return false;
    }
    public void playDeathSound() {
     int randomSound = Greenfoot.getRandomNumber(2);   
        switch (randomSound) {
            case 0:
            Greenfoot.playSound("gma_ow.wav");
            break;
            case 1:
            Greenfoot.playSound("gma_ow2.wav");
            break;
           
            default:
            break;
          
        }
      
        
    }
    public void playFinishSound() {
        int randomSound = Greenfoot.getRandomNumber(2);  
         switch (randomSound) {
            case 0:
            Greenfoot.playSound("gma_sweetie.wav");
            break;
            case 1:
            Greenfoot.playSound("gma_thanks.wav");
            break;
           
            default:
            break;
          
        }
        
        
        
    }
   
    
    
    
}
