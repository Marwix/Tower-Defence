package game;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import windows.GameWindow;

public class MouseHandler implements MouseMotionListener, MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		GameWindow.GamePanel.towerGrid.mouseClick(e.getButton());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Panel.mousePosition = new Point (e.getX(),e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Panel.mousePosition = new Point (e.getX(),e.getY());
		
	}

}
