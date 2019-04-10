package Driver;


import Interfaces.BoardStrategy;
import Interfaces.MenuIF;
import java.util.Scanner;

import UI_CLI.Board_Color_CLI;
import UI_CLI.Board_Mono_CLI;
import sun.applet.Main;

/**
 * This is the first thing the player sees when they start the program, it asks
 * them if they want to play a game of chess, and if they want a colored
 * board or a mono board
 * @author Caleb Tupone
 *
 */
public class MainMenu implements MenuIF {

    private Scanner input = new Scanner(System.in);


    MainMenu(){

    }

    @Override
    public void display() {
        System.out.println("Hello! Welcome to chess-meister! How about a nice "
        + "game of chess? Y/N");
    }

    public String askInput(){
        return input.next().toUpperCase();
    }

    /**
     * Used to choose the board type the user wants
     */
     public BoardStrategy chooseBoardType(){

        BoardStrategy strategy;
        System.out.println("If you would like a colored board, please type "
                + "COLOR, if you would like MONO just enter anything else");
        String uInput = input.next().toUpperCase();
        if (wantToExit(uInput)){
            System.exit(0);
        }
        else{
            if (uInput.equals("COLOR")){
                strategy = new Board_Color_CLI();
            }
            else{
                strategy = new Board_Mono_CLI();
            }
            return strategy;
        }
        return null;
    }


    private boolean wantToExit(String input){
        return input.equals("EXIT");
    }

}
