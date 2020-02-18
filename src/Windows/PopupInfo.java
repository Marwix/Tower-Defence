package Windows;

import javax.swing.JOptionPane;
/**
 * 
 * Class used to create dialog windows 
 * Can be used for general information or warnings
 *
 */
public class PopupInfo implements Window{
	
	/**
	 * Create a customizeable popup dialog 
	 * @param message - message to be displayed
	 * @param type - type of pooup ("Inane error") or similar
	 */
	public PopupInfo(String message, String type) {
		createPopup(message, type);
	}

	/**
	 * Creates the popup window with the provided parameters
	 * @param message
	 * @param type
	 */
	private void createPopup(String message, String type) {
		JOptionPane.showMessageDialog(null, message, type, JOptionPane.ERROR_MESSAGE);

	}

}
