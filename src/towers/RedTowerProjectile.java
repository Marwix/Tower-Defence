package towers;
import java.awt.Graphics;

import game.Constants;
import game.TextureHandler;
import monsters.*;

public class RedTowerProjectile implements TowerProjectile, Runnable{
	
	private int xCoord, yCoord;
	private Enemy target = null;
	private int speed = 5;
	//Damage received from tower
	private int damage;
	private boolean targetHit;
	
	public RedTowerProjectile(int xCoord, int yCoord, Enemy target, int damage) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.target = target;
		this.damage = damage;
		targetHit = false;
	}

	@Override
	public void travel() {
		new Thread(this).start();
		
	}

	@Override
	public void run() {
		
		int xDiff = (int)(target.getX() - xCoord);
		int yDiff = (int)(target.getY() - yCoord);
		
		if (Math.abs(xDiff) < 6 && Math.abs(yDiff) < 6) {
			target.changeHealth(-damage);
			targetHit = true;
		}

		if (xDiff > 0) {
			xCoord++;
		} else if (xDiff < 0) {
			xCoord--;
		}
		if (yDiff > 0) {
			yCoord++;
		} else if (yDiff < 0) {
			yCoord--;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TextureHandler.RED_PROJECTILE.img, xCoord, yCoord, Constants.WIDTH/3, Constants.HEIGHT/3, null);
		
	}
	
	public boolean getTargetHit() {
		return targetHit;
	}

}
