package Monsters;

class GreenEnemy implements Enemy
{
	private int health;
	private int points;
	private int damage;
	public int position;
	private double speed;
	private int index;
	
	public GreenEnemy(int health, int damage, int points, double speed, int position, int index) 
	{
		this.health = health;
		this.points = points;
		this.damage = damage;
		this.speed = speed;
		this.position = position;
		this.index = index;
	}

	@Override
	public void move() 
	{
		//Move monster across map
		
	}

	@Override
	public void setSpeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeHealth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makeVisible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getYPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int index() {
		// TODO Auto-generated method stub
		return 0;
	}




}
