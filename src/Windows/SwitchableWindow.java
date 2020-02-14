package Windows;
import java.awt.Container;

public interface SwitchableWindow {
	/**
	 * Every switchable window needs to be able to return the content to be shown
	 * 
	 * @return Container that can be displayed
	 */
	public Container getContent();

	/**
	 * Window switch function
	 * 
	 * @param newcontent - New content to be displayed
	 */
	public void switchWindow(SwitchableWindow newcontent);

}
