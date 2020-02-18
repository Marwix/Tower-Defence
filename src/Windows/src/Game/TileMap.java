package Game;
import java.awt.*;
import java.io.*;


public class TileMap {

	public Tile[][] tile;
	public int gridWidth;
	public int gridHeight;
	public MapHandler readfile;
	
	public TileMap() {
		readfile = new MapHandler("map/testmap.txt");
		readfile.LoadMapFromText();
		readGrid();
	}
	
	public void readGrid() {
		
		tile = new Tile[readfile.getgridHeight()][readfile.getgridWidth()];
		
		for(int row = 0; row< tile.length; row++) {
			for(int col = 0; col< tile[0].length; col++) {
				
				tile[row][col] = new Tile(col*header.gridSize, row*header.gridSize, header.WIDTH, header.WIDTH, readfile.grid[row][col]);
			}
		}
	}
	
	
	public void draw(Graphics g) {
		for(int row = 0; row< tile.length; row++) {
			for(int col = 0; col< tile[0].length; col++) {
				tile[row][col].draw(g);
			}
		}
	}
	
}
