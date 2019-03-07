package UI_CLI;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;

public class Board_Mono_CLI implements BoardStrategy{

	@Override
	public void draw(BoardIF board) {
		SquareIF[][] layout = board.getSquare();
		
		for (int j = board.getHeight()-1; j > 0; j--) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (layout[i][j].getPiece() == null) {
					System.out.print("   ");
				}else {
					System.out.print(layout[i][j].getPiece());
				}
				if (i >= board.getWidth()) {
					System.out.print("\n");
				}
			}
		}
		
	}

}
