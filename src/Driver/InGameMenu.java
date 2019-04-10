package Driver;

import Interfaces.BoardIF;
import Interfaces.MenuIF;

import java.util.Scanner;

public class InGameMenu implements MenuIF {

    private Scanner input = new Scanner(System.in);

    InGameMenu(){

    }

    @Override
    public void display(){
        System.out.println("What would you like to do?\n 0: Move a Piece\n" +
                " EXIT: Exit the program");

    }

    public String askInput(){
        return input.next().toUpperCase();
    }

    public String selectPiece(){
        System.out.print("If you would like to do something else type 'back'\n" +
                "Select a piece > ");
        return input.next().toUpperCase();
    }

    public String selectDestination(){
        System.out.print("If you would like to select a different piece type " +
                "back \nSelect a destination to move to > ");
        return input.next().toUpperCase();
    }




}
