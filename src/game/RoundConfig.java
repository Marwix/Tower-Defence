package game;

import monsters.EnemyTracker;

public class RoundConfig {
	
	public int round;
	public int startGreen;
	public int startRed;
	public int startYellow;
	public int startSpookey;
	public int startMikey;
	
	
	public RoundConfig(int round, int startRed, int startSpookey, int startMikey, int startGreen, int startYellow) {
		this.round = round;
		this.startGreen = startGreen;
		this.startRed = startRed;
		this.startYellow = startYellow;
		this.startSpookey = startSpookey;
		this.startMikey = startMikey;
	}
	
	public void changeRound() {
		
		if(round % 2 == 0) {
			if(round == 2) {
				Panel.enemies.createEnemy(startGreen + 2, startRed + 1, 0, 0, 0);
			}
		}
		
		if(round % 3 == 0) {
			Panel.enemies.createEnemy(startGreen + 2, startRed + 3,0, 0, 0);
			if(round == 6) {
				Panel.enemies.createEnemy(startGreen + 2, startRed + 2,startYellow + 2 , 0, 0);
			}
		}
		if(round % 5 == 0) {
			Panel.enemies.createEnemy(startGreen + 2, startRed + 3,startYellow + 3 , 0, 0);
			if(round == 10) {
				Panel.enemies.createEnemy(startGreen + 2, startRed + 4,startYellow + 2 ,startMikey + 2 , 0);
			}
		}
		if(round % 15 == 0) {
			Panel.enemies.createEnemy(startGreen + 2, startRed + 3,startYellow + 3 , startMikey + 3, 0);
			if(round == 10) {
				Panel.enemies.createEnemy(startGreen + 2, startRed + 4,startYellow + 2 ,startMikey + 2 , startSpookey + 1);
			}
		}
		
	}
	
}
