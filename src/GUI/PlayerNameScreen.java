package GUI;

import Interfaces.ScreenChangeHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Author: Tyler Baylson
 */
public class PlayerNameScreen extends BorderPane implements EventHandler<ActionEvent> {

    private static PlayerNameScreen instance;

    private ScreenChangeHandler GUI;

    private Button playButton;
    private Button exitButton;

    private PlayerNameScreen(){
        getStyleClass().add("menu");

        VBox centerView = new VBox();
        centerView.getStyleClass().add("vertical-group");

        HBox bottomView = new HBox();
        bottomView.getStyleClass().add("horizontal-group");

        // Title of the screen
        Label title = new Label("Enter Player Names");
        title.getStyleClass().add("title");
        setAlignment(title, Pos.CENTER);

        // Player Entries
        PlayerNameEntry playerOneName = new PlayerNameEntry("Player 1 Name");
        PlayerNameEntry playerTwoName = new PlayerNameEntry("Player 2 Name");
        centerView.getChildren().addAll(playerOneName, playerTwoName);

        // The play button
        playButton = new Button("Play");
        playButton.getStyleClass().add("button");
        playButton.setOnAction(this);

        // The back button
        exitButton = new Button("Back");
        exitButton.getStyleClass().add("button");
        exitButton.setOnAction(this);

        bottomView.getChildren().addAll(playButton, exitButton);

        setTop(title);
        setCenter(centerView);
        setBottom(bottomView);
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
