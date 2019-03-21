package Move_Validation;

import Interfaces.BoardIF;
import Model.Piece;
import Model.Position;
import Model.Board;


public abstract class PieceValidator extends Piece{
	
	Board board;
	PieceValidator PV;

	public PieceValidator(BoardIF board) {
		this.board = (Board)board;
	}

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
	}

	public abstract Position[] showMoves(Position pos);
	
	/**
	 * inRange- Ensures two given integers are within the range of the board array
	 * @param i- Relates to an integer spanning the width of the board
	 * @param j- Relates to an integer spanning the height of the board
	 * @return- True if the given integers are within the range of the board array, otherwise false
	 **/
	public boolean inRange(int i, int j) {
		return (0 <= i && i <= this.board.getWidth()) && (0 <= j && j <= this.board.getHeight());
	}

}
