package windows;

import game.TextureHandler;

/**
 * 
 * Class used for the launch sequence
 *
 */
public class Main {

	public static void main(String[] args) {
	
		/**
		 * Only launch game if handlers were successfully loaded
		 */
		if (TextureHandler.allOk()) {
		
			new MainMenu();
		} else {
			new PopupInfo("Textures failed to load\nLaunch aborted", "Inane error");
		}

	}

}
