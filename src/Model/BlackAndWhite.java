package Model;

import Enums.GameColor;
import Interfaces.BlackAndWhiteIF;

/**
 * Class to set and get the color of pieces and squares in the chess board
 *
 * @author Caleb Tupone 100% all
 * @version 1.0
 */
public class BlackAndWhite implements BlackAndWhiteIF{
	
	protected GameColor color;
	
	/**
	 * Returns color of object
	 * 
	 * @return Black or White
	 */
	public GameColor getColor(){
		return color;
	}
	
	/**
	 * Sets the color
	 * 
	 * @param gc - The color to set to
	 */
	public void setColor(GameColor gc){
		this.color = gc;
	}
	
	/**
	 * Checks if the color is currently black
	 * 
	 * @return Boolean - Returns true if black, false otherwise
	 */
	public boolean isBlack(){
		return this.color == GameColor.BLACK;
	}
	
	/**
	 * Checks if the color is currently white
	 * 
	 * @return Boolean - Returns true if white, false otherwise
	 */
	public boolean isWhite(){
		return this.color == GameColor.WHITE;
	}
	
	/**
	 *Sets the color to black 
	 * 
	 * @param b - Boolean value for if black should be true
	 */
	public void setBlack(boolean b){
		this.color = b ? GameColor.BLACK : GameColor.WHITE;
	}
	
	/**
	 *Sets the color to white 
	 * 
	 * @param b - Boolean value for if white should be true
	 */
	public void setWhite(boolean b){
		this.color = b ? GameColor.WHITE : GameColor.BLACK;
	}
}
