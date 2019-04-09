package Driver;

import java.util.Scanner;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Model.Board;
import Model.Position;
import UI_CLI.Board_Color_CLI;
import UI_CLI.Board_Mono_CLI;

/**
 * This class calls most if not all of the functions required to run the chess
 * game correctly
 * @author Caleb Tupone
 *
 */
class Controller {
	
	
	private BoardIF game = new Board();
	private String uInput = "";
	private PieceIF curP;
	private Scanner input = new Scanner(System.in);

	Controller(){
		
	}

	/**
	 * This method starts up a game of chess or quits the game
	 */
	void go(){
		boolean gameIsRunning = true;
		System.out.println("Would you like to play a game of chess? Y/N");


		while(gameIsRunning){
			uInput = input.next().toUpperCase();
			if(uInput.equals("Y")){
				runGame();

			}
			else if(uInput.equals("N")){
				gameIsRunning = false;
			}
			else{
				System.out.println("Please enter either yes or no Y/N");
			}
		}


		input.close();

		}

	/**
	 * This method is used for running the game
 	 */
	private void runGame(){
		System.out.println("If at anytime you would like to exit the game just " +
				"type 'exit'\n");
		chooseBoardType();
		while(!wantToExit(uInput)){
			Position fromP = selectPiece();
			selectDestination(fromP);
		}



	}
		
	
	/**
	 * Method that is used to check if input is within board range
	 * @param r rank of user input
	 * @param f file of user input
	 * @return if input is within range of the board
	 */
	private boolean checkInput(int r, char f){
		if (f >= 65 && f <= 72){
			if (r >= 1 && r <= 8){
				return false;
			}
			else{
				System.out.println("Invalid rank position, please enter second "
						+ "a number from '1' to '8'");
				return true;
			}
		}
		else{
			System.out.println("Invalid file position, please enter first "
					+ "a letter from 'a' to 'h'");
			return true;
		}
	}
	
	/**
	 * Method that checks of input is of correct char length
	 * @param fr string user entered
	 * @return if input is correct length
	 */
	private boolean checkInputLength(String fr){
		if (fr.length() != 2){
			System.out.println("Please enter in the format: 1 character "
					+ "(file or f) and then 1 number (rank or r) 'fr' ");

			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Used to check if the position the user selected is a valid piece
	 * @param game the board
	 * @param r the rank of user input
	 * @param f the file of user input
	 * @return if input is a valid piece
	 */
	private boolean checkInputPos(BoardIF game, int r, char f){
		if(game.getPiece(r, f) == null) {
			System.out.println("The spot you have selected is empty");

			return true;
		}
		else {
			return false;
		}

	}
	
	/**
	 * Used to choose the board type the user wants
	 */
	private void chooseBoardType(){

		BoardStrategy strategy;
		System.out.println("If you would like a colored board, please type "
				+ "COLOR, if you would like MONO just enter anything else");
		uInput = input.next().toUpperCase();
		if (wantToExit(uInput)){
			System.exit(0);
		}
		else{
			if (uInput.equals("COLOR")){
				strategy = new Board_Color_CLI();
			}
			else{
				strategy = new Board_Mono_CLI();
			}
			game.setDrawStrategy(strategy);
		}
	}

	/**
	 * This method selects a piece and shows the available moves that piece can
	 * make
	 * @return the position of the piece that the user has selected
	 */
	private Position selectPiece(){

		char f;
		int r;

		game.draw();
		System.out.print("Select a piece to move > ");
		uInput = input.next().toUpperCase(); // This is where what the user
											// inputs is stored
		if (wantToExit(uInput)){
			System.exit(0);

		}
		else {
			f = (uInput.charAt(0));
			r = (uInput.charAt(1) - 48);



			// This loops is used the make sure the user selects a proper
			//piece to move
			while(checkInputLength(uInput) || checkInput(r, f) ||
					checkInputPos(game, r, f)){
				System.out.print("Select a piece to move > ");
				uInput = input.next().toUpperCase(); // This is where what the

				if (wantToExit(uInput)){
					System.exit(0);
				}

				//user inputs is stored
				f = (uInput.charAt(0));
				r = (uInput.charAt(1) - 48);
			}

			curP = game.getPiece(r, f);
			game.showMoves(curP);
			Position fromP = new Position(f, r);

			return fromP;
		}
		return null;

	}
	
	private void selectDestination(Position fromP){

		char f;
		int r;

			System.out.print("Select a destination to move to > ");
			uInput = input.next().toUpperCase();
			f =  uInput.charAt(0);
			r = (uInput.charAt(1) - 48);
			Position toP = new Position(f, r);
			if (wantToExit(uInput)) {
				System.exit(0);

			}


			// This loop is used to make sure the user selects a proper
			//	destination for their piece
			while(checkInputLength(uInput) || checkInput(r, f) ||
					!curP.validateMove(game.getSquare(fromP).getPosition(), toP)){

				System.out.print("Select a destination to move to > ");
				uInput = input.next().toUpperCase();
				if (wantToExit(uInput)){
					System.exit(0);
				}
				f = uInput.charAt(0);
				r = (uInput.charAt(1) - 48);
				toP = new Position(f, r);
			}
			game.move(fromP, toP);
	}
	private boolean wantToExit(String input){
		return input.equals("EXIT");
	}
		
}
