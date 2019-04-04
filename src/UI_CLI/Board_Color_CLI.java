package UI_CLI;

import Enums.Files;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;

/**
 * This class prints out the chess board and pieces in the CLI in color
 *
 * @author Dillon Ramsey
 * @version 1.0
 */
public class Board_Color_CLI implements BoardStrategy{

	public static final String RESET = "\u001b[0m";
	public static final String BLACK_B= "\u001b[40m";
	public static final String W_BLUE = "\u001b[36m";
	public static final String WHITE_B = "\u001b[48m";
	public static final String W_RED = "\u001b[31m";
	public static final String YELLOW_B = "\u001b[45m";
	public static final String BOLD = "\u001b[1m";


	/**
	 * Method draws the chess board and pieces in the CLI in color
	 *
	 * @param board - A two dimensional array containing all the squares of the chess board
	 */
	@Override
	public void draw(BoardIF board) {
		/**
		 * Variable holding a 2D array of squares
		 */
		SquareIF[][] layout = board.getSquares();

		System.out.print("  ");
		//Prints the Files above the board
		for (int i = 0; i < Files.values().length; i++) {
			System.out.print("   "  + Files.values()[i].getFile());
		}
		System.out.println("\n");
		//Outer loop for setting pieces on the board
		for (int j = board.getHeight()-1; j > -1; j--) {
			//Prints the rank to the left of the board
			System.out.print(Rank.values()[j].getRank());
			System.out.print("   ");
			//Inner for loop that sets pieces on the board
			for (int i = 0; i < board.getWidth(); i++) {
				//Checks if the piece is null
				if (layout[i][j].getPiece() == null) {
					//Checks the color of the current square and prints it accordingly
					if (layout[i][j].getHighlight()){
						System.out.print(YELLOW_B + "    " + RESET);
					}else if (layout[i][j].getColor().getColor() == 'w'){
                        System.out.print(WHITE_B + "    " + RESET);
                    }else{
                        System.out.print(BLACK_B + "    " + RESET);
                    }
                }else {
					//Checks the color of the square and piece and sets them accordingly
					if (layout[i][j].getHighlight()) {
						if (layout[i][j].getPiece().getColor().getColor() == 'w') {
							System.out.print(YELLOW_B + W_BLUE + BOLD + layout[i][j].getPiece().toString() + RESET);
						} else {
							System.out.print(YELLOW_B + W_RED + BOLD + layout[i][j].getPiece().toString() + RESET);
						}
					}else if (layout[i][j].getColor().getColor() == 'w') {
                    	if (layout[i][j].getPiece().getColor().getColor() == 'w') {
							System.out.print(WHITE_B + W_BLUE + BOLD + layout[i][j].getPiece().toString() + RESET);
						}else{
							System.out.print(WHITE_B + W_RED + BOLD + layout[i][j].getPiece().toString() + RESET);
						}
                    }else{
						if (layout[i][j].getPiece().getColor().getColor() == 'w'){
							System.out.print(BLACK_B + W_BLUE + BOLD + layout[i][j].getPiece().toString() + RESET);
						}else{
							System.out.print(BLACK_B + W_RED + BOLD + layout[i][j].getPiece().toString() + RESET);
						}
                    }
                }
			}
			System.out.print("\n");
		}
		System.out.println("");
	}
}
