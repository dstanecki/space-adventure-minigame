import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Asteroid class interacts with laser and spaceship objects
 * 
 * @Daniel Stanecki
 * @version1
 */
public class Asteroid extends Actor
{
    int speed = 0;
    public Asteroid(int moveSpeed) {
        int rand = Greenfoot.getRandomNumber(100) + 50; //randomize asteroid size
        speed = moveSpeed; 
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + rand, image.getHeight() +rand); //resize asteroid image
        setImage(image);
    }
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        impactOnLaser();
        impactOnSpaceship();
        
        // this if statement must be at the end
        if (this.getX()==0){
            getWorld().removeObject(this);
        }
        
    }
    // 
    public void removeLaser() {
        Actor laser;
        laser = getOneIntersectingObject(Laser.class); 
        if (laser != null) {
            getWorld().removeObject(laser);
        }
    }
    
    public void impactOnLaser() {
        Actor laser;
        laser = getOneIntersectingObject(Laser.class); 
        if (laser != null) {
            GreenfootImage image = getImage();
            if (image.getWidth() > 100) {
                image.scale(image.getWidth() - 50, image.getHeight() - 50); //decrease asteroid size if laser hits, given asteroid width is over 100
                setImage(image);
            }
            else if (image.getWidth() < 100 && image.getWidth() > 1) {
                image.scale(1, 1); //instead of fully removing the asteroid upon destruction, I have it set to a near-microscopic size
                setImage(image);
                Counter.addScore(100); //player gets 100 score upon full destruction of an asteroid
            }
            if (image.getWidth() > 1 || image.getHeight() > 1)
                getWorld().removeObject(laser);
        }
    }
    
    // End the game when you hit a spaceship 
    public void impactOnSpaceship() {
        Actor spaceship;
        spaceship = getOneIntersectingObject(Spaceship.class);
        if (spaceship != null) {
            GreenfootImage image = getImage();
            if (image.getWidth() > 1 && image.getHeight() > 1){
                Level1 level1 = new Level1();
                Greenfoot.setWorld(level1);
                Counter.setScore(0);
            }
        }
    }
    
    
}
