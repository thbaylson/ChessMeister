package Model;

import Enums.Files;
import Enums.Rank;
import Interfaces.SquareIF;

/**
 * The position.
 * 
 * @author Caleb
 * @version 1.0
 */
public class Position {
	
	
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

}
