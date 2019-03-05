package Interfaces;

import Enums.Files;
import Enums.Rank;

public interface BoardIF{

	public void init_board();
	
	public void setup();
	
	public void draw();
	
	public SquareIF[][] getSquare();
	
	public void setDrawStrategy(BoardStrategy d);
	
	public int getWidth();
	
	public int getHeight();
	
	public PieceIF getPiece(Rank r, Files f);
	
}
