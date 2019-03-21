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
	public Position[] showMoves(Position pos) {
		int rank = pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();
		
		
		
		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();

		for (int i = rank + 1, j = file + 1; i < this.board.getHeight() &&
				j < this.board.getWidth(); i++, j++){
			System.out.println(squares[j][i]);
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} else {
				break;
			}
		}
		
		for (int i = rank + 1, j = file - 1; i < this.board.getHeight() &&
				j > 0; i++, j--){
			
			if(j < 0)
			j = 0;
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} else {
				break;
			}
		}
		
		for (int i = rank - 1, j = file - 1; i > 0 &&
				j > 0; i--, j--){
			
			if (i < 0)
				i = 0;
			
			if(j < 0)
				j = 0;
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} else {
				break;
			}
		}
		
		for (int i = rank - 1, j = file + 1; i > 0 &&
				j < this.board.getWidth(); i--, j++){
			
			if( i < 0)
				i = 0;
			
			if (squares[j][i].getPiece() == null ) {
				moves.add(squares[j][i].getPosition());
			} else {
				break;
			}
		}
		
		System.out.println(moves);
		
		Position[] send = new Position[moves.size()];
		for (int i = 0; i < moves.size(); i++){
			
			send[i] = moves.get(i);
		}
		
		
		return send;
			
		
		
		
		
		
		
		
		
		
	}

}
