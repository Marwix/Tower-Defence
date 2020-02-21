package network;
import java.net.*;
import java.io.*;

/**
 * Used to establish connection to a server
 * and send/retrieve data from it.
 * 
 *
 */
public class Client {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private String address;
	private int port;
	private boolean connected = false;

	/**
	 * Saves information about the server target
	 * 
	 * @param address - IP or localhost
	 * @param port    - port to use
	 */

	public Client(String address, int port) {
		this.address = address;
		this.port = port;

	}

	/**
	 * Send single data to server
	 * 
	 * @param player - active player
	 * @param score  - achieved score
	 * @throws IOException
	 */
	public void addData(String player, int score) throws IOException {
		connect();
		String data = "Y:" + player + ":" + score;
		System.out.println(data);
		output.writeUTF(data);
		disconnect();
	}

	/**
	 * Retrieve data from the server about a specific user
	 * 
	 * @param player - player to search for
	 * @return - player:score string format
	 * @throws IOException
	 */
	public String getDataSingle(String player) throws IOException {
		connect();
		output.writeUTF("X:" + player);
		BufferedReader ss = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data = ss.readLine();
		disconnect();
		return data;
	}

	/**
	 * Establishes a connection with the provided target
	 */
	private void connect() {
		try {
			socket = new Socket(address, port);
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			connected = true;

		} catch (UnknownHostException e) {
			connected = false;
			e.printStackTrace();
		} catch (IOException e) {
			connected = false;
			e.printStackTrace();
		}

	}

	/**
	 * Disconnects from the target
	 */
	private void disconnect() {
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * Test connection
	 * Returns true if successful 
	 * false otherwise
	 */
	public boolean serverReachable() {
		connect();
		try {
			output.writeUTF("W");
			connected = true;
		} catch (IOException e) {
			connected = false;
			return connected;
		} catch (NullPointerException e) {
			connected = false;
			return connected;
		}
		disconnect();
		
		return connected;
	}

	/**
	 * Requests top ten player + score from server
	 * 
	 * @return returns string of top 10 in one line divided by commas (",")
	 */
	public String getTopTen() {

		String indata = "";
		connect();
		try {
			output.writeUTF("Z");
			BufferedReader ss = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			indata = ss.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect();
		return indata;
	}

}
