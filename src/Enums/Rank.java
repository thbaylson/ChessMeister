package Enums;

/**
 * Enum for the rank
 *
 * @author Caleb Tupone %70 the enum itself and the getter
 * @author Tyler Baylson %30 both the switch cases
 */
public enum Rank {
	
	
	R1(1,0),
	R2(2,1), 
	R3(3,2), 
	R4(4,3), 
	R5(5,4), 
	R6(6,5), 
	R7(7,6), 
	R8(8,7);
	
	private final int rank;
	
	private final int arrayp;
	
	
	/**
	 * Constructor for rank
	 * 
	 * @param rank - The rank on the chess board
	 * @param arrayp - The position in the array
	 */
	private Rank(final int rank, final int arrayp){
		this.rank = rank;
		this.arrayp = arrayp;
	}

	/**
	 * Gets the rank
	 * 
	 * @return rank - the rank
	 */
	public int getRank() {
		return rank;
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
	 * Gets the array position based on the rank from the board
	 * 
	 * @param r - The rank from the chess board
	 * @return rank - the position in the array
	 */
	public static int getArrayp(int r) {
		Rank rank = Rank.R1;
		switch(r) {
		case 1:
			rank = Rank.R1;
			break;
		case 2:
			rank = Rank.R2;
			break;
		case 3:
			rank = Rank.R3;
			break;
		case 4:
			rank = Rank.R4;
			break;
		case 5:
			rank = Rank.R5;
			break;
		case 6:
			rank = Rank.R6;
			break;
		case 7:
			rank = Rank.R7;
			break;
		case 8:
			rank = Rank.R8;
			break;
		}
		return rank.getArrayp();
	}
	
	/**
	 * Gets the array position based on the rank from the board
	 * 
	 * @param r - The rank from the chess board
	 * @return rank - the position in the array
	 */
	public static Rank getRank(int r) {
		Rank rank = Rank.R1;
		switch(r) {
		case 1:
			rank = Rank.R1;
			break;
		case 2:
			rank = Rank.R2;
			break;
		case 3:
			rank = Rank.R3;
			break;
		case 4:
			rank = Rank.R4;
			break;
		case 5:
			rank = Rank.R5;
			break;
		case 6:
			rank = Rank.R6;
			break;
		case 7:
			rank = Rank.R7;
			break;
		case 8:
			rank = Rank.R8;
			break;
		}
		return rank;
	}
	
}
