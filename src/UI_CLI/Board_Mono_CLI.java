package UI_CLI;

import Enums.Files;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;


/**
 * This class prints out the chess board and pieces in the CLI
 *
 * @author Dillon Ramsey 100% all
 * @version 1.0
 */
public class Board_Mono_CLI implements BoardStrategy{

	/**
	 * Method draws the chess board and pieces in the CLI
	 * 
	 * @param board - A two dimensional array containing all the squares of the chess board
	 */
	@Override
	public void draw(BoardIF board) {
		/**
		 * Variable holding a 2D array of squares
		 */
		SquareIF[][] layout = new SquareIF[8][8];
		if (board.getTurn()){
			SquareIF[][] flip = board.getSquares();
			int R = 0;
			for (int i = board.getWidth()-1; i >= 0; i--){
				int F = 0;
				for (int j = board.getHeight()-1; j >= 0; j--){
					layout[R][F] = flip[i][j].clone();
					F++;
				}
				R++;
			}
		}else{
			layout = board.getSquares();
		}
		System.out.print("  ");
		//Prints the Files above the board
		for (int i = 0; i < Files.values().length; i++) {
			System.out.print("      "  + layout[i][0].getPosition().getFile().getFile() + " ");
		}
		System.out.println("\n");
		//Outer loop for setting pieces on the board
		for (int j = board.getHeight()-1; j > -1; j--) {
			//Prints the rank to the left of the board
			System.out.print(layout[0][j].getPosition().getRank().getRank());
			System.out.print("   ");
			//Inner for loop that sets pieces on the board
			for (int i = 0; i < board.getWidth(); i++) {
				//Checks if the piece is null
				if (layout[i][j].getPiece() == null) {
					//Checks the color of the current square and prints it accordingly
					if (layout[i][j].getHighlight()){
						System.out.print("(%    %)");
					}else if (layout[i][j].getColor().getColor() == 'w'){
						System.out.print("[      ]");
					}else{
						System.out.print("[#    #]");
					}
				}else {
					//Checkes the color of the square and piece and sets them accordingly
					if (layout[i][j].getHighlight()){
						System.out.print("(%" + layout[i][j].getPiece().toString() + "%)");
					}else if (layout[i][j].getColor().getColor() == 'w') {
						System.out.print("[ " + layout[i][j].getPiece().toString() + " ]");
					}else{
						System.out.print("[#" + layout[i][j].getPiece().toString() + "#]");
					}
				}
			}
				System.out.print("\n\n");
		}
	}

}
