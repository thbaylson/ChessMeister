package Move_Validation;

import Interfaces.BoardIF;
import Model.Piece;
import Model.Position;


public class PieceValidator extends Piece{
	
	BoardIF board;
	
	public PieceValidator(BoardIF board, Piece piece) {
		super(piece.getChessPieceType(), piece.getColor());
		this.board = board;
	}
	
	@Override
	public void validateMove(Position from, Position to) {
		
	}
	
	@Override
	public Position[] showMoves(Position pos) {
		return null;
	}

}
