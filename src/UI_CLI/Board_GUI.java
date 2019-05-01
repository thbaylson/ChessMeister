package UI_CLI;

import Interfaces.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Board_GUI implements BoardStrategy{

    /**The grid pane representing the board*/
    private GridPane gPane;

    private BoardBuilderInterface builder;

    /**
     * Method draws the chess board and pieces in the CLI in color
     *
     * @param board - A two dimensional array containing all the squares of the chess board
     */
    @Override
    public void draw(BoardIF board) {
        /**
         * Variable holding a 2D array of squares
         */
        SquareIF[][] layout = new SquareIF[8][8];
        gPane = new GridPane();
        if (board.getTurn()){
            SquareIF[][] flip = board.getSquares();
            int R = 0;
            for (int i = board.getWidth()-1; i >= 0; i--){
                int F = 0;
                for (int j = board.getHeight()-1; j >= 0; j--){
                    layout[R][F] = flip[i][j].clone();
                    F++;
                }
                R++;
            }
        }else{
            layout = board.getSquares();
        }
        for (int j = board.getHeight()-1; j > -1; j--) {
            //Inner for loop that sets pieces on the board
            for (int i = 0; i < board.getWidth(); i++) {
                //Checks if the piece is null
                if (layout[i][j].getPiece() == null) {
                    //Checks the color of the current square and prints it accordingly
                    if (layout[i][j].getHighlight()){
                        gridBuilder(layout[i][j].getPiece(), j, i, 'w', 'w', true);
                    }else if (layout[i][j].getColor().getColor() == 'w'){
                        gridBuilder(layout[i][j].getPiece(), j, i, 'w', 'w', false);
                    }else{
                        gridBuilder(layout[i][j].getPiece(), j, i, 'b', 'w', false);
                    }
                }else {
                    //Checks the color of the square and piece and sets them accordingly
                    if (layout[i][j].getHighlight()) {
                        if (layout[i][j].getPiece().getColor().getColor() == 'w') {
                            gridBuilder(layout[i][j].getPiece(), j, i, 'w', 'w', true);
                        } else {
                            gridBuilder(layout[i][j].getPiece(), j, i, 'b', 'b', true);
                        }
                    }else if (layout[i][j].getColor().getColor() == 'w') {
                        if (layout[i][j].getPiece().getColor().getColor() == 'w') {
                            gridBuilder(layout[i][j].getPiece(), j, i, 'w', 'w', false);
                        }else{
                            gridBuilder(layout[i][j].getPiece(), j, i, 'w', 'b', false);
                        }
                    }else{
                        if (layout[i][j].getPiece().getColor().getColor() == 'w'){
                            gridBuilder(layout[i][j].getPiece(), j, i, 'b', 'w', false);
                        }else{
                            gridBuilder(layout[i][j].getPiece(), j, i, 'b', 'b', false);
                        }
                    }
                }
            }
        }
        builder.updateBoard(gPane);
    }

    public void gridBuilder(PieceIF piece, int col, int row, char sColor, char pColor, boolean hl){
        Button butt = new Button();
        String text = "";
        if (piece != null) {
            text = piece.toString();
        }
        butt.setText(text);
        if (hl){
            butt.setStyle("-fx-background-color: #50148c");
        }else if (sColor == 'w'){
            butt.setStyle("-fx-background-color: #ffffff");
        }else{
            butt.setStyle("-fx-background-color: #000000");
        }
        if (pColor == 'w'){
            butt.setStyle("-fx-text-fill: #0000ff");
        }else{
            butt.setStyle("-fx-text-fill: #ff0000");
        }
        gPane.add(butt, col, row, 1, 1);
    }
}

