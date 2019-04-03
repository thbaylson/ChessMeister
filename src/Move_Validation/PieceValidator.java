package Move_Validation;

import Interfaces.BoardIF;
import Model.Piece;
import Model.Position;
import Model.Board;

/**
 * Abstract class that is used for the decorator subclasses
 *
 * @author Tyler
 * @version 1.0
 */
public abstract class PieceValidator extends Piece{
	
	Board board;

	/**
	 * Constructor for PieceValidators
	 *
	 * @param board - An instance of the board object
	 */
	public PieceValidator(BoardIF board) {
		this.board = (Board)board;
	}

	/**
	 * Abstract method for making an array of valid moves of a piece
	 *
	 * @param pos - The position of the piece to check
	 * @return An array of positions that are valid to move to
	 */
	public Position[] showMoves(Position pos) {
		System.out.println("\nPV\n");
		return null;
	}
	
	/**
	 * inRange- Ensures two given integers are within the range of the board array
	 *
	 * @param i- Relates to an integer spanning the width of the board
	 * @param j- Relates to an integer spanning the height of the board
	 * @return- True if the given integers are within the range of the board array, otherwise false
	 **/
	public boolean inRange(int i, int j) {
		return (0 <= i && i < this.board.getWidth()) && (0 <= j && j < this.board.getHeight());
	}

}
