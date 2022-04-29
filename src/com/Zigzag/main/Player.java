package com.Zigzag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject
{
    Random r = new Random();
    Handler handler;
    public Player(float x, float y, ID id, Handler handler) 
    {
        super(x, y, id);
        this.handler = handler;
                                       //velX = r.nextInt(5) + 1;
                                       //velY = r.nextInt(5);
        
    }
    
    @Override
    public Rectangle getbounds()
    {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

      @Override
    public void tick() 
    {
       x += velX;
       y += velY;
       
       x = Game.clamp(x, 0, Game.WIDTH -37);
       y = Game.clamp(y, 0, Game.HEIGHT -60);
       
      handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
       
       collision();
    }
    
    private void collision()
    {
        for(int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.BesicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy || tempObject.getID() == ID.EnemyBoss)    // tempobject is now besicenemy
            {
                if(getbounds().intersects(tempObject.getbounds()))
                {
                    HUD.HEALTH -= 2;   //collision code
                }
            }
        }
    }

      @Override
    public void render(Graphics g) 
    {
        /* Graphics2D g2D = (Graphics2D)
        g.setColor(Color.red);
        g2D.draw(getbounds());
        */
        
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }
}
