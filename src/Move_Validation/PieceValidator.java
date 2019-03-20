package Move_Validation;

import Interfaces.BoardIF;
import Model.Piece;
import Model.Position;


public abstract class PieceValidator extends Piece{
	
	BoardIF board;
	PieceValidator PV;

	public PieceValidator(BoardIF board) {
		this.board = board;
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
