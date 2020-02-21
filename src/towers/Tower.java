package towers;

import java.awt.Graphics;

interface Tower {

	
	/**
	 * Draw tower
	 * @param g where to draw
	 */
	public void draw(Graphics g);
	
	/**
	 * Tell the tower to shoot at closest (if within range) enemy
	 */
	public void shoot();
	/**
	 * Returns tower value
	 * @return tower value(cost)
	 */
	public int getValue();
	
	/**
	 * Returns X coord
	 * @return
	 */
	public int getXCoord();
	
	/**
	 * Returns Y coord
	 * @return
	 */
	public int getYCoord();
	
	
	
}
