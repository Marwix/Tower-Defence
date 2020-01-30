import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Frame {

	private JFrame frame;
	private Container MainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		MainMenu = frame.getContentPane();
		frame.setBounds(100, 100, 1300, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.setLayout(null);
		
		JButton btnNewButton = new JButton("PLAY");
		//btnNewButton.addActionListener(e->play());
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		btnNewButton.setBounds(378, 396, 520, 87);
		MainMenu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HIGHSCORE");
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 29));
		btnNewButton_1.setBounds(378, 493, 520, 74);
		MainMenu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("QUIT");
		btnNewButton_2.addActionListener(e->Quit());
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		btnNewButton_2.setBounds(378, 574, 520, 74);
		MainMenu.add(btnNewButton_2);
	}
	
	private void Quit() {
		System.exit(0);
	}
	
}
