

public class Main implements Runnable {

	private Thread thread;

	public void run() {
		tick();
	}

	public void tick() {
		System.out.println("Testing thread creation");
	}

	public synchronized void start() {
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		try {
			thread.join();
		}catch(Exception e) {
			System.out.println("Error joinning thread @ Main Stop");
		}finally {
			System.exit(0);
		}
	}
}