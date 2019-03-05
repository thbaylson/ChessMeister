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
		this.arrayp = arrayp;
	}

	public int getRank() {
		return rank;
	}

	public int getArrayp() {
		return arrayp;
	}

	
	
}
