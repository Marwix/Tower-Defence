package towers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProjectileTracker {
	
	private ArrayList<TowerProjectile> projectileList;
	private ArrayList<TowerProjectile> projectileToDelete;

	public ProjectileTracker() {
		
		projectileList = new ArrayList<TowerProjectile>();
		projectileToDelete = new ArrayList<TowerProjectile>();

	}
	
	public void projectileAct() {
		
		for (int i = 0; i < projectileList.size(); i++) {
			TowerProjectile tp = projectileList.get(i);
			tp.travel();
			if (tp.getTargetHit()) projectileToDelete.add(tp);
		}

	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < projectileList.size(); i++) {
			TowerProjectile tp = projectileList.get(i);
			tp.draw(g);
		}

	}
	
	public void deleteOldProjectile() {
		projectileList.removeAll(projectileToDelete);
		projectileToDelete.clear();
	}
	
	public void addProjectile(TowerProjectile tp) {
		projectileList.add(tp);
	}
	
	public void removeProjectile(TowerProjectile tp) {
		projectileToDelete.add(tp);
	}

}
