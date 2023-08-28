import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class alligator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alligator extends Actor
{
    /**
     * Act - do whatever the alligator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Alligator(int scaleIn){
        setScale(scaleIn);
        //getImage().scale(sizeX, sizeY);
        
        
    }
    public void act() 
    {
        
    }    
    public void setScale(int scaleIn){
        int scale = scaleIn;
        
          switch(scale)
       {
         //int of 1 is blue
         case 1:
         getImage().scale(33, 43);
         break;
         //int 2 is green
         case 2:
         getImage().scale(66, 75);
         break;
         // int 3 is orange
         case 3:
         getImage().scale(100, 100);
         case 4:
         getImage().scale(44, 44);
         default:
         
         
         break;
       
        }
        
        
        
    }
    
}
