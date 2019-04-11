package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

/**
 * Move validator for Rooks and Queens
 *
 * @author Tyler Baylson
 * @version 1.0
 */
public class HortzVertzValidator extends PieceValidator {

	public HortzVertzValidator(BoardIF board) {
		super(board);
	}

	/**
	 * Method to check the moves available to the current piece
	 *
	 * @param pos - The position of the piece currently selected
	 * @return result - An array containing the moves available to this piece as position objects
	 */
	@Override
	public Position[] showMoves(Position pos) {
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();

		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		moves.addAll(checkLeft(rank, file, squares));// 	(file-- until 0)			, rank
		moves.addAll(checkRight(rank, file, squares));// 	(file++ until board.length)	, rank
		moves.addAll(checkUp(rank, file, squares));// 		file						, (rank++ until board.length)
		moves.addAll(checkDown(rank, file, squares));// 	file						, (rank-- until 0)

		return super.showMoves(moves, pos);
	}
	
	/**
	 * checkLeft- Helper method to check all squares to the left of this piece
	 * @param rank- Relates to an integer spanning the width of the board
	 * @param file- Relates to an integer spanning the height of the board
	 * @param squares- The 2D array of squares that compose the board
	 * @return- An array of acceptable movement options
	 */
	private ArrayList<Position> checkLeft(int rank, int file, SquareIF[][] squares){
		ArrayList<Position> moves = new ArrayList<Position>();
		for (int i = file - 1; i >= 0; i--) {
			if (inRange(i, rank) && squares[i][rank].getPiece() == null) {
				moves.add(squares[i][rank].getPosition());
			}else if(inRange(i, rank) && (squares[i][rank].getPiece().getColor() != 
					(squares[file][rank].getPiece().getColor() ))){
				moves.add(squares[i][rank].getPosition());
				break;
			}else {
				return moves;
			}
		}
		return moves;
	}
	
	/**
	 * checkRight- Helper method to check all squares to the right of this piece
	 * @param rank- Relates to an integer spanning the width of the board
	 * @param file- Relates to an integer spanning the height of the board
	 * @param squares- The 2D array of squares that compose the board
	 * @return- An array of acceptable movement options
	 */
	private ArrayList<Position> checkRight(int rank, int file, SquareIF[][] squares){
		ArrayList<Position> moves = new ArrayList<Position>();
		for (int i = file + 1; i < this.board.getWidth(); i++) {
			if (inRange(i, rank) && squares[i][rank].getPiece() == null) {
				moves.add(squares[i][rank].getPosition());
			}else if(inRange(i, rank) && (squares[i][rank].getPiece().getColor() != 
					(squares[file][rank].getPiece().getColor() ))){
				moves.add(squares[i][rank].getPosition());
				break;
			}else {
				return moves;
			}
		}
		return moves;
	}
	
	/**
	 * checkUp- Helper method to check all squares above this piece
	 * @param rank- Relates to an integer spanning the width of the board
	 * @param file- Relates to an integer spanning the height of the board
	 * @param squares- The 2D array of squares that compose the board
	 * @return- An array of acceptable movement options
	 */
	private ArrayList<Position> checkUp(int rank, int file, SquareIF[][] squares){
		ArrayList<Position> moves = new ArrayList<Position>();
		for (int j = rank + 1; j < this.board.getHeight(); j++) {
			if (inRange(file, j) && squares[file][j].getPiece() == null) {
				moves.add(squares[file][j].getPosition());
			}else if(inRange(file, j) && (squares[file][j].getPiece().getColor() != 
					(squares[file][rank].getPiece().getColor() ))){
				moves.add(squares[file][j].getPosition());
				break;
			}else {
				return moves;
			}
		}
		return moves;
	}
	
	/**
	 * checkDown- Helper method to check all squares below this piece
	 * @param rank- Relates to an integer spanning the width of the board
	 * @param file- Relates to an integer spanning the height of the board
	 * @param squares- The 2D array of squares that compose the board
	 * @return- An array of acceptable movement options
	 */
	private ArrayList<Position> checkDown(int rank, int file, SquareIF[][] squares){
		ArrayList<Position> moves = new ArrayList<Position>();
		for (int j = rank - 1; j >= 0; j--) {
			if (inRange(file, j) && squares[file][j].getPiece() == null) {
				moves.add(squares[file][j].getPosition());
			}else if(inRange(file, j) && (squares[file][j].getPiece().getColor() != 
					(squares[file][rank].getPiece().getColor() ))){
				moves.add(squares[file][j].getPosition());
				break;
			}else {
				return moves;
			}
		}
		return moves;
	}

	/**
	 * Clones this validator
	 *
	 * @param board - The game board
	 * @return Returns a clone of this validator using a new board
	 */
	public HortzVertzValidator clone(BoardIF board){
		HortzVertzValidator HVV = new HortzVertzValidator(board);
		return HVV;
	}
}
