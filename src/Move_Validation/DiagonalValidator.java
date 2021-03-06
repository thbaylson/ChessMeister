package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;


/**
 * This validator is used to look in the diagonal directions of a piece and
 * determine if the squares are valid positons to move to
 * @author Caleb Tupone 100% All
 *
 */

public class DiagonalValidator extends PieceValidator{

	public DiagonalValidator(BoardIF board) {
		super(board);
	}

	/**
	 * This method gives a list of all valid moves that a piece that can move
	 * diagonal is allowed to make
	 * @param pos position of the piece the user has selected
	 */
	@Override
	public Position[] showMoves(Position pos) {
		ArrayList<Position> moves = checkMoves(pos);

		moves = super.checkForCheck(moves, pos);

		return super.showMoves(moves, pos);
		/**
		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){

			send[i] = moves.get(i);
		}
		super.showMoves(pos);
		return send;
		**/
	}

	/**
	 * Gets a list of valid moves
	 * @param pos - The position of the piece
	 * @return A list of valid moves
	 */
	@Override
	public ArrayList<Position> checkMoves(Position pos) {
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
			} else {
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
		return moves;
	}

	/**
	 * Clones this validator
	 *
	 * @param board - The game board
	 * @return Returns a clone of this validator using a new board
	 */
	public DiagonalValidator clone(BoardIF board){
		DiagonalValidator DV = new DiagonalValidator(board);
		return DV;
	}

	/**
	 * This method gives a list of all valid moves that a piece that can move
	 * diagonal is allowed to make
	 */
	@Override
	public Position[] showMoves() {
		Position pos = this.getPosition();
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
		for (int i = rank + 1, j = file + 1; inRange(j, i); i++, j++) {

			if (squares[j][i].getPiece() == null) {
				moves.add(squares[j][i].getPosition());
			} else if (squares[j][i].getPiece().getColor() != squares[file][rank].getPiece().getColor()) {
				moves.add(squares[j][i].getPosition());
				break;
			} else {
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

		Position[] endMoves = new Position[moves.size()];
		for(int i = 0; i < moves.size(); i++){
			endMoves[i] = moves.remove(0);
		}
		return endMoves;
	}



}
