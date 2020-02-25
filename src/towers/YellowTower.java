package towers;

import java.awt.Color;
import java.awt.Graphics;

import game.Constants;
import game.Panel;
import game.TextureHandler;
import monsters.Enemy;
import monsters.EnemyTracker;
import monsters.GreenEnemy;

public class YellowTower implements Tower {

	
	private int xCoord;
	private int yCoord;
	private int attack;
	private int shootingSpeed = 1000;
	private int damage = 100; 
	private static final int value = 10;
	private static final int range = 130;

	public YellowTower(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.YELLOW_TOWER.img, xCoord, yCoord, Constants.WIDTH, Constants.HEIGHT, null);
		
	}

	private void aim() {
		if (attack >= shootingSpeed) {
			for (Enemy g : EnemyTracker.enemyList) {
				
				// 
				int xDiff = Math.abs(xCoord - (int) g.getX());
				int yDiff = Math.abs(yCoord - (int) g.getY());
				int vector = (int) Math.sqrt(xDiff*xDiff + yDiff*yDiff);
				
				if (g.getSpawn() == true && g.getHealth() > 0 && vector -16< range) {
					g.changeHealth(-damage);
					attack = 0;
					break;
				}

			}
		} else attack++;

	}

	@Override
	public void shoot() {
		new Thread(this).start();
		
	}

	public int getValue() {
		return value;
	}
	public static int getStaticValue() {
		return value;
	}
	
	/**
	 * Returns X coord
	 * @return
	 */
	public int getXCoord() {
		return xCoord;
	}
	
	public static int getRange() {
		return range;
	}
	
	/**
	 * Returns Y coord
	 * @return
	 */
	public int getYCoord() {
		return yCoord;
	}

	@Override
	public void run() {
		aim();
		
	}	
}
