import java.io.*;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileGrid {
	
	private BufferedImage TileLay;
	private int[][] grid;
	
	/*
	 * @param takes in the map and puts the numbers in the grid Array and initializes the array
	 * loads the picture
	 */
	public TileGrid(int [][] map) {
		
		grid = new int[map.length][map[0].length];
		
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x< grid[y].length; x++) {
				grid[y][x] = map[y][x];
			}
		}
		
		TileLay = LoadPicture("combined.png");
		
	}
	
	/*
	 * @param Graphics g
	 * checks the array and searches for the corresponding picture
	 * the OutofBOund variable checks if you are outside of the picture array and try to correct it
	 * draws the image from the picture by checking the sides(32) 
	 */
	public void Draw(Graphics g) {
		
		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x< grid[y].length; x++) {
				
				int pointer = grid[y][x];
				int OutofBound = 0;
				
				if(pointer > ((TileLay.getWidth() / header.WIDTH) - 1) ) {
					OutofBound++;
					
					pointer = pointer - (TileLay.getWidth() / header.WIDTH);
				}
				
				g.drawImage(TileLay,
						x * header.WIDTH,
						y * header.Heigth, 
						((x * header.WIDTH) + header.WIDTH), ((y * header.Heigth) + header.Heigth),
						pointer * header.WIDTH, OutofBound * header.Heigth,
						((pointer * header.WIDTH) + header.WIDTH), ((OutofBound * header.Heigth) + header.Heigth), null);
			}
		}
		
		
	}
	/*
	 * @param Filename
	 * loads the images
	 */
	public BufferedImage LoadPicture(String Filename) {
		BufferedImage Picture = null;
		
		try {
			
			Picture = ImageIO.read(new File(Filename));
			
		}catch(IOException e) {
		System.out.println("hittar inte filen");	
		}
		return Picture;
	}
	
	
}
