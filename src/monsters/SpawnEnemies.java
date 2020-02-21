package monsters;
import game.*;


public class SpawnEnemies {

	public int waittime;
	public int waitedtime;
	
	/*
	 * @param time between spawning the monsters
	 * @param waited time always 0 but the developer can specify where the time should start
	 */
	public SpawnEnemies(int waittime, int waitedtime) {
		this.waittime = waittime;
		this.waitedtime = waitedtime;
	}
	
	
	
	/*
	 * Spawning monsters in a time that the developer has specified
	 * when its spawn resets the timer to 0 again 
	 */
	public void enemySpawner() {
		if(waitedtime >= waittime) {
			for(int i = 0; i< Panel.greenEnemy.length; i++) {
				if(!Panel.greenEnemy[i].spawn) {
					
					Panel.greenEnemy[i].init();
					break;
				}
			}
			waitedtime = 0;
		}else {
			waitedtime++;
		}
	}
	
}
