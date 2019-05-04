package GUI;

import Enums.GameColor;
import Interfaces.BoardManagerInterface;
import Interfaces.PieceIF;
import Model.Position;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * A object representing each square on the chess board as a button
 *
 * @author Dillon Ramsey 100%
 */
public class BoardButton extends BorderPane {

    /**The piece on the square*/
    private PieceIF piece;
    /**The image of the piece*/
    private ImageView image;
    /**The Board Manager*/
    private BoardManagerInterface builder;
    /**The button that represents the square*/
    private Button butt;
    /**If the square is highlighted*/
    private boolean highlighted;
    /**The position of the square*/
    private Position pos;

    /**
     * The constructor for the BoardButton
     *
     * @param builder - The BoardManager for the board
     */
    public BoardButton(BoardManagerInterface builder){
        this.builder = builder;
        butt = new Button();
        butt.setMaxSize(47, 45);
        butt.setMinSize(47,45);
        this.setCenter(butt);
        butt.pressedProperty().addListener(PressedListener);
        this.highlighted = false;
        this.pos = null;
    }

    /**
     * Listener for when the button in pressed
     */
    ChangeListener<Boolean> PressedListener = new ChangeListener<Boolean>() {
        @Override
        /**
         * Updates the board according to what square was pressed
         */
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue) {
                if (highlighted) {
                    builder.movePiece(pos);
                    builder.switchTurn();
                }else if (piece != null){
                    if ((piece.getColor()==GameColor.BLACK&&builder.getTurn())||(piece.getColor()==GameColor.WHITE&&!builder.getTurn())) {
                        builder.showMoves(piece);
                    } else {
                        builder.reDraw();
                    }
                }else{
                    builder.reDraw();
                }
            }
        }
    };

    /**
     * Sets the piece on the square
     * @param piece - The piece on the square
     */
    public void setPiece(PieceIF piece){
        this.piece = piece;
    }

    /**
     * Sets the image of the piece on the square
     * @param image - The image of the piece
     */
    public void setImage(ImageView image){
        this.image = image;
        image.setFitWidth(butt.getMaxWidth());
        image.setFitHeight(butt.getMaxHeight());
        butt.setGraphic(image);
    }

    /**
     * Sets the background color of the square
     * @param background - The color to set the square
     */
    public void setBackground(String background){
        butt.setStyle(background);
    }

    /**
     * Sets if the square is highlighted
     * @param highlighted - If the square is highlighted
     */
    public void setHighlighted(boolean highlighted){
        this.highlighted = highlighted;
    }

    /**
     * Sets the position of the square
     * @param pos - The position of the square
     */
    public void setPosition(Position pos){
        this.pos = pos;
    }
}
