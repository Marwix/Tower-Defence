package Game;
import java.awt.*;

public class Tile extends Rectangle {
	
	public int Type;
	
	public Tile(int x, int y, int width, int height, int type) {
		setBounds(x, y, width, height);
		this.Type = type;
	}
	
	public void draw(Graphics g) {
		if(Type == 1) {
			g.drawImage(TextureHandler.grass1, x, y, header.WIDTH, header.Heigth, null);
		}else if(Type == 2) {
			g.drawImage(TextureHandler.water1, x, y, header.WIDTH, header.Heigth, null);
		}else if (Type == 0) {
			g.drawImage(TextureHandler.brick1, x, y, header.WIDTH, header.Heigth, null);
		}
		else{
			g.drawRect(x, y, width, height);
		}
		}
		
	}
	
