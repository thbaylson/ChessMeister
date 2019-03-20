package Move_Validation;


import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

public class KnightValidator extends PieceValidator{

	public KnightValidator(BoardIF board) {
		super(board);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPieceValidator(PieceValidator p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position[] showMoves(Position pos) {
		int rank =  pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();

		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		for(int i = -2; i < 3; i++) {
			for(int j = -2; j < 3; j++) {
				if(squares[rank + i][file + j] == null){
					moves.add(squares[rank + i][file + j].getPosition());
				}else {
					break;
				}
			}
		}
		
		return (Position[]) moves.toArray();
	}

}
