package GUI;

import Enums.GameColor;
import Interfaces.PieceIF;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;


/**
 * Objects representing each players captured pieces
 *
 * @author Zach 60% PlayerPane
 * @author Dillon 40% addChildren getPlayer
 */
public class PlayerPane extends VBox {

    /**The player*/
    private int player;
    /**Tile pane containing captured pieces*/
    private TilePane capturedPieces;
    /**Array of images*/
    private ArrayList<ImageView> iArray;

    /**
     * Constructor for  PlayerPane
     * @param playerNumber - The player number
     */
    public PlayerPane(int playerNumber){
        this.player = playerNumber;
        iArray = new ArrayList<>();
        setPrefSize(200, 400);
        setSpacing(40);
        Label title = new Label("Player " + playerNumber);
        title.getStyleClass().add("my-label");
        title.setPadding(new Insets(20,0,0,0));
        title.setScaleX(1.2);
        title.setScaleY(1.2);

        Label playerName = new Label("P" + playerNumber);
        playerName.getStyleClass().add("my-label");
        playerName.setPadding(new Insets(0,0,40,0));
        playerName.setAlignment(Pos.CENTER_RIGHT);
        playerName.setScaleX(1.2);
        playerName.setScaleY(1.2);

        Label capturedLabel = new Label("Captured:");
        capturedLabel.getStyleClass().add("my-label");
        capturedLabel.setScaleX(1.2);
        capturedLabel.setScaleY(1.2);

        capturedPieces = new TilePane();
        capturedPieces.setPrefColumns(2);
        capturedPieces.setMaxHeight(30);
        capturedPieces.setMinWidth(10);

        getChildren().addAll(
                title,
                playerName,
                capturedLabel,
                capturedPieces);
    }

    /**
     * Adds pieces to the captured area
     * @param pieces - The pieces to add
     */
    public void addChilden(ArrayList<PieceIF> pieces){
        capturedPieces.getChildren().removeAll(iArray);
        iArray = new ArrayList<>();
        for (PieceIF piece : pieces){
            ImageView image = null;
            if (piece != null) {
                switch (piece.getChessPieceType()) {
                    case King:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WK.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BK.png")));
                        }
                        break;
                    case Queen:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WQ.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BQ.png")));
                        }
                        break;
                    case Rook:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WR.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BR.png")));
                        }
                        break;
                    case Knight:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WN.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BN.png")));
                        }
                        break;
                    case Bishop:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WB.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BB.png")));
                        }
                        break;
                    case Pawn:
                        if (piece.getColor() == GameColor.WHITE) {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/WP.png")));
                        } else {
                            image = new ImageView(new Image(getClass().getResourceAsStream("./images/BP.png")));
                        }
                        break;
                }
            }
            if (image != null) {
                image.setFitHeight(capturedPieces.getMaxHeight());
                image.setFitWidth(capturedPieces.getMaxWidth());
                iArray.add(image);
            }
        }
        capturedPieces.getChildren().addAll(iArray);
    }

    /**
     * Gets the player number
     * @return The player's number
     */
    public int getPlayer(){
        return player;
    }
}
