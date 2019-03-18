package UI_CLI;

import Enums.Files;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;


/**
 * This class prints out the chess board and pieces in the CLI
 *
 * @author Dillon Ramsey
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
		SquareIF[][] layout = board.getSquares();
		
		System.out.print("  ");
		for (int i = 0; i < Files.values().length; i++) {
			System.out.print("   "  + Files.values()[i].getFile());
		}
		System.out.println("\n");
		for (int j = board.getHeight()-1; j > -1; j--) {
			System.out.print(Rank.values()[j].getRank());
			System.out.print("   ");
			for (int i = 0; i < board.getWidth(); i++) {
				if (layout[i][j].getPiece() == null) {
					System.out.print("   ");
				}else {
					System.out.print(layout[i][j].getPiece());
				}
			}
				System.out.print("\n\n");
		}
	}

}
