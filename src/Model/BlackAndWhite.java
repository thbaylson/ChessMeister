package Model;

import Enums.GameColor;
import Interfaces.BlackAndWhiteIF;

public class BlackAndWhite implements BlackAndWhiteIF{
	
	protected GameColor color;
	
	public GameColor getColor(){
		return color;
	}
	
	public void setColor(GameColor gc){
		this.color = gc;
	}
	
	public boolean isBlack(){
		return this.color == GameColor.BLACK;
	}
	
	public boolean isWhite(){
		return this.color == GameColor.WHITE;
	}
	
	public void setBlack(boolean b){
		this.color = b ? GameColor.BLACK : GameColor.WHITE;
	}
	
	public void setWhite(boolean b){
		this.color = b ? GameColor.WHITE : GameColor.BLACK;
	}
}
