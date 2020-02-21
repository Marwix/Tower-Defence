package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import monsters.*;

import towers.TowerTracker;

public class Panel extends JPanel implements Runnable {

	public static int maxFPS = 10000000;
	public static int fps = 0;
	public static int waittime = 2600;
	public static int waitedtime = 0;
	
	
	public static boolean turnOn = true;
	public static int JPanelHeight;
	public static int JPanelwidth;
	

	public static TileMap tilemap;
	public static GreenEnemy[] greenEnemy = new GreenEnemy[20];
	public static SpawnEnemies spawnEnemies = new SpawnEnemies(waittime, waitedtime);
	public static TowerTracker towerGrid;
	public static Point mousePosition = new Point(0,0);
	public static boolean openGame;
	
	
	public Thread gamethread;

	public Panel() {
		openGame = true;
		init();
	}
	
	public void init() {
		
		
		setUpTowerTracker();

		threadInit();
		
		tilemap = new TileMap();
		spawnEnemy();
	}

	private void setUpTowerTracker() {
		towerGrid = new TowerTracker();
	}

	public void spawnEnemy() {
		for (int i = 0; i < greenEnemy.length; i++) {
			greenEnemy[i] = new GreenEnemy();
		}
	}

	public void threadInit() {
		gamethread = new Thread(this);

		gamethread.start();
	}

	/**
	 * Used to draw the game and its components
	 * Call repeatedly for to "animate"
	 */
	@Override
	public void paintComponent(Graphics g) {
		if (turnOn) {

			turnOn = false;
		}

		g.clearRect(0, 0, getWidth(), getHeight());

		tilemap.draw(g); // draw the map

		for (int i = 0; i < greenEnemy.length; i++) {
			if (greenEnemy[i].spawn) {
				greenEnemy[i].draw(g);
			}
		}
		
		//merge later
		towerGrid.draw(g);

		
		
	}
	
	
	/**
	 * Game loop
	 * This will be done repeatedly until stopped
	 * 
	 */
	@Override
	public void run() {
		while (openGame) {
			
			if (!turnOn) {
				spawnEnemies.enemySpawner();
				for(int i=0; i<greenEnemy.length; i++) {
					if(greenEnemy[i].spawn) {
						greenEnemy[i].move();
					}
				}
			}
			towerGrid.deleteSoldTowers();
			repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}