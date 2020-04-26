package bomberman.game.entities.players;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.gfx.Assets;
import bomberman.tiles.Tile;

public class Player1 extends Player
{
	public Player1(Handler handler,float x, float y) 
	{
		super(handler, x, y, Player.DEFAULT_PLAYER_WIDTH, Player.DEFAULT_PLAYER_HEIGHT);
		playerid = 1;
	}

	@Override
	public void tick() {
		getInput();
		move();
		pickPowerUp();
		if(exploded)
			death(0);
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		xTile=(int)((x+DEFAULT_PLAYER_WIDTH/2)/Tile.TILEWIDTH);
		yTile=(int)((y+DEFAULT_PLAYER_HEIGHT/2)/Tile.TILEHEIGHT);
		
		if(handler.getKeyManager().w)
			yMove = -speed;
		if(handler.getKeyManager().s)
			yMove = speed;
		if(handler.getKeyManager().a)
			xMove = -speed;
		if(handler.getKeyManager().d)
			xMove = speed;
		if(handler.getKeyManager().space && !handler.getWorld().CheckTileBomb(xTile,yTile))
		{
			if (bombs>0)
			{
				bombs--;
				SetBomb();
			}
		}

	}

	public void pickPowerUp()
	{
		
	}
	
	@Override
	public void render(Graphics G) 
	{
		G.drawImage(Assets.player1, (int) x, (int) y, width, height, null);
	}
	
}
