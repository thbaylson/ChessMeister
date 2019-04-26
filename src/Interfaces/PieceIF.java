package Interfaces;

import Enums.ChessPieceType;
import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
import Model.Position;
import Move_Validation.PieceValidator;

/**
 * The interface for piece
 *
 * @author Caleb
 * @version 1.0
 */
public interface PieceIF {
	/**
	 * Gets the type of chess piece
	 *
	 * @return The type of chess piece
	 */
	public ChessPieceType getChessPieceType();

	/**
	 * Sets the type of chess piece
	 *
	 * @param t - The type of chess piece to set
	 */
	public void setChessPieceType(ChessPieceType t);

	/**
	 * Gets the piece validator
	 *
	 * @return The piece validator
	 */
	public PieceValidator getPieceValidator();

	/**
	 * Sets the piece's validator
	 * @param p - The PieceValidator to set
	 */
	public void setPieceValidator(PieceValidator p);

	/**
	 * Method to validate the proposed move
	 * @param from - The position of the piece to move
	 * @param to - The position to move the piece to
	 * @return Boolean
	 */
	public default boolean validateMove(Position from, Position to) {
		return true;
	}

	/**
	 * Method to list the moves available to the piece
	 *
	 * @return An array containing all the valid moves
	 */
	public Position[] showMoves();

	/**
	 * Gets the color of the piece
	 *
	 * @return The color of the piece
	 */
	public GameColor getColor();

    /**
     * Sets the position of the piece
     */
    public void setPosition(Position pos);

    /**
     * Gets and returns the position of the piece
     *
     * @return The position of the piece
     */
    public Position getPosition();

	/**
	 * Creates a clone of this object
	 *
	 * @return Clone of this object
	 */
	public PieceIF clone();

	/**
	 * Clones the PieceValidator assigned to this piece
	 *
	 * @param board - The game board
	 */
	public void clonePV(BoardIF board);

    public void changeValidator(PieceValidator pv);
}
