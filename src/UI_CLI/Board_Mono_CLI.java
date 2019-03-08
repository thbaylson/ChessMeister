package UI_CLI;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.SquareIF;

public class Board_Mono_CLI implements BoardStrategy{

	@Override
	public void draw(BoardIF board) {
		SquareIF[][] layout = board.getSquares();
		
		for (int j = board.getHeight()-1; j > -1; j--) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (layout[i][j].getPiece() == null) {
					System.out.print("   ");
				}else {
					System.out.print(layout[i][j].getPiece());
				}
			}
				System.out.print("\n");
		}
	}

}
