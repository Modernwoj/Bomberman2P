package bomberman.states;

import java.awt.Graphics;

import bomberman.game.Handler;
import bomberman.gfx.Assets;
import bomberman.ui.ClickListener;
import bomberman.ui.UIImageButton;
import bomberman.ui.UIManager;

public class EndState extends State {

	private UIManager uiManager;
	private int player;
	
	public EndState(Handler handler, int player) {
		super(handler);
		handler.getGame().ResetWindow();
		
		uiManager = new UIManager (handler); 
		this.player = player;

		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(256, 250, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().levelSelectState = new LevelSelectState(handler);
				State.setState(handler.getGame().levelSelectState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.endgame[player], 0, 0, 640, 360, null);
		uiManager.render(g);
	}

}