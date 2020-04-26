package bomberman.states;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.tiles.Tile;
import bomberman.worlds.World;


public class GameState extends State
{

	
	private World world;
	private World world1,world2,world3;

	public GameState(Handler handler, int level)
	{
		super(handler);
		readWorlds();
		switch (level)
		{
		case 1:
			world = world1;
			break;
		case 2:
			world = world2;
			break;
		case 3:
			world = world3;
			break;
		}
		handler.setWorld(world);
		if (handler.getWorld().getValidity()) 
			init();
	}
	public void init()
	{
		handler.getGame().SetWindow(handler.getWorld().getwidth()*Tile.TILEWIDTH, handler.getWorld().getheight()*Tile.TILEWIDTH);
	}
	public void readWorlds(){
		world1 = new World(handler,"/worlds/world1.txt");
		world2 = new World(handler,"/worlds/world2.txt");
		world3 = new World(handler,"/worlds/world3.txt");
	}
	
	@Override
	public void tick() 
	{
		world.tick();	
	}

	@Override
	public void render(Graphics G) 
	{
		world.render(G);
	}
}
