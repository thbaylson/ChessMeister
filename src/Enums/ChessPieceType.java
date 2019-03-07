package Enums;

public enum ChessPieceType {
	Rook('R', "Rook"),
	Knight('N', "Knight"),
	Bishop('B', "Bishop"),
	Queen('Q', "Queen"),
	King('K',"King"),
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
