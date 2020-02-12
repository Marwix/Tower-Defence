
import java.awt.Graphics;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {

	private TileGrid Grid;
	/*
	 * 0 = bricks
	 * 1 = grass
	 * 2 = grumligare grass
	 * 3 = grus
	 * 4 = snö
	 * 5 = sand
	 */
	public Panel() {
	
		Grid = new TileGrid(new int[][] {
			{0,1,9,1,1}
		}); 
			
		
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Grid.Draw(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
