package towers;

import java.awt.Graphics;

import game.Constants;
import game.Panel;
import game.TextureHandler;

public class RedTower implements Tower {

	private int attackSpeed = 15, damage, xCoord, yCoord;
	// Gör om till final senare
	private static int value = 10;

	public RedTower(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.RED_TOWER.img, xCoord, yCoord, Constants.WIDTH, Constants.HEIGHT, null);
	}

	private void aim() {

	}

	@Override
	public void shoot() {
		// aim, shoot sleep - aim, shoot, sleep ?

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
	
	/**
	 * Returns Y coord
	 * @return
	 */
	public int getYCoord() {
		return yCoord;
	}	
}
