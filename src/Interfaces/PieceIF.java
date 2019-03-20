package Interfaces;

import Enums.ChessPieceType;
import Enums.GameColor;
import Model.Position;
import Move_Validation.PieceValidator;

public interface PieceIF {
	
	public ChessPieceType getChessPieceType();
	
	public void setChessPieceType(ChessPieceType t);
	
	public PieceValidator getPieceValidator();
	
	public void setPieceValidator(PieceValidator p);
	
	public default boolean validateMove(Position from, Position to) {
		return true;
	}
	
	public default Position[] showMoves(Position pos) {
		return this.getPieceValidator().showMoves(pos);
	}

	public GameColor getColor();
}
