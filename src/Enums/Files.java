package Enums;

public enum Files {
	
	A('a', 0),
	B('b', 1),
	C('c', 2),
	D('d', 3),
	E('e', 4),
	F('f', 5),
	G('g', 6),
	H('h', 7);
	
	private final char file;
	
	private final int arrayp;
	
	private Files(final char file, final int arrayp){
		this.file = file;
		this.arrayp = arrayp;
	}

	public int getRank() {
		return file;
	}

	public int getArrayp() {
		return arrayp;
	}
}
