package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

public class DiagonalValidator extends PieceValidator{

	public DiagonalValidator(BoardIF board) {
		super(board);
	}
	
	@Override
	/**
	 * This method gives a list of all valid moves that a piece that can move 
	 * diagonal is allowed to make
	 */
	public Position[] showMoves(Position pos) {
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		
		
		
		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		/**
		 * This loop checks up-right diagonal
		 */
		for (int i = rank + 1, j = file + 1; i < this.board.getHeight() &&
				j < this.board.getWidth(); i++, j++){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks up-left diagonal
		 */
		for (int i = rank + 1, j = file - 1; i < this.board.getHeight() &&
				j >= 0; i++, j--){

			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks down-left diagonal
		 */
		for (int i = rank - 1, j = file - 1; i >= 0 &&
				j >= 0; i--, j--){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} 
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
			}
			else {
				break;
			}
		}
		
		/**
		 * This loop checks down-right diagonal
		 */
		for (int i = rank - 1, j = file + 1; i >= 0 &&
				j < this.board.getWidth(); i--, j++){
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			}
			else if(squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()){
				moves.add(squares[j][i].getPosition());
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

}
