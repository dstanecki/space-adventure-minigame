import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    public Laser(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 320, image.getHeight() - 210);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fire();
    }
    
    public void fire() {
        move(25);
        
        if (isAtEdge()) {
            World Space = getWorld();
            Space.removeObject(this);
        }
    }
}
