package bomberman.tiles;

import bomberman.gfx.Assets;

public class ObstacleTile extends Tile
{
	public ObstacleTile(int id) 
	{
		super(Assets.obstacle, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
}

