package Enums;

public enum GameColor {
	
	WHITE('w'), 
	BLACK('b');
	
	private final char color;
	
	
	private GameColor(final char color){
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

}
