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
		int file = pos.getFile().getArrayp();
		int rank =  pos.getRank().getArrayp();
		Position[] result;

		SquareIF[][] squares = this.board.getSquares();
		SquareIF sqAt;
		ArrayList<Position> moves = new ArrayList<Position>();
		for(int i = -2; i < 3; i++) {
			for(int j = -2; j < 3; j++) {
				if(inRange(file + i, rank + j) && squares[file + i][rank + j] == null){
					moves.add(squares[file + i][rank + j].getPosition());
				}else {
					if(inRange(file + i, rank + j) && squares[file + i][rank + j].getPiece() != null) {
						if(squares[file + i][rank + j].getPiece().getColor() != 
								pos.getSquare().getPiece().getColor()) {
							moves.add(squares[file + i][rank + j].getPosition());
						}
					}
				}
			}
		}
		
		result = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			result[i] = moves.get(i);
		}
		return result;
	}

}
