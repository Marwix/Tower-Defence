package towers;

import java.awt.Graphics;

import game.Constants;
import game.Panel;
import game.TextureHandler;
import monsters.Enemy;
import monsters.EnemyTracker;
import monsters.GreenEnemy;

public class BlueTower implements Tower {

	private int shootingSpeed = 15, damage = 10, xCoord, yCoord;
	private int attack;
	
	private static final int value = 10;
	private static final int  range = 500;

	public BlueTower(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.BLUE_TOWER.img, xCoord, yCoord, Constants.WIDTH, Constants.HEIGHT, null);
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
	
	/**
	 * Returns the set range of the tower
	 * @return range 
	 */
	public static int getRange() {
		return range;
	}
	
	
	@Override
	public int getValue() {
		return value;
	}
	/**
	 * Return tower (generic) value
	 * @return generic value
	 */
	public static int getStaticValue() {
		return value;
	}
	
	@Override
	public int getXCoord() {
		return xCoord;
	}
	
	@Override
	public int getYCoord() {
		return yCoord;
	}

	@Override
	public void run() {
		aim();
		
	}	
}
