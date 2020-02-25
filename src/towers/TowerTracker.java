package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import game.Constants;
import game.MapHandler;
import game.Panel;
import game.TextureHandler;
import windows.GameWindow;

/**
 * Class used to keep track of active towers and current build mode for towers
 * 
 */
public class TowerTracker {

	public static TextureHandler buildMode;
	public static ArrayList<Tower> towerList, towerToDelete;

	public TowerTracker() {
		buildMode = TextureHandler.EMPTY;
		towerList = new ArrayList<Tower>();
		towerToDelete = new ArrayList<Tower>();

	}

	/**
	 * What to do when mouse is clicked within game window
	 * 
	 * @param mouseButton - which mouse button is pressed
	 */
	public void mouseClick(int mouseButton) {

		// Snyggare att använda dessa?
		int x = (int) Panel.mousePosition.getX() / 64;
		int y = (int) Panel.mousePosition.getY() / 64;

		boolean occupied = false;
		Tower temp = null;
		
		
		for (int i = 0; i< towerList.size(); i++) {
			Tower t = towerList.get(i);
			if (t.getXCoord() == 64 * (Panel.mousePosition.x / 64)
					&& t.getYCoord() == 64 * (Panel.mousePosition.y / 64)) {
				temp = t;
				occupied = true;
		}


		}

		if (mouseButton == 1) {
			System.out.println("LEFT CLICK");
			// if player can afford selected tower and tile is not occupied -> create tower
			// and paint
			if (buildMode == TextureHandler.RED_TOWER && GameWindow.player.getGold() >= RedTower.getStaticValue()
					&& !occupied
					&& Panel.tilemap.tile[(Panel.mousePosition.y / 64)][(Panel.mousePosition.x / 64)].Type == 1) {
				GameWindow.player.changeGold(-RedTower.getStaticValue());
				towerList.add(new RedTower(64 * (Panel.mousePosition.x / 64), 64 * (Panel.mousePosition.y / 64)));
			}

			if (buildMode == TextureHandler.BLUE_TOWER && GameWindow.player.getGold() >= BlueTower.getStaticValue()
					&& !occupied
					&& Panel.tilemap.tile[(Panel.mousePosition.y / 64)][(Panel.mousePosition.x / 64)].Type == 2) {
				GameWindow.player.changeGold(-BlueTower.getStaticValue());
				towerList.add(new BlueTower(64 * (Panel.mousePosition.x / 64), 64 * (Panel.mousePosition.y / 64)));
			}

			if (buildMode == TextureHandler.YELLOW_TOWER && GameWindow.player.getGold() >= YellowTower.getStaticValue()
					&& !occupied
					&& Panel.tilemap.tile[(Panel.mousePosition.y / 64)][(Panel.mousePosition.x / 64)].Type == 1) {
				GameWindow.player.changeGold(-YellowTower.getStaticValue());
				towerList.add(new YellowTower(64 * (Panel.mousePosition.x / 64), 64 * (Panel.mousePosition.y / 64)));
			}

			// Prepare sold towers for deletion
			// Prevents java.util.ConcurrentModificationException
			if (buildMode == TextureHandler.SELL && occupied) {

				GameWindow.player.changeGold(temp.getValue() / 2);
				towerToDelete.add(temp);

			}
			System.out.println(GameWindow.player.getGold());

		}
		if (mouseButton == 2) {
			System.out.println("MIDDLE CLICK");

		}
		if (mouseButton == 3) {
			System.out.println("RIGHT CLICK");
			buildMode = TextureHandler.EMPTY;

		}

	}
	
	

	public void towerAct() {
		for(int i = 0; i<towerList.size(); i++)
		towerList.get(i).shoot();
	}

	/**
	 * Draw everything related to towers Line 1-3: Draw towers in current list Line
	 * 4-5: Make the selected tower follow mouse pointer Line 8+: Display the range
	 * of the selected tower
	 * 
	 * @param g - Where to draw
	 */
	public void draw(Graphics g) {
		
		for (int i = 0; i<towerList.size(); i++) {
			towerList.get(i).draw(g);
		}
		
		g.drawImage(buildMode.img, (int) Panel.mousePosition.getX(), (int) Panel.mousePosition.getY(), Constants.WIDTH,
				Constants.HEIGHT, null);

		
		// Display range while placing tower
		if (buildMode == TextureHandler.RED_TOWER) {
			g.setColor(Color.RED);
			g.drawOval((int) Panel.mousePosition.getX() - (RedTower.getRange() - 32),
					(int) Panel.mousePosition.getY() - (RedTower.getRange() - 32), 2 * RedTower.getRange(),
					2 * RedTower.getRange());
		}
		if (buildMode == TextureHandler.YELLOW_TOWER) {
			g.setColor(Color.YELLOW);
			g.drawOval((int) Panel.mousePosition.getX() - (YellowTower.getRange() - 32),
					(int) Panel.mousePosition.getY() - (YellowTower.getRange() - 32), 2 * YellowTower.getRange(),
					2 * YellowTower.getRange());
		}
		if (buildMode == TextureHandler.BLUE_TOWER) {
			g.setColor(Color.BLUE);
			g.drawOval((int) Panel.mousePosition.getX() - (BlueTower.getRange() - 32),
					(int) Panel.mousePosition.getY() - (BlueTower.getRange() - 32), 2 * BlueTower.getRange(),
					2 * BlueTower.getRange());
		}

	}

	// Safely remove sold towers and clear list of sold towers
	public void deleteSoldTowers() {
		towerList.removeAll(towerToDelete);
		towerToDelete.clear();
	}

}
