package Enums;

/**
 * Enum of the game colors
 * 
 * @author Caleb
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
	private GameColor(final char color){
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
