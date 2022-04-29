package com.Zigzag.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject
{
    private Handler handler;
    Random r = new Random();
    private int timer = 85;
    private int timer2 =50;
    
    public EnemyBoss(int x, int y, ID id, Handler handler) 
    {
        super(x, y, id);
        
        this.handler = handler;
        velX = 0;
        velY = 2;
        
    }
    
    @Override
    public Rectangle getbounds()
    {
        return new Rectangle((int)x, (int)y, 160, 98);
    }


      @Override
    public void tick() 
    {
       x += velX;
       y += velY;
       
       if(timer <=0 ) velY = 0;
       else timer--;
       
       if(timer <=0 ) timer2--;
       if(timer2 <=0 )
       {
         if(velX == 0) velX = 2;   
         
         /* 
         if(velX > 0)
             velX += 0.005f;
         else if(velX < 0)
             velX -= 0.005f;
         velX = Game.clamp(velX, 7, 7);
         */
         
         int spawn = r.nextInt(10);
         if(spawn == 0)
             handler.addObject(new EnemyBossBullets((int)x+90,(int)y+90, ID.BesicEnemy, handler));
       }
       
       if(x <= 0 || x >= Game.WIDTH - 160)  velX *= -1;
       
     }

      @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.BLUE);
        g.fillRect((int)x, (int)y, 160, 98);
        
    }
    
}

