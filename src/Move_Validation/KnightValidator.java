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
		ArrayList<Position> moves = new ArrayList<Position>();
		
		//The case where the possible position is one to the right and two higher
		System.out.println(inRange(file + 1, rank + 2));
		if(inRange(file + 1, rank + 2) && squares[file + 1][rank + 2].getPiece() == null) {
			moves.add(squares[file + 1][rank + 2].getPosition());
		}
		//The case where the possible position is one to the right and two lower
		if(inRange(file + 1, rank - 2) && squares[file + 1][rank - 2].getPiece() == null) {
			moves.add(squares[file + 1][rank - 2].getPosition());
		}
		//The case where the possible position is two to the right and one higher
		if(inRange(file + 2, rank + 1) && squares[file + 2][rank + 1].getPiece() == null) {
			moves.add(squares[file + 2][rank + 1].getPosition());
		}
		//The case where the possible position is two to the right and one lower
		if(inRange(file + 2, rank - 1) && squares[file + 2][rank - 1].getPiece() == null) {
			moves.add(squares[file + 2][rank - 1].getPosition());
		}
		
		
		//The case where the possible position is one to the left and two higher
		if(inRange(file - 1, rank + 2) && squares[file - 1][rank + 2].getPiece() == null) {
			moves.add(squares[file - 1][rank + 2].getPosition());
		}
		//The case where the possible position is one to the left and two lower
		if(inRange(file - 1, rank - 2) && squares[file - 1][rank - 2].getPiece() == null) {
			moves.add(squares[file - 1][rank - 2].getPosition());
		}
		//The case where the possible position is two to the left and one higher
		if(inRange(file - 2, rank + 1) && squares[file - 2][rank + 1].getPiece() == null) {
			moves.add(squares[file - 2][rank + 1].getPosition());
		}		
		//The case where the possible position is two to the left and one lower
		if(inRange(file - 2, rank - 1) && squares[file - 2][rank - 1].getPiece() == null) {
			moves.add(squares[file - 2][rank - 1].getPosition());
		}
		System.out.println(moves);
		result = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			result[i] = moves.get(i);
		}
		return result;
	}

}
