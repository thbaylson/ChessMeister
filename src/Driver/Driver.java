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
		     f = from.charAt(0);
		     r = from.charAt(1);
		     
		     game.getPiece(r, f);
		     
		     
		     System.out.print("Select a destination to move to > ");
		     String to = input.next();
		     f = to.charAt(0);
		     r = to.charAt(1);
		     
		     
		     
		     
		     
		}
		
		
		
	}
}
