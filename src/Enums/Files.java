package Enums;

/**
 * Enum for the files on the chess board
 * 
 * @author Caleb, Tyler
 *
 */
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
	
	/**
	 * Constructor for the files
	 * 
	 * @param file - The position on the chess board
	 * @param arrayp - The position in the array
	 */
	private Files(final char file, final int arrayp){
		this.file = file;
		this.arrayp = arrayp;
	}

	/**
	 * Gets the file
	 * 
	 * @return file - The position on the chess board
	 */
	public char getFile() {
		return file;
	}

	/**
	 * Gets the array position
	 * 
	 * @return arrayp - The array position
	 */
	public int getArrayp() {
		return arrayp;
	}
	
	/**
	 * Gets array position based on the file as a char
	 * 
	 * @param f - The file as a char
	 * @return files - The array position
	 */
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
	
	/**
	 * Gets array position based on the file as a char
	 * 
	 * @param f - The file as a char
	 * @return files - The array position
	 */
	public static Files getFile(char f) {
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
		return files;
	}
}
