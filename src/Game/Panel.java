package Game;
import java.awt.*;
import java.io.IOException;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

	public static int maxFPS = 10000000;
	public static int fps = 0;

	public static boolean turnOn;
	public static int JPanelHeight;
	public static int JPanelwidth;

	public static Image[] Grass1 = new Image[1000];
	public static Image[] Water1 = new Image[1000];
	public static Image[] Bricks1 = new Image[1000];

	public TileMap tilemap;
	public Thread gamethread;

	public Panel() throws IOException {
		turnOn = true;

		threadInit();

		tilemap = new TileMap();
		loadGrass();
		loadWater();
		loadBricks();

	}

	public void loadBricks() throws IOException {
		for (int i = 0; i < Bricks1.length; i++) {
			Bricks1[i] = ReadFile.getBricks1();
		}
	}

	public void loadWater() throws IOException {
		for (int i = 0; i < Water1.length; i++) {
			Water1[i] = ReadFile.getWater1();
		}
	}

	public void loadGrass() throws IOException {
		for (int i = 0; i < Grass1.length; i++) {
			Grass1[i] = ReadFile.getGrass1();
		}
	}

	public void threadInit() {
		gamethread = new Thread(this);

		gamethread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (turnOn) {

			turnOn = false;
		}

		g.clearRect(0, 0, getWidth(), getHeight());

		tilemap.draw(g); // draw the map

	}

	@Override
	public void run() {
		while (true) {
			if (!turnOn) {

			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}