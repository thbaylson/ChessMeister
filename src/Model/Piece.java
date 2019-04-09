package Model;

import Enums.ChessPieceType;
import Enums.Files;
import Enums.GameColor;
import Enums.Rank;
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
	private Position pos;

	public Piece(){
		this.cpt = null;
		this.color = null;
<<<<<<< HEAD
=======
		this.pos = null;
>>>>>>> origin/caleb

	}
	/**
	 * Constructor for the Piece object
	 * 
	 * @param cpt - The type of chess piece
	 * @param color - The color of the chess piece
	 */
	public Piece(ChessPieceType cpt, GameColor color) {
		this.cpt = cpt;
		this.color = color;
		if(this.pv != null) {
			this.pv.setColor(color);
		}
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

	/**
	 * Gets the PieceValidator and returns it
	 * @return Returns a PieceValidator
	 */
	public PieceValidator getPieceValidator() {
		return this.pv;
		//return (this.pv != null) ? this.pv : null;
	}

	/**
	 * Sets the PieceValidator, the pieceValidator's color, and the color of the 
	 * pieceValidators' piecevalidators;
	 *
	 * @param p - The PieceValidator to set
	 */
	public void setPieceValidator(PieceValidator p) {
		PieceValidator temp;
		this.pv = p;
		this.pv.setColor(this.color);
		
		temp = this.pv.getPieceValidator();
		while(temp != null) {
			temp.setColor(this.color);
			temp = temp.getPieceValidator();
		}
	}

	/**
	 * Validates the proposed move and checks for check
	 *
	 * @param from - The position the piece is moving from
	 * @param to - The position the piece is trying to move to
	 * @return Returns boolean true if the move was successful and false otherwise
	 */
	public boolean validateMove(Position from, Position to) {
		return validateMove(from, to, this.pv);
	}
	
	/**
	 * Recursive method in line with the decorator pattern to determine if a move is valid
	 *
	 * @param from - The position the piece is moving from
	 * @param to - The position the piece is trying to move to
	 * @param to - The position the piece is trying to move to
	 * @return Returns boolean true if the move was successful and false otherwise
	 */
	public boolean validateMove(Position from, Position to, PieceValidator validator) {
		boolean isValid = false;
		Position[] possibleMoves = validator.showMoves(from);
			for(Position pos : possibleMoves){
				if(pos.getRank() == to.getRank() && pos.getFile() == to.getFile()) {
					isValid = true;
				}
			}
			if(validator.getPieceValidator() != null) {
				isValid = isValid || validateMove(from, to, validator.getPieceValidator());
			}
		return isValid;
	}

	/**
	 * Prints out the color and type of the chess piece
	 */
	@Override
	public String toString() {
		return " " + this.color.getColor() + cpt.getLetter() + " ";
	}

	/**
	 * Gets and returns the GameColor
	 *
	 * @return The color of the piece
	 */
	public GameColor getColor(){
		return this.color;
	}

	/**
	 * Method to list the moves available to the piece
	 *
	 * @return An array containing all the valid moves
	 */
	public Position[] showMoves(){
		return this.getPieceValidator().showMoves(this.pos);

	}

	/**
	 * Sets the position of the piece
	 */
	public void setPosition(Position pos) {
		this.pos = pos;
	}

	/**
	 * Gets and returns the position of the piece
	 *
	 * @return The position of the piece
	 */
	public Position getPosition() {
		return pos;
	}
}
