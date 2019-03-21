package UI_CLI;

import Enums.Files;
import Enums.Rank;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;

public class Board_Color_CLI implements BoardStrategy{

	public static final String RESET = "\u001B[0m";
	public static final String BLACK_B= "\u001B[40m";
	public static final String W_WHITE = "\u001B[37m";
	public static final String WHITE_B = "\u001B[48m";
	public static final String W_BLACK = "\u001B[30m";
	public static final String BOLD = "\u001B[1m";

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
					if (layout[i][j].getColor().getColor() == 'w'){
						System.out.print(WHITE_B + "    " + RESET);
					}else{
						System.out.print(BLACK_B + "    " + RESET);
					}
				}else {
					if (layout[i][j].getColor().getColor() == 'w') {
						System.out.print(WHITE_B + W_BLACK + BOLD + layout[i][j].getPiece().toString() + RESET);
					}else{
						System.out.print(BLACK_B + W_WHITE + BOLD + layout[i][j].getPiece().toString() + RESET);
					}
				}
			}
			System.out.print("\n");
		}
		System.out.println("");
	}
}
