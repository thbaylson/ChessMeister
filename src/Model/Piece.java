package Model;

import Enums.ChessPieceType;
import Enums.GameColor;
import Interfaces.PieceIF;
import Move_Validation.PieceValidator;


/**
 * Class modeling a piece
 * 
 * @author Tyler, Caleb, Dillon
 * @version 1.0
 */
public class Piece extends BlackAndWhite implements PieceIF{

	private ChessPieceType cpt;
	private GameColor color;
	private PieceValidator pv;

	public Piece(){
		this.cpt = null;
		this.color = null;
	}
	/**
	 * Constructor for Piece object
	 * 
	 * @param cpt - The type of chess piece
	 * @param color - The color of the chess piece
	 */
	public Piece(ChessPieceType cpt, GameColor color) {
		this.cpt = cpt;
		this.color = color;
	}
	
	/**
	 * Returns the chess piece type
	 * 
	 * @return cpt - Chess piece type
	 */
	@Override
	public ChessPieceType getChessPieceType() {
		return this.cpt;
	}
	
	/**
	 * Sets the type of chess piece
	 * 
	 * @param t - The chess piece type to set to
	 */
	@Override
	public void setChessPieceType(ChessPieceType t) {
		this.cpt = t;
	}
	
	public PieceValidator getPieceValidator() {
		return this.pv;
	}
	
	public void setPieceValidator(PieceValidator p) {
		this.pv = p;
	}
	
	public boolean validateMove(Position from, Position to) {
			for(Position pos : this.pv.showMoves(from)){
				if(pos.getRank() == to.getRank() && pos.getFile() == to.getFile()) {
					return true;
				}
			}
		return false;
	}
	
	public Position[] showMoves() {
		//this.pv.showMoves();
		return null;
	}
	
	/**
	 * Prints out the color and type of the chess piece
	 */
	@Override
	public String toString() {
		return " " + this.color.getColor() + cpt.getLetter() + " ";
	}

	public GameColor getColor(){
		return this.color;
	}
}
