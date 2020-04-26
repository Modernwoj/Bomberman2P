package bomberman.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import bomberman.gfx.Assets;
import bomberman.gfx.Window;
import bomberman.input.KeyManager;
import bomberman.input.MouseManager;
import bomberman.states.MenuState;
import bomberman.states.State;

public class Game implements Runnable
{
//=========deklaracje============
	//okno gry
	private Window window, menuwindow;
	private int width, height;
	public String title;
	
	//praca gry
	private boolean running = false;
	private Thread thread;
	
	
	//grafika
	private BufferStrategy BS;
	private Graphics G;
	
	
	//States
	public State gameState;
	public State menuState;
	public State levelSelectState;
	public State endState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Handler
	private Handler handler;
//================================
	
	//konstruktor
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		//Input
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init()
	{
		window = new Window(title,width, height);
		window.getFrame().addKeyListener(keyManager);
		window.getFrame().addMouseListener(mouseManager);
		window.getFrame().addMouseMotionListener(mouseManager);
		window.getCanvas().addMouseListener(mouseManager);
		window.getCanvas().addMouseMotionListener(mouseManager);
		menuwindow = window;

		Assets.init();
		
		handler = new Handler(this);
		menuState = new MenuState(handler);

		State.setState(menuState);
	}
	
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render()
	{
		BS = window.getCanvas().getBufferStrategy();
		if(BS == null)
		{
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		G = BS.getDrawGraphics();
		//clear screen
		G.clearRect(0, 0, width, height);
		//Drawing	
		
		if(State.getState() != null)
			State.getState().render(G);
		//End Drawing
		BS.show();
		G.dispose();
	}
	
	public void run()
	{
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				delta--;
			}
		}
		
		stop();
		
	}
	//Change Window
	public void SetWindow(int newwidth, int newheight)
	{
		window.closeWindow();
		window = new Window(title, newwidth, newheight);
		window.getFrame().addKeyListener(keyManager);
		window.getFrame().addMouseListener(mouseManager);
		window.getFrame().addMouseMotionListener(mouseManager);
		window.getCanvas().addMouseListener(mouseManager);
		window.getCanvas().addMouseMotionListener(mouseManager);
	}
	public void ResetWindow()
	{
		window.shutdown();
		window = menuwindow;
		window.openWindow();
	}
	
	
	//GETTERS 
	
	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
}
	
	
	
	
	
	
	
	
	

}
