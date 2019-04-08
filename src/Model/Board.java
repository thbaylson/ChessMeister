package Model;

import Enums.*;
import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Interfaces.SquareIF;
import Memento.Memento;
import Move_Validation.*;

import java.util.ArrayList;

/**
 * The concrete implementation of BoardIF
 *
 * @author Tyler Baylson
 * @version 1.0
 */
public class Board implements BoardIF{
	
	/** The array of squares that represent a chess board**/
	private SquareIF[][] bLayout;
	
	/** The method in which everything will be displayed to the user**/
	private BoardStrategy strat;
	
	public Board() {
		init_board();
		setup();
	}
	
	 /**
	  * init_board- Initializes the board onto the heap
	 */
	@Override
	public void init_board() {
		this.bLayout = new Square[8][8];
	}

	 /**
	  * setup- Places squares of the appropriate colors in the board array
	  * and places the appropriate chess piece on each square.
	 */
	@Override
	public void setup() {
		GameColor currentColor;
		/** Cycles through all the squares to assign them to black or white*/
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				currentColor = ((i + j) % 2 == 1) ? GameColor.WHITE : GameColor.BLACK;
				bLayout[i][j] = new Square(currentColor);
				bLayout[i][j].setPosition(Files.values()[i], Rank.values()[j]);
				bLayout[i][j].getPosition().setSquare(bLayout[i][j]);
			}
		}
		/** Correctly places the appropriate pieces, excluding pawns*/
		for(int i = 0; i < GameColor.values().length; i++) {
			bLayout[0][i * 7].setPiece(new Piece(ChessPieceType.Rook, GameColor.values()[i]));
			bLayout[0][i * 7].getPiece().setPieceValidator(new HortzVertzValidator(this));
			
			bLayout[1][i * 7].setPiece(new Piece(ChessPieceType.Knight, GameColor.values()[i]));
			bLayout[1][i * 7].getPiece().setPieceValidator(new KnightValidator(this));
			
			bLayout[2][i * 7].setPiece(new Piece(ChessPieceType.Bishop, GameColor.values()[i]));
			bLayout[2][i * 7].getPiece().setPieceValidator(new DiagonalValidator(this));
			
			bLayout[3][i * 7].setPiece(new Piece(ChessPieceType.King, GameColor.values()[i]));
			bLayout[3][i * 7].getPiece().setPieceValidator(new KingValidator(this));
			
			bLayout[4][i * 7].setPiece(new Piece(ChessPieceType.Queen, GameColor.values()[i]));
			bLayout[4][i * 7].getPiece().setPieceValidator(new DiagonalValidator(this));
			bLayout[4][i * 7].getPiece().getPieceValidator().setPieceValidator(new HortzVertzValidator(this));
			
			bLayout[5][i * 7].setPiece(new Piece(ChessPieceType.Bishop, GameColor.values()[i]));
			bLayout[5][i * 7].getPiece().setPieceValidator(new DiagonalValidator(this));
			
			bLayout[6][i * 7].setPiece(new Piece(ChessPieceType.Knight, GameColor.values()[i]));
			bLayout[6][i * 7].getPiece().setPieceValidator(new KnightValidator(this));
			
			bLayout[7][i * 7].setPiece(new Piece(ChessPieceType.Rook, GameColor.values()[i]));
			bLayout[7][i * 7].getPiece().setPieceValidator(new HortzVertzValidator(this));
		}

		
		/** Places all the pawns*/
		for (int i = 0; i < 8; i++) {
			bLayout[i][1].setPiece(new Piece(ChessPieceType.Pawn, GameColor.WHITE));
			bLayout[i][1].getPiece().setPieceValidator(new PawnValidator(this));

			bLayout[i][6].setPiece(new Piece(ChessPieceType.Pawn, GameColor.BLACK));
			bLayout[i][6].getPiece().setPieceValidator(new PawnValidator(this));
		}
	}
	
	/**
	 * move- For a given position, moves the piece from that position to another given position
	 * @param from- The position the desired piece will move from
	 * @param to- The position the desired piece will move to
	 */
	public void move(Position from, Position to) {
		bLayout[to.getFile().getArrayp()][to.getRank().getArrayp()].setPiece(
				bLayout[from.getFile().getArrayp()][from.getRank().getArrayp()].getPiece());
		
		bLayout[from.getFile().getArrayp()][from.getRank().getArrayp()].clear();
	}

	 /**
	  * draw- Draws the chess board in accordance with the BoardStrategy
	 */
	@Override
	public void draw() {
		this.strat.draw(this);
	}

	 /**
	  * getSquares- Gets the 2D array of SquareIFs that represents the board
	 * @return: The 2D array of SquareIFs that represents the board
	 */
	@Override
	public SquareIF[][] getSquares() {
		return this.bLayout;
	}

	 /**
	  * setDrawStrategy- Sets the desired draw method
	 * @param d: The BoardStrategy to be used to draw the board
	 */
	@Override
	public void setDrawStrategy(BoardStrategy d) {
		this.strat = d;
	}

	 /**
	  * getWidth- Gets the width of the board
	 * @return: An int representing the width of the board
	 */
	@Override
	public int getWidth() {
		return bLayout.length;
	}

	 /**
	  * getHeight- Returns the height of the board
	 * @return: An int representing the height of the board
	 */
	@Override
	public int getHeight() {
		return bLayout[1].length;
	}
	
	 /**
	  * getPosition- For any given, valid rank (as an int) and file (as a char), this will return the piece
	 * in that spot. If no piece exists there, this returns null.
	 * @param r: The Rank int representing the rank on the board
	 * @param f: The Files char representing a file on the board
	 * @return: A position on the board
	 */
	public Position getPosition(int r, char f) {
		int rank = Rank.getArrayp(r);
		int file = Files.getArrayp(f);
		return  bLayout[file][rank].getPosition();
	}

	/**
	 * Returns the current draw strategy
	 *
	 * @return The draw strategy
	 */
	public BoardStrategy getDrawStrategy(){
		return this.strat;
	}

	 /**
	  * getPiece- For any given, valid rank and file, this will return the piece
	 * in that spot. If no piece exists there, this returns null.
	 * @param r: The Rank enum representing the rank on the board
	 * @param f: The Files enum representing a file on the board
	 * @return: A piece on the board or null
	 */
	@Override
	public PieceIF getPiece(Rank r, Files f){
		return bLayout[f.getArrayp()][r.getArrayp()].getPiece();
	}
	

	 /**
	  * getPiece- For any given, valid rank and file, this will return the piece
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

	/**
	 * getSquare- Method to get the square at a given position
	 * @param pos - The position of the desired square
	 * @return Return a SquareIF
	 */
	public SquareIF getSquare(Position pos){
		return pos.getSquare();
	}

	/**
	 * Prints out the valid moves for the piece
	 *
	 * @param curP - The current piece being worked with
	 */
	public void showMoves(PieceIF curP){
		Position[] posArray = curP.showMoves();
		ArrayList<SquareIF> sqArray = new ArrayList<>();
		for (Position p : posArray){
			SquareIF S = getSquare(p);
			S.setHighlight(true);
			sqArray.add(S);
		}
		this.draw();
		for (SquareIF S : sqArray){
			S.setHighlight(false);
		}
	}

	/**
	 * Create a save state of the board
	 *
	 * @return A memento containing the board's save state
	 */
	public Memento<BoardIF> saveState(){
		Memento<BoardIF> mem = new Memento<>(this.clone());
		return mem;
	}

	/**
	 * Restores a previous save state
	 *
	 * @param memento - The previous save state
	 */
	public void restoreState(Memento<BoardIF> memento){
		BoardIF state = memento.getState();
		this.bLayout = state.getSquares();
		this.setDrawStrategy(state.getDrawStrategy());
	}

	/**
	 * Creates a deep clone of board
	 *
	 * @return The clone of board
	 */
	public BoardIF clone(){
		BoardIF newBoard = new Board();
		SquareIF[][] newSQ = newBoard.getSquares();
		newBoard.setDrawStrategy(this.strat);
		for (int i = 0; i < this.getWidth(); i++){
			for (int j = 0; j < this.getHeight(); j++){
				newSQ[i][j] = bLayout[i][j].clone();
				if (newSQ[i][j].getPiece() != null) {
					newSQ[i][j].getPiece().clonePV(newBoard);
				}
			}
		}
		return newBoard;
	}

}
