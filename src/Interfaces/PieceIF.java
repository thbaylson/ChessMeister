package Interfaces;

import Enums.ChessPieceType;
import Model.Position;
import Move_Validation.PieceValidator;

public interface PieceIF {
	
	public ChessPieceType getChessPieceType();
	
	public void setChessPieceType(ChessPieceType t);
	
	public PieceValidator getPieceValidator();
	
	public void setPieceValidator(PieceValidator p);
	
	public void validateMove(Position from, Position to);
	
	public Position[] showMoves(Position from);
	
}
