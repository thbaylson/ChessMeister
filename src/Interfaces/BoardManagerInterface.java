package Interfaces;

import Model.Position;
import javafx.scene.layout.GridPane;

public interface BoardManagerInterface {

    public void updateBoard(GridPane gPane);

    public void buildBoard();

    public GridPane getGrid();

    public void showMoves(PieceIF piece);

    public void reDraw();

    public void movePiece(Position pos);

    public boolean getTurn();

    public void switchTurn();
    }
