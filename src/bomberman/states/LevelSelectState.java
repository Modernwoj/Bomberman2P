package bomberman.states;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.gfx.Assets;
import bomberman.ui.ClickListener;
import bomberman.ui.UIImageButton;
import bomberman.ui.UIManager;

public class LevelSelectState extends State {

	private UIManager uiManager;
	
	public LevelSelectState(Handler handler) {
		super(handler);
		uiManager = new UIManager (handler); 

		handler.getMouseManager().setUIManager(uiManager);
		init();
	}
	public void init()
	{
		uiManager.addObject(new UIImageButton(164, 198, 64, 64, Assets.btn_1, new ClickListener() {
			@Override
			public void onClick() {
				handler.getGame().gameState = new GameState (handler, 1);
				CheckValidity();
			}
		}));
		uiManager.addObject(new UIImageButton(288, 198, 64, 64, Assets.btn_2, new ClickListener() {
			@Override
			public void onClick() {
				handler.getGame().gameState = new GameState (handler, 2);
				CheckValidity();
			}
		}));
		uiManager.addObject(new UIImageButton(412, 198, 64, 64, Assets.btn_3, new ClickListener() {
			@Override
			public void onClick() {
				handler.getGame().gameState = new GameState (handler, 3);
				CheckValidity();
			}
		}));
	}
	public void CheckValidity()
	{
		if (handler.getWorld().getValidity()) 
		{
			State.setState(handler.getGame().gameState);
			handler.getMouseManager().setUIManager(null);
		}
		else System.out.println("Blad");
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.levelselect, 0, 0, 640, 360, null);
		uiManager.render(g);
	}

}
