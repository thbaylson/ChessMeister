package Move_Validation;


import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

public class KingValidator extends PieceValidator{

	public KingValidator(BoardIF board) {
		super(board);
		// TODO Auto-generated constructor stub
	}

	public Position[] showMoves(Position pos) {
		
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		
		
		
		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		if (squares[file + 1][rank].getPiece() == null)
			moves.add(squares[file + 1][rank].getPosition());
		
		if (file - 1 > 0)
			if (squares[file - 1][rank].getPiece() == null)
				moves.add(squares[file - 1][rank].getPosition());
		
		
		if (squares[file][rank + 1].getPiece() == null)
			moves.add(squares[file][rank + 1].getPosition());
		
		if (rank - 1 > 0)
			if (squares[file][rank - 1].getPiece() == null)
				moves.add(squares[file][rank - 1].getPosition());
		
			
		
		
		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			
			send[i] = moves.get(i);
		}
		System.out.println(moves.size());
		
		
		return send;
	}

}
