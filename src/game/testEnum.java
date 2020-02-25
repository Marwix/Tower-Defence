package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public enum testEnum {

	MAP1("map");
	
	public final String fileName;
	
	public static int gridWidth;
	public static int gridHeight;
	public String filename;
	
	private static int gridSize;
	public static int[][] grid;
	
	testEnum(String fileName) {
		this.fileName = fileName;
	}
	
	public static void LoadMapFromText(String filename) {
		gridSize = Constants.GRID_SIZE;
		
		
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
