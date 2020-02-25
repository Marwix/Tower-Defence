package game;

import java.awt.*;
import javax.swing.JPanel;

import monsters.*;
import towers.ProjectileTracker;
import towers.TowerTracker;

public class Panel extends JPanel implements Runnable {

	public static int maxFPS = 10000000;
	public static int fps = 0;

	public static boolean turnOn = true;

	public static int JPanelHeight;
	public static int JPanelwidth;

	public static TileMap tilemap;
	//public static EnemyTracker enemies;
	//public static TowerTracker towerGrid;
	//public static ProjectileTracker projectiles;
	public static GameLogic gamelogic;
	public static Point mousePosition = new Point(0, 0);
	public static boolean openGame;

	public Thread gamethread;

	public Panel() {
		openGame = true;
		init();
	}

	public void init() {
		tilemap = new TileMap();
		gamelogic = new GameLogic();
		threadInit();
	}
	
	public void threadInit() {
		gamethread = new Thread(this);
		gamethread.start();
	}

	/**
	 * Used to draw the game and its components Call repeatedly for to "animate"
	 */
	@Override
	public void paintComponent(Graphics g) {
		if (turnOn) {

			turnOn = false;
		}

		g.clearRect(0, 0, getWidth(), getHeight());

		tilemap.draw(g);
		gamelogic.draw(g);
		
		/*
		 * if(GameWindow.player.getHealth() == 0) {
		 * g.drawImage(TextureHandler.GAME_OVER.img, 0, 0, Constants.SCREEM_WIDTH,
		 * Constants.SCREEN_HEIGHT, null); for(int i=0; i<greenEnemy.length; i++) {
		 * if(greenEnemy[i].spawn) { greenEnemy[i].spawn = false; } }
		 * 
		 * }
		 */

	}

	/**
	 * Game loop This will be done repeatedly until stopped
	 * 
	 */
	@Override
	public void run() {
		gamelogic.gameLogicStart();
		while (openGame) {
			long start = System.currentTimeMillis();
			repaint();
			long end = System.currentTimeMillis();
			try {
				Thread.sleep(10-(end-start));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}