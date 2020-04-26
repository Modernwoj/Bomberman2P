package bomberman.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import bomberman.game.Handler;

public abstract class Entity 
{

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	public int xTile,yTile;
	public boolean exploded = false;
	
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0,0,width-1,height-1);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics G);
	
	public boolean checkEntityCollisions(){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds().intersects(getCollisionBounds()))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(){
		return new Rectangle((int) (x), (int) (y), bounds.width, bounds.height);
	}
	
	public void remove() 
	{
		handler.getWorld().removeEntity(this);
	}
	
	public float getX() 
	{
		return x;
	}

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}
	public void explode()
	{
		this.exploded = true;
	}

}