package Monsters;

interface Enemy {
	
	public void move();
	public void setSpeed();
	public void changeHealth();
	public int getDamage();
	public void makeVisible();
	public int getYPosition();
	public int getXPosition();
	public int getPoints();
	public int index();

}
