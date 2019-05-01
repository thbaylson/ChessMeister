package UI_CLI;

import Interfaces.BoardBuilderInterface;
import Interfaces.BoardIF;
import javafx.scene.layout.GridPane;

public class BoardBuilder implements BoardBuilderInterface {

    private GridPane board;

    private BoardIF gameBoard;

    private static BoardBuilder singleton;

    private BoardBuilder(GridPane board, BoardIF gameBoard){
        this.board = board;
        this.gameBoard = gameBoard;
    }

    @Override
    public void updateBoard(GridPane gPane) {
        board = gPane;
    }

    public static BoardBuilder getInstance(GridPane board, BoardIF gameBoard){
        if(singleton == null)
            singleton = new BoardBuilder(board, gameBoard);
        return singleton;
    }

    public void setGameBoard(BoardIF gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void buildBoard(){
        gameBoard.draw();
    }
}
