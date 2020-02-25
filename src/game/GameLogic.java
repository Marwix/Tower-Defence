package game;

import java.awt.Graphics;

import monsters.EnemyTracker;
import towers.ProjectileTracker;
import towers.TowerTracker;

public class GameLogic implements Runnable {

	public static EnemyTracker enemies;
	public static TowerTracker towerGrid;
	public static ProjectileTracker projectiles;
	
	public GameLogic() {
		setUpTrackers();
	}
	
	private void setUpTrackers() {
		enemies = new EnemyTracker();
		enemies.createEnemy(2,2,2,2,2,2);
		towerGrid = new TowerTracker();
		projectiles = new ProjectileTracker();
	}
	public void draw(Graphics g) {
		enemies.draw(g);
		towerGrid.draw(g);
	}
	
	public void gameLogicStart() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(Panel.openGame) {
			long start = System.currentTimeMillis();
			if(!Panel.turnOn) {
				enemies.startSpawner();
				enemies.move();
			}
			
			EnemyTracker.clearDead();
			enemies.endRound();
			towerGrid.towerAct();
			towerGrid.deleteSoldTowers();
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
