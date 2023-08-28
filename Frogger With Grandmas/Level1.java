import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World {


    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int level = 1;
    private static GreenfootSound soundtrack = new GreenfootSound("soundtrack.mp3");
    private static Score score;
    
    public Level1()
    {    
        // Create a new world with 720x428 cells with a cell size of 1x1 pixels.
        super(720, 428, 1);
        
        
        initialize();
        
        setPaintOrder(gameOver.class, Dude.class, Grandma.class, FinishLine.class);
        
        
    }
    //This method initliazes the world with all the actors
    public void initialize() {
        soundtrack.setVolume(50);
        soundtrack.playLoop();
            
        score = new Score();
        
        
        
        
        
        
        //score.addToScore();
        Actor dude = new Dude();
        
        Actor FinishLine = new FinishLine();
      //  for (int  i = 1; 
        
      //  addObject(car, 200, 200);
        //addObject(car2, 400, 400);
        addObject(score, 10, 10);
        addObject(dude, 50, 100);
        addObject(new Grandma(), 650, 200);
       // addObject(all, 300, 200);
        addObject(FinishLine, 50, 200);
        //addObject(new Car(0, 1), possiblePlaces(), 400);
        spawnCars();
        spawnAlligator();

        
    }
    public void act() {
        if(Score.getGrandmas() >= 15) {
            Greenfoot.stop();
            
            
        }
        
        
    }
    public int getLevel() {
        
        
        return level;
    }
    public int randomizer() {
        int random = Greenfoot.getRandomNumber(score.getScore() + 1) + score.getScore(); 
      
        
      return random;  
    }
 
    public int possiblePlaces() {
        
       //int[] Car = {150, 200, 250, 300, 350, 400, 450, 500, 550, 600};
       int[] Car = {150 ,250,450, 550};
       int ret = Car[Greenfoot.getRandomNumber(4)];
                if(Greenfoot.getRandomNumber(100) < 10) {
                    ret = ret + 50;
                    return ret;
                    
                }
              
        return ret;
    }
    public void spawnCars() {
      
        for (int i = 0; i < randomizer(); i++){
        addObject(new Car(Greenfoot.getRandomNumber(4), Greenfoot.getRandomNumber(2)), possiblePlaces(), 400);
    
    
}
        
    }
    public void spawnAlligator() {
       
       if(Score.score >= 4) {
           
        for (int i = 0; i < 2; i++){
            int poss = Greenfoot.getRandomNumber(200) + 100;
       int posx = (Greenfoot.getRandomNumber(150) + 250);
       
        addObject(new Alligator(Greenfoot.getRandomNumber(3) + 1), 365, poss);
        //365
    }
}
        
        
    }
    public void resetEverything() {
        List<Car> cL = getObjects(Car.class);
        for(Car c : cL) {
             c.reset();
             
            }
        List<Dude> dL = getObjects(Dude.class);
        for(Dude d : dL) {
             d.reset();
             
            }
        List<Grandma> gL = getObjects(Grandma.class);
        for(Grandma g : gL) {
             g.reset();
             
            }
    }
}
