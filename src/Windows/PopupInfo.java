package Windows;

import javax.swing.JOptionPane;

public class PopupInfo {
	public PopupInfo(String message, String type) {
		createPopup(message, type);
	}

	private void createPopup(String message, String type) {
		JOptionPane.showMessageDialog(null, message, type, JOptionPane.ERROR_MESSAGE);

	}

}
