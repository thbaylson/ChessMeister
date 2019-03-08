package Model;

import Enums.ChessPieceType;
import Enums.GameColor;
import Interfaces.PieceIF;

public class Piece extends BlackAndWhite implements PieceIF{

	private ChessPieceType cpt;
	private GameColor color;
	
	public Piece(ChessPieceType cpt, GameColor color) {
		this.cpt = cpt;
		this.color = color;
	}
	
	@Override
	public ChessPieceType getChessPieceType() {
		return this.cpt;
	}

	@Override
	public void setChessPieceType(ChessPieceType t) {
		this.cpt = t;
	}
	
	@Override
	public String toString() {
		return " " + this.color.getColor() + cpt.getLetter() + " ";
	}
}