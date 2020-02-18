package Windows;

import Game.TextureHandler;

/**
 * 
 * Class used for the launch sequence
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//Handlers
		new TextureHandler();
		
		
		/**
		 * Only launch game if handlers were successfully loaded
		 */
		if (TextureHandler.getSuccess()) {
		
			new MainMenu();
		} else {
			new PopupInfo("Textures failed to load\nLaunch aborted", "Inane error");
		}

	}

}
