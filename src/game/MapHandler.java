package game;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapHandler {

	public int gridWidth;
	public int gridHeight;
	public String filename;
	
	private int gridSize;
	public int[][] grid;
	
	public MapHandler(String fileNames) {
		this.filename = fileNames;
	}
	
	public void LoadMapFromText() {
		this.gridSize = Constants.GRID_SIZE;
		
		
			BufferedReader readfile;
			try {
				readfile = new BufferedReader(new FileReader(filename));
				
				gridWidth = Integer.parseInt(readfile.readLine());
				gridHeight = Integer.parseInt(readfile.readLine());
				
				grid = new int[gridHeight][gridWidth];
				
				String delimiters = " ";
				
				for(int row = 0; row< gridHeight; row++) {
					String readline = readfile.readLine();
					
					String[] tempStorage = readline.split(delimiters);
					
					for(int col = 0; col<gridWidth; col++) {
						grid[row][col] = Integer.parseInt(tempStorage[col]);
					}
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		
		
		
	}
	
	public int getgridWidth() {
		return gridWidth;
	}
	
	public int getgridHeight() {
		return gridHeight;
		
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
}
