package Driver;




/**
 * Driver that runs the game and accepts user input
 * @author Caleb Tupone
 *
 *
 */
public class Driver {


	/**
	 * The main method that creates a game of chess for two players to play
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controller chessMeister = new Controller();
		chessMeister.go();
	}
}
