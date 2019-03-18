package Driver;

import Model.Board;


import java.util.Scanner;

import Interfaces.BoardStrategy;
import UI_CLI.Board_Mono_CLI;

public class Driver {

	public static void main(String[] args) {
		Board game = new Board();
		BoardStrategy gStrat = new Board_Mono_CLI();
		game.setDrawStrategy(gStrat);
		game.draw();
		
		
		Scanner input = new Scanner(System.in);
		int x = 0;
		char f;
		int r;
		while(x == 0){
			 System.out.print("Select a piece to move > ");
		     String from = input.next();
		     
		     f = (char) (from.charAt(0) - 32);
		     System.out.println(f);
		     r = from.charAt(1);
		     
		     if (f >= 65 && f <= 72){
		    	 if (r >= 1 && r <= 8)
		    		System.out.println(game.getPiece(r, f)); 
		     }
		     
		     System.out.print("Select a destination to move to > ");
		     String to = input.next();
		     f = to.charAt(0);

		     r = to.charAt(1);
		     
		     
		    input.close(); 
		     
		     
		     
		     
		}
		
		
		
	}
}
