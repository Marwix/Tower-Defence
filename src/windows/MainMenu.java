package windows;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import game.*;
import network.*;

public class MainMenu implements Window, SwitchableWindow {
	private JFrame frame;
	private Container MainMenu;
	private Client client;
	JLabel mainMenuBackground;
	JButton quitButton, loadGameButton, highScoreButton, newGameButton;
	boolean server_reached = false;
	

	public MainMenu() {
		
		//Online IP:
		// 83.249.189.91
		client = new Client("localhost", 1604);
		initialize();

	}

	/**
	 * MainMenu initialization
	 */
	private void initialize() {

		/**
		 * Create the main frame and assign its content pane to MainMenu
		 * 
		 */
		frame = new JFrame("Tower Defence");
		MainMenu = frame.getContentPane();
		frame.setBounds(100, 100, Constants.SCREEM_WIDTH, Constants.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	

		// setup for main menu buttons
		MainMenu.setLayout(null);

		// Load button
		loadGameButton = new JButton("LOAD GAME");
		loadGameButton.addActionListener(e -> loadGame());
		loadGameButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		loadGameButton.setBounds(378, 396, 520, 87);
		MainMenu.add(loadGameButton);

		// Highscore button
		highScoreButton = new JButton("HIGHSCORE");
		highScoreButton.setForeground(new Color(50, 205, 50));
		highScoreButton.addActionListener(e -> HighScore());
		highScoreButton.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 29));
		highScoreButton.setBounds(378, 493, 520, 74);
		MainMenu.add(highScoreButton);
		//Enable if server is reachable
		boolean connectionStatus = client.serverReachable();
		highScoreButton.setEnabled(connectionStatus);
		
		// Quit button
		quitButton = new JButton("QUIT");
		quitButton.addActionListener(e -> Quit());
		quitButton.setForeground(Color.RED);
		quitButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		quitButton.setBounds(378, 574, 520, 47);
		MainMenu.add(quitButton);

		JButton newGameButton = new JButton("NEW GAME");
		newGameButton.addActionListener(e -> newGame());
		newGameButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 29));
		newGameButton.setBounds(378, 298, 520, 87);
		frame.getContentPane().add(newGameButton);

		// JLabel added for optional main menu background image. Does nothing else
		mainMenuBackground = new JLabel("");
		mainMenuBackground.setBounds(0, 0, 1264, 665);
		frame.getContentPane().add(mainMenuBackground);

		// Create the top menu
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(e -> Quit());
		mnFile.add(mntmQuit);

		// Insert dev operations into this JMenu
		// = insert JMenuItems into it and add actions to new items
		JMenu mnDev = new JMenu("Dev");
		menuBar.add(mnDev);

		JMenuItem sendDataItem = new JMenuItem("Test connection T/F");
		sendDataItem.addActionListener(e -> sendTestData());
		mnDev.add(sendDataItem);

		// Move buttons when window is resized
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent ev) {
				Rectangle r = frame.getBounds();
				int h = r.height;
				int w = r.width;
				// Adjust background to window size (up to image resolution) - use 4k image?
				mainMenuBackground.setBounds(0, 0, w, h);
				// Buttons
				newGameButton.setBounds(	(w / 2 - 270), (h / 2) - 200, 520, 87);
				loadGameButton.setBounds(	(w / 2) - 270, (h / 2) - 100, 520, 87);
				highScoreButton.setBounds(	(w / 2) - 270, (h / 2),		  520, 74);
				quitButton.setBounds(		(w / 2) - 270, (h / 2) + 86,  520, 47); // +86 pga diff i storlek (87-74 vs 74 - 47)
			}
		});
		frame.setVisible(true);
		if (!connectionStatus) {
			new PopupInfo("Server not found\nHighscore disabled", "Inane error");
		}
	}

	/**
	 * Method for quitButton Shuts down the program
	 */
	private void Quit() {
		System.exit(0);
	}

	/**
	 * Change view to received window/content
	 */

	public void switchWindow(SwitchableWindow newcontent) {
		frame.getContentPane().setVisible(false);

		if (newcontent == null) {

			frame.setContentPane(MainMenu);
			MainMenu.setVisible(true);
		}

		else {
			frame.setContentPane(newcontent.getContent());
			newcontent.getContent().setVisible(true);
		}

	}

	/**
	 * Method for newGame Changes content pane to game view Hides mainMenu
	 * 
	 * @throws IOException
	 */
	private void newGame(){

		try {
			switchWindow(new GameWindow(this));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * Method for loadGameButton Loads saved game state Changes content pane to game
	 * view Hides mainMenu
	 */
	private void loadGame() {

	}

	/**
	 * Method for highScoreButton Opens high score window
	 */
	private void HighScore() {
		new HighScoreWindow(client);
	}

	@Override
	public Container getContent() {
		return MainMenu;
	}

	/**
	 * Send test data to server It is possible to send
	 */

	private void sendTestData() {

		System.out.println(client.serverReachable());
	}

}
