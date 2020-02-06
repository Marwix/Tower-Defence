

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		
		JFrame panel = new JFrame("test");
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setContentPane(new Panel());
		panel.pack();
		panel.setVisible(true);
	}

}
