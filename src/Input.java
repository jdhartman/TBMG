import java.awt.event.*;

public class Input implements KeyListener, MouseListener{


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if (key == KeyEvent.VK_B) {
			if(DrawGraphics.isDebugging()) {
				DrawGraphics.setDebugging(false);
			}else {
				DrawGraphics.setDebugging(true);
			}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}


	//mouse listener methods
	public void mouseExited(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}