package monsters;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Constants;
import game.Panel;
import game.TextureHandler;
import windows.GameWindow;

public class GreenEnemy extends Rectangle
{
	private int notWalkingTime;
	private final int whenToWalk;
	public int health;
	public int gold;
	public int enemyID;
	public int xStart;
	public int yStart;
	
	public int enemyMoved;
	public int moveToRight;
	public int moveToLeft;
	public int moveToDown;
	public int moveToUp;
	public int DefaultWay;
	
	public boolean movedToRight;
	public boolean movedToLeft;
	public boolean movedToDown;
	public boolean movedToUp;
	
	
	public boolean spawn = false;
	/*
	 * Creating the monsters with specified health, gold, speed and a enemyID that might be used later for other stuff
	 */
	public GreenEnemy() 
	{
		health = 100;
		gold = 10;
		enemyID = 1;
		moveToRight = 0;
		moveToLeft = 1;
		moveToDown = 2;
		moveToUp = 3;
		DefaultWay = moveToRight;
		notWalkingTime = 0;
		whenToWalk = 15;
		
		moveToRight = 0;
		moveToLeft = 1;
		moveToDown = 2;
		moveToUp = 3;
		
		movedToUp = false;
		movedToDown = false;
		movedToRight = false;
		movedToLeft = false;
	}
	
	/*
	 * Creating the monster at the starting location(always on the left and on x = 0)
	 * after creating the monster changing its boolean to true that signifies that the monster is alive
	 */
	
	
	public void init() {
		for(int y = 0; y < Panel.tilemap.tile.length; y++) {
			if(checkSpawmPoint(y)) {
				setBounds(Panel.tilemap.tile[y][0].x, Panel.tilemap.tile[y][0].y, Constants.GRID_SIZE, Constants.GRID_SIZE);
				yStart = y;
				xStart = 0;
			}
		}
		
		spawn = true;
	}
	
	private boolean timeToWalk() {
		if(notWalkingTime >= whenToWalk) {
			notWalkingTime = 0;
			return true;
		}else {
			notWalkingTime++;
			return false;
		}
		
		
	}
	
	private boolean okToWalkon() {
		return spawn;
		
	}
	
	/*
	 * checking the tile to see if its a ok spot to spawn the monsters
	 */
	private boolean checkSpawmPoint(int y) {
		
		if(Panel.tilemap.tile[y][0].Type == Constants.ENEMY_ROAD) {
			return true;
		}
		return false;
		
	}
	
	private void enemyDirections() {
		
		if(DefaultWay == moveToRight) {
			x++;
		}else if(DefaultWay == moveToLeft) {
			x--;
		}else if(DefaultWay == moveToUp) {
			y++;
		}else if(DefaultWay == moveToDown) {
			y--;
		}
		
		enemyMoved++;
		
		if(enemyMoved == Constants.GRID_SIZE) {
			if(DefaultWay == moveToRight) {
				movedToRight = true;
				xStart++;
			}else if(DefaultWay == moveToLeft) {
				movedToLeft = true;
				xStart--;
			}else if(DefaultWay == moveToDown) {
				movedToDown = true;
				yStart--;
			}else if(DefaultWay == moveToUp) {
				movedToUp = true;
				
				yStart++;
		}
			
			
				if((Panel.tilemap.tile[yStart+1][xStart].Type == 0) && !movedToDown ) {
					DefaultWay = moveToUp;
				}
			
			
				if((Panel.tilemap.tile[yStart-1][xStart].Type == 0) && !movedToUp) {
					
					DefaultWay = moveToDown;
				}
			
				if((Panel.tilemap.tile[yStart][xStart+1].Type == 0) && !movedToLeft) {
					
					DefaultWay = moveToRight;
				}
			
			
			if(DefaultWay != moveToRight) {
				if((Panel.tilemap.tile[yStart][xStart-1].Type == 0) && !movedToRight ) {
					
					DefaultWay = moveToLeft;
				}
			}
				
				movedToUp = false;
				movedToDown = false;
				movedToRight = false;
				movedToLeft = false;
			
			
			enemyMoved = 0;
			
			
		
		
		}
	}
		
	public void move() {
		if(timeToWalk()) {
			enemyDirections();
				
		}
	}
		
	
	
	/*
	 * @param Graphics component
	 * draws the image on the graphic component
	 */
	public void draw(Graphics g) {
		if(spawn) { 
			g.drawImage(TextureHandler.GREEN_MONSTER.img, x, y, width, height, null);
		}
	}

	

}
