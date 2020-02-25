package monsters;
import game.*;


public class SpawnEnemies implements Runnable {

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
		
		for(int i = 0 ; i<EnemyTracker.enemyList.size(); i++) {
			try {
				if(waitedtime >= waittime) {
					if(!EnemyTracker.enemyList.get(i).getSpawn()) {
						EnemyTracker.enemyList.get(i).init();
						waitedtime = 0;
					}
				}else {
					waitedtime++;
				}
				Thread.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
}
	public void startThread() {
		new Thread(this).start();
	}



	@Override
	public void run() {
		enemySpawner();
	
	
}
}
