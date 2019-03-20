package Move_Validation;

import Enums.ChessPieceType;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Model.Piece;
import Model.Position;


public abstract class PieceValidator implements PieceIF{
	
	BoardIF board;
	
	public PieceValidator(BoardIF board) {
		this.board = board;
	}
	
	@Override
	public void validateMove(Position from, Position to) {
		Position[] pos = showMoves(from);
		boolean valid = false;
		for(Position po : pos) {
			if(po.equals(to)) {
				valid = true;
			}
			if(valid) {
				//Move the piece;
				break;
			}
		}
	}
	
	@Override
	public ChessPieceType getChessPieceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setChessPieceType(ChessPieceType t) {
		// TODO Auto-generated method stub
		
	}

}
