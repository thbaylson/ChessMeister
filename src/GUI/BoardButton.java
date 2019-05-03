package GUI;

import Enums.GameColor;
import Interfaces.BoardBuilderInterface;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
import Model.Position;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class BoardButton extends BorderPane {

    private PieceIF piece;

    private ImageView image;

    private BoardBuilderInterface builder;

    private Button butt;

    private boolean highlighted;

    private Position pos;

    public BoardButton(BoardBuilderInterface builder){
        this.builder = builder;
        butt = new Button();
        butt.setMaxSize(47, 45);
        butt.setMinSize(47,45);
        this.setCenter(butt);
        butt.pressedProperty().addListener(PressedListener);
        this.highlighted = false;
        this.pos = null;
    }

    ChangeListener<Boolean> PressedListener = new ChangeListener<Boolean>() {
        @Override
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

    public void setPiece(PieceIF piece){
        this.piece = piece;
    }

    public void setImage(ImageView image){
        this.image = image;
        image.setFitWidth(butt.getMaxWidth());
        image.setFitHeight(butt.getMaxHeight());
        butt.setGraphic(image);
    }

    public void setBackground(String background){
        butt.setStyle(background);
    }

    public void setHighlighted(boolean highlighted){
        this.highlighted = highlighted;
    }

    public void setPosition(Position pos){
        this.pos = pos;
    }
}
