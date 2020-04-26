package bomberman.gfx;


import java.awt.image.BufferedImage;
import bomberman.game.entities.players.Player;
import bomberman.tiles.Tile;


public class Assets 
{
		
	public static BufferedImage player1, player2, wall, bomb, floor, obstacle, explosion, menu,levelselect;
	public static BufferedImage[] btn_start,btn_1,btn_2,btn_3, powerup,endgame;
	
	public static void init()
	{
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
		SpriteSheet menusheet = new SpriteSheet(ImageLoader.loadImage("/textures/menu.png"));
		SpriteSheet levelsheet = new SpriteSheet(ImageLoader.loadImage("/textures/levelselect.png"));
		menu = menusheet.crop(0, 0, 640, 360);
		levelselect = levelsheet.crop(0, 0, 640, 360);
		
		endgame = new BufferedImage[2];
		endgame[0] = sheet.crop(Tile.TILEWIDTH*2, Tile.TILEHEIGHT * 4,Tile.TILEWIDTH * 2, Tile.TILEHEIGHT);
		endgame[1] = sheet.crop(Tile.TILEWIDTH*2, Tile.TILEHEIGHT * 5,Tile.TILEWIDTH * 2, Tile.TILEHEIGHT);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(0, Tile.TILEHEIGHT * 2,Tile.TILEWIDTH * 2, Tile.TILEHEIGHT);
		btn_start[1] = sheet.crop(0, Tile.TILEHEIGHT * 3,Tile.TILEWIDTH * 2, Tile.TILEHEIGHT);
		
		btn_1 = new BufferedImage[2];
		btn_1[0] = sheet.crop(0, Tile.TILEHEIGHT * 4,Tile.TILEWIDTH , Tile.TILEHEIGHT);
		btn_1[1] = sheet.crop(Tile.TILEWIDTH, Tile.TILEHEIGHT * 4,Tile.TILEWIDTH , Tile.TILEHEIGHT);
		
		btn_2 = new BufferedImage[2];
		btn_2[0] = sheet.crop(0, Tile.TILEHEIGHT * 5,Tile.TILEWIDTH , Tile.TILEHEIGHT);
		btn_2[1] = sheet.crop(Tile.TILEWIDTH, Tile.TILEHEIGHT * 5,Tile.TILEWIDTH , Tile.TILEHEIGHT);
			
		btn_3 = new BufferedImage[2];
		btn_3[0] = sheet.crop(Tile.TILEWIDTH*2, Tile.TILEHEIGHT * 3,Tile.TILEWIDTH , Tile.TILEHEIGHT);
		btn_3[1] = sheet.crop(Tile.TILEWIDTH*3, Tile.TILEHEIGHT * 3,Tile.TILEWIDTH , Tile.TILEHEIGHT);
		
		powerup = new BufferedImage[3];
		powerup[0] = sheet.crop(Tile.TILEWIDTH * 3, Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		powerup[1] = sheet.crop(Tile.TILEWIDTH * 2, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		powerup[2] = sheet.crop(Tile.TILEWIDTH * 3, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		player1 = sheet.crop(0, 0, Player.DEFAULT_PLAYER_WIDTH, Player.DEFAULT_PLAYER_HEIGHT);
		player2 = sheet.crop(Tile.TILEWIDTH, 0,  Player.DEFAULT_PLAYER_WIDTH, Player.DEFAULT_PLAYER_HEIGHT);
		wall = sheet.crop(Tile.TILEWIDTH, Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		bomb = sheet.crop(Tile.TILEWIDTH * 2, 0, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		floor = sheet.crop(Tile.TILEWIDTH * 3, 0, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		obstacle = sheet.crop(0, Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		explosion = sheet.crop(Tile.TILEWIDTH * 2, Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}
}
