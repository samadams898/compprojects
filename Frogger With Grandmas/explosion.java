import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class explosion extends Actor

{
    public int timer = 10;
    /**
     * Act - do whatever the explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        timer--;
        Greenfoot.playSound("explosion.wav");
        if(timer <= 0){
         getWorld().removeObject(this);   
            
        }
    }    
}
