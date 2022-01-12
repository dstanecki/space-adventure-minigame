import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressAnyKeyToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressAnyKeyToPlay extends Actor
{
    int count = 0;
    /**
     * Act - do whatever the PressAnyKeyToPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        if (count == 15) {
            setImage("blank.png");
        }
            
            
        if (count >= 30) {
            setImage("pressAnyKeyToPlay.png");
            count = 0;
        }
        
        count++;
        
        String key = Greenfoot.getKey();
        
        if (key != null) {
            Level1 level1 = new Level1();
            Greenfoot.setWorld(level1);
        }
    }
}
