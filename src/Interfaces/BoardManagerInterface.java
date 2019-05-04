package Interfaces;

import GUI.PlayerPane;
import Model.Position;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * A class to manage the board logic and the GUI
 *
 * @author Dillon Ramsey 100%
 */
public interface BoardManagerInterface {

    /**
     * Updates the chess board
     * @param gPane - The chess board
     */
    public void updateBoard(GridPane gPane);

    /**
     * Builds the chess board
     */
    public void buildBoard();

    /**
     * Gets the chess board
     * @return The chess board
     */
    public GridPane getGrid();

    /**
     * Shows the moves of the piece
     * @param piece - The piece to show the moves of
     */
    public void showMoves(PieceIF piece);

    /**
     * Redraws the board
     */
    public void reDraw();

    /**
     * Moves a piece to specified spot
     * @param pos - The position to move to
     */
    public void movePiece(Position pos);

    /**
     * gets the turn
     * @return The turn
     */
    public boolean getTurn();

    /**
     * Switches the turn
     */
    public void switchTurn();

    /**
     * Gets the specified players captured pieces
     *
     * @param Player - The player to check
     * @return The captured pieces
     */
    public ArrayList<PieceIF> getCapturedPieces(int Player);

    /**
     * Sets the player pane
     * @param pPane - The Player pane
     */
    public void setPlayerPane(PlayerPane pPane, int player);
    }
