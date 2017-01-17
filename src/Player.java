import java.awt.*;

public class Player {

	private static double x = 100;
	private static double y = 100;
	private static Color color = Color.red;

	public static void tick() {
		
	}

	public static void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, 20, 20);
	}

	public static void setPosition(double i, double j) {
		x = i;
		y = j;
	}

	public static void setColor(Color c) {
		color = c;
	}

}