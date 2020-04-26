package bomberman.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener 
{
	
	private boolean[] keys;
	public boolean up, down, left, right, enter;
	public boolean w, s, a, d, space;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		w = keys[KeyEvent.VK_W];
		s = keys[KeyEvent.VK_S];
		a = keys[KeyEvent.VK_A];
		d = keys[KeyEvent.VK_D];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}
