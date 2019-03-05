package Model;

import Enums.*;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Interfaces.SquareIF;
		
public class Board implements BoardIF{
	SquareIF[][] boardLayout;
	
	@Override
	public void init_board() {
		boardLayout = new Square[8][8];
	}

	@Override
	public void setup() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				boardLayout[i][j] = new Square();
			}
		}
		boardLayout[0][0].setPiece(Rook);
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SquareIF[][] getSquare() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDrawStrategy(BoardStrategy d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PieceIF getPiece(Rank r, Files f) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PieceIF getPiece(int col, char row) {
		// TODO
		return null;
	}

}
