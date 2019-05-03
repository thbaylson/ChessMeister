package GUI;

import Interfaces.BoardBuilderInterface;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Model.Board;
import Model.Position;
import javafx.scene.layout.GridPane;

public class BoardBuilder implements BoardBuilderInterface {

    private GridPane board;

    private BoardIF gameBoard;

    private GameScreen screen;

    private static BoardBuilder singleton;

    private PieceIF piece;

    private BoardBuilder(GridPane board, GameScreen screen){
        this.board = board;
        this.screen = screen;
        gameBoard = new Board();
        Board_GUI GUI = new Board_GUI();
        GUI.setBuilder(this);
        gameBoard.setDrawStrategy(GUI);
        this.piece = null;
    }

    @Override
    public void updateBoard(GridPane gPane) {
        board = gPane;
        screen.updateBoard(board);
    }

    public static BoardBuilder getInstance(GridPane board, GameScreen screen){
        if(singleton == null)
            singleton = new BoardBuilder(board, screen);
        return singleton;
    }

    public void buildBoard(){
        gameBoard.draw();
    }

    public GridPane getGrid(){
        return board;
    }

    public void showMoves(PieceIF piece){
        this.piece = piece;
        gameBoard.showMoves(piece);
    }

    public void reDraw(){
        gameBoard.draw();
        screen.updateBoard(board);
    }

    public void movePiece(Position pos){
        gameBoard.move(piece.getPosition(), pos);
        reDraw();
        this.piece = null;
    }

    public boolean getTurn(){
        return gameBoard.getTurn();
    }

    public void switchTurn(){
        gameBoard.switchTurn();
    }
}
