package bomberman.game.entities.bombs;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.game.entities.Entity;
import bomberman.gfx.Assets;
import bomberman.tiles.Tile;

public class Bomb extends Entity
{
	private int speed;
	private long lastTime, timer;
	protected boolean _removed = false;
	private Explosion explosion;
	private int[] tab ;
	private int power;
	private int playerid;
	
	public Bomb(Handler handler,float x, float y, int power, int playerid) 
	{
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT);
		this.speed = 2000;
		this.power = power;
		this.playerid = playerid;
		timer = 0;
		lastTime = System.currentTimeMillis();
		
	}
	
	public void tick() 
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if((timer > speed) || exploded)
		{
			tab = explosionCheck((int) (x/Tile.TILEWIDTH),(int) (y/Tile.TILEHEIGHT));
			explosion=new Explosion(handler,x,y);
			handler.getWorld().addEntity(explosion);
			for(int i=0;i<4;i++)
			{
				for(int j=1;j<=tab[i] && j < power+1;j++)
				{
					switch(i) {

					case 0:
						explosion=new Explosion(handler,x,y-j*Tile.TILEHEIGHT);
						break;
					case 1:
						explosion=new Explosion(handler,x,y+j*Tile.TILEHEIGHT);
						break;
					case 2:
						explosion=new Explosion(handler,x-j*Tile.TILEWIDTH,y);
						break;
					case 3:
						explosion=new Explosion(handler,x+j*Tile.TILEWIDTH,y);
					}
					handler.getWorld().addEntity(explosion);
				}
			ResetTileBomb((int) (x)/Tile.TILEWIDTH,(int) (y)/Tile.TILEHEIGHT);
			ResetBomb();
			remove();
			}
		}
	}
	public void ResetTileBomb(int x,int y)
	{
		handler.getWorld().ResetTileBomb(x, y);

	}
	public void ResetBomb()
	{
		if(playerid == 1)
			handler.getWorld().getEntityManager().getPlayer1().addBomb();
		if(playerid == 2)
			handler.getWorld().getEntityManager().getPlayer2().addBomb();
	}
	
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.bomb,(int) (x),(int) (y), width, height, null);	
	}
	public int[] explosionCheck(int x, int y)
	{
		return handler.getWorld().explosionCheck(x,y);
	}

}
