package Model;

import Enums.*;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Interfaces.SquareIF;


public class Board implements BoardIF{
	SquareIF[][] bLayout;
	
	public Board() {
		init_board();
		setup();
	}
	
	@Override
	public void init_board() {
		bLayout = new Square[8][8];
	}

	@Override
	public void setup() {
		GameColor currentColor;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				currentColor = ((i+j)%2 == 0) ? GameColor.WHITE : GameColor.BLACK;
				bLayout[i][j] = new Square(currentColor);
			}
		}
		int num;
		for(int i = 0; i < GameColor.values().length; i++) {
			for(int j = 0; j < ChessPieceType.values().length; j++) {
				if(j < 5) {
					bLayout[j][i * 7].setPiece(new Piece(ChessPieceType.values()[j], GameColor.values()[i]));
				}
				else {
					num = 7 - j;
					bLayout[j][i * 7].setPiece(new Piece(ChessPieceType.values()[num], GameColor.values()[i]));
				}
			}
		}

		for (int i = 0; i < 8; i++) {
			bLayout[i][2].setPiece(new Piece(ChessPieceType.Pawn, GameColor.WHITE));
			bLayout[i][6].setPiece(new Piece(ChessPieceType.Pawn, GameColor.BLACK));
		}
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

}
