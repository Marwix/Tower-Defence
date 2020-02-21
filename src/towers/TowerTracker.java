package towers;

import java.awt.Graphics;
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
	public static LinkedList<Tower> towerList, towerToDelete;

	public TowerTracker() {
		buildMode = TextureHandler.EMPTY;
		towerList = new LinkedList<Tower>();
		towerToDelete = new LinkedList<Tower>();

	}

	/**
	 * What to do when mouse is clicked within game window
	 * 
	 * @param mouseButton - which mouse button is pressed
	 */
	public void mouseClick(int mouseButton) {
		
		//Snyggare att använda dessa?
		int x = (int) Panel.mousePosition.getX() / 64;
		int y = (int) Panel.mousePosition.getY() / 64;
		
		boolean occupied = false;
		Tower temp = null;
		for (Tower t : towerList) {
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
			if (buildMode == TextureHandler.EMPTY && occupied) {

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

	/**
	 * Draw everything related to towers 
	 * Line 1-3: Draw towers in current list
	 * Line 4-5: Make the selected tower follow mouse pointer
	 * 
	 * @param g - Where to draw
	 */
	public void draw(Graphics g) {
		for (Tower t : towerList) {
			t.draw(g);
		}
		g.drawImage(buildMode.img, (int) Panel.mousePosition.getX(), (int) Panel.mousePosition.getY(), Constants.WIDTH,
				Constants.HEIGHT, null);

	}

	//Safely remove sold towers and clear list of sold towers
	public void deleteSoldTowers() {
		towerList.removeAll(towerToDelete);
		towerToDelete.clear();
	}

}
