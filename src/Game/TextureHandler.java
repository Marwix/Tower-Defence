package Game;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureHandler {

	static boolean success = true;
	public static BufferedImage water1, grass1, brick1;

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
	
	public static boolean getSuccess() {
		return success;
	}

}
