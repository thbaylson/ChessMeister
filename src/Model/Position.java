package Model;

import Enums.Files;
import Enums.Rank;
import Interfaces.SquareIF;

/**
 * The position.
 * 
 * @author Caleb Tupone getter and setter and equals %60
 * @author Dillon Ramsey clone %20
 * @authro Tyler Baylson toString %20
 * @version 1.0
 */
public class Position {
	
	private SquareIF sq;
	private Files file;
	private Rank rank;
	
	/**
	 * Constructor for position
	 * 
	 * @param f - The file position
	 * @param r - The rank position
	 */
	public Position(Files f, Rank r) {
		this.file = f;
		this.rank = r;
	}
	
	public Position(char f, int r) {
		this.file = Files.getFile(f);
		this.rank = Rank.getRank(r);
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
	
	/**
	 * toString- Returns an appropriate string representing this object.
	 * @return The string version of this object
	 */
	@Override
	public String toString() {
		return "[".concat(this.file.toString()).concat("][").concat(this.rank.toString()).concat("]");
	}

	/**
	 * Method to check if a object is equal to this position
	 *
	 * @param obj - The object being checked
	 * @return A boolean true if the object is equal and false otherwise
	 */
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

	public Position clone(){
		Position newPos = new Position(this.file, this.rank);
		return newPos;
	}
}