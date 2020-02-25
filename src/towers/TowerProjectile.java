package towers;

import java.awt.Graphics;

import monsters.Enemy;

public interface TowerProjectile extends Runnable{
	
	
	
	/**
	 * Make the projectile chase its target
	 * OR travel to target area
	 */
	public void travel();
	
	/**
	 * Draw projectile's current position
	 * @param g - Where to draw
	 */
	public void draw(Graphics g);
	
	public boolean getTargetHit();

}
