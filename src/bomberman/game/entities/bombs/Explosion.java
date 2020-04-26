package bomberman.game.entities.bombs;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.game.entities.Entity;
import bomberman.gfx.Assets;
import bomberman.tiles.Tile;

public class Explosion extends Entity
{
	private int speed;
	private long lastTime, timer;
	
	public Explosion(Handler handler,float x, float y)  
	{
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT);
		speed = 200;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() 
	{

			
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		Kill();
		if(timer > speed)
		{
			if((handler.getWorld().getTiles((int) (x)/Tile.TILEWIDTH,(int) (y)/Tile.TILEHEIGHT))==2)
				handler.getWorld().destroyObstacle((int) (x)/Tile.TILEWIDTH,(int) (y)/Tile.TILEHEIGHT,(int) x ,(int) y);
			remove();
		}
	}
	public void render(Graphics G) 
	{
		G.drawImage(Assets.explosion, (int) x , (int) y, width, height, null);

	}

	public void Kill()
	{
		Entity e = checkEntityExplosion();
		if(e!=null) {
			e.explode();
		}
	}
	public Entity checkEntityExplosion(){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds().intersects(getCollisionBounds()))
				return e;
		}
		return null;
	}

	
}
