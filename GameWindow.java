import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
	JLabel goldDisplayLabel, scoreDisplayLabel, hpDisplayLabel;
	
	
	/**
	 * Create window 
	 * Create MainMenu container for its items
	 * Create GameWindow container for its items (play area and so on)
	 *
	 */
	
	public GameWindow() {
		MainMenu = new Container();
		GameWindow = new Container();
		
		initializeMainMenu();
		initializeGameWindow();
		
	}
	
	/**
	 * MainMenu initialization 
	 */
	public void initializeMainMenu() {
		
		/**
		 * Create the main frame and assign its content pane to MainMenu
		 * 
		 */
		frame = new JFrame("Tower Defence");
		MainMenu = frame.getContentPane();
		frame.setBounds(100, 100, 1300, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setup for main menu buttons
		MainMenu.setLayout(null);
		
		//Play button
		JButton playButton = new JButton("PLAY");
		playButton.addActionListener(e->Play());
		playButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		playButton.setBounds(378, 396, 520, 87);
		MainMenu.add(playButton);
		
		//Highscore button
		JButton highScoreButton = new JButton("HIGHSCORE");
		highScoreButton.addActionListener(e->HighScore());
		highScoreButton.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 29));
		highScoreButton.setBounds(378, 493, 520, 74);
		MainMenu.add(highScoreButton);
		
		//Quit button
		JButton quitButton = new JButton("QUIT");
		quitButton.addActionListener(e->Quit());
		quitButton.setForeground(Color.RED);
		quitButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		quitButton.setBounds(378, 574, 520, 74);
		MainMenu.add(quitButton);
		frame.setVisible(true);
	}
	
	
	
	/**
	 * Method for quitButton
	 * Shuts down the program
	 */
	private void Quit() {
		System.exit(0);
	}
	
	/**
	 * Method for playButton
	 * Changes content pane to game view
	 * Hides mainMenu
	 */
	private void Play() {
		MainMenu.setVisible(false);
		frame.setContentPane(GameWindow);
		GameWindow.setVisible(true);
		System.out.println("PLAY PRESSED");
		setDisplayGold(0);
		setDisplayHP(100);
		setDisplayScore(0);
		
	}
	/**
	 * Method for highScoreButton
	 * Opens high score window
	 */
	private void HighScore() {
		//new HighScoreWindow;
	}
	
	
	/**
	 * GameWindow initialization
	 * 
	 */
	private void initializeGameWindow() {
		
		GameWindow.setLayout(new BorderLayout(0, 0));
		
		//Creating left menu panel
		//For chosing tower to buy
		//or entering "SELL MODE"
		JPanel towerMenuPanel = new JPanel();
		GameWindow.add(towerMenuPanel, BorderLayout.WEST);
		
		//Maybe improve this later
		//quick fix to make the buttons align properly
		JButton yellowTowerButton = new JButton("Yellow Tower");
		
		JButton blueTowerButton = new JButton(" Blue Tower   ");
		
		JButton sellButton = new JButton("Sell");
		
		JButton redTowerButton = new JButton("  Red Tower  ");
		GroupLayout towerButtonPanel = new GroupLayout(towerMenuPanel);
		//Left panel button placements
		towerButtonPanel.setHorizontalGroup(
			towerButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(towerButtonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(towerButtonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(redTowerButton)
						.addComponent(yellowTowerButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(towerButtonPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(blueTowerButton)
					.addContainerGap())
				.addGroup(Alignment.LEADING, towerButtonPanel.createSequentialGroup()
					.addGap(29)
					.addComponent(sellButton)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		towerButtonPanel.setVerticalGroup(
			towerButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(towerButtonPanel.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(redTowerButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(yellowTowerButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(blueTowerButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sellButton)
					.addGap(314))
		);
		
		//Insert button panel into menu panel
		towerMenuPanel.setLayout(towerButtonPanel);
		
		//Set up for bottom menu panel
		
		JPanel infoPanel = new JPanel();
		GameWindow.add(infoPanel, BorderLayout.SOUTH);
		
		hpDisplayLabel = new JLabel("HP PANEL");
		
		
		goldDisplayLabel = new JLabel("GULD PANEL");
		
		scoreDisplayLabel = new JLabel("SCOREPANEL");
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(e->mainMenu());
		
		
		JButton pauseButton = new JButton("Pause");
		
		GroupLayout bottomPanelLayout = new GroupLayout(infoPanel);
		
		//Layou setup for bottom panel
		bottomPanelLayout.setHorizontalGroup(
				bottomPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(bottomPanelLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(hpDisplayLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(goldDisplayLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scoreDisplayLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 687, Short.MAX_VALUE)
					.addComponent(pauseButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainMenuButton)
					.addGap(61))
		);
		bottomPanelLayout.setVerticalGroup(
				bottomPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(bottomPanelLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(hpDisplayLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addComponent(scoreDisplayLabel)
					.addComponent(goldDisplayLabel)
					.addComponent(mainMenuButton)
					.addComponent(pauseButton))
		);
		//Add menu layout to bottom infoPanel
		infoPanel.setLayout(bottomPanelLayout);
		
		//Game frame - replace later with actual game frame?
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setForeground(Color.BLUE);
		GameWindow.add(panel_2, BorderLayout.CENTER);
		
		//Create the top menu ?Move to main menu creation instead?
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		
		//Insert dev operations into this JMenu
		//= insert JMenuItems into it and add actions to new items
		JMenu mnDev = new JMenu("Dev");
		menuBar.add(mnDev);
		
	}
	
	//Switch back to main menu view when "Main Menu" is pressed
	private void mainMenu() {
		GameWindow.setVisible(false);
		frame.setContentPane(MainMenu);
		MainMenu.setVisible(true);
		System.out.println("MAIN MENU PRESSED");
		
	}
	
	
	//Public methods for displaying information to player
	//replace with listeners later?
	
	public void setDisplayGold(int gold) {
		goldDisplayLabel.setText("GOLD: " + gold);
		goldDisplayLabel.setForeground(Color.YELLOW);
	
	}
	
	public void setDisplayHP(int hp) {
		hpDisplayLabel.setText("GOLD: " + hp);
		hpDisplayLabel.setForeground(Color.RED);
	
	}
	
	public void setDisplayScore(int score) {
		scoreDisplayLabel.setText("SCORE: " + score);
		scoreDisplayLabel.setForeground(Color.GREEN);
	
	}

}
