package Interfaces;

import Enums.Files;
import Enums.Rank;
import Model.Position;

public interface BoardIF{

	public void init_board();
	
	public void setup();
	
	public void draw();
	
	public SquareIF[][] getSquares();
	
	public void setDrawStrategy(BoardStrategy d);
	
	public int getWidth();
	
	public int getHeight();
	
	public PieceIF getPiece(Rank r, Files f);
	
	public void move(Position from, Position to);

	public PieceIF getPiece(int r, char f);
	
}
