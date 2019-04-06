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
	boolean high;
	GameColor color;

	/**
	 * Constructor for a square
	 * 
	 * @param c - the color to make a square
	 */
	public Square(GameColor c) {
		this.color = c;
		this.sPiece = null;
		this.high = false;
		this.pos = null;
	}
	
	/**
	 * Makes the piece on square equal to null
	 */
	@Override
	public void clear() {
		sPiece = null;
	}

	/**
	 * Sets the piece on the square
	 * 
	 * @param p - The piece to put on the square
	 */
	@Override
	public void setPiece(PieceIF p) {
		this.sPiece = p;
		this.sPiece.setPosition(this.pos);
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

	/**
	 * Sets the position of the square
	 *
	 * @param f - The file to set the square to
	 * @param r - The rank to set the square to
	 */
	public void setPosition(Files f, Rank r) {
		this.pos = new Position(f,r);
		pos.setSquare(this);
	}

	/**
	 * Sets the position of Sqaure using another position
	 *
	 * @param pos - The position to set the square to
	 */
	public void setPosition(Position pos){
		this.pos = new Position(pos.getFile(), pos.getRank());
		pos.setSquare(this);
	}

	/**
	 * Gets and returns the position of the square
	 *
	 * @return The position of the square
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * Used to set highlighted to true or false
	 *
	 * @param high - Boolean variable as to if the square is highlighted
	 */
	public void setHighlight(boolean high){
		this.high = high;
	}

	/**
	 * Returns if the square is highlighted
	 *
	 * @return - Boolean true or false
	 */
	public boolean getHighlight(){
		return high;
	}

	/**
	 * Creates a deep clone of this Sqaure
	 *
	 * @return Clone of this Square
	 */
	public SquareIF clone(){
		Square newSquare = new Square(this.getColor());
		newSquare.setPosition(this.pos.clone());
		newSquare.pos.setSquare(newSquare);
		if (this.sPiece != null){
			newSquare.setPiece(this.sPiece.clone());
			System.out.println("This is position: " + sPiece.getPosition());
		}
		newSquare.setHighlight(this.high);
		return newSquare;
	}
}
