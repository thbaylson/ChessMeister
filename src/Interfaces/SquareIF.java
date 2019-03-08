package Interfaces;

import Enums.GameColor;

public interface SquareIF {

	public void clear();
	
	public void setPiece(PieceIF p);
	
	public PieceIF getPiece();
	
	public GameColor getColor();
}
