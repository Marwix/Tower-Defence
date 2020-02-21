package game;

import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class dedicated to loading and distributing textures Textures are loaded by
 * name from default location
 * 
 * TextureHandler is able to tell the program if the texture load was successful
 * or not
 */

public enum TextureHandler {
	WATER("Water1"), GRASS("Grass1"), BRICK("Brick1"), GREEN_MONSTER("GreenMonster"),
	RED_TOWER("RedTower1"), YELLOW_TOWER("YellowTower1"),BLUE_TOWER("BlueTower1"), EMPTY("Empty");

	public final BufferedImage img;

	TextureHandler(String fileName) {
		this.img = getTexture(fileName);
	}

	public static boolean allOk() {
		for(TextureHandler e : TextureHandler.values()) {
			if(e.img == null) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Attempt to load a texture
	 * 
	 * @param texturename - filename without extension
	 * @return returns image if found
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	private static BufferedImage getTexture(String textureName) {
		BufferedImage temp = null;

		try {
			File image = new File("pic/" + textureName + ".png");
			temp = ImageIO.read(image);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load texture "+textureName);
		}

		return temp;
	}

}
