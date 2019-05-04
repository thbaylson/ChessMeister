package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerPane extends VBox {

    private Label playerName;

    public PlayerPane(int playerNumber){
        setPrefSize(200, 400);
        setSpacing(40);
        Label title = new Label("Player " + playerNumber);
        title.getStyleClass().add("my-label");
        title.setPadding(new Insets(20,0,0,0));
        title.setScaleX(1.5);
        title.setScaleY(1.5);

        if (playerNumber == 1){
            playerName = new Label(PlayerNameScreen.getInstance().getPlayerOneField());
        }
        else {
            playerName = new Label(PlayerNameScreen.getInstance().getPlayerTwoField());
        }

        playerName.getStyleClass().add("my-label");
        playerName.setPadding(new Insets(0,0,40,0));
        playerName.setAlignment(Pos.CENTER_RIGHT);
        playerName.setScaleX(1.5);
        playerName.setScaleY(1.5);

        Label capturedLabel = new Label("Captured:");
        capturedLabel.getStyleClass().add("my-label");
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
