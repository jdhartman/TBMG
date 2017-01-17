

public class GameStateManager {

	//constants
	public static final int MAIN_MENU = 0;
	public static final int GAME = 1;
	public static final int OPTIONS = 2;


	public static int currentState = 0;

	public static void setGameState(int state) {
		currentState = state;
	}	

	public static int getCurrentState() {
		return currentState;
	}


}