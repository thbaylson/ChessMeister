package Driver;

import Model.Board;

import java.util.Scanner;

import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import UI_CLI.Board_Mono_CLI;

/**
 * Driver that runs the game and accepts user input
 * @author Caleb Tupone
 * 
 *
 */
public class Driver {
	
	
	/**
	 * The main method that creates a game of chess for two players to play
	 * @param args
	 */
	public static void main(String[] args) {
		BoardIF game = new Board();
		BoardStrategy gStrat = new Board_Mono_CLI();
		game.setDrawStrategy(gStrat);
		game.draw();
		
		
		Scanner input = new Scanner(System.in);
		
		char f;
		int r;
		while(!input.next().toUpperCase().equals("EXIT")){
			
			 System.out.print("Select a piece to move > ");
			 
		     String from = input.next().toUpperCase();
		     f = (char) (from.charAt(0));
		     r = (from.charAt(1) - 48);
		     
		     if (checkInput(r, f)){
		    	 System.out.println(game.getPiece(r, f)); 
		    	 
		    	 System.out.print("Select a destination to move to > ");
		    	 
			     String to = input.next();
			     f = (char) to.charAt(0);
			     r = to.charAt(1) - 48;
			     if (checkInput(r, f)){
			    	 game.getPiece(r, f);
			     }
		     }
<<<<<<< HEAD

		    
	
		}
		input.close(); 	
	}
	private static boolean checkInput(int r, char f){
	    if (f >= 65 && f <= 72){
	    	 if (r >= 1 && r <= 8){
	    		return true;
	    	 }
	    	 else{
		    	 System.out.println("Invalid rank position, please enter second "
		    	 		+ "a number from '1' to '8'");
		    	 return false;
		     }
	     }
	     else{
	    	 System.out.println("Invalid file position, please enter first "
	    	 		+ "a letter from 'a' to 'h'");
	    	 return false;
	     }
=======

		     
		     System.out.print("Select a destination to move to > ");
		     String to = input.next();
		     f = to.charAt(0);

		     r = to.charAt(1);

		}
		input.close();
		
		
		
>>>>>>> 182d4a19d746a874c90f21a0179f8c0cab3a5f96
	}
}
