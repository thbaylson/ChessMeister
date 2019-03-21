package Driver;

import Model.Board;
import Interfaces.BoardStrategy;
import UI_CLI.Board_Mono_CLI;

public class Driver {

	public static void main(String[] args) {
		Board game = new Board();
		BoardStrategy gStrat = new Board_Mono_CLI();
		game.setDrawStrategy(gStrat);

		game.draw();

		
		char f;
		int r;
		
		while(!uInput.equals("EXIT")){
			 game.draw();
			 System.out.print("Select a piece to move > ");
		     uInput = input.next().toUpperCase(); // This is where what the user inputs is stored
		     f = (char) (uInput.charAt(0));
		     r = (uInput.charAt(1) - 48);
		     Piece curp = (Piece) game.getPiece(r, f);
		     
		     while(checkInputLength(uInput) || checkInput(r, f) || checkInputPos(game, r, f)){
		    	 System.out.print("Select a piece to move > ");
			     uInput = input.next().toUpperCase(); // This is where what the user inputs is stored
			     f = (char) (uInput.charAt(0));
			     r = (uInput.charAt(1) - 48);
		     } 
		    
		     
		    Position fromP = new Position(f, r);
		    		    
		     
		    
		    System.out.print("Select a destination to move to > ");
		    uInput = input.next().toUpperCase();
		    f = (char) uInput.charAt(0);
			r = (uInput.charAt(1) - 48);
			
		    while(checkInputLength(uInput) || checkInput(r, f)){
		    	
		    	 System.out.print("Select a destination to move to > ");
				 uInput = input.next().toUpperCase();
				 f = (char) uInput.charAt(0);
			     r = (uInput.charAt(1) - 48);
		    }
		    
		    Position toP = new Position(f, r);
		    if(curp.validateMove(game.getSquare(fromP).getPosition(), toP)){
		    	 game.move(fromP, toP);
		    }	
		}
		input.close();
	}
}
