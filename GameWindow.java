import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	
	private int WIDTH = 1280,HEIGHT = 704;
	JLabel mainMenuBackground;
	JButton quitButton,loadGameButton, highScoreButton,newGameButton;
	
	
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
		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//setup for main menu buttons
		MainMenu.setLayout(null);
		
		//Load button
		loadGameButton = new JButton("LOAD GAME");
		loadGameButton.addActionListener(e->loadGame());
		loadGameButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		loadGameButton.setBounds(378, 396, 520, 87);
		MainMenu.add(loadGameButton);
		
		//Highscore button
		highScoreButton = new JButton("HIGHSCORE");
		highScoreButton.setForeground(new Color(50, 205, 50));
		highScoreButton.addActionListener(e->HighScore());
		highScoreButton.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 29));
		highScoreButton.setBounds(378, 493, 520, 74);
		MainMenu.add(highScoreButton);
		
		//Quit button
		quitButton = new JButton("QUIT");
		quitButton.addActionListener(e->Quit());
		quitButton.setForeground(Color.RED);
		quitButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		quitButton.setBounds(378, 574, 520, 47);
		MainMenu.add(quitButton);
		
		JButton newGameButton = new JButton("NEW GAME");
		newGameButton.addActionListener(e->newGame());
		newGameButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		newGameButton.setBounds(378, 298, 520, 87);
		frame.getContentPane().add(newGameButton);
		
		//JLabel added for optional main menu background image. Does nothing else
		mainMenuBackground = new JLabel("");
		mainMenuBackground.setBounds(0, 0, 1264, 665);
		frame.getContentPane().add(mainMenuBackground);
		
		// Move buttons when window is resized
		frame.addComponentListener(new ComponentAdapter( ) {
			  public void componentResized(ComponentEvent ev) {
			   Rectangle r = frame.getBounds();
			   int h = r.height;
			   int w = r.width;
			   //Adjust background to window size (up to image resolution) - use 4k image?
			   mainMenuBackground.setBounds(0, 0, w, h);
			   //Buttons
			   newGameButton.setBounds		((w/2-270), 	(h/2)-200	, 520, 87);
			   loadGameButton.setBounds		((w/2)-270, 	(h/2)-100	, 520, 87);
			   highScoreButton.setBounds	((w/2)-270, 	(h/2)		, 520, 74);
			   quitButton.setBounds			((w/2)-270, 	(h/2)+86	, 520, 47); //+86 pga diff i storlek (87-74 vs 74 - 47)
			     }
			});
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
	 * Method for newGame
	 * Changes content pane to game view
	 * Hides mainMenu
	 */
	private void newGame() {
		MainMenu.setVisible(false);
		frame.setContentPane(GameWindow);
		GameWindow.setVisible(true);
		System.out.println("PLAY PRESSED");
		//setDisplayGold(0);
		//setDisplayHP(100);
		//setDisplayScore(0);
		
	}
	
	/**
	 * Method for loadGameButton
	 * Loads saved game state
	 * Changes content pane to game view
	 * Hides mainMenu
	 */
	private void loadGame() {
		
		
	}
	
	/**
	 * Method for highScoreButton
	 * Opens high score window
	 */
	private void HighScore() {
		//new HighScoreWindow();
	}
	
	
	/**
	 * GameWindow initialization
	 * 
	 */
	private void initializeGameWindow() {
		
		
GameWindow.setLayout(new BorderLayout(0, 0));
		
		//Creating left menu panel
		//For choosing tower to buy
		//or entering "SELL MODE"
		JPanel towerMenuPanel = new JPanel();
		towerMenuPanel.setBackground(Color.DARK_GRAY);
		GameWindow.add(towerMenuPanel, BorderLayout.WEST);
		GridBagLayout gbl_towerMenuPanel = new GridBagLayout();
		gbl_towerMenuPanel.columnWidths = new int[]{95, 0};
		gbl_towerMenuPanel.rowHeights = new int[]{130, 42, 42, 42, 42, 130, 0};
		gbl_towerMenuPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_towerMenuPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		towerMenuPanel.setLayout(gbl_towerMenuPanel);
		
		JButton redTowerButton = new JButton("Red Tower");
		redTowerButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		redTowerButton.setToolTipText("Cost: X, Range: X, Attack Speed: osv");
		GridBagConstraints gbc_redTowerButton = new GridBagConstraints();
		gbc_redTowerButton.insets = new Insets(0, 0, 5, 0);
		gbc_redTowerButton.fill = GridBagConstraints.BOTH;
		gbc_redTowerButton.gridx = 0;
		gbc_redTowerButton.gridy = 1;
		towerMenuPanel.add(redTowerButton, gbc_redTowerButton);
		
		
		
		JButton yellowTowerButton = new JButton("Yellow Tower");
		yellowTowerButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		yellowTowerButton.setToolTipText("Cost: X, Range: X, Attack Speed: osv");
		GridBagConstraints gbc_yellowTowerButton = new GridBagConstraints();
		gbc_yellowTowerButton.fill = GridBagConstraints.BOTH;
		gbc_yellowTowerButton.insets = new Insets(0, 0, 5, 0);
		gbc_yellowTowerButton.gridx = 0;
		gbc_yellowTowerButton.gridy = 2;
		towerMenuPanel.add(yellowTowerButton, gbc_yellowTowerButton);
		
		JButton blueTowerButton = new JButton("Blue Tower");
		blueTowerButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		blueTowerButton.setToolTipText("Cost: X, Range: X, Attack Speed: osv");
		GridBagConstraints gbc_blueTowerButton = new GridBagConstraints();
		gbc_blueTowerButton.insets = new Insets(0, 0, 5, 0);
		gbc_blueTowerButton.fill = GridBagConstraints.BOTH;
		gbc_blueTowerButton.gridx = 0;
		gbc_blueTowerButton.gridy = 3;
		towerMenuPanel.add(blueTowerButton, gbc_blueTowerButton);
		
		JButton sellButton = new JButton("Sell");
		sellButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		sellButton.setToolTipText("Enter sell mode");
		GridBagConstraints gbc_sellButton = new GridBagConstraints();
		gbc_sellButton.fill = GridBagConstraints.BOTH;
		gbc_sellButton.insets = new Insets(0, 0, 5, 0);
		gbc_sellButton.gridx = 0;
		gbc_sellButton.gridy = 4;
		towerMenuPanel.add(sellButton, gbc_sellButton);
		
		//Set up for bottom menu panel
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.DARK_GRAY);
		GameWindow.add(infoPanel, BorderLayout.SOUTH);
		
		hpDisplayLabel = new JLabel("HP: 100");
		hpDisplayLabel.setToolTipText("Health Points - if it reaches 0 you lose");
		hpDisplayLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		hpDisplayLabel.setForeground(Color.RED);
		
		
		goldDisplayLabel = new JLabel("GOLD: 10000");
		goldDisplayLabel.setToolTipText("Gold: currency use to buy towers");
		goldDisplayLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		goldDisplayLabel.setForeground(Color.YELLOW);
		
		scoreDisplayLabel = new JLabel("SCORE: 10000");
		scoreDisplayLabel.setToolTipText("Score: earned by killing monsters (and completing rounds?)");
		scoreDisplayLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		scoreDisplayLabel.setForeground(Color.ORANGE);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(e->mainMenu());
		mainMenuButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		mainMenuButton.setToolTipText("Return to main menu");
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.setToolTipText("Pauses the game");
		pauseButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		JButton saveButton = new JButton("Save");
		saveButton.setToolTipText("Save your progress");
		saveButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		GroupLayout bottomPanelLayout = new GroupLayout(infoPanel);
		bottomPanelLayout.setHorizontalGroup(
			bottomPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(bottomPanelLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(hpDisplayLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(goldDisplayLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scoreDisplayLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
					.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pauseButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainMenuButton)
					.addGap(61))
		);
		bottomPanelLayout.setVerticalGroup(
			bottomPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(bottomPanelLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(hpDisplayLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addComponent(mainMenuButton)
					.addComponent(scoreDisplayLabel)
					.addComponent(goldDisplayLabel)
					.addComponent(pauseButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		bottomPanelLayout.setAutoCreateContainerGaps(true);
		//Add menu layout to bottom infoPanel
		infoPanel.setLayout(bottomPanelLayout);
		
		//Game frame - replace later with actual game frame?
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setForeground(Color.WHITE);
		GameWindow.add(panel_2, BorderLayout.CENTER);
		
		//Create the top menu ?Move to main menu creation instead?
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		//mntmQuit.addActionListener(e->Quit());
		mnFile.add(mntmQuit);
		
		
		//Insert dev operations into this JMenu
		//= insert JMenuItems into it and add actions to new items
		JMenu mnDev = new JMenu("Dev");
		menuBar.add(mnDev);
		
	}
	
	/**
	 * Switch back to main menu view when "Main Menu" is pressed
	 */
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
