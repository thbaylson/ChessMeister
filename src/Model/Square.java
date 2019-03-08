package Model;

import Enums.GameColor;
import Interfaces.PieceIF;
import Interfaces.SquareIF;

public class Square extends BlackAndWhite implements SquareIF{
	PieceIF sPiece;

	public Square(GameColor c) {
		this.color = c;
		this.sPiece = null;
	}
	
	@Override
	public void clear() {
		sPiece.setChessPieceType(null);
	}

	@Override
	public void setPiece(PieceIF p) {
		this.sPiece = p;
		
	}

	@Override
	public PieceIF getPiece() {
		return this.sPiece;
	}
	@Override
	public GameColor getColor() {
		return this.color;
	}

}
