package Interfaces;

import Enums.Files;
import Enums.Rank;
import Memento.Memento;
import Model.Board;
import Model.Position;

import java.util.ArrayList;

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
	 * Returns the current draw strategy
	 *
	 * @return The draw strategy
	 */
	public BoardStrategy getDrawStrategy();

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

	/**
	 * getPosition- For any given, valid rank (as an int) and file (as a char), this will return the piece
	 * in that spot. If no piece exists there, this returns null.
	 * @param r: The Rank int representing the rank on the board
	 * @param f: The Files char representing a file on the board
	 * @return: A position on the board
	 */
	public Position getPosition(int r, char f);

	/**
	 * Prints out the valid moves for the piece
	 *
	 * @param curP - The current piece being worked with
	 */
	public void showMoves(PieceIF curP);

	/**
	 * Create a save state of the board
	 *
	 * @return A memento containing the board's save state
	 */
	public Memento<BoardIF> saveState();

	/**
	 * Restores a previous save state
	 *
	 * @param memento - The previous save state
	 */
	public void restoreState(Memento<BoardIF> memento);

	/**
	 * Create a clone of the object
	 *
	 * @return Clone of the object
	 */
	public BoardIF clone();

	/**
	 * Gets who's turn it is
	 *
	 * @return boolean true if black turn and false if white
	 */
	public boolean getTurn();

	/**
	 * Switches who's turn it is
	 */
	public void switchTurn();

	/**
	 * Sets the turn to the specified player
	 * true for black and false for white
	 *
	 * @param turn - boolean variable for turn
	 */
	public void setTurn(boolean turn);

	public boolean check();

	public boolean checkmate();

	public void setPOne(ArrayList<PieceIF> P1);

	public void setPTwo(ArrayList<PieceIF> P2);
}
