package windows;

public interface UserInterface {
	/**
	 * Update the interface 
	 */
	public void updateInterface();
	
	/**
	 * Update gold display to player's current gold
	 */
	public void updateGoldDisplay();
	
	/**
	 * Update score display to player's current score
	 */
	public void updateScoreDisplay();
	
	/**
	 * Update health display to player's current health
	 */
	public void updateHealthDisplay();
	
	/**
	 * Update player progress display
	 */
	public void updateProgressDisplay();
}
