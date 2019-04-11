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
	//PieceValidator PV;

	/**
	 * Constructor for PieceValidators
	 *
	 * @param board - An instance of the board object
	 */
	public PieceValidator(BoardIF board) {
		this.board = (Board)board;
	}

	/**
	 * Method to validate a move from one position to another
	 *
	 * @param from - The position the piece is moving from
	 * @param to - The position the piece is trying to move to
	 * @return Boolean true if the move is valid and false otherwise
	 *
	public boolean validateMove(Position from, Position to) {
		Position[] pos = showMoves(from);
		boolean valid = false;
		for(Position po : pos) {
			if(po.equals(to)) {
				valid = true;
			}
			//Move the piece;
			if(valid) {
				break;
			}
		}
		return valid;
	}*/

	/**
	 * Abstract method for making an array of valid moves of a piece
	 *
	 * @param pos - The position of the piece to check
	 * @return An array of positions that are valid to move to
	 */
	public abstract Position[] showMoves(Position pos);
	
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
