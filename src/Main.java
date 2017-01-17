import java.awt.Color;

public class Main implements Runnable {

	private static Thread thread;
	private Window window;
	private DrawGraphics dg;
	private static Player player;
	private static Input input;
	private boolean running = false;


	private final int TPS = 60;
	private static int ticksPerSecond= 0;

	public void init() {
		window = new Window();
		window.createWindow();
		dg = new DrawGraphics();
		dg.start();
		input = new Input();
		window.getFrame().addKeyListener(input);

		GameStateManager.setGameState(GameStateManager.MAIN_MENU);



	}

	public void run() {

		init();
		
		long before;
		long after;
		long second = 1000000000;
		long timer = second / TPS;
		long longTime = System.nanoTime();

		int ticks = 0;

		while(running) {

			
			before = System.nanoTime();
			tick();
			ticks++;
			after = System.nanoTime();

			//calculate time for thread to sleep till next tick
			long downTime = after - before;
			if (downTime < timer) {
				try {
					thread.sleep((timer - downTime) / 1000000);
				}catch (Exception e) {
					
				}
			}

			//check if it has been a second or longer to update ticksPerSecond
			if(before - longTime >= second) {
				ticksPerSecond = ticks;
				ticks = 0;
				longTime = before;
				//System.out.println("TPS: " + ticksPerSecond);
			}
		}

		stop();
	}


	public void tick() {
		int state = GameStateManager.getCurrentState();
		if(state == GameStateManager.MAIN_MENU) {

		}else if(state == GameStateManager.GAME){
			Player.tick();
		}
		
	}

	public synchronized void start() {
		if (thread == null) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		running = false;

		try {
			thread.interrupt();
		}catch (Exception e) {
			System.out.println("Error joinning thread @ Main Stop");
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}

	public static int getTPS() {
		return ticksPerSecond;
	}

}