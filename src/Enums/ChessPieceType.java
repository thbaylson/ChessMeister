package Enums;

public enum ChessPieceType {
	
	King('K',"King"),
	Queen('Q', "Queen"),
	Rook('R', "Rook"),
	Bishop('B', "Bishop"),
	Knight('N', "Knight"),
	Pawn('P', "Pawn");
	
	
	private final char letter;
	
	private final String name;
	
	private ChessPieceType(final char letter, final String name){
		this.letter = letter;
		this.name = name;
	}

	public char getLetter() {
		return this.letter;
	}

	public String getName() {
		return this.name;
	}
}
