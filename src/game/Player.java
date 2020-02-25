package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JLabel;
import javax.swing.JPanel;

import windows.GameWindow;
import windows.UserInterface;

public class Player{

	private int health, score, gold;
	private String player;
	UserInterface ui;

	/**
	 * New player setup
	 * 
	 * @param initHealth
	 */
	public Player(int initHealth, int Gold, UserInterface ui) {
		health = initHealth;
		score = 0;
		gold = Gold;
		this.ui = ui;
		
	}

	/**
	 * Returns current health as an int
	 * 
	 * @return current health as int
	 */
	public int getHealth() {

		return health;
	}

	/**
	 * Adjust player health, accepts + and -
	 * 
	 * @param change amount to be changed
	 * 
	 */
	public void changeHealth(int change) {

		health = health + change;
		if (health < 0)
			health = 0;
		ui.updateHealthDisplay();
	}
	
	public void changeGold(int change) {
		gold += change;
		if (gold < 0) {
			gold = 0;
		}
		ui.updateGoldDisplay();
	}

	/**
	 * Increase or decrease score
	 * 
	 * @param change how will score change
	 */
	public boolean changeScore(int change) {

		score = score + change;
		if (score < 0) {
			score = 0;
			return false;
		}
		;
		ui.updateScoreDisplay();
		return true;
	}

	/**
	 * Returns current score
	 * 
	 * @return
	 */
	public int getScore() {
		return score;

	}

	/**
	 * Returns current gold as an int
	 * 
	 * @return current gold as int
	 */
	public int getGold() {
		return gold;

	}

	/**
	 * Set player name
	 * 
	 * @param name
	 * @return returns true if successful
	 */
	public boolean setName(String name) {

		if (name.equals(null) || name.trim().equals(null) || name.length() > 15)
			return false;

		player = name.trim().toUpperCase();
		return true;

	}

	/**
	 * returns player info as string ready for HighScore
	 * 
	 * @return string
	 */
	public String toString() {

		return "PLAYER: " + player + "    : SCORE: " + score + "\n";

	}
	
	/**
	 * Return name + score in server format.
	 * 
	 * @return
	 */
	public String scoreToSave() {

		return player + ":" + score;
	}



}
