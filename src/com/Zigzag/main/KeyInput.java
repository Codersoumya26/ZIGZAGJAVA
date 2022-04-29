package com.Zigzag.main;

import com.Zigzag.main.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
   private Handler handler;
   private boolean[] Keydown = new boolean[4];
    
   //Game game;
   
   public KeyInput(Handler handler)
    {
        this.handler = handler;
     /*   this.game = game;  
        
        Keydown[0] = false;
        Keydown[1] = false;
        Keydown[2] = false;
        Keydown[3] = false;
       */     
    } 

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
              
        for(int i=0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.Player)
            {
                // key events for player 1
                
                if(key == KeyEvent.VK_W)   tempObject.setvely(-5); //Keydown[0] = true; }
                if(key == KeyEvent.VK_S)   tempObject.setvely(5);  //Keydown[1] = true; }
                if(key == KeyEvent.VK_D)   tempObject.setvelX(5);  //Keydown[2] = true; }
                if(key == KeyEvent.VK_A)   tempObject.setvelX(-5); //Keydown[3] = true; }
            }
            
            if(tempObject.getID() == ID.Player)
            {
                // key events for player 
                
                if(key == KeyEvent.VK_UP)     tempObject.setvely(-5);// Keydown[0] = true;} 
                if(key == KeyEvent.VK_DOWN)   tempObject.setvely(5); //Keydown[1] = true; }
                if(key == KeyEvent.VK_RIGHT)  tempObject.setvelX(5); //Keydown[2] = true; }
                if(key == KeyEvent.VK_LEFT)   tempObject.setvelX(-5);//Keydown[3] = true; }
            }
        }
          
        /*if(key == KeyEvent.VK_P || key == KeyEvent.VK_SPACE )
          {  
              if(game.gameState == STATE.Game)
              {
                if(Game.paused) Game.paused = false ;
                else Game.paused = true ;
               }
          }*/
        
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    
    public void keyReleased(KeyEvent e)
    {
      int key = e.getKeyCode();
         
         for(int i=0; i < handler.object.size(); i++)
         {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getID() == ID.Player)
            {
                // key events for player 
                
                if(key == KeyEvent.VK_W) tempObject.setvely(0); //Keydown[0] = false; { tempObject.setvely(0); }
                if(key == KeyEvent.VK_S)  tempObject.setvely(0); //Keydown[1] = false; //{ tempObject.setvely(0); }
                if(key == KeyEvent.VK_D) tempObject.setvelX(0); //Keydown[2] = false; //{ tempObject.setvelX(0); }
                if(key == KeyEvent.VK_A) tempObject.setvelX(0); //Keydown[3] = false; //{ tempObject.setvelX(0); }
            }
             
            if(tempObject.getID() == ID.Player)
            {
                // key events for player 
                
                if(key == KeyEvent.VK_UP)    tempObject.setvely(0); //Keydown[0] = false; //{ tempObject.setvely(0); }
                if(key == KeyEvent.VK_DOWN)  tempObject.setvely(0); //Keydown[1] = false; //{ tempObject.setvely(0); }
                if(key == KeyEvent.VK_RIGHT) tempObject.setvelX(0);//Keydown[2] = false; //{ tempObject.setvelX(0); }
                if(key == KeyEvent.VK_LEFT)  tempObject.setvelX(0); //Keydown[3] = false; //{ tempObject.setvelX(0); }
            }
            
            // vartical movment
             // if(!Keydown[0] && !Keydown[1] ) tempObject.setvely(0);
            // horizental movment
             // if(!Keydown[2] && !Keydown[3] ) tempObject.setvelX(0);
             
            }
         
         
     }
}
