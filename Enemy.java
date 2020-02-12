package monster;

class Enemy implements EnemiesFace
{
	private int health;
	private int points;
	private int damage;
	public int position;
	private double speed;
	private int index;
	
	public Enemy(int health, int damage, int points, double speed, int position, int index) 
	{
		this.health = health;
		this.points = points;
		this.damage = damage;
		this.speed = speed;
		this.position = position;
		this.index = index;
	}

	@Override
	public int move() 
	{
		return (this.position = position + 1);
	}

	@Override
	public double speed() 
	{
		return this.speed;
	}

	@Override
	public int getHealth() 
	{
		return this.health;
	}

	@Override
	public int damage() 
	{
		return this.damage;
	}

	@Override
	public boolean makeVisible() 
	{
		if (this.health <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public int getPosition()
	{
		return this.position;
	}

	@Override
	public int getPoints() 
	{
		return this.points;
	}

	@Override
	public int index() 
	{
		return this.index;
	}
}
