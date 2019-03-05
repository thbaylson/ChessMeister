package Model;

import Enums.GameColor;
import Interfaces.BlackAndWhiteIF;

public class BlackAndWhite implements BlackAndWhiteIF{
	
	private GameColor color;
	
	public GameColor getColor(){
		return color;
	}
	
	public void setColor(GameColor gc){
		
	}
	
	public boolean isBlack(){
		return false;
	}
	
	public boolean isWhite(){
		return false;
	}
	
	public void setBlack(boolean b){
		
	}
	
	public void setWhite(boolean b){
		
	}

}
