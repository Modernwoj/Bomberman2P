package bomberman.main;

import bomberman.game.Game;

public class Main 
{
	
	
	public static void main(String args[])
	{
		Game game = new Game("Bomberman!", 640, 360);
		game.start();
	}
	
}