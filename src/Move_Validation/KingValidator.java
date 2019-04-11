package Move_Validation;


import java.util.ArrayList;


import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;
/**
 * This class creates a list of positions for a king to move to
 * @author Caleb Tupone 100% all
 *
 */

public class KingValidator extends PieceValidator{

	public KingValidator(BoardIF board) {
		super(board);
	}

	public Position[] showMoves(Position pos) {
		
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		
		
		
		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		/**
		 * This if-statement allows the king to move right 1
		 */
		if (file + 1 < this.board.getWidth())
			if (squares[file + 1][rank].getPiece() == null)
				moves.add(squares[file + 1][rank].getPosition());
			else if(squares[file + 1][rank].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file + 1][rank].getPosition());
			
				
		
		/**
		 * This if-statement allows the king to move left 1
		 */
		if (file - 1 > 0)
			if (squares[file - 1][rank].getPiece() == null)
				moves.add(squares[file - 1][rank].getPosition());
			else if(squares[file - 1][rank].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file - 1][rank].getPosition());
				
		/**
		 * This if-statement allows the king to move up 1
		 */
		if (rank + 1 < this.board.getHeight())
			if (squares[file][rank + 1].getPiece() == null)
				moves.add(squares[file][rank + 1].getPosition());
			else if(squares[file][rank + 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file][rank + 1].getPosition());
		
		/**
		 * This if-statement allows the king to move down 1
		 */
		if (rank - 1 > 0)
			if (squares[file][rank - 1].getPiece() == null)
				moves.add(squares[file][rank - 1].getPosition());
			else if(squares[file][rank - 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file][rank - 1].getPosition());
		
		/**
		 * Diagonal up-right
		 */
		if (inRange(file + 1, rank + 1))
			if (squares[file + 1][rank + 1].getPiece() == null)
				moves.add(squares[file + 1][rank + 1].getPosition());
			else if(squares[file + 1][rank + 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file + 1][rank + 1].getPosition());
			
		/**
		 * Diagonal up-left
		 */
		if (inRange(file - 1, rank + 1))
			if (squares[file - 1][rank + 1].getPiece() == null)
				moves.add(squares[file - 1][rank + 1].getPosition());
			else if(squares[file - 1][rank + 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file - 1][rank + 1].getPosition());
		
		/**
		 * Diagonal down-left
		 */
		if (inRange(file - 1, rank - 1))
			if (squares[file - 1][rank - 1].getPiece() == null)
				moves.add(squares[file - 1][rank - 1].getPosition());
			else if(squares[file - 1][rank - 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file - 1][rank - 1].getPosition());
		
		/**
		 * Diagonal down-right
		 */
		if (inRange(file + 1, rank - 1))
			if (squares[file + 1][rank - 1].getPiece() == null)
				moves.add(squares[file + 1][rank - 1].getPosition());
			else if(squares[file + 1][rank - 1].getPiece().getColor() 
					!= squares[file][rank].getPiece().getColor())
				moves.add(squares[file + 1][rank - 1].getPosition());
		
		/**
		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			
			send[i] = moves.get(i);
		}
	
		
		
		return send;**/
		return super.showMoves(moves, pos);
	}

	/**
	 * Clones this validator
	 *
	 * @param board - The game board
	 * @return Returns a clone of this validator using a new board
	 */
	public KingValidator clone(BoardIF board){
		KingValidator KV = new KingValidator(board);
		return KV;
	}

}
