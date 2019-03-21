package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

public class HortzVertzValidator extends PieceValidator {

	public HortzVertzValidator(BoardIF board) {
		super(board);
	}

	public Position[] showMoves(Position pos) {
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		Position[] result;

		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		moves.addAll(checkLeft(rank, file, squares));
		moves.addAll(checkRight(rank, file, squares));
		moves.addAll(checkUp(rank, file, squares));
		moves.addAll(checkDown(rank, file, squares));

		result = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			result[i] = moves.get(i);
		}
		return result;
	}
	
	/**
	 * checkDown- Helper method to check all squares to the left of this piece
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
			}else {
				return moves;
			}
		}
		return moves;
	}
	
	/**
	 * checkDown- Helper method to check all squares to the right of this piece
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
			}else {
				return moves;
			}
		}
		return moves;
	}
	
	/**
	 * checkDown- Helper method to check all squares above this piece
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
			}else {
				return moves;
			}
		}
		return moves;
	}
}
