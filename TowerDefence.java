package tower;


public class TowerDefence implements Tower {
	
	double shootspeed;
	int position;
    //private image tower = ImageLoader.getLoader().getImage("resources/.......png"); //kanske nåt åt detta håll för att få framm bilden av tornen
	final private double shootrange =50;    // konstant behöver inte ha ne metod med shootrange                                                                       // behöver dock importera bibliotek tror jag
	
	public TowerDefence(double shootspeed, int position ) {
		this.shootspeed= shootspeed;
		this.position=position;
		
	}


	@Override
	public void shootSpeed() {
		this.shootspeed = shootrange;
	}

	@Override
	public int stePosition() {
	     return this.position;
	    
	}

	@Override
	public void draw() {
		
		
	}


	@Override
	public int index() {
		return this.index();
		
	}
	
	
	
 
}
