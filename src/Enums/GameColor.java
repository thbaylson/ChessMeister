package Enums;

/**
 * Enum of the game colors
 * 
 * @author Caleb Tupone 100% All
 * @version 1.0
 */
public enum GameColor {
	
	WHITE('w'), 
	BLACK('b');
	
	private final char color;
	
	/**
	 * Constructor for GameColor
	 * 
	 * @param color - The color
	 */
	GameColor(final char color){
		this.color = color;
	}
	
	/**
	 * Gets the color
	 * 
	 * @return color - The color
	 */
	public char getColor() {
		return color;
	}

}
