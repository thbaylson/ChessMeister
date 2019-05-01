package Move_Validation;


import java.util.ArrayList;

import Enums.ChessPieceType;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
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

	/**
	 * Gets a list of valid moves
	 * @param pos - The position of the piece
	 * @return A list of valid moves
	 */
	public Position[] showMoves(Position pos){
		ArrayList<Position> moves = new ArrayList<>();
		for (Position kPos : this.checkMoves(pos)){
			moves.add(kPos);
		}
		moves = super.checkForCheck(moves, pos);

		Position[] moveList = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			moveList[i] = moves.get(i);
		}
		return moveList;
	}

	/**
	 * Gets a list of valid moves
	 * @param pos - The position of the piece
	 * @return A list of valid moves
	 */
	public ArrayList<Position> checkMoves(Position pos) {
		
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

		return moves;
	}

	/**
	 * Checks if the king can castle
	 * @param kPos - The position of the king
	 * @return A list of valid positions
	 */
	public ArrayList<Position> canCastle(Position kPos){
		ArrayList<Position> moves = new ArrayList<>();
		ArrayList<Position> rook = new ArrayList<>();
		PieceIF theKing = board.getCurKing();
		boolean king = theKing.getMoved();
		int turn = 1;
		if (board.getTurn()){
			turn = 2;
		}
		if (king){
			return moves;
		}
		for (PieceIF r1 : board.getPlayerPieces(turn)){
			if(r1.getChessPieceType() == ChessPieceType.Rook && r1.getMoved()){
				return moves;
			}
		}
		if (theKing.getColor().getColor() == 'w'){
			moves.add(new Position('b', 1));
			moves.add(new Position('c', 1));
		}else{
			moves.add(new Position('b', 8));
			moves.add(new Position('c', 8));
		}
		return moves;
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
