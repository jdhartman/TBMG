import javax.swing.JPanel;
import java.awt.*;

public class DrawGraphics extends JPanel implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	private static boolean debugging = true;

	private static int maxFPS = 80;
	private static int FPS = 0;

	private void init() {
		Window.getFrame().add(this);	//add jpanel to jframe
	}

	public void run() {

		init();
		
		long before = System.nanoTime();
		long after = before;
		long second = 1000000000;
		long timer = second / maxFPS;
		long lastTime = before;

		int updates = 0;

		while(running) {
			before = System.nanoTime();
			repaint();
			updates++;
			after = System.nanoTime();

			//calc time for thread to sleep
			long downTime = after - before;
			if (downTime < timer) {
				try {
					thread.sleep((timer - downTime) / 1000000);
				}catch (Exception e) {

				}
			}

			//check if been second
			if(before - lastTime >= second) {
				FPS = updates;
				updates = 0;
				lastTime = before;
				//System.out.println("FPS: " + FPS);
			}
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, Window.getWidth(), Window.getHeight());

		/*draw stuff below*/
		/////////////////////////////////////////////////////////////////////////////////////////

		//draw test color and block
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.getWidth(), Window.getHeight());

		Main.getPlayer().render(g);

		if(debugging) {
			g.setColor(Color.white);
			g.drawString("FPS: " + FPS, 10, 20);
			g.drawString("TPS: " + Main.getTPS(), 10, 40);
		}
		

		

		/////////////////////////////////////////////////////////////////////////////////////////
		g.dispose();
	}










	public static void setMaxFPS(int max) {
		maxFPS = max;
	}

	public synchronized void start() {
		if(thread == null) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.interrupt();
		}catch(Exception e) {
			System.out.println("Error in stopping thread in DrawGraphics");
		}
	}

	public static void setDebugging(boolean b) {
		debugging = b;
	}

	public static boolean isDebugging() {
		return debugging;
	}

}