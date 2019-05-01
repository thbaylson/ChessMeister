package Interfaces;

import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
import Model.Piece;
import Model.Position;
import Move_Validation.PieceValidator;

/**
 * Interface for square
 *
 * @author Caleb Tupone 60% everything else
 * @author Dillon Ramsey 40% clone, getHighlight, and setHighlight
 */
public interface SquareIF {
	/**
	 * Clears the current square
	 */
	public void clear();

	/**
	 * Sets a piece for the square
	 *
	 * @param p - The piece to set on the square
	 */
	public void setPiece(PieceIF p);
	
	/**
	 * Sets a piece for the square
	 *
	 * @param piece - The piece to set on the square
	 * @param pv - The piece validator for this piece
	 */
	public void setPiece(Piece piece, PieceValidator pv);

	/**
	 * Gets the piece currently on the square
	 *
	 * @return The piece currently on the square
	 */
	public PieceIF getPiece();

	/**
	 * Gets the color of the square
	 *
	 * @return The color of the square
	 */
	public GameColor getColor();

	/**
	 * Sets the position of the square
	 *
	 * @param f - The file of the square
	 * @param r - the rank of the square
	 */
	public void setPosition(Files f, Rank r);

	/**
	 * Sets the position of Sqaure using another position
	 *
	 * @param pos - The position to set the square to
	 */
	public void setPosition(Position pos);

	/**
	 * Gets the position of the square
	 *
	 * @return The position of the square
	 */
	public Position getPosition();

	/**
	 * Used to set highlighted to true or false
	 *
	 * @param high - Boolean variable as to if the square is highlighted
	 */
	public void setHighlight(boolean high);

	/**
	 * Returns if the square is highlighted
	 *
	 * @return - Boolean true or false
	 */
	public boolean getHighlight();

	/**
	 * Creates a clone of this object
	 *
	 * @return Clone of this object
	 */
	public SquareIF clone();
}
