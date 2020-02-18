package Game;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class dedicated to loading and distributing textures Textures are loaded by
 * name from default location
 * 
 * TextureHandler is able to tell the program if the texture load was successful
 * or not
 */

public class TextureHandler {

	static boolean success = true;
	public static BufferedImage water1, grass1, brick1;

	/**
	 * Loads specified textures by name
	 * 
	 */
	public TextureHandler() {
		try {
			water1 = getTexture("Water1");
			grass1 = getTexture("Grass1");
			brick1 = getTexture("Brick1");
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}

	}

	/**
	 * Attempt to load a texture
	 * 
	 * @param texturename - filename without extension
	 * @return returns image if found
	 * @throws IOException
	 */
	
	//Prova att ta bort throws IO
	private static BufferedImage getTexture(String texturename) throws IOException {

		BufferedImage temp = null;
		try {
			File image = new File("pic/" + texturename + ".png");
			temp = ImageIO.read(image);
			return temp;
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * Returns whether texture load was successful or not
	 * 
	 * @return success state
	 */
	public static boolean getSuccess() {
		return success;
	}

}
