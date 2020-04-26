package bomberman.game.entities.powerups;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.game.entities.Entity;
import bomberman.gfx.Assets;

public class PowerUp extends Entity
{
	public static final int DEFAULT_POWERUP_WIDTH = 32,
							DEFAULT_POWERUP_HEIGHT = 32;
	private int powerid;
	
	public PowerUp(Handler handler,float x, float y, int powerid) 
	{
		super(handler, x, y, DEFAULT_POWERUP_WIDTH , DEFAULT_POWERUP_HEIGHT);
		this.setPowerid(powerid);
	}

	@Override
	public void tick() {
		GivePower();
	}

	@Override
	public void render(Graphics G) {
		G.drawImage(Assets.powerup[powerid], (int) x, (int) y, width, height, null);
	}
	public void GivePower()
	{
		Entity e = checkEntityPowerUp();
		if(e!=null) {
			if( e == handler.getWorld().getEntityManager().getPlayer1())
			{
				handler.getWorld().getEntityManager().getPlayer1().PowerUp(powerid);
			}
			if( e == handler.getWorld().getEntityManager().getPlayer2())
			{
				handler.getWorld().getEntityManager().getPlayer2().PowerUp(powerid);
			}
			remove();
		}
	}
	public Entity checkEntityPowerUp(){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds().intersects(getCollisionBounds()))
				return e;
		}
		return null;
	}
	

	public int getPowerid() {
		return powerid;
	}

	public void setPowerid(int powerid) {
		this.powerid = powerid;
	}
}
