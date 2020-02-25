package monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Constants;
import game.Panel;
import game.TextureHandler;
import windows.GameWindow;

public class SpookeyEnemy extends Rectangle implements Enemy {

	private int notWalkingTime;
	private final int whenToWalk;
	
	public int health;
	public int gold;
	public int enemyID;
	public int damageToPlayer;
	
	public int healthbar = 10;
	public int emptySpace = 4;
	
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
	
	private int score = 10;
	
	public boolean spawn = false;
	/*
	 * Creating the monsters with specified health, gold, speed and a enemyID that might be used later for other stuff
	 */
	public SpookeyEnemy() 
	{
		health = 64;
		gold = 2;
		enemyID = 1;
		damageToPlayer = -25;
		
		
		moveToRight = 0;
		moveToLeft = 1;
		moveToDown = 2;
		moveToUp = 3;
		DefaultWay = moveToRight;
		
		notWalkingTime = 0;
		whenToWalk = 3;
	
		
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
	
	public boolean timeToWalk() {
		if(notWalkingTime >= whenToWalk) {
			notWalkingTime = 0;
			return true;
		}else {
			notWalkingTime++;
			return false;
		}
		
		
	}
	
	
	/*
	 * checking the tile to see if its a ok spot to spawn the monsters
	 */
	public boolean checkSpawmPoint(int y) {
		
		if(Panel.tilemap.tile[y][0].Type == Constants.ENEMY_ROAD) {
			return true;
		}
		return false;
		
	}
	
	public void changeHealth(int change) {
		health += change;
		if (health <= 0) {
			health = 0;
			GameWindow.player.changeGold(this.gold);
			GameWindow.player.changeScore(this.score);
			EnemyTracker.enemyToDeleteList.add(this);
			spawn = false;
			EnemyTracker.clearDead();
		}
	}
	
	public void passedToBase() {
		spawn = false;
		EnemyTracker.clearDead();
	}
	
	public void damagePlayer() {
		GameWindow.player.changeHealth(damageToPlayer);
		System.out.println(" "+ GameWindow.player.getHealth());
	}
	
	public void enemyDirections() {
		
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
				
			
			if(Panel.tilemap.tile[yStart][xStart].Type == 6) {
				//passedToBase();
				damagePlayer();
				
				
			}
				
				movedToUp = false;
				movedToDown = false;
				movedToRight = false;
				movedToLeft = false;
			
			
			enemyMoved = 0;
			
			
		
		
		}
	}
		
	public void move() {
		new Thread(this).start();

	}
		
	
	
	/*
	 * @param Graphics component
	 * draws the image on the graphic component
	 */
	public void draw(Graphics g) {
		if(spawn) { 
			g.drawImage(TextureHandler.SPOOKEY.img, x, y, width, height, null);
			g.setColor(Color.GREEN);
			g.fillRect(x, y - (healthbar + emptySpace) , health, healthbar);
		}
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public boolean getSpawn() {
		// TODO Auto-generated method stub
		return spawn;
	}

	@Override
	public int getGold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnemyID() {
		// TODO Auto-generated method stub
		return enemyID;
	}

	@Override
	public int getDamageToPlayer() {
		// TODO Auto-generated method stub
		return damageToPlayer;
	}

	@Override
	public void run() {
		if(timeToWalk()) {
			enemyDirections();
				
		}
	}
}

		
	
