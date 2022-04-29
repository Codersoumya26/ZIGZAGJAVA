
package com.Zigzag.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD 
{
    public static float HEALTH = 100;
    private float greenvalue = 255;
    
    private int score = 0;
    private int level = 1;
    
  public void tick()
  {   
      HEALTH = Game.clamp(HEALTH, 0, 100);
      greenvalue = Game.clamp(greenvalue, 0, 255);
      
      greenvalue = HEALTH*2;
      score++;
  }
  
  public void render(Graphics g)
  {
     g.setColor(Color.gray);
     g.fillRect(415, 15, 200, 30);
     g.setColor(new Color(75,(int)greenvalue,0));
     g.fillRect(415, 15, (int)(HEALTH*2), 30);
     g.setColor(Color.white);
     g.drawRect(415, 15, 200, 30);
  
     g.drawString("POINT: "+ score, 15, 20);
     g.drawString("LEVEL: "+ level, 15, 35);
  }
     
     public void setscore(int score)
     {
       this.score = score;
     }
     public int getScore()
     {
         return score;
     }
     public int getlevel()
     {
         return level;
     }
     public void setlevel(int level)
     {
         this.level = level;
     }
     
}
