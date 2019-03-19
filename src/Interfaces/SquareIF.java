package Interfaces;

import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
import Model.Position;

public interface SquareIF {

	public void clear();
	
	public void setPiece(PieceIF p);
	
	public PieceIF getPiece();
	
	public GameColor getColor();
	
	public void setPosition(Files f, Rank r);
	
	public Position getPosition();
}
