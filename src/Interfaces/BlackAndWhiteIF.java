package Interfaces;

import Enums.GameColor;

/**
 * The Black and White Interface
 *
 * @author Caleb
 * @version 1.0
 */
public interface BlackAndWhiteIF {

	/**
	 * Gets the GameColor and returns it
	 *
	 * @return The GameColor
	 */
	public GameColor getColor();

	/**
	 * Returns if the color is currently black
	 *
	 * @return Boolean
	 */
	public boolean isBlack();

	/**
	 * Returns if the color is currently white
	 *
	 * @return Boolean
	 */
	public boolean isWhite();
}
