package Model;

import Enums.Files;
import Enums.Rank;
import Interfaces.SquareIF;

/**
 * The position.
 * 
 * @author Caleb
 * @author Dillon Ramsey
 * @version 1.0
 */
public class Position {
	
	private SquareIF sq;
	
	private Rank rank;
	private Files file;
	
	/**
	 * Constructor for position
	 * 
	 * @param f - The file position
	 * @param r - The rank position
	 */
	public Position(Files f, Rank r) {
		this.rank = r;
		this.file = f;
	}
	
	public Position(char f, int r) {
		this.rank = Rank.getRank(r);
		this.file = Files.getFile(f);
	}
	
	/**
	 * Returns the rank
	 * 
	 * @return Rank
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Sets the rank
	 * 
	 * @param rank - The rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/**
	 * Returns the file
	 * 
	 * @return file
	 */
	public Files getFile() {
		return file;
	}
	
	/**
	 * Sets the file
	 * 
	 * @param file - the file to set
	 */
	public void setFile(Files file) {
		this.file = file;
	}
	
	/**
	 * Returns the square at this rank and file
	 * 
	 * @return sq - The square object at this position
	 */
	public SquareIF getSquare() {
		return this.sq;
	}
	
	/**
	 * Sets the square at this position
	 * 
	 * @param square - The square to set at this position
	 */
	public void setSquare(SquareIF square) {
		this.sq = square;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (file != other.file)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}
}