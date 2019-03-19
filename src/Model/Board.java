package Model;

import Enums.*;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Interfaces.SquareIF;


public class Board implements BoardIF{
	private SquareIF[][] bLayout;
	private BoardStrategy strat;
	
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
				currentColor = ((i+j)%2 == 1) ? GameColor.WHITE : GameColor.BLACK;
				bLayout[i][j] = new Square(currentColor);
			}
		}
		int num;
		for(int i = 0; i < GameColor.values().length; i++) {
			for(int j = 0; j < bLayout.length; j++) {
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
			bLayout[i][1].setPiece(new Piece(ChessPieceType.Pawn, GameColor.WHITE));
			bLayout[i][6].setPiece(new Piece(ChessPieceType.Pawn, GameColor.BLACK));
		}
	}

	@Override
	public void draw() {
		strat.draw(this);
	}

	@Override
	public SquareIF[][] getSquares() {
		return bLayout;
	}

	@Override
	public void setDrawStrategy(BoardStrategy d) {
		strat = d;
	}

	@Override
	public int getWidth() {
		return bLayout.length;
	}

	@Override
	public int getHeight() {
		return bLayout[1].length;
	}

	@Override
	public PieceIF getPiece(Rank r, Files f){
		return bLayout[r.getArrayp()][f.getArrayp()].getPiece();
	}
	

	@Override
	public PieceIF getPiece(int r, char f){
		int rank = Rank.getArrayp(r);
		int file = Files.getArrayp(f);
		return  bLayout[file][rank].getPiece();
	}

}
