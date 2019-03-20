package Move_Validation;

import java.util.ArrayList;

import Interfaces.BoardIF;
import Interfaces.SquareIF;
import Model.Position;

public class HortzVertzValidator extends PieceValidator {

	public HortzVertzValidator(BoardIF board) {
		super(board);
	}
	
	@Override
	public Position[] showMoves(Position pos) {
		int rank =  pos.getRank().getArrayp();
		int file = pos.getFile().getArrayp();

		SquareIF[][] squares = this.board.getSquares();
		ArrayList<Position> moves = new ArrayList<Position>();
		
		for(int i = rank + 1; i < this.board.getHeight(); i++) {
			if(squares[i][file] == null) {
				moves.add(squares[i][file].getPosition());
			}else {
				break;
			}
		}
		for(int i = rank - 1; i > 0; i--) {
			if(squares[i][file] == null) {
				moves.add(squares[i][file].getPosition());
			}else {
				break;
			}
		}
		for(int j = file + 1; j < this.board.getWidth(); j++) {
			if(squares[file][j] == null) {
				moves.add(squares[file][j].getPosition());
			}else {
				break;
			}
		}
		for(int j = rank - 1; j < this.board.getWidth(); j--) {
			if(squares[file][j] == null) {
				moves.add(squares[file][j].getPosition());
			}else {
				break;
			}
		}
		return (Position[]) moves.toArray();
	}

	@Override
	public void setPieceValidator(PieceValidator p) {
		
	}

}
