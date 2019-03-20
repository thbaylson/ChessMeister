package Interfaces;

import Enums.ChessPieceType;
import Enums.GameColor;
import Model.Position;
import Move_Validation.PieceValidator;

public interface PieceIF {

	
	public ChessPieceType getChessPieceType();
	
	public void setChessPieceType(ChessPieceType t);
	
	public void setPieceValidator(PieceValidator p);
	
	public void validateMove(Position from, Position to);
	
	public Position[] showMoves(Position from);

	public GameColor getColor();
}
