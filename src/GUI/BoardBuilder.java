package GUI;

import Interfaces.BoardBuilderInterface;
import Interfaces.BoardIF;
import Model.Board;
import javafx.scene.layout.GridPane;

public class BoardBuilder implements BoardBuilderInterface {

    private GridPane board;

    private BoardIF gameBoard;

    private static BoardBuilder singleton;

    private BoardBuilder(GridPane board){
        this.board = board;
        gameBoard = new Board();
        Board_GUI GUI = new Board_GUI();
        GUI.setBuilder(this);
        gameBoard.setDrawStrategy(GUI);
    }

    @Override
    public void updateBoard(GridPane gPane) {
        board = gPane;
    }

    public static BoardBuilder getInstance(GridPane board){
        if(singleton == null)
            singleton = new BoardBuilder(board);
        return singleton;
    }

    public void buildBoard(){
        gameBoard.draw();
    }

    public GridPane getGrid(){
        return board;
    }
}
