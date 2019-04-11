package Driver;


import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.MenuIF;
import Interfaces.PieceIF;
import Memento.CareTaker;
import Model.Board;
import Model.Position;
import UI_CLI.Board_Color_CLI;
import UI_CLI.Board_Mono_CLI;


/**
 * This class calls most if not all of the functions required to run the chess
 * game correctly
 *
 * @author Caleb Tupone 99%
 * @author Dillon Ramsey 1%
 */
class Controller {

    private int currentPlayer = 1;
    private BoardIF game;
    private MenuIF inGameMenu;
    private PieceIF curP;
    private MenuIF mainMenu;
    private CareTaker<BoardIF> ct;



    Controller() {
        game = new Board();
        inGameMenu = new InGameMenu();
        mainMenu = new MainMenu();
        ct = new CareTaker<BoardIF>();
    }

    /**
     * This method starts up a game of chess or quits the game
     */
    void go() {

        boolean gameIsRunning = true;
        while (gameIsRunning) {
            mainMenu.display();
            String uInput = mainMenu.askInput();

            if (uInput.equals("Y") || uInput.equals("YES")) {
                BoardStrategy strategy = chooseBoardType();
                game.setDrawStrategy(strategy);
                runGame();

            } else if (uInput.equals("N") || uInput.equals("NO")) {
                gameIsRunning = false;
            } else {
                System.out.println("Please enter either yes or no Y/N");
            }
        }
    }

    /**
     * This method is used for running the game
     */
    private void runGame() {
        System.out.println("Player 1, please enter your name, you will be " +
                "the White(blue) pieces further denoted by the prenote 'w' " +
                "before each piece.");
        String player1 = inGameMenu.askInput();
        System.out.println("Player 2, please enter your name, you will be " +
                "the Black(red) pieces further denoted by the prenote 'b' " +
                "before each piece");
        String player2 = inGameMenu.askInput();

        String uInput = "";
        ct.add(game.saveState());
        while (!wantToExit(uInput)) {
            game.draw();
            if (currentPlayer == 1)
                System.out.println(player1 + " it is your turn!");
            else
                System.out.println(player2 + " it is your turn!");

            inGameMenu.display();

            uInput = inGameMenu.askInput();
            switch (uInput) {
                case "0":
                    Position fromP = selectPiece();
                    if (fromP != null) {
                        Position toP = selectDestination(fromP);
                        if (toP != null) {
                            game.move(fromP, toP);
                            switchPlayer();
                            game.switchTurn();
                            ct.add(game.saveState());
                        }
                    }
                    break;
                case "1":
                    game.draw();
                    break;
                case "2":
                    game.restoreState(ct.undo());
                    switchPlayer();
                    break;
                case "3":
                    game.restoreState(ct.redo());
                    switchPlayer();
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Please select a valid command");
            }
        }
    }

    /**
     * This method selects a piece and shows the available moves that piece can
     * make
     *
     * @return the position of the piece that the user has selected
     */
    private Position selectPiece() {
        char currentPlayerColor;
        if (currentPlayer == 1) {
            currentPlayerColor = 'w';
        } else {
            currentPlayerColor = 'b';
        }

        char f;
        int r;
        System.out.print("If you would like to do something else type 'back'\n" +
                "Select a piece > ");
        String uInput = inGameMenu.askInput();

        if (uInput.equals("BACK")) {
            return null;
        } else {
            while (checkInputLength(uInput)) {
                System.out.print("If you would like to do something else type 'back'\n" +
                        "Select a piece > ");
                uInput = inGameMenu.askInput();
                if (uInput.equals("BACK")) {
                    return null;
                }
            }
            f = (uInput.charAt(0));
            r = (uInput.charAt(1) - 48);
            curP = game.getPiece(r, f);
            // This loops is used the make sure the user selects a proper
            //piece to move
            while (checkInput(r, f) || checkInputPos(game, r, f) ||
                    checkIfCorrectPlayer(curP.getColor().getColor(), currentPlayerColor)) {
                System.out.print("If you would like to do something else type 'back'\n" +
                        "Select a piece > ");
                uInput = inGameMenu.askInput(); // This is where what the

                if (uInput.equals("BACK")) {
                    return null;
                }
                while (checkInputLength(uInput)) {
                    System.out.print("If you would like to do something else type 'back'\n" +
                            "Select a piece > ");
                    uInput = inGameMenu.askInput();
                    if (uInput.equals("BACK")) {
                        return null;
                    }
                }
                //user inputs is stored
                f = (uInput.charAt(0));
                r = (uInput.charAt(1) - 48);
                curP = game.getPiece(r, f);
            }
            curP = game.getPiece(r, f);
            game.showMoves(curP);
            return game.getPosition(r, f);
        }
    }

