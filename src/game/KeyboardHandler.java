package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Button typed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_1) {
			System.out.println("Key pressed code");	
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Button released");
		
	}

}
