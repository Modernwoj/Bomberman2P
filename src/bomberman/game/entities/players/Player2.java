package bomberman.game.entities.players;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.gfx.Assets;
import bomberman.tiles.Tile;

public class Player2 extends Player
{
	public Player2(Handler handler,float x, float y) 
	{
		super(handler,x, y, Player.DEFAULT_PLAYER_WIDTH, Player.DEFAULT_PLAYER_HEIGHT);
		playerid = 2;
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		if(exploded)
			death(1);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		xTile=(int)((x+DEFAULT_PLAYER_WIDTH/2)/Tile.TILEWIDTH);
		yTile=(int)((y+DEFAULT_PLAYER_HEIGHT/2)/Tile.TILEHEIGHT);
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().enter && !handler.getWorld().CheckTileBomb(xTile,yTile))	
		{
				if (bombs>0)
				{
					bombs--;
					SetBomb();
				}
		}
	}
	@Override
	public void render(Graphics G) 
	{
		G.drawImage(Assets.player2, (int) x, (int) y, width, height, null);

	}
}
