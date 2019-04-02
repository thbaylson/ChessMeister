package Driver;

import Model.Board;
import Model.Piece;
import Model.Position;

import java.util.Scanner;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import UI_CLI.Board_Color_CLI;
import UI_CLI.Board_Mono_CLI;

/**
 * Driver that runs the game and accepts user input
 * @author Caleb Tupone
 *
 *
 */
public class Driver {


	/**
	 * The main method that creates a game of chess for two players to play
	 * @param args Any arguments input when the game is started
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String uInput = "";
		BoardIF game = new Board();
		BoardStrategy gStrat;

		System.out.println("If you would like a colored board, please type "
				+ "COLOR, else, press any key to continue");
		uInput = input.next().toUpperCase();
		if (uInput.equals("COLOR")){
			gStrat = new Board_Color_CLI();
		}
		else{
			gStrat = new Board_Mono_CLI();
		}

		game.setDrawStrategy(gStrat);
		char f;
		int r;
		
		while(!uInput.equals("EXIT")) {
            game.draw();
            System.out.print("Select a piece to move > ");
            uInput = input.next().toUpperCase(); // This is where what the user inputs is stored
            f = (char) (uInput.charAt(0));
            r = (uInput.charAt(1) - 48);
            Piece curp = (Piece) game.getPiece(r, f);
            game.showMoves(curp);

            /**
             * This loops is used the make sure the user selects a proper
             * piece to moves
             */
            while (checkInputLength(uInput) || checkInput(r, f) ||
                    checkInputPos(game, r, f)) {
                System.out.print("Select a piece to move > ");
                uInput = input.next().toUpperCase(); // This is where what the
                //user inputs is stored
                f = (char) (uInput.charAt(0));
                r = (uInput.charAt(1) - 48);
            }


            Position fromP = new Position(f, r);


            System.out.print("Select a destination to move to > ");
            uInput = input.next().toUpperCase();
            f = (char) uInput.charAt(0);
            r = (uInput.charAt(1) - 48);

            /**
             * This loop is used to make sure the user selects a proper
             * destination for their piece
             */
            while (checkInputLength(uInput) || checkInput(r, f)) {

                System.out.print("Select a destination to move to > ");
                uInput = input.next().toUpperCase();
                f = (char) uInput.charAt(0);
                r = (uInput.charAt(1) - 48);
            }

            Position toP = new Position(f, r);
            System.out.println(game.getSquare(fromP));
            if (curp.validateMove(game.getSquare(fromP).getPosition(), toP)) {
                game.move(fromP, toP);
            } else {
                System.out.println("The position you chose is invlaid for that piece");
            }
        }
		input.close();
	}
	
	/**
	 * Method that is used to check if input is within board range
	 * @param r rank of user input
	 * @param f file of user input
	 * @return if input is within range of the board
	 */
	private static boolean checkInput(int r, char f){
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
	private static boolean checkInputLength(String fr){
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
	private static boolean checkInputPos(BoardIF game, int r, char f){
		if(game.getPiece(r, f) == null) {
			System.out.println("The spot you have selected is empty");

			return true;
		}
		else {
			return false;
		}

	}

}
