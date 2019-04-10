package Driver;


import Interfaces.MenuIF;

import java.util.Scanner;

/**
 * This class displays a menu that the players can use to decide how they would
 * like to interact with the game. It also displays current options at each
 * step of the game.
 */
public class InGameMenu implements MenuIF {

    private Scanner input = new Scanner(System.in);

    InGameMenu(){

    }

    /**
     * This method displays the in-game menu
     */
    @Override
    public void display(){
        System.out.println("What would you like to do?\n 0: Move a Piece\n" +
                " EXIT: Exit the program");

    }

    /**
     * This method accepts input in reference to the in-game menu
     * @return returns the user's input
     */
    public String askInput(){
        return input.next().toUpperCase();
    }

    /**
     * This method accepts user input to select a piece
     * @return returns the user's input
     */
    String selectPiece(){
        System.out.print("If you would like to do something else type 'back'\n" +
                "Select a piece > ");
        return input.next().toUpperCase();
    }

    /**
     * This method accepts the user's input to select a destination for the piece
     * they have previously selected
     * @return returns the user's input
     */
    String selectDestination(){
        System.out.print("If you would like to select a different piece type " +
                "back \nSelect a destination to move to > ");
        return input.next().toUpperCase();
    }




}
