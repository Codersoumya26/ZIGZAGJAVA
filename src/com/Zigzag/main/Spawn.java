package com.Zigzag.main;

import static com.Zigzag.main.Game.HEIGHT;
import static com.Zigzag.main.Game.WIDTH;
import java.util.Random;

public class Spawn 
{
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    private float scorekeep = 0;
    
    public Spawn(Handler handler, HUD hud)
    {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick()
    {
        scorekeep ++;
        
        if(scorekeep >= 742)
        {
            scorekeep = 0;
            hud.setlevel(hud.getlevel() +1);
            
            if(hud.getlevel() == 2)
           {
                handler.addObject(new BesicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.BesicEnemy, handler));
           }
            else if(hud.getlevel() == 4)
           {
                handler.addObject(new BesicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.BesicEnemy, handler));
           }
             else if(hud.getlevel() == 5)
           {
                handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.FastEnemy, handler));
           }
              else if(hud.getlevel() == 7)
           {
                handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.SmartEnemy, handler));
           }
           else if(hud.getlevel() == 8)
           {
                handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.FastEnemy, handler));
           }
            else if(hud.getlevel() == 10)
           {
                handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.FastEnemy, handler));
           }
            else if(hud.getlevel() == 11)
           {
               handler.clearEnemy();
               handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48 , -120,ID.EnemyBoss, handler));
           }
            else if(hud.getlevel() == 16)
           {
                handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.SmartEnemy, handler));
           }
            else if(hud.getlevel() == 19)
           {
                handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.SmartEnemy, handler));
           }
            
        }
    }
}
