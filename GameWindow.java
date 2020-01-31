import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GameWindow {
	
	private JFrame frame;
	private Container MainMenu, GameWindow;
	
	
	
	public GameWindow() {
		MainMenu = new Container();
		GameWindow = new Container();
		
		initializeMainMenu();
		initializeGameWindow();
		
	}
	
	public void initializeMainMenu() {
		
		
		frame = new JFrame("Tower Defence");
		MainMenu = frame.getContentPane();
		frame.setBounds(100, 100, 1300, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.setLayout(null);
		
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.addActionListener(e->Play());
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
		frame.setVisible(true);
	}
	
	
	
	
	private void Quit() {
		System.exit(0);
	}
	
	private void Play() {
		MainMenu.setVisible(false);
		frame.setContentPane(GameWindow);
		GameWindow.setVisible(true);
		System.out.println("PLAY PRESSED");
		
	}
	
	private void HighScore() {
		
	}
	
	
	
	private void initializeGameWindow() {
		
		GameWindow.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		GameWindow.add(panel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JButton btnNewButton_2 = new JButton("Sell");
		
		JButton btnNewButton_3 = new JButton("Red Tower");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewButton_2)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addGap(314))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		GameWindow.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("HP PANEL");
		
		JLabel lblNewLabel_1 = new JLabel("GULD PANEL");
		
		JLabel lblNewLabel_2 = new JLabel("SCOREPANEL");
		
		JButton MainMenuButton = new JButton("Main Menu");
		MainMenuButton.addActionListener(e->mainMenu());
		
		
		JButton btnPause = new JButton("Pause");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 687, Short.MAX_VALUE)
					.addComponent(btnPause)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MainMenuButton)
					.addGap(61))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addComponent(lblNewLabel_1)
					.addComponent(MainMenuButton)
					.addComponent(btnPause))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setForeground(Color.BLUE);
		GameWindow.add(panel_2, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnDev = new JMenu("Dev");
		menuBar.add(mnDev);
		
	}
	
	private void mainMenu() {
		GameWindow.setVisible(false);
		frame.setContentPane(MainMenu);
		MainMenu.setVisible(true);
		System.out.println("MAIN MENU PRESSED");
		
	}

}
