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
     * This method accepts input
     * @return returns user's input
     */
    public String askInput() {
        return input.next().toUpperCase();
    }


}
