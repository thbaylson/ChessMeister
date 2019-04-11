package Move_Validation;

import java.util.ArrayList;
import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

/**
 * Move validator for Knight
 *
 * @author Tyler Baylson
 * @version 1.0
 */
public class KnightValidator extends PieceValidator{
	
	/** The 2D SquareIF array that represents every square on the board**/
	SquareIF[][] squares;
	

	public KnightValidator(BoardIF board) {
		super(board);
		squares = this.board.getSquares();
	}

	/**
	 * Method to check the moves available to the current knight
	 *
	 * @param pos - The position of the knight currently selected
	 * @return result - An array containing the moves available to this knight as position objects
	 */
	@Override
	public Position[] showMoves(Position pos) {
		int file = pos.getFile().getArrayp();
		int rank =  pos.getRank().getArrayp();
		ArrayList<Position> moves = new ArrayList<Position>();
		Position[] result;
		Position tmp;
		
		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				if((Math.abs(i * j) == 2) || (Math.abs(i * j) == 3)) {
					 tmp = findMove(file, rank, i, j);
					 if(tmp != null) {
						 moves.add(tmp);
					 }
				}
			}
		}
/**
		result = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			result[i] = moves.get(i);
		}
		return result;**/
		return super.showMoves(moves, pos);
	}

	/**
	 * Method to check the moves available to the current knight
	 *
	 * @return result - An array containing the moves available to this knight as position objects
	 */
	@Override
	public Position[] showMoves() {
		Position pos = this.getPosition();
		int file = pos.getFile().getArrayp();
		int rank =  pos.getRank().getArrayp();
		ArrayList<Position> moves = new ArrayList<Position>();
		Position[] result;
		Position tmp;

		for(int i = -2; i <= 2; i++) {
			for(int j = -2; j <= 2; j++) {
				if((Math.abs(i * j) == 2) || (Math.abs(i * j) == 3)) {
					tmp = findMove(file, rank, i, j);
					if(tmp != null) {
						moves.add(tmp);
					}
				}
			}
		}
		Position[] endMoves = new Position[moves.size() - 1];
		for(int i = 0; i < moves.size() - 1; i++){
			endMoves[i] = moves.remove(0);
		}
		return endMoves;
	}
	
	/**
	 * findMove- Given an offset, this helper method determines if that move is valid for a knight
	 * @param file- The file of the current position
	 * @param rank- The rank of the current position
	 * @param i- The file offset from where this knight is currently
	 * @param j- The file offset from where this knight is currently
	 * @return foundMove- If the move is valid this returns the position, else, it returns null
	 */
	private Position findMove(int file, int rank, int i, int j) {
		Position foundMove = null;
		if(inRange(file + i, rank + j) && squares[file + i][rank + j].getPiece() == null) {
			foundMove = squares[file + i][rank + j].getPosition();
		}else if(inRange(file + i, rank + j)&&(squares[file + i][rank + j].getPiece().getColor() !=
				(squares[file][rank].getPiece().getColor() ))){
			foundMove = squares[file + i][rank + j].getPosition();
		}
		return foundMove;
	}
}