package Model;

import Enums.Files;
import Enums.Rank;
import Interfaces.SquareIF;

public class Position {
	
	private SquareIF sq;
	
	private Rank rank;
	private Files file;
	
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}

}
