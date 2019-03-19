package Model;

import Enums.GameColor;
import Enums.Rank;
import Enums.Files;
import Interfaces.PieceIF;
import Interfaces.SquareIF;

/**
 * Model for a square on the chess board
 * 
 * @author Dillon, Tyler, Caleb
 * @version 1.0
 */
public class Square extends BlackAndWhite implements SquareIF{
	PieceIF sPiece;
	Position pos;

	/**
	 * Constructor for a square
	 * 
	 * @param c - the color to make a square
	 */
	public Square(GameColor c) {
		this.color = c;
		this.sPiece = null;
	}
	
	/**
	 * Makes the piece on square equal to null
	 */
	@Override
	public void clear() {
		sPiece.setChessPieceType(null);
	}

	/**
	 * Sets the piece on the square
	 * 
	 * @param p - The piece to put on the square
	 */
	@Override
	public void setPiece(PieceIF p) {
		this.sPiece = p;
	}

	/**
	 * Gets the piece currently on the square
	 * 
	 * @return sPiece - The piece currently on the square
	 */
	@Override
	public PieceIF getPiece() {
		return this.sPiece;
	}
	
	/**
	 * Gets the color of the square
	 * 
	 * @return color - The color of the square
	 */
	@Override
	public GameColor getColor() {
		return this.color;
	}
	
	public void setPosition(Files f, Rank r) {
		pos = new Position(f,r);
	}
	
	public Position getPosition() {
		return pos;
	}
}
