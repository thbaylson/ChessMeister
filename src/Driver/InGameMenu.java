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
                " 1: Redraw Board \n 2: Undo Move \n 3: Redo Move \n " +
                "EXIT: Exit the program");

    }

    /**
     * This method accepts input
     * @return returns the user's input
     */
    public String askInput(){
        return input.next().toUpperCase();
    }





}
