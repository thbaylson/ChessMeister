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
	private boolean turn;
	
	private ArrayList<PieceIF> playerOnePieces;
	private ArrayList<PieceIF> playerTwoPieces;
	
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
		turn = false;
		this.playerOnePieces = new ArrayList<PieceIF>();
		this.playerTwoPieces = new ArrayList<PieceIF>();
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
				currentColor = ((i + j) % 2 == 1) ? GameColor.values()[0] : GameColor.values()[1];
				bLayout[i][j] = new Square(currentColor);
				bLayout[i][j].setPosition(Files.values()[i], Rank.values()[j]);
				bLayout[i][j].getPosition().setSquare(bLayout[i][j]);
			}
		}
		/** Correctly places the appropriate pieces, excluding pawns*/
		PieceValidator queen;
		for(int i = 0; i < GameColor.values().length; i++) {
			
			placePiece(0, i * 7, i, ChessPieceType.Rook, new HortzVertzValidator(this));
			placePiece(1, i * 7, i, ChessPieceType.Knight, new KnightValidator(this));
			placePiece(2, i * 7, i, ChessPieceType.Bishop, new DiagonalValidator(this));
			placePiece(3, i * 7, i, ChessPieceType.King, new KingValidator(this));
			
			queen = new HortzVertzValidator(this);
			queen.setPieceValidator(new DiagonalValidator(this));
			placePiece(4, i * 7, i, ChessPieceType.Queen, queen);
			
			placePiece(5, i * 7, i, ChessPieceType.Bishop, new DiagonalValidator(this));
			placePiece(6, i * 7, i, ChessPieceType.Knight, new KnightValidator(this));
			placePiece(7, i * 7, i, ChessPieceType.Rook, new HortzVertzValidator(this));

		}

		
		/** Places all the pawns*/
		for (int i = 0; i < 8; i++) {
			/** Places all the white pawns along the first rank**/
			placePiece(i, 1, 0, ChessPieceType.Pawn, new PawnValidator(this));
			
			/** Places all the black pawns along the sixth rank**/
			placePiece(i, 6, 1, ChessPieceType.Pawn, new PawnValidator(this));
		}
	}
	
	/**
	 * placePiece- Creates, colors, sets player ownership, and places a piece onto the board
	 * @param file- The file the piece will be placed on
	 * @param rank- The rank the piece will be placed on
	 * @param colorIndex- The index in the GameColor enumeration that relates to this piece's color
	 * @param piece- The chess piece type of this piece
	 * @param pv- The piece validator for this piece
	 */
	private void placePiece(int file, int rank, int colorIndex, ChessPieceType piece, PieceValidator pv) {
		//pv.setColor(GameColor.values()[colorIndex]);
		//System.out.println(pv.getColor());
		bLayout[file][rank].setPiece(new Piece(piece, GameColor.values()[colorIndex]), pv);
		if(colorIndex == 0) {
			playerOnePieces.add(bLayout[file][rank].getPiece());
		}else {
			playerTwoPieces.add(bLayout[file][rank].getPiece());
		}
	}
	
	/**
	 * move- For a given position, moves the piece from that position to another given position
	 * @param from- The position the desired piece will move from
	 * @param to- The position the desired piece will move to
	 */
	public void move(Position from, Position to) {
		if(to.getSquare().getPiece() != null){
			if (to.getSquare().getPiece().getColor().getColor() == 'w'){
				playerOnePieces.remove(to.getSquare().getPiece());
			}else{
				playerTwoPieces.remove(to.getSquare().getPiece());
			}
		}
		isCastling(from, to);
		bLayout[from.getFile().getArrayp()][from.getFile().getArrayp()].getPiece().setMoved(true);
		bLayout[to.getFile().getArrayp()][to.getRank().getArrayp()].setPiece(
				bLayout[from.getFile().getArrayp()][from.getRank().getArrayp()].getPiece());

		bLayout[from.getFile().getArrayp()][from.getRank().getArrayp()].clear();
	}

	/**
	 * Checks if the piece is a king and if it is castling and moves rooks accordingly
	 * @param from
	 * @param to
	 */
	public void isCastling(Position from, Position to){
		PieceIF piece = from.getSquare().getPiece();
		if (piece.getChessPieceType() == ChessPieceType.King && !piece.getMoved()){
			if (piece.getColor().getColor() == 'w'){
				if (to.getFile().getFile() == 'b' && !getPiece(1, 'a').getMoved()){
					if (getPiece(1, 'a').checkMoves().contains(getPosition(1, 'c'))){
						move(getPosition(1,'a'), getPosition(1,'c'));
					}
				}else if(to.getFile().getFile() == 'f' && !getPiece(1, 'h').getMoved()) {
					if (getPiece(1, 'h').checkMoves().contains(getPosition(1, 'e'))) {
						move(getPosition(1, 'h'), getPosition(1, 'e'));
					}
				}
			}else if(piece.getColor().getColor() == 'b'){
				if (from.getFile().getFile() == 'b' && !getPiece(8, 'a').getMoved()){
					if (getPiece(8, 'a').checkMoves().contains(getPosition(8, 'c'))){
						move(getPosition(8,'a'), getPosition(8,'c'));
					}
				}else if(to.getFile().getFile() == 'f' && !getPiece(8, 'h').getMoved()) {
					if (getPiece(8, 'h').checkMoves().contains(getPosition(8, 'e'))) {
						move(getPosition(8, 'h'), getPosition(8, 'e'));
					}
				}
			}
		}
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

	public BoardStrategy getDrawStrategy(){
		return this.strat;
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
	 * getPosition- For any given, valid rank (as an int) and file (as a char), this will return 
	 * the piece in that spot. If no piece exists there, this returns null.
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
	 * getPlayerPieces- Returns the piece ArrayList for the specified player
	 * @param player- The player whose pieces are to be returned
	 * @return- The piece ArrayList for the specified player
	 * @throws IllegalArgumentException- Thrown when called with an invalid player number
	 */
	public ArrayList<PieceIF> getPlayerPieces(int player) throws IllegalArgumentException{
		if(player == 1) {
			return this.playerOnePieces;
		}
		else if(player ==2) {
			return this.playerTwoPieces;
		}else {
			throw new IllegalArgumentException();
		}
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
		SquareIF[][] SQ = state.getSquares();
		for (int i = 0; i < this.getWidth(); i++){ //Clones each piece and PieceValidator
			for (int j = 0; j < this.getHeight(); j++){
				bLayout[i][j] = SQ[i][j].clone();
				if (bLayout[i][j].getPiece() != null) {
					bLayout[i][j].getPiece().clonePV(this);
				}
			}
		}
		this.setDrawStrategy(state.getDrawStrategy());
		this.turn = state.getTurn();
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
		newBoard.setTurn(this.turn);
		ArrayList<PieceIF> P1 = new ArrayList<>();
		ArrayList<PieceIF> P2 = new ArrayList<>();
		for (int i = 0; i < this.getWidth(); i++){ //Clones each piece and PieceValidator
			for (int j = 0; j < this.getHeight(); j++){
				newSQ[i][j] = bLayout[i][j].clone();
				if (newSQ[i][j].getPiece() != null) {
					newSQ[i][j].getPiece().clonePV(newBoard);
					if (newSQ[i][j].getPiece().getColor().getColor() == 'w'){
						P1.add(newSQ[i][j].getPiece());
					}else if (newSQ[i][j].getPiece().getColor().getColor() == 'b'){
						P2.add(newSQ[i][j].getPiece());
					}
				}
			}
		}
		newBoard.setPOne(P1);
		newBoard.setPTwo(P2);
		return newBoard;
	}

	/**
	 * Gets who's turn it is
	 *
	 * @return boolean true if black turn and false if white
	 */
	public boolean getTurn(){
		return turn;
	}

	/**
	 * Switches who's turn it is
	 */
	public void switchTurn(){
		if (turn){
			turn = false;
		}else{
			turn = true;
		}
	}

	/**
	 * Sets the turn to the specified player
	 * true for black and false for white
	 *
	 * @param turn - boolean variable for turn
	 */
	public void setTurn(boolean turn){
		this.turn = turn;
	}

	/**
	 * Checks if current player's king is in check at start of turn
	 * @return True if king is in check
	 */
	public boolean check(){
		boolean isCheck = false;
		if (!turn){
			for (PieceIF piece : playerTwoPieces){
				for (Position pos : piece.checkMoves()){
					if (getCurKing().getPosition().equals(pos)){
						isCheck = true;
					}
				}
			}
		}else{
			for (PieceIF piece : playerOnePieces){
				for (Position pos : piece.checkMoves()){
					if (getCurKing().getPosition().equals(pos)){
						isCheck = true;
					}
				}
			}
		}
		return isCheck;
	}

	/**
	 * Checks if current player is in checkmate
	 * @return True if current player is in checkmate
	 */
	public boolean checkmate(){
		ArrayList<Position> Moves = new ArrayList<>();
		if (turn){
			for (PieceIF piece : playerTwoPieces){
				for (Position pos : piece.showMoves()){
					Moves.add(pos);
				}
			}
		}else{
			for (PieceIF piece : playerOnePieces){
				for (Position pos : piece.showMoves()){
					Moves.add(pos);
					System.out.println(pos.toString());
				}
			}
		}
		if(Moves.isEmpty()){
			return true;
		}
		return false;
	}

	/**
	 * Sets the pieces of player 1
	 * @param P1 - A list of player 1's pieces
	 */
	public void setPOne(ArrayList<PieceIF> P1){
		playerOnePieces = P1;
	}

	/**
	 * Sets the pieces of player 2
	 * @param P2 - A list of player 2's pieces
	 */
	public void setPTwo(ArrayList<PieceIF> P2){
		playerTwoPieces = P2;
	}

	/**
	 * Gets the king of the enemy
	 * @return The enemy's king
	 */
	public PieceIF getEnemyKing(){
		if (turn == false){
			for (PieceIF p : playerTwoPieces){
				if (p.getChessPieceType() == ChessPieceType.King){
					return p;
				}
			}
		}else{
			for (PieceIF p : playerOnePieces){
				if (p.getChessPieceType() == ChessPieceType.King){
					return p;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the king of the current player
	 * @return The current player's king
	 */
	public PieceIF getCurKing(){
		if (turn == true){
			for (PieceIF p : playerTwoPieces){
				if (p.getChessPieceType() == ChessPieceType.King){
					return p;
				}
			}
		}else{
			for (PieceIF p : playerOnePieces){
				if (p.getChessPieceType() == ChessPieceType.King){
					return p;
				}
			}
		}
		return null;
	}
}
