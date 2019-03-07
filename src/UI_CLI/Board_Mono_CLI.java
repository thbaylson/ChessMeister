package UI_CLI;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;
import Model.Square;

public class Board_Mono_CLI implements BoardStrategy{

	@Override
	public void draw(BoardIF board) {
		SquareIF[][] layout = board.getSquare();
		
		for (int j = board.getHeight()-1; j > -1; j--) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (layout[i][j].getPiece() == null) {
					System.out.print("   ");
				}else {
					System.out.print(layout[i][j].getPiece());
				}
				//Square test = (Square)(layout[i][j]);
				//System.out.print(" " + test.getColor() + " ");
			}
				System.out.print("\n");
		}
	}

}
