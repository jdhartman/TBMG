import javax.swing.*;
import java.awt.event.*;

public class Window implements WindowListener{

	private static String title = "Turn Based Multiplayer Game Client";
	private static JFrame frame;

	
	private static double aspectRatio = 9.0/16;
	private static int width = 1080;
	private static int height = (int)(width * aspectRatio);
	

	public void createWindow() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addWindowListener(this);

		frame.requestFocus();
		frame.setVisible(true);
	}

	public static void setAspectRatio(double ratio) {
		aspectRatio = ratio;
	}

	public static void setResolution(int resWidth) {
		width = resWidth;
		height = (int)(width * aspectRatio);
		frame.setSize(width, height);
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}


	//window listener methods
	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "Closing Game");
		Main main = new Main();
		main.stop();
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowOpened(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}
}