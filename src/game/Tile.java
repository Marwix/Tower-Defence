package game;
import java.awt.*;

public class Tile extends Rectangle {
	
	public int Type;
	
	public Tile(int x, int y, int width, int height, int type) {
		setBounds(x, y, width, height);
		this.Type = type;
	}
	
	public void draw(Graphics g) {
		if(Type == 1) {
			g.drawImage(TextureHandler.GRASS.img, x, y, Constants.WIDTH, Constants.HEIGHT, null);
		}else if(Type == 2) {
			g.drawImage(TextureHandler.WATER.img, x, y, Constants.WIDTH, Constants.HEIGHT, null);
		}else if (Type == 0) {
			g.drawImage(TextureHandler.BRICK.img, x, y, Constants.WIDTH, Constants.HEIGHT, null);
		}else if(Type == 6) {
			g.drawImage(TextureHandler.EXIT.img, x, y, Constants.WIDTH, Constants.HEIGHT, null);
		}
		else{
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
		}
		}
		
	}
	
