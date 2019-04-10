package Driver;


import Interfaces.BoardIF;
import Interfaces.BoardStrategy;
import Interfaces.PieceIF;
import Model.Board;
import Model.Position;


/**
 * This class calls most if not all of the functions required to run the chess
 * game correctly
 *
 * @author Caleb Tupone
 */
class Controller {


    private int currentPlayer = 1;
    private BoardIF game = new Board();
    private InGameMenu inGameMenu = new InGameMenu();
    private PieceIF curP;
    private MainMenu mainMenu = new MainMenu();


    Controller() {

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
                System.out.println("If at anytime you would like to exit the game just " +
                        "type 'exit'\n");
                BoardStrategy strategy = mainMenu.chooseBoardType();
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

        String uInput = "";
        while (!wantToExit(uInput)) {
            game.draw();
            System.out.println("Player " + currentPlayer + " It is your turn!");
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
                            //game.flipBoard();
                        }
                    }
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

        String uInput = inGameMenu.selectPiece();

        if (uInput.equals("BACK")) {
            return null;
        } else {
            while (checkInputLength(uInput)) {
                uInput = inGameMenu.selectPiece();
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
                uInput = inGameMenu.selectPiece(); // This is where what the

                if (uInput.equals("BACK")) {
                    return null;
                }
                while (checkInputLength(uInput)) {
                    uInput = inGameMenu.selectPiece();
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
            return new Position(f, r);
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


        String uInput = inGameMenu.selectDestination();

        if (uInput.equals("BACK")) {
            return null;
        }
        while (checkInputLength(uInput)) {
            uInput = inGameMenu.selectDestination();
            if (uInput.equals("BACK")) {
                return null;
            }
        }
        f = uInput.charAt(0);
        r = (uInput.charAt(1) - 48);
        Position toP = new Position(f, r);

        // This loop is used to make sure the user selects a proper
        //	destination for their piece
        while (checkIfSamePos(fromP, toP) || checkInput(r, f) ||
                !curP.validateMove(game.getSquare(fromP).getPosition(),
                        toP)) {

            uInput = inGameMenu.selectDestination();
            if (uInput.equals("BACK")) {
                return null;
            }
            while (checkInputLength(uInput)) {
                uInput = inGameMenu.selectDestination();
                if (uInput.equals("BACK")) {
                    return null;
                }
            }

            f = uInput.charAt(0);
            r = (uInput.charAt(1) - 48);
        }
        return new Position(f, r);

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
        } else {
            return false;
        }
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
        } else {
            return false;
        }

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
        } else {
            return false;
        }

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
        } else {
            return false;
        }
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
