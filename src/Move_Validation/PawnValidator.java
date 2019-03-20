package Move_Validation;

import Enums.GameColor;
import Interfaces.BoardIF;
import Model.Position;

public class PawnValidator extends PieceValidator{

	public PawnValidator(BoardIF board) {
		super(board);
		// TODO Auto-generated constructor stub
	}

	public Position[] showMoves(Position pos) {
		int file = pos.getFile().getArrayp();
		int rank = pos.getRank().getArrayp();
		char color = pos.getSquare().getPiece().getColor().getColor();
		if (color == 'w'){
			if (rank == 2){

			}
		}
		return null;
	}

}
