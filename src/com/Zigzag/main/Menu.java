package com.Zigzag.main;

import static com.Zigzag.main.Game.HEIGHT;
import com.Zigzag.main.Game.STATE;
import static com.Zigzag.main.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter{
    
   private Game game;
   private Handler handler;
   private HUD hud;
   private Random r = new Random();
    public Menu(Game game,Handler handler,HUD hud)
       {
           this.game = game;
           this.hud = hud;
           this.handler = handler;
       }
    
    public void mousePressed(MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY(); 
        
       if(game.gameState == STATE.Menu)
       {
         // PLAY BUTTON
        if(mouseOver(mx,my,210, 120, 200, 64))
        {
         game.gameState = STATE.Game;
         handler.addObject(new Player(WIDTH/2-28,HEIGHT/2-28,ID.Player, handler));
         handler.clearEnemy();
         handler.addObject(new BesicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50),ID.BesicEnemy, handler));
          
        }
        
        //HELP BUTTON
        if(mouseOver(mx,my,210, 220, 200, 64))
        {
            game.gameState = STATE.Help;
        }
        
        //` QUIT BUTTON
        if(mouseOver(mx,my,210, 320, 200, 64))
        {
               System.exit(1);
        }  
       }
       
        //Back Button for help
        if(game.gameState == STATE.Help)
        {
            if(mouseOver(mx,my,210, 320, 200, 64))
              {
               game.gameState = STATE.Menu;
               
              }   
        }
        
        
        if(game.gameState == STATE.End)
        {
          // Main Menu BUTTON for END
            if(mouseOver(mx,my,210, 320, 200, 64))
            {
             game.gameState = STATE.Menu;
             hud.setlevel(1);
             hud.setscore(0);
             
            } 
            
        }
    }
    public void mouseReleased(MouseEvent e){
        
    }
    private boolean mouseOver(int mx, int my, int x,int y,int width, int height){
        if(mx > x && mx < x+width ){
           if(my > y && my < y+height ){
            return true;
        }else return false;
    }else return false;
    }     
    public void tick(){
        
    }
    public void render(Graphics g)
    {
        if(game.gameState == STATE.Menu)
        {
        Font fnt = new Font("arial",1,50);
        Font fnt2 = new Font("arial",1,41);
        
        g.setFont(fnt);
        g.setColor(Color.RED);
        g.drawString("ZIGZAG", 215, 70);
        g.setColor(Color.white);
        g.setFont(fnt2);
        g.drawRect(210, 120, 200, 64);
        g.drawString("PLAY", 258, 170);
        g.drawRect(210, 220, 200, 64);
        g.drawString("HELP", 258, 270);
        g.drawRect(210, 320, 200, 64);
        g.drawString("QUIT", 258, 370);
        }
        else if(game.gameState == STATE.Help)
        {
        Font fnt = new Font("arial",1,50);
        Font fnt2 = new Font("arial",1,41);
        Font fnt3 = new Font("arial",1,30);
        g.setFont(fnt);
        g.setColor(Color.RED);
        g.drawString("HELP", 240, 70);
        g.setFont(fnt3);
        g.setColor(Color.PINK);
        g.drawString("Use W,A,S,D and Arrow Keys to move ", 70, 120);
        g.drawString("your Player & Dodge enemies.", 70, 150);
        g.drawString("Increase Your point for level up.", 70, 180);
        g.drawString("** Navigate Yourself,Score Higher **", 70, 230);
        g.drawString("** ENJOY  Non-stop  ZIGZAG WAVE **", 45, 270);
        g.setFont(fnt3);
        g.setColor(Color.white);
        g.drawRect(210, 320, 200, 64);
        g.drawString("Main Menu", 235, 360);
        }
        else if(game.gameState == STATE.End)
        {
        Font fnt = new Font("arial",1,90);
        Font fnt2 = new Font("arial",1,54);
        Font fnt3 = new Font("arial",1,27);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("OOPS !!!", 140, 85);
        g.setFont(fnt2);
        g.drawString("***GAME OVER***", 100, 180);
        g.setFont(fnt3);
        g.setColor(Color.RED);
        g.drawString(" *[@!@]*       YOUR_LAST_SCORE :-  "+hud.getScore(), 22, 250);
        g.drawString("@You LOST. Don't be UPSET ; #TRY AGAIN ", 30, 295);
        g.setFont(fnt3);
        g.setColor(Color.YELLOW);
        g.drawRect(210, 320, 200, 64);
        g.drawString("Main Menu", 235, 360);
        }
    }
}
