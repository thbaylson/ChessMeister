package Model;

import Enums.Files;
import Enums.Rank;

public class Position {
	
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
