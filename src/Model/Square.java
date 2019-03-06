package Model;

import Interfaces.PieceIF;
import Interfaces.SquareIF;

public class Square extends BlackAndWhite implements SquareIF{
	PieceIF sPiece;
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

}
