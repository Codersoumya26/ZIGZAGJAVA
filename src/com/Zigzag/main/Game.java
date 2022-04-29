package com.Zigzag.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;                     


public class Game extends Canvas implements Runnable
{
    public static final long serialVersionUID = 1550691097823471818L;
             
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    
   // public static boolean paused = false;
    
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    public enum STATE{
        Menu,
        Help,
        Game,
        End
    };
    
    public static STATE gameState = STATE.Menu;
    
    public Game()
    {
       handler = new Handler(); 
       hud = new HUD();
       menu = new Menu(this, handler, hud);
       this.addKeyListener(new KeyInput(handler));
       this.addMouseListener(menu);
       
       
        
       new Window(WIDTH,HEIGHT,"ZigZag Wave", this);
        
        spawner = new Spawn(handler,hud);
        r = new Random();
        
        
        if(gameState == STATE.Game)
        {
            handler.addObject(new Player(WIDTH/2-28,HEIGHT/2-28,ID.Player, handler));
           handler.addObject(new BesicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT),ID.BesicEnemy, handler));
        }
        else{
            for(int i=0; i<14; i++)
             {
              handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT),ID.MenuParticle, handler));
             }  
        }
       
        /*
        handler.addObject(new Player(0, 0, ID.Player,handler)); 
        handler.addObject(new Player(173,150, ID.Player,handler));
        */
    }
    
    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop()
    {
      try 
        {
            thread.join();
            running = false;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }    
    }
    
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks ;
        double delta = 0 ;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
           while(delta >= 1){
               tick();
               delta--;
           }
           if(running)
             render();
           frames++;
           
           if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
             //System.out.println("FPS: "+frames);
               frames = 0;
           }
        }
        stop();
    }
    
    private void tick()
    {
        handler.tick();
        
        if(gameState == STATE.Game)
        {
            //if(!paused)
         //{      
            
            hud.tick();
            spawner.tick();
            

         //  END_ GAME
            if(HUD.HEALTH <= 0){
                HUD.HEALTH = 100;
                gameState = STATE.End;
               handler.clearEnemy();
                for(int i=0; i<14; i++)
              {
                    handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT),ID.MenuParticle, handler));
              }
             //}
           }
        }
        else if(gameState == STATE.Menu || gameState == STATE.End )
        {
            menu.tick();
            //handler.tick();
        }
        
    }
    
    private void render()
    {
          BufferStrategy bs = this.getBufferStrategy();
          if(bs == null)
          {
              this.createBufferStrategy(3);
              return;
          }
          
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        
        /*
        if(paused)
        {
//          Font fnt = new Font("arial",1,54);
//          g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString(" **GAME PAUSED** ", 100, 45);
        }*/
        
        if(gameState == STATE.Game)
        {
            hud.render(g);
        } 
        else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End )
        {
            menu.render(g);
        }
        g.dispose();
        bs.show();
        
    }
    
    public static float clamp(float var,float min,float max)
    {
        if(var >= max) 
             return var = max;
        else if(var <= min)
             return var = min;
        else return var;
    }
    
    public static void main(String[] args) 
    {
        new Game();
    }
    
}
