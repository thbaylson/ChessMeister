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

	public void validateMove(Position from, Position to) {
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
	}

	public abstract Position[] showMoves(Position pos);

}
