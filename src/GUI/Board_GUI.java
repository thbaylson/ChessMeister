package GUI;

import Enums.ChessPieceType;
import Enums.GameColor;
import Interfaces.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        gPane.setHgap(1);
        gPane.setVgap(1);
        gPane.setGridLinesVisible(true);
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
        for (int j = board.getHeight()-1; j > -1; j--) {
            //Inner for loop that sets pieces on the board
            for (int i = 0; i < board.getWidth(); i++) {
                //Checks if the piece is null
                if (layout[i][j].getPiece() == null) {
                    //Checks the color of the current square and prints it accordingly
                    if (layout[i][j].getHighlight()){
                        gridBuilder(layout[i][j].getPiece(), i, j, 'w', 'w', true);
                    }else if (layout[i][j].getColor().getColor() == 'w'){
                        gridBuilder(layout[i][j].getPiece(), i, j, 'w', 'w', false);
                    }else{
                        gridBuilder(layout[i][j].getPiece(), i, j, 'b', 'w', false);
                    }
                }else {
                    //Checks the color of the square and piece and sets them accordingly
                    if (layout[i][j].getHighlight()) {
                        if (layout[i][j].getPiece().getColor().getColor() == 'w') {
                            gridBuilder(layout[i][j].getPiece(), i, j, 'w', 'w', true);
                        } else {
                            gridBuilder(layout[i][j].getPiece(), i, j, 'b', 'b', true);
                        }
                    }else if (layout[i][j].getColor().getColor() == 'w') {
                        if (layout[i][j].getPiece().getColor().getColor() == 'w') {
                            gridBuilder(layout[i][j].getPiece(), i, j, 'w', 'w', false);
                        }else{
                            gridBuilder(layout[i][j].getPiece(), i, j, 'w', 'b', false);
                        }
                    }else{
                        if (layout[i][j].getPiece().getColor().getColor() == 'w'){
                            gridBuilder(layout[i][j].getPiece(), i, j, 'b', 'w', false);
                        }else{
                            gridBuilder(layout[i][j].getPiece(), i, j, 'b', 'b', false);
                        }
                    }
                }
            }
        }
        builder.updateBoard(gPane);
    }

    public void gridBuilder(PieceIF piece, int col, int row, char sColor, char pColor, boolean hl){
        Button butt = new Button();
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("./images/WP.png")));
        butt.setMaxSize(47, 45);
        butt.setMinSize(47,45);
        if (piece != null) {
            switch (piece.getChessPieceType()){
                case King :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WK_smooth.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BK.png")));
                    }
                    break;
                case Queen :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WQ_smooth.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BQ.png")));
                    }
                    break;
                case Rook :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WR.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BR.png")));
                    }
                    break;
                case Knight :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WN.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BN.png")));
                    }
                    break;
                case Bishop :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WB.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BB.png")));
                    }
                    break;
                case Pawn :
                    if (piece.getColor() == GameColor.WHITE){
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/WP.png")));
                    }else{
                        image = new ImageView(new Image(getClass().getResourceAsStream("./images/BP.png")));
                    }
                    break;
            }
            image.setFitWidth(butt.getMaxWidth());
            image.setFitHeight(butt.getMaxHeight());
            butt.setGraphic(image);
        }
        butt.setAlignment(Pos.CENTER);
        if (hl){
            butt.setStyle("-fx-background-color: #50148c");
        }else if (sColor == 'w'){
            butt.setStyle("-fx-background-color: #b49646");
        }else {
            butt.setStyle("-fx-background-color: #785000");
        }
        gPane.add(butt, col, row, 1, 1);
    }

    public void setBuilder(BoardBuilder builder){
        this.builder = builder;
    }
}

