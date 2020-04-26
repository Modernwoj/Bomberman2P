package bomberman.game.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import bomberman.game.Handler;
import bomberman.game.entities.players.Player1;
import bomberman.game.entities.players.Player2;
import bomberman.game.entities.powerups.PowerUp;

public class EntityManager {
	
	private Handler handler;
	private Player1 player1;
	private Player2 player2;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player1 player1,Player2 player2){
		this.handler = handler;
		this.player1 = player1;
		this.player2 = player2;
		entities = new ArrayList<Entity>();
		addEntity(player1);
		addEntity(player2);
	}
	
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void addEntity(Entity e){
		entities.add(0,e);
	}
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	public void SetPowerUp(int x, int y)
	{
		Random random = new Random();
		int rand = random.nextInt(3);
		PowerUp powerup = new PowerUp(handler, x, y, rand);
		addEntity(powerup);
	}
	
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player1 getPlayer1() {
		return player1;
	}
	public Player2 getPlayer2() {
		return player2;
	}

	public void setPlayer1(Player1 player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(Player2 player2) {
		this.player2 = player2;
	}


	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}