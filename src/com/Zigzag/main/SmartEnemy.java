package com.Zigzag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject
{
    private Handler handler;
    private GameObject player;
    
    public SmartEnemy(float x, float y, ID id, Handler handler) 
    {
        super(x, y, id);
        this.handler = handler;
         
// important calculation smart enemy         
         for(int i =0; i < handler.object.size(); i++)
         {
             if(handler.object.get(i).getID() == ID.Player) 
                 player = handler.object.get(i);
         }
         
        
    }
    
    @Override
    public Rectangle getbounds()
    {
        return new Rectangle((int)x, (int)y, 16, 16);
    }


      @Override
    public void tick() 
    {
       x += velX;
       y += velY;
       
       //FORMULEE[]
       float diffx = x - player.getX() - 8;
       float diffy = y - player.getY() - 8;
       float distance =  (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
   
        velX =  ((-1/distance) * diffx);  
        velY =  ((-1/distance) * diffy);
        
       //if(y <= 0 || y >= Game.HEIGHT - 32)  velY *= -1;
       //if(x <= 0 || x >= Game.WIDTH - 16)  velX *= -1;
       
       handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, 0.02f, handler));
    }

      @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
