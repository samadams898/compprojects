import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//private static Font(10) font;
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int score = 1;
    public static int grandmasDead = 0;
    public void act() 
    {
        // Add your action code here.
        getImage().drawString(toString(), 10, 10);
    } 

    
    
    //private int grandmaCount;
    /**
     * Constructor for objects of class Score
     */
  
    public static void addToScore() {
       
           
         
     score++;   
    }
    public static int getScore() {
        
        
     return score;   
    }
    public static void grandmaDead() {
        
     grandmasDead++;   
    }
    public static int getGrandmas() {
        
     return grandmasDead;   
    }
    public String toString() {
        String ret = "" + getScore() + "\n" + grandmasDead;
        
     return  ret;
    }
    

   


}
