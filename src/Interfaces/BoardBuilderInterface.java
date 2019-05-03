package Interfaces;

import javafx.scene.layout.GridPane;

public interface BoardBuilderInterface {

    public void updateBoard(GridPane gPane);

    public void buildBoard();

    public GridPane getGrid();

    public void showMoves(PieceIF piece);

    public void reDraw();
    }
