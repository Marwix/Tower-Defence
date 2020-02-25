package towers;

import java.awt.Graphics;

import game.Constants;
import game.Panel;
import game.TextureHandler;
import monsters.Enemy;
import monsters.EnemyTracker;
import monsters.GreenEnemy;

public class RedTower implements Tower, Runnable {

	private int shootingSpeed = 200, damage = 10, xCoord, yCoord;
	private int attack;

	private static final int value = 10;
	private static final int range = 500;
	private ProjectileTracker myProjectiles;

	public RedTower(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		attack = 0;
		myProjectiles = new ProjectileTracker();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.RED_TOWER.img, xCoord, yCoord, Constants.WIDTH, Constants.HEIGHT, null);
		myProjectiles.draw(g);
	}

	private void aim() {
		if (attack >= shootingSpeed) {
			for (int i = 0; i < EnemyTracker.enemyList.size(); i++) {
				Enemy g = EnemyTracker.enemyList.get(i);
				int xDiff = Math.abs(xCoord - (int) g.getX());
				int yDiff = Math.abs(yCoord - (int) g.getY());
				int vector = (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);

				if (g.getSpawn() == true && g.getHealth() > 0 && vector - 16 < range) {
					// g.changeHealth(-damage);
					myProjectiles.addProjectile(new RedTowerProjectile(xCoord, yCoord, g, damage));
					attack = 0;
					break;
				}

			}
		} else
			attack++;

	}

	@Override
	public void shoot() {
		new Thread(this).start();

	}

	public static int getRange() {
		return range;
	}

	// Snygga till senare om möjligt
	public int getValue() {
		return value;
	}

	public static int getStaticValue() {
		return value;
	}

	/**
	 * Returns X coord
	 * 
	 * @return
	 */
	public int getXCoord() {
		return xCoord;
	}

	/**
	 * Returns Y coord
	 * 
	 * @return
	 */
	public int getYCoord() {
		return yCoord;
	}

	@Override
	public void run() {
		aim();
		myProjectiles.projectileAct();
		myProjectiles.deleteOldProjectile();

	}
}
