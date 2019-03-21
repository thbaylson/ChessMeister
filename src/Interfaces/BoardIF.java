package Interfaces;

import Enums.Files;
import Enums.Rank;
import Model.Position;

/**
 * Interface for the board
 *
 * @author Caleb
 * @version 1.0
 */
public interface BoardIF{

	/**
	 * Initializes the board
	 */
	public void init_board();

	/**
	 * Sets up the board
	 */
	public void setup();

	/**
	 * Calls the appropriate draw class to draw the board
	 */
	public void draw();

	/**
	 * Gets the 2D array of squares and returns it
	 *
	 * @return 2D array of squares
	 */
	public SquareIF[][] getSquares();

	/**
	 * Sets the draw strategy
	 *
	 * @param d - The draw strategy to be used
	 */
	public void setDrawStrategy(BoardStrategy d);

	/**
	 * Gets the width of the board
	 *
	 * @return The width of the board
	 */
	public int getWidth();

	/**
	 * Gets the hieght of the board
	 *
	 * @return The height of the board
	 */
	public int getHeight();

	/**
	 * Gets a piece based on its rank and file
	 *
	 * @param r - Piece's rank
	 * @param f - Piece's file
	 * @return The piece at the specified rank and file
	 */
	public PieceIF getPiece(Rank r, Files f);

	/**
	 * Moves a piece from one position to another
	 *
	 * @param from - The position of the piece to move
	 * @param to - The position to move the piece to
	 */
	public void move(Position from, Position to);

	/**
	 * Gets the piece at the specified position
	 *
	 * @param r - The rank as an integer
	 * @param f - The file as a char
	 * @return The piece at the specified position
	 */
	public PieceIF getPiece(int r, char f);

	/**
	 * Gets the square at the specified position
	 *
	 * @param fromP - The position of the desired square
	 * @return The square at the specified position
	 */
	public SquareIF getSquare(Position fromP);
	
}
