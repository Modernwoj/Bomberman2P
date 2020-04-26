package bomberman.game.entities.players;


import bomberman.game.Handler;
import bomberman.game.entities.Entity;
import bomberman.game.entities.bombs.Bomb;
import bomberman.states.EndState;
import bomberman.states.State;
import bomberman.tiles.Tile;

public abstract class Player extends Entity 
{
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_PLAYER_WIDTH = 32,
							DEFAULT_PLAYER_HEIGHT = 32;
	protected float speed;
	protected float xMove, yMove;
	protected int bombs, maxbombs;
	protected int power;
	protected int playerid;

	public Player(Handler handler,float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		maxbombs = 1;
		bombs = 1;
		power = 1;
	}
	
	public void move()
	{
			moveX();
			moveY();
	}

	public void moveX()
	{
		if(xMove > 0)
		{		//Prawo
			int tx = (int) (x + xMove  + bounds.width) / Tile.TILEWIDTH;
				//Bezposredni ruch
			if(!collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y  + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}	//wspomaganie wejscia	
			else if(!collisionWithTile(tx, (int) (y  + bounds.height - DEFAULT_PLAYER_HEIGHT/8) / Tile.TILEHEIGHT) &&
					collisionWithTile(tx, (int) (y  + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove +DEFAULT_PLAYER_WIDTH/8;
				y = ((int)(y + DEFAULT_PLAYER_HEIGHT/4)/Tile.TILEHEIGHT)*Tile.TILEHEIGHT + Tile.TILEHEIGHT- DEFAULT_PLAYER_HEIGHT;
			} 
			else if(!collisionWithTile(tx, (int) (y  + DEFAULT_PLAYER_HEIGHT/8) / Tile.TILEHEIGHT) &&
					collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT)){
				x += xMove+DEFAULT_PLAYER_WIDTH/8;
				y = ((int)(y + DEFAULT_PLAYER_HEIGHT/4)/Tile.TILEHEIGHT)*Tile.TILEHEIGHT;
			} //Wyrownanie
			else
			{
				x = tx * Tile.TILEWIDTH - bounds.width -1;
			}
			
		}else if(xMove < 0)
		{		//Lewo
			int tx = (int) (x + xMove ) / Tile.TILEWIDTH;
				//Bezposredni ruch
			if(!collisionWithTile(tx, (int) (y ) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y  + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}	//wspomaganie wejscia	
			else if(!collisionWithTile(tx, (int) (y + bounds.height - DEFAULT_PLAYER_HEIGHT/8) / Tile.TILEHEIGHT) &&
					collisionWithTile(tx, (int) (y  + bounds.height) / Tile.TILEHEIGHT)){
				x +=xMove-DEFAULT_PLAYER_WIDTH/8;
				y = ((int)(y + DEFAULT_PLAYER_HEIGHT/4)/Tile.TILEHEIGHT)*Tile.TILEHEIGHT + Tile.TILEHEIGHT- DEFAULT_PLAYER_HEIGHT;
			} 
			else if(!collisionWithTile(tx, (int) (y + DEFAULT_PLAYER_HEIGHT/8) / Tile.TILEHEIGHT) &&
					collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT)){
				x += xMove-DEFAULT_PLAYER_WIDTH/8;
				y = ((int)(y + DEFAULT_PLAYER_HEIGHT/4)/Tile.TILEHEIGHT)*Tile.TILEHEIGHT;
			} //Wyrownanie
			else
			{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH ;
			}
			
		}
	}
	
	public void moveY()
	{
		if(yMove < 0)
		{		//Gora
			int ty = (int) (y + yMove) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x ) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}	//wspomaganie wejscia	
			else if(!collisionWithTile(((int) (x + bounds.width - DEFAULT_PLAYER_WIDTH/8) / Tile.TILEHEIGHT),ty) &&
					collisionWithTile((int) (x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove-DEFAULT_PLAYER_HEIGHT/8;
				x = ((int)(x + DEFAULT_PLAYER_WIDTH/4)/Tile.TILEWIDTH)*Tile.TILEWIDTH + Tile.TILEWIDTH - DEFAULT_PLAYER_WIDTH;
			} 
			else if(!collisionWithTile((int) (x + DEFAULT_PLAYER_WIDTH/8) / Tile.TILEWIDTH, ty) &&
					collisionWithTile((int) (x) / Tile.TILEWIDTH, ty)){
				y += yMove-DEFAULT_PLAYER_HEIGHT/8;
				x = ((int)(x + DEFAULT_PLAYER_WIDTH/4)/Tile.TILEWIDTH)*Tile.TILEWIDTH;
			} //Wyrownanie
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT;
			}
			
		}else if(yMove > 0)
		{		//Dol
			int ty = (int) (y + yMove + bounds.height) / Tile.TILEHEIGHT;
				//Bezposredni ruch
			if(!collisionWithTile((int) (x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}	//wspomaganie wejscia	
			else if(!collisionWithTile(((int) (x + bounds.width - DEFAULT_PLAYER_WIDTH/8) / Tile.TILEHEIGHT), ty) &&
					collisionWithTile((int) (x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove+DEFAULT_PLAYER_HEIGHT/8;
				x = ((int)(x + DEFAULT_PLAYER_WIDTH/4)/Tile.TILEWIDTH)*Tile.TILEWIDTH + Tile.TILEWIDTH - DEFAULT_PLAYER_WIDTH;
			} 
			else if(!collisionWithTile((int) (x + DEFAULT_PLAYER_WIDTH/8) / Tile.TILEWIDTH, ty) &&
					collisionWithTile((int) (x) / Tile.TILEWIDTH, ty)){
				y += yMove+DEFAULT_PLAYER_HEIGHT/8;
				x = ((int)(x + DEFAULT_PLAYER_WIDTH/4)/Tile.TILEWIDTH)*Tile.TILEWIDTH;
			} //Wyrownanie
			else
			{
				y = ty * Tile.TILEHEIGHT - bounds.height -1;
			}
		}
	}
	public void SetBomb() 
	{
			handler.getWorld().SetTileBomb(xTile,yTile);
			Bomb bomb = new Bomb(handler,Tile.TILEWIDTH*xTile,Tile.TILEWIDTH*yTile, power, playerid);
			handler.getWorld().addEntity(bomb);
	}
	public void addBomb()
	{
		if (bombs<maxbombs)
			bombs++;
	}
	public void PowerUp(int powerid)
	{
		switch(powerid)
		{
		case 0:
			if(power < 5)
				power++;
			break;
		case 1:
			if (speed < 2*DEFAULT_SPEED)
				speed = speed + 0.2f*DEFAULT_SPEED;
			break;
		case 2:
			if(maxbombs<5)
				{
				maxbombs++;
				bombs++;
				}
			break;
		
		}
	}
	public void death(int x)
	{
			remove();
			Endgame(x);
	}
	public void Endgame(int x)
	{
		handler.getGame().endState = new EndState(handler, x);
		State.setState(handler.getGame().endState);
	}
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	public float getxMove() 
	{
		return xMove;
	}

	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}

	public float getyMove()
	{
		return yMove;
	}

	public void setyMove(float yMove) 
	{
		this.yMove = yMove;
	}
	public float getSpeed() 
	{
		return speed;
	}

	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}
}