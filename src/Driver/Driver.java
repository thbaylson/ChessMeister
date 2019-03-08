package Driver;

import Model.Board;
import Interfaces.BoardStrategy;
import UI_CLI.Board_Mono_CLI;

public class Driver {

	public static void main(String[] args) {
		Board game = new Board();
		BoardStrategy gStrat = new Board_Mono_CLI();
		game.setDrawStrategy(gStrat);
		
		//Use this in the future to test Color
		//gStrat = new Board_Color_CLI();
		//game.setDrawStrategy(gStrat);
		
		game.draw();
	}
}