    /**
     * This method selects the position the player wants to move their piece to
     *
     * @param fromP the current position of the piece the player selected
     * @return a position where the user wants to move their piece to
     */
    private Position selectDestination(Position fromP) {

        char f;
        int r;

        System.out.print("If you would like to select a different piece type " +
                "back \nSelect a destination to move to > ");
        String uInput = inGameMenu.askInput();

        if (uInput.equals("BACK")) {
            return null;
        }
        while (checkInputLength(uInput)) {
            System.out.print("If you would like to select a different piece type " +
                    "back \nSelect a destination to move to > ");
            uInput = inGameMenu.askInput();
            if (uInput.equals("BACK")) {
                return null;
            }
        }
        f = uInput.charAt(0);
        r = (uInput.charAt(1) - 48);
        Position toP = game.getPosition(r, f);

        // This loop is used to make sure the user selects a proper
        //	destination for their piece
        while (checkIfSamePos(fromP, toP) || checkInput(r, f) ||
                checkIfValidMove(fromP, toP)) {
            System.out.print("If you would like to select a different piece type " +
                    "back \nSelect a destination to move to > ");
            uInput = inGameMenu.askInput();
            if (uInput.equals("BACK")) {
                return null;
            }
            while (checkInputLength(uInput)) {
                System.out.print("If you would like to select a different piece type " +
                        "back \nSelect a destination to move to > ");
                uInput = inGameMenu.askInput();
                if (uInput.equals("BACK")) {
                    return null;
                }
            }
            f = uInput.charAt(0);
            r = (uInput.charAt(1) - 48);
            toP = new Position(f, r);
        }
        return new Position(f, r);
    }

    /**
     * This method is used to determine if the player has decided to exit the
     * program part way, specifically when choosing the board type
     *
     * @param input user's input
     * @return the result if the user wants to exit the program or not
     */
    private boolean wantToExit(String input) {
        return input.equals("EXIT");
    }

    /**
     * Method that is used to check if input is within board range
     *
     * @param r rank of user input
     * @param f file of user input
     * @return if input is within range of the board
     */
    private boolean checkInput(int r, char f) {
        if (f >= 65 && f <= 72) {
            if (r >= 1 && r <= 8) {
                return false;
            } else {
                System.out.println("Invalid rank position, please enter second "
                        + "a number from '1' to '8'");
                return true;
            }
        } else {
            System.out.println("Invalid file position, please enter first "
                    + "a letter from 'a' to 'h'");
            return true;
        }
    }

    /**
     * Method that checks of input is of correct char length
     *
     * @param fr string user entered
     * @return if input is correct length
     */
    private boolean checkInputLength(String fr) {
        if (fr.length() != 2) {
            System.out.println("Please enter in the format: 1 character "
                    + "(file or f) and then 1 number (rank or r) 'fr' ");

            return true;
        }
        return false;
    }

    /**
     * Used to check if the position the user selected is a valid piece
     *
     * @param game the board
     * @param r    the rank of user input
     * @param f    the file of user input
     * @return if input is a valid piece
     */
    private boolean checkInputPos(BoardIF game, int r, char f) {
        if (game.getPiece(r, f) == null) {
            System.out.println("The spot you have selected is empty");

            return true;
        }
        return false;
    }

    /**
     * This checks to see if the player has selected the same position that the
     * piece is already on
     *
     * @param fromP the position of the piece the player wants to move
     * @param toP   the position the player wants to move the piece to
     * @return if input is a valid position
     */
    private boolean checkIfSamePos(Position fromP, Position toP) {
        if (fromP.equals(toP)) {
            System.out.println("You have selected the same position as the" +
                    " current location of the piece");
            return true;
        }
        return false;
    }

    /**
     * This method checks if the current player has selected a piece that is
     * their color
     *
     * @param color              the color of the piece the player selected
     * @param currentPlayerColor the color of the current player
     * @return if the player has selected the correct colored piece
     */
    private boolean checkIfCorrectPlayer(char color, char currentPlayerColor) {
        if (currentPlayerColor != color) {
            System.out.println("You cannot select the other players " +
                    "pieces");
            return true;
        }
        return false;
    }

    /**
     * This method is used to check if the position that the user selected
     * is withing the valid move set for the piece they selected
     *
     * @param fromP the position of the piece the player wants to move
     * @param toP   the position the player wants to move the piece to
     * @return whether or not the user selected a valid position
     */
    private boolean checkIfValidMove(Position fromP, Position toP) {
        if (!curP.validateMove(game.getSquare(fromP).getPosition(), toP)) {
            System.out.println("That piece cannot move there, please " +
                    "select a highlighted position");
            return true;
        }
        return false;
    }


    /**
     * Used to choose the board type the user wants
     *
     * @return returns the type of board the user wants
     */
    private BoardStrategy chooseBoardType() {

        BoardStrategy strategy;
        System.out.println("If you would like a colored board, please type "
                + "COLOR, if you would like MONO just enter anything else");
        String uInput = mainMenu.askInput();
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
     * Switches the current player
     */
    private void switchPlayer() {
        if (currentPlayer == 1)
            currentPlayer = 2;
        else {
            currentPlayer = 1;
        }
    }



}
