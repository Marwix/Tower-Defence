
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.SwingConstants;

import javax.swing.JTextArea;

import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;


public class HighScoreWindow {

	private JFrame frame;
	
	public HighScoreWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HighScores");
		frame.pack();
		frame.setVisible(true);
		frame.setBounds(0, 0, 650, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel closeBtnPanel = new JPanel();
		frame.getContentPane().add(closeBtnPanel, BorderLayout.SOUTH);
		
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 
				frame.setVisible(false); 
			}
		});
		btnClose.setHorizontalAlignment(SwingConstants.LEFT);
		btnClose.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		closeBtnPanel.add(btnClose);
		
		JPanel highscorePanel = new JPanel();
		frame.getContentPane().add(highscorePanel, BorderLayout.NORTH);
		
		JLabel lblHighscores = new JLabel("HIGHSCORES");
		lblHighscores.setFont(new Font("Agency FB", Font.BOLD, 65));
		highscorePanel.add(lblHighscores);
		
		JPanel textPanel = new JPanel();
		frame.getContentPane().add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setTabSize(0);
		textArea.setEditable(false);
		textArea.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.ITALIC, 25));
		textArea.setRows(10);
		textArea.setText("TEST 1\n");
		textPanel.add(scrollPane);
		
		
		JPanel leftSidePanel = new JPanel();
		leftSidePanel.setPreferredSize(new Dimension(35,0));
		textPanel.add(leftSidePanel, BorderLayout.WEST);
		
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setPreferredSize(new Dimension(35,0));
		textPanel.add(rightSidePanel, BorderLayout.EAST);
		
	}
}
