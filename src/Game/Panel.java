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

	

	public TileMap tilemap;
	public Thread gamethread;

	public Panel() throws IOException {
		turnOn = true;

		threadInit();

		tilemap = new TileMap();
		

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