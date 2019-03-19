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
	
	 /*init_board- Initializes the board onto the heap
	 */
	@Override
	public void init_board() {
		this.bLayout = new Square[8][8];
	}

	 /*setup- Places squares of the appropriate colors in the board array
	  * and places the appropriate chess piece on each square.
	 */
	@Override
	public void setup() {
		GameColor currentColor;
		/* Cycles through all the squares to assign them to black or white*/
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				currentColor = ((i+j)%2 == 1) ? GameColor.WHITE : GameColor.BLACK;
				bLayout[i][j] = new Square(currentColor);
				bLayout[i][j].setPosition(Files.values()[j], Rank.values()[i]);
			}
		}
		int num;
		/* Cycles through all the squares and correctly places the appropriate pieces, excluding pawns*/
		for(int i = 0; i < GameColor.values().length; i++) {
			for(int j = 0; j < this.getHeight(); j++) {
				if(j < 5) {
					bLayout[j][i * 7].setPiece(new Piece(ChessPieceType.values()[j], 
							GameColor.values()[i]));
				}
				else {
					num = 7 - j;
					bLayout[j][i * 7].setPiece(new Piece(ChessPieceType.values()[num], 
							GameColor.values()[i]));
				}
			}
		}
		/* Places all the pawns*/
		for (int i = 0; i < 8; i++) {
			bLayout[i][1].setPiece(new Piece(ChessPieceType.Pawn, GameColor.WHITE));
			bLayout[i][6].setPiece(new Piece(ChessPieceType.Pawn, GameColor.BLACK));
		}
	}

	 /*draw- Draws the chess board in accordance with the BoardStrategy
	 */
	@Override
	public void draw() {
		this.strat.draw(this);
	}

	 /*getSquares- Gets the 2D array of SquareIFs that represents the board
	 * @return: The 2D array of SquareIFs that represents the board
	 */
	@Override
	public SquareIF[][] getSquares() {
		return this.bLayout;
	}

	 /*setDrawStrategy- Sets the desired draw method
	 * @param d: The BoardStrategy to be used to draw the board
	 */
	@Override
	public void setDrawStrategy(BoardStrategy d) {
		this.strat = d;
	}

	 /*getWidth- Gets the width of the board
	 * @return: An int representing the width of the board
	 */
	@Override
	public int getWidth() {
		return bLayout.length;
	}

	 /*getHeight- Returns the height of the board
	 * @return: An int representing the height of the board
	 */
	@Override
	public int getHeight() {
		return bLayout[1].length;
	}

	 /*getPiece- For any given, valid rank and file, this will return the piece 
	 * in that spot. If no piece exists there, this returns null.
	 * @param r: The Rank enum representing the rank on the board
	 * @param f: The Files enum representing a file on the board
	 * @return: A piece on the board or null
	 */
	@Override
	public PieceIF getPiece(Rank r, Files f){
		return bLayout[r.getArrayp()][f.getArrayp()].getPiece();
	}
	

	 /*getPiece- For any given, valid rank and file, this will return the piece 
	 * in that spot. If no piece exists there, this returns null.
	 * @param r: The int representing the rank on the board
	 * @param f: The char representing a file on the board
	 * @return: A piece on the board or null
	 */
	@Override
	public PieceIF getPiece(int r, char f){
		int rank = Rank.getArrayp(r);
		int file = Files.getArrayp(f);
		return  bLayout[file][rank].getPiece();
	}

}
