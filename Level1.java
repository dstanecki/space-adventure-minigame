import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is level 1.
 * 
 * @Daniel Stanecki 
 * @version 1
 */
public class Level1 extends World
{
    
    int count = 0;
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Level1()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        // Add Spaceship to world
        Spaceship spaceship = new Spaceship();
        addObject(spaceship, 100, 270);
        // Add Counter object which will count your score
        Counter counter = new Counter();
        addObject(counter, 850, 50);
        
        setPaintOrder(Counter.class); //this puts my score counter on the top layer
    }
    
    public void act() {
        asteroidSpawn();
        wormholeSpawn();
    }
    
    public void asteroidSpawn(){ //frequency and speed of asteroids increases as time passes
        if (Greenfoot.getRandomNumber(100) < 1 && count < 600) {
            int moveSpeed = Greenfoot.getRandomNumber(5)+1;
            addObject(new Asteroid(-moveSpeed), 960, Greenfoot.getRandomNumber(440) + 50);
        }
        if (Greenfoot.getRandomNumber(100) < 2 && count > 600 && count < 1200) {
            int moveSpeed = Greenfoot.getRandomNumber(6)+1;
            addObject(new Asteroid(-moveSpeed), 960, Greenfoot.getRandomNumber(440) + 50);
        }
        if (Greenfoot.getRandomNumber(100) < 3 && count > 1200 && count < 1800) {
            int moveSpeed = Greenfoot.getRandomNumber(7)+1;
            addObject(new Asteroid(-moveSpeed), 960, Greenfoot.getRandomNumber(440) + 50);
        }
    }
        
    public void wormholeSpawn(){ //after player has survived for 1800 ticks, the wormhole spawns
        count ++;
        if (count == 1800) {
            addObject(new Wormhole(), 960, 270);
        }
    }
    }

