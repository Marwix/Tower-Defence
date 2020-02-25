package monsters;

import java.awt.Graphics;

public interface Enemy extends Runnable{
	
	
	
	/*
	 * how to walk
	 */
	public void enemyDirections();
	/*
	 * @param change, change mosters health
	 */
	public void changeHealth(int change);
	/*
	 * where to spawn
	 */
	public void init();
	/*
	 * when to walk
	 */
	public boolean timeToWalk();
	/*
	 * @param type of tile
	 * checks if monster can spawn on tile
	 */
	public boolean checkSpawmPoint(int y);
	/*
	 * if the monster has passed to the end remove it
	 */
	public void passedToBase();
	
	public void move();
	public void draw(Graphics g);
	public int getHealth();
	public double getX();
	public double getY();
	public boolean getSpawn();
	public int getGold();
	public int getEnemyID();
	public int getDamageToPlayer();
	
	

}
