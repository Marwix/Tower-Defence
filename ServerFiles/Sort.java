package ServerFiles;

import java.io.IOException;

public class Sort 
{
	String location = System.getProperty("user.home") + "/Desktop";
	String username;
	int score;
	
	public Sort(String username, int score) throws IOException
	{
		this.username = username;
		this.score = score;
	}
}
