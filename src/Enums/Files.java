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

	public char getFile() {
		return file;
	}

	public int getArrayp() {
		return arrayp;
	}
	
	public static int getArrayp(char f) {
		Files files = Files.A;
		switch(f) {
		case 'A':
			files = Files.A;
			break;
		case 'B':
			files = Files.B;
			break;
		case 'C':
			files = Files.C;
			break;
		case 'D':
			files = Files.D;
			break;
		case 'E':
			files = Files.E;
			break;
		case 'F':
			files = Files.F;
			break;
		case 'G':
			files = Files.G;
			break;
		case 'H':
			files = Files.H;
			break;
		}
		return files.getArrayp();
	}
}
