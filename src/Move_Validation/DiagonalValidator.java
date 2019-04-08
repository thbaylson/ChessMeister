package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;


/**
 * This validator is used to look in the diagonal directions of a piece and 
 * determine if the squares are valid positons to move to
 * @author Caleb Tupone
 *
 */

public class DiagonalValidator extends PieceValidator{

	public DiagonalValidator(BoardIF board) {
		super(board);
	}
	
	@Override
	/**
	 * This method gives a list of all valid moves that a piece that can move 
	 * diagonal is allowed to make
	 * @param the position of the piece the user has selected
	 */
	public Position[] showMoves(Position pos) {
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		
		
		// This is a 2d array that is used to reference the game board
		SquareIF[][] squares = this.board.getSquares();
		
		// This is a list that will hold all the available moves that 
		// the selected piece can move to
		ArrayList<Position> moves = new ArrayList<Position>();
		
		/**
		 * This loop checks up-right diagonal
		 */
		for (int i = rank + 1, j = file + 1; inRange(j, i); i++, j++){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
				break;
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks up-left diagonal
		 */
		for (int i = rank + 1, j = file - 1; inRange(j, i); i++, j--){

			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
				break;
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks down-left diagonal
		 */
		for (int i = rank - 1, j = file - 1; inRange(j, i); i--, j--){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
				break;
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks down-right diagonal
		 */
		for (int i = rank - 1, j = file + 1; inRange(j, i); i--, j++){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			}
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
				break;
			}
			else {
				break;
			}
		}
		

		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			
			send[i] = moves.get(i);
		}
		return send;	
	}

	public DiagonalValidator clone(BoardIF board){
		DiagonalValidator DV = new DiagonalValidator(board);
		return DV;
	}

}
