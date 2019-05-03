package GUI;

import Interfaces.BoardBuilderInterface;
import Interfaces.BoardIF;
import Interfaces.PieceIF;
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

    public BoardButton(BoardBuilderInterface builder){
        this.builder = builder;
        butt = new Button();
        butt.setMaxSize(47, 45);
        butt.setMinSize(47,45);
        this.setCenter(butt);
        butt.pressedProperty().addListener(PressedListener);
    }

    ChangeListener<Boolean> PressedListener = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue) {
                if (piece != null) {
                    builder.showMoves(piece);
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
        System.out.println(background);
    }
}
