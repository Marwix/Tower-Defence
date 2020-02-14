package Windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Game.*;
import MouseSettings.BuildRedTower;
import MouseSettings.MouseMode;
import MouseSettings.*;

public class GameWindow implements Window, SwitchableWindow{
	
	public static Panel GamePanel;
	
	private Container GameContent;
	JLabel goldDisplayLabel, scoreDisplayLabel, hpDisplayLabel;
	
	//private int WIDTH = 1280,HEIGHT = 704;
	JLabel mainMenuBackground;
	JButton quitButton,loadGameButton, highScoreButton,newGameButton;
	SwitchableWindow MainMenu;
	MouseMode currentMouse;
	
	/**
	 * Create window 
	 * Create MainMenu container for its items
	 * Create GameWindow container for its items (play area and so on)
	 * @param original - The main menu window so it doesn't get lost
	 * @throws IOException 
	 *
	 */
	
	public GameWindow(SwitchableWindow original) throws IOException {
		MainMenu = original;
		GameContent = new Container();
		
		
		initialize();
	}

	
	/**
	 * GameWindow initialization
	 * @throws IOException 
	 * 
	 */
	private void initialize() throws IOException {
		
		
		GameContent.setLayout(new BorderLayout(0, 0));
		
		//Creating left menu panel
		//For choosing tower to buy
		//or entering "SELL MODE"
		JPanel towerMenuPanel = new JPanel();
		towerMenuPanel.setBackground(Color.DARK_GRAY);
		GameContent.add(towerMenuPanel, BorderLayout.WEST);
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
		redTowerButton.addActionListener(e->buildRedMode());
		
		
		
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
		GameContent.add(infoPanel, BorderLayout.SOUTH);
		
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
		
		GamePanel = new Panel();
		GameContent.add(GamePanel, BorderLayout.CENTER);
		

		
	}
	
	/**
	 * Switch back to main menu view when "Main Menu" is pressed
	 */
	public void switchWindow(SwitchableWindow newcontent) {
		MainMenu.switchWindow(newcontent);
		
	}
	
	
	private void mainMenu() {
		switchWindow(MainMenu);
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


	@Override
	public Container getContent() {
		return GameContent;
	}
	
	/**
	 * Mouse action
	 */
	
	private void mouseClickAction() {
		
		currentMouse.mouseAction();
		
	}
	
	//Mouse modes
	/**
	 * Set mouse mouse mode to build red towers
	 */
	private void buildRedMode() {
		currentMouse = new BuildRedTower();
	}
	
	private void sellMode() {
		currentMouse = new sellTower();
	}
	
	

}
