package Enums;

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
	
	
	
	private Rank(final int rank, final int arrayp){
		this.rank = rank;
		this.arrayp = rank - 1;
	}

	public int getRank() {
		return rank;
	}

	public int getArrayp() {
		return arrayp;
	}

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
	
}
