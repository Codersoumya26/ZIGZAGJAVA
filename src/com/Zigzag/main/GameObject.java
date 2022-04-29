package com.Zigzag.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject
{
  protected float x, y;  
  protected ID id;
  protected float velX,velY;
  
  public GameObject(float x, float y, ID id)
  {
      this.x = x;
      this.y = y;
      this.id = id;
  }
  
  public abstract void tick();
  public abstract void render(Graphics g);
  public abstract Rectangle getbounds();
  
  public void setX(int x)
  {
      this.x = x;
  }
  public void setY(int y)
  {
      this.y = y;
  }
  public float getX()
  {
      return x;
  }
  public float getY()
  {
      return y;
  }
  public void setID(ID id)
  {
      this.id = id;
  }
  public ID getID()
  {
      return id;
  }
  public void setvelX(int velX)
  {
      this.velX = velX;
  }
  public void setvely(int velY)
  {
      this.velY = velY;
  }
  public float getvelX()
  {
      return velX;
  }
  public float getvelY()
  {
      return velY;
  }
}
