package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * This class is used to accept the players names
 * @author: Tyler Baylson 95%
 * @author: Caleb Tupone 5% getPlayerName
 */
public class PlayerNameEntry extends VBox {



    /** The input text field where players will enter their names**/
    private TextField name;

    /**
     * The PlayerNameEntry object seen in PlayerNameScreen. This holds the
     * information of the players' names
     * @param playerName
     */
    PlayerNameEntry(String playerName){
        getStyleClass().add("vertical-group");

        Label title = new Label(playerName);
        title.getStyleClass().add("header");

        name = new TextField("NoName");
        name.setAlignment(Pos.CENTER);
        name.setMaxSize(200.0, 10.0);

        getChildren().addAll(title, name);
    }

    String getPlayerName(){
        return name.getText();
    }

}
