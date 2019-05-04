package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Author: Tyler Baylson
 */
public class PlayerNameEntry extends VBox {

    private TextField name;

    PlayerNameEntry(String playerName){
        getStyleClass().add("vertical-group");
        //setAlignment(Pos.CENTER);

        Label title = new Label(playerName);
        title.getStyleClass().add("header");

        name = new TextField("NoName");
        //name.setText();
        name.setAlignment(Pos.CENTER);
        name.setMaxSize(200.0, 10.0);

        getChildren().addAll(title, name);
    }

    String getPlayerName(){
        return name.getText();
    }

    void setPlayerName(String text){
        name.setText(text);
    }
}
