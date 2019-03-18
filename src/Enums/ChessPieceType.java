package Enums;

/**
 * Enum containing chess piece types
 * 
 * @author Caleb
 * @version 1.0
 */
public enum ChessPieceType {
	Rook('R', "Rook"),
	Knight('N', "Knight"),
	Bishop('B', "Bishop"),
	Queen('Q', "Queen"),
	King('K',"King"),
	Pawn('P', "Pawn");
	
	
	private final char letter;
	private final String name;
	
	/**
	 * Constructor for chess peice type
	 * 
	 * @param letter - The letter to associate with each piece
	 * @param name - The name of each peice
	 */
	private ChessPieceType(final char letter, final String name){
		this.letter = letter;
		this.name = name;
	}

	/**
	 * Gets the letter of the piece
	 * 
	 * @return letter - Piece's letter
	 */
	public char getLetter() {
		return this.letter;
	}

	/**
	 * Gets the name of the piece
	 * 
	 * @return name - The name of the piece
	 */
	public String getName() {
		return this.name;
	}
}
