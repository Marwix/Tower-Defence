package monsters;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class EnemyTracker implements Runnable {
	
	
	public static int waittime = 4000;
	public static int waitedtime = 0;
	
	public static SpawnEnemies spawnEnemies = new SpawnEnemies(waittime, waitedtime);
	
	public static ArrayList<Enemy> enemyList;
	public static ArrayList<Enemy> enemyToDeleteList;
	private int deletedEnemies;
	
	public EnemyTracker(){
		deletedEnemies = 0;
		enemyList = new ArrayList<Enemy>();
		enemyToDeleteList = new ArrayList<Enemy>();
	}
	
	
	public void createEnemy(int greenEnemy, int redEnemy, int yellowEnemy, int mikeyEnemy, int spookeyEnemy, int invisEnemy) {
		if(greenEnemy > 0) {
			for(int i = 0; i < greenEnemy; i++) {
				enemyList.add(new GreenEnemy());
			}
		}
		if(redEnemy > 0) {
			for(int i = 0; i < redEnemy; i++) {
				enemyList.add(new RedEnemy());
			}
		}
		if(yellowEnemy > 0) {
			for(int i = 0; i < yellowEnemy; i++) {
				enemyList.add(new YellowEnemy());
			}
		}
		if(mikeyEnemy > 0) {
			for(int i = 0; i < mikeyEnemy; i++) {
				enemyList.add(new MikeyEnemy());
			}
		}
		if(spookeyEnemy > 0) {
			for(int i = 0; i < spookeyEnemy; i++) {
				enemyList.add(new SpookeyEnemy());
			}
		}
		if(invisEnemy > 0) {
			for(int i = 0; i < invisEnemy; i++) {
				enemyList.add(new InvisEnemy());
			}
		}
		
	}
	public void draw(Graphics g) {
		
		for(int i = 0 ; i<EnemyTracker.enemyList.size(); i++) {
			if(EnemyTracker.enemyList.get(i).getSpawn()) {
				EnemyTracker.enemyList.get(i).draw(g);
			}
			}
		
		/*for (int i = 0; i < enemyList.size();i++) {
			enemyList.get(i).draw(g);
		}*/

	}
	
	public void move() {
		for (int i = 0; i < EnemyTracker.enemyList.size(); i++) {
			Enemy e = EnemyTracker.enemyList.get(i);
			if (e.getSpawn()) {
				e.move();
			}
		}
	}
	
	public static void clearDead() {
		enemyList.removeAll(enemyToDeleteList);
		enemyToDeleteList.clear();
	}
	
	public void startSpawner() {
		spawnEnemies.startThread();
	}
	
	public void endRound() {
		if (EnemyTracker.enemyList.size() == 0) {
			createEnemy(2,2,2,2,2,2);
			System.out.println("new Round");
		}
	}

	@Override
	public void run() {
		
		
	}
	

	

}
