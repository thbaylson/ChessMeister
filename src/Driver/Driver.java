package Driver;
/**
 * Driver that runs the game and accepts user input
 * @author Caleb Tupone 100% All
 *
 *
 */
public class Driver {


	/**
	 * The main method that creates a game of chess for two players to play
	 * @param args Any arguments input when the game is started
	 */
	public static void main(String[] args) {

		Controller chessMeister = new Controller();
		chessMeister.go();
	}
}
