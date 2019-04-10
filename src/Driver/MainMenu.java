package Driver;


import Interfaces.BoardStrategy;
import Interfaces.MenuIF;

import java.util.Scanner;

import UI_CLI.Board_Color_CLI;
import UI_CLI.Board_Mono_CLI;


/**
 * This is the first thing the player sees when they start the program, it asks
 * them if they want to play a game of chess, and if they want a colored
 * board or a mono board
 *
 * @author Caleb Tupone
 */
public class MainMenu implements MenuIF {

    private Scanner input = new Scanner(System.in);


    MainMenu() {

    }

    /**
     * This method displays the main menu
     */
    @Override
    public void display() {
        System.out.println("Hello! Welcome to chess-meister! How about a nice "
                + "game of chess? Y/N");
    }

    /**
     * This method accepts input in reference to the main menu.
     * @return returns user's input
     */
    public String askInput() {
        return input.next().toUpperCase();
    }

    /**
     * Used to choose the board type the user wants
     * @return returns the type of board the user wants
     */
    BoardStrategy chooseBoardType() {

        BoardStrategy strategy;
        System.out.println("If you would like a colored board, please type "
                + "COLOR, if you would like MONO just enter anything else");
        String uInput = input.next().toUpperCase();
        if (wantToExit(uInput)) {
            System.exit(0);
        } else {
            if (uInput.equals("COLOR")) {
                strategy = new Board_Color_CLI();
            } else {
                strategy = new Board_Mono_CLI();
            }
            return strategy;
        }
        return null;
    }

    /**
     * This method is used to determine if the player has decided to exit the
     * program part way, specifically when choosing the board type
     * @param input user's input
     * @return the result if the user wants to exit the program or not
     */
    private boolean wantToExit(String input) {
        return input.equals("EXIT");
    }

}
