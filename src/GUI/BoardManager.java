package GUI;

import Interfaces.BoardManagerInterface;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Model.Board;
import Model.Position;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * A class to manage the board logic and the GUI
 *
 * @author Dillon Ramsey 100%
 */
public class BoardManager implements BoardManagerInterface {

    /**The Grid that represent the board*/
    private GridPane board;
    /**The game board with logic*/
    private BoardIF gameBoard;
    /**The pane holding the chess board grid*/
    private GameScreen screen;
    /**This object*/
    private static BoardManager singleton;
    /**The piece currently being worked with*/
    private PieceIF piece;
    /**The player pane*/
    private PlayerPane pPaneOne;
    private PlayerPane pPaneTwo;

    /**
     * Constructor for BoardManager
     *
     * @param board - The game board
     * @param screen - The screen holding the chess board
     */
    private BoardManager(GridPane board, GameScreen screen){
        this.board = board;
        this.screen = screen;
        gameBoard = new Board();
        Board_GUI GUI = new Board_GUI();
        GUI.setBuilder(this);
        gameBoard.setDrawStrategy(GUI);
        this.piece = null;
    }

    /**
     * Updates the chess board when changes are made
     * @param gPane - The grid making up the chess board
     */
    @Override
    public void updateBoard(GridPane gPane) {
        board = gPane;
        screen.updateBoard(board);
    }

    /**
     * Returns an instance of board manager
     *
     * @param board - The game board
     * @param screen - The screen holding the chess board
     * @return The BoardManager
     */
    public static BoardManager getInstance(GridPane board, GameScreen screen){
        if(singleton == null)
            singleton = new BoardManager(board, screen);
        return singleton;
    }

    /**
     * Builds the board
     */
    public void buildBoard(){
        gameBoard.draw();
    }

    /**
     * gets the grid making up the chess board
     * @return The chess board
     */
    public GridPane getGrid(){
        return board;
    }

    /**
     * Shows the moves of a piece
     * @param piece - The piece to show the moves of
     */
    public void showMoves(PieceIF piece){
        this.piece = piece;
        gameBoard.showMoves(piece);
    }

    /**
     * Redraws the cehss board
     */
    public void reDraw(){
        gameBoard.draw();
        screen.updateBoard(board);
        if (!gameBoard.getpOneCapPieces().isEmpty()) {
            //pPaneOne.addChilden(gameBoard.getpOneCapPieces());
        }
        if (!gameBoard.getpTwoCapPieces().isEmpty()){
        //pPaneTwo.addChilden(gameBoard.getpTwoCapPieces());
        }
    }

    /**
     * Moves a piece
     * @param pos - The position of the place to move to
     */
    public void movePiece(Position pos){
        gameBoard.move(piece.getPosition(), pos);
        reDraw();
        this.piece = null;
    }

    /**
     * Gets whoes turn it is
     * @return The turn as a boolean
     */
    public boolean getTurn(){
        return gameBoard.getTurn();
    }

    /**
     * Switchs the turn
     */
    public void switchTurn(){
        gameBoard.switchTurn();
        screen.setFooterBar();
    }

    /**
     * Gets the specified players captured pieces
     *
     * @param Player - The player to check
     * @return The captured pieces
     */
    public ArrayList<PieceIF> getCapturedPieces(int Player){
        if (Player == 1){
            return gameBoard.getpOneCapPieces();
        }else{
            return gameBoard.getpTwoCapPieces();
        }
    }

    /**
     * Sets the player pane
     * @param pPane - The Player pane
     */
    public void setPlayerPane(PlayerPane pPane, int player){
        if (player == 1){
            this.pPaneOne = pPane;
        }else{
            this.pPaneTwo = pPane;
        }
    }
}
