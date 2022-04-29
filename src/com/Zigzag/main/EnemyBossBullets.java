package com.Zigzag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullets extends GameObject
{
    private Handler handler;
    Random r = new Random();
    public EnemyBossBullets(int x, float y, ID id, Handler handler) 
    {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5 - -5)+ -5);
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
       
       if(y >= Game.HEIGHT) handler.removeObject(this);
       handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }

      @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
