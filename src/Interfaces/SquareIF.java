package Interfaces;

import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
import Model.Position;

/**
 * Interface for square
 *
 * @author Caleb
 * @version 1.0
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
}
