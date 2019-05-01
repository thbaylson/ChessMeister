package GUI;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Author: Tyler Baylson
 */
public class PlayerNameScreen extends VBox implements EventHandler<ActionEvent> {

    private static PlayerNameScreen instance;

    private ScreenChangeHandler GUI;

    private Button playButton;
    private Button exitButton;

    private PlayerNameScreen(){
        getStyleClass().add("menu");

        // Name Entries
        Label title;
        PlayerNameEntry playerOneName;
        PlayerNameEntry playerTwoName;

        // Sets alignment and spacing for the VBox
        setAlignment(Pos.CENTER);
        setSpacing(50);

        // Title of the screen
        title = new Label("Enter Player Names");
        title.getStyleClass().add("label");
        title.setScaleX(4);
        title.setScaleY(4);

        // Player One Label
        playerOneName = new PlayerNameEntry("Player 1 Name");
        playerOneName.getStyleClass().add("label");

        // Player Two TextField
        playerTwoName = new PlayerNameEntry("Player 2 Name");
        playerTwoName.getStyleClass().add("label");

        // The back button
        playButton = new Button("Play");
        playButton.setPrefSize(100, 50);
        playButton.setOnAction(this);

        // The back button
        exitButton = new Button("Back");
        exitButton.setPrefSize(100, 50);
        exitButton.setOnAction(this);

        // This will hold the bottom two buttons
        BorderPane buttonHolder = new BorderPane();
        buttonHolder.setPadding(new Insets(0,25,0,125));
        buttonHolder.setCenter(playButton);
        buttonHolder.setRight(exitButton);

        getChildren().addAll(title,
                playerOneName,
                playerTwoName,
                buttonHolder);
    }

    ChangeListener<String> ch = new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

        }
    };

    public void handle(ActionEvent event){
        if(event.getSource() == exitButton){
            System.out.println("PlayerNameScreen: Back");
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == playButton){
            System.out.println("PlayerNameScreen: Play");
            GUI.switchScreen(ScreenChangeHandler.Screens.GAMESCREEN);
        }
    }

    static PlayerNameScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new PlayerNameScreen();
            return instance;
        }
    }

    void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }

}
