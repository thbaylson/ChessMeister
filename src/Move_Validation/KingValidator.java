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
		
		
		
		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			
			send[i] = moves.get(i);
		}
		
		
		return send;
	}

}
