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
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				bLayout[i][j] = new Square();
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
		/*
		bLayout[0][0].setPiece(new Piece(ChessPieceType.Rook, GameColor.WHITE));
		bLayout[1][0].setPiece(new Piece(ChessPieceType.Knight, GameColor.WHITE));
		bLayout[2][0].setPiece(new Piece(ChessPieceType.Bishop, GameColor.WHITE));
		bLayout[3][0].setPiece(new Piece(ChessPieceType.Queen, GameColor.WHITE));
		bLayout[4][0].setPiece(new Piece(ChessPieceType.King, GameColor.WHITE));
		bLayout[5][0].setPiece(new Piece(ChessPieceType.Bishop, GameColor.WHITE));
		bLayout[6][0].setPiece(new Piece(ChessPieceType.Knight, GameColor.WHITE));
		bLayout[7][0].setPiece(new Piece(ChessPieceType.Rook, GameColor.WHITE));
		bLayout[0][7].setPiece(new Piece(ChessPieceType.Rook, GameColor.BLACK));
		bLayout[1][7].setPiece(new Piece(ChessPieceType.Knight, GameColor.BLACK));
		bLayout[2][7].setPiece(new Piece(ChessPieceType.Bishop, GameColor.BLACK));
		bLayout[3][7].setPiece(new Piece(ChessPieceType.Queen, GameColor.BLACK));
		bLayout[4][7].setPiece(new Piece(ChessPieceType.King, GameColor.BLACK));
		bLayout[5][7].setPiece(new Piece(ChessPieceType.Bishop, GameColor.BLACK));
		bLayout[6][7].setPiece(new Piece(ChessPieceType.Knight, GameColor.BLACK));
		bLayout[7][7].setPiece(new Piece(ChessPieceType.Rook, GameColor.BLACK));
		*/
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
