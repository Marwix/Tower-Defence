package towers;

import java.awt.Graphics;

import game.Constants;
import game.Panel;
import game.TextureHandler;

public class YellowTower implements Tower {

	private int attackSpeed = 15, damage, xCoord, yCoord;
	// Gör om till final senare
	private static int value = 10;

	public YellowTower(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.YELLOW_TOWER.img, xCoord, yCoord, Constants.WIDTH, Constants.HEIGHT, null);
	}

	private void aim() {

	}
	
	
	@Override
	public void shoot() {
		// aim, shoot sleep - aim, shoot, sleep ?

	}
	
	/**
	 * Returns the value (cost) of the tower
	 * @return
	 */
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
