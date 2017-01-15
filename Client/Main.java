

public class Main implements Runnable {

	private static Thread thread;
	private Window window;
	private boolean running = false;


	private final int TPS = 60;
	private int ticksPerSecond= 0;

	public void init() {
		window = new Window();
		window.createWindow();
	}

	public void run() {

		init();
		
		long before = System.nanoTime();
		long after = before;
		long second = 1000000000;
		long timer = second / TPS;
		long longTime = before;

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
					System.out.println("Error with thread sleeping in Main Run");
				}
			}

			//check if it has been a second or longer to update ticksPerSecond
			if(before - longTime >= second) {
				ticksPerSecond = ticks;
				ticks = 0;
				longTime = before;
				System.out.println("TPS: " + ticksPerSecond);
			}
		}

		stop();
	}

	int i = 0;
	public void tick() {
		i++;
		if(i > 500) {
			System.out.println("changing resolution");
			Window.setResolution(1920);
			i = 0;
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
			System.out.println("before");
			thread.interrupt();
			
		}catch (Exception e) {
			System.out.println("Error joinning thread @ Main Stop");
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
}