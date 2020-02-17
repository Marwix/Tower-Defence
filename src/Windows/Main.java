package Windows;

import Game.TextureHandler;

public class Main {

	public static void main(String[] args) {
		
		new TextureHandler();
		if (TextureHandler.getSuccess()) {
		
			new MainMenu();
		} else {
			new PopupInfo("Textures failed to load\nLaunch aborted", "Inane error");
		}

	}

}
