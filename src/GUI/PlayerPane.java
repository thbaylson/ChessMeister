package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerPane extends VBox {

    public PlayerPane(int playerNumber){
        setPrefSize(200, 400);
        Label title = new Label("Player " + playerNumber);
        title.setScaleX(1.5);
        title.setScaleY(1.5);

        Label playerName = new Label("P" + playerNumber);
        playerName.setAlignment(Pos.CENTER_RIGHT);
        playerName.setScaleX(1.5);
        playerName.setScaleY(1.5);

        Label capturedLabel = new Label("Captured:");
        capturedLabel.setScaleX(1.5);
        capturedLabel.setScaleY(1.5);

        HBox capturedPieces = new HBox();

        getChildren().addAll(
                title,
                playerName,
                capturedLabel,
                capturedPieces);
    }
}
