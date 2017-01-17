import java.awt.*;

public class MainMenu {

	public static void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.getWidth(), Window.getHeight());

		g.setColor(Color.red);
		g.drawString("Turn Based MultiPlayer Game", Window.getWidth() / 2, Window.getHeight() / 2);
	}
}