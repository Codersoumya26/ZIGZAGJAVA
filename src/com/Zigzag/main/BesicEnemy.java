package com.Zigzag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BesicEnemy extends GameObject
{
    private Handler handler;
    public BesicEnemy(int x, float y, ID id, Handler handler) 
    {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
       
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
       
       if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
       if(x <= 0 || x >= Game.WIDTH - 16)  velX *= -1;
       
       handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }

      @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
