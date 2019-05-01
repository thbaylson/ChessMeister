package UI_CLI;

import Interfaces.BoardBuilderInterface;
import javafx.scene.layout.GridPane;

public class BoardBuilder implements BoardBuilderInterface {

    private GridPane board;

    private static BoardBuilder singleton;

    private BoardBuilder(GridPane board){
        this.board = board;
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
}
