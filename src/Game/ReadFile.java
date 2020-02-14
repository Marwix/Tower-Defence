package Game;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadFile {

	public int gridWidth;
	public int gridHeight;
	public String filename;
	
	private int gridSize;
	public int[][] grid;
	
	public static BufferedImage picture;
	public static BufferedImage picture2;
	public static BufferedImage picture3;
	
	public ReadFile(String fileNames) {
		this.filename = fileNames;
	}
	
	public void LoadMapFromText() {
		this.gridSize = header.gridSize;
		
		try {
			BufferedReader readfile = new BufferedReader(new FileReader(filename));
			
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
			
		}catch(Exception e) {
		System.out.println("Cant find textfile");	
		}
		
		
	}
	
public static BufferedImage getWater1() throws IOException {
		
		picture = null;
		
		try {

            //you can either use URL or File for reading image using ImageIO
          File image = new File("pic/Water1.png");
          picture = ImageIO.read(image);
          
        return picture;

      } catch (IOException e) {
            e.printStackTrace();
      }
		return picture;
		
	}
	
	public static BufferedImage getGrass1() throws IOException {
		
		picture2 = null;
		
		try {

            //you can either use URL or File for reading image using ImageIO
          File image2 = new File("pic/Grass1.png");
          picture2 = ImageIO.read(image2);
          
        return picture2;

      } catch (IOException e) {
            e.printStackTrace();
      }
		return picture2;
		
	}
	
public static BufferedImage getBricks1() throws IOException {
		
		picture3 = null;
		
		try {

            //you can either use URL or File for reading image using ImageIO
          File image3 = new File("pic/Brick1.png");
          picture3 = ImageIO.read(image3);
          
        return picture3;

      } catch (IOException e) {
            e.printStackTrace();
      }
		return picture3;
		
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
