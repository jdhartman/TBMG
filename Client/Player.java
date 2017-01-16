import java.awt.*;

public class Player {

	private double x;
	private double y;
	private Color color;

	public Player(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, 20, 20);
	}

}