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

    private PlayerNameEntry playerOneName;
    private PlayerNameEntry playerTwoName;

    private String playerOneField;
    private String playerTwoField;

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
        playerOneName = new PlayerNameEntry("Player 1 Name");
        playerTwoName = new PlayerNameEntry("Player 2 Name");
        playerOneField = playerOneName.getPlayerName();
        playerTwoField = playerTwoName.getPlayerName();
        centerView.getChildren().addAll(playerOneName, playerTwoName);

        // The play button
        playButton = new Button("Play");
        playButton.getStyleClass().add("my-button");
        playButton.setOnAction(this);

        // The back button
        exitButton = new Button("Back");
        exitButton.getStyleClass().add("my-button");
        exitButton.setOnAction(this);

        bottomView.getChildren().addAll(playButton, exitButton);

        setTop(title);
        setLeft(MainMenuScreen.getImage("king"));
        setRight(MainMenuScreen.getImage("queen"));
        setCenter(centerView);
        setBottom(bottomView);
    }


    public void handle(ActionEvent event){
        boolean isCorrectLengthP1 = false;
        boolean isCorrectLengthP2 = false;

        if(event.getSource() == exitButton){
            System.out.println("PlayerNameScreen: Back");
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == playButton){
            System.out.println("PlayerNameScreen: Play");
            if(isCorrectLengthP1 == false){
                if(!(playerOneName.getPlayerName().length() <= 12)){
                    System.out.println("Player one's name is too long, " +
                            "must be no more than 12 characters");

                }
                else{
                    playerOneField = playerOneName.getPlayerName();
                    isCorrectLengthP1 = true;
                }
            }
            if(isCorrectLengthP2 == false){
                if(!(playerTwoName.getPlayerName().length() <= 12)){
                    System.out.println("Player two's name is too long, " +
                            "must be no more than 12 characters");

                }
                else{
                    playerTwoField = playerTwoName.getPlayerName();
                    isCorrectLengthP2 = true;
                }
            }


            if (isCorrectLengthP1 && isCorrectLengthP2){
                GameScreen.getInstance().setPlayerPane(1);
                GameScreen.getInstance().setPlayerPane(2);
                GUI.switchScreen(ScreenChangeHandler.Screens.GAMESCREEN);
            }

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

    public String getPlayerOneField() {
        return playerOneField;
    }

    public String getPlayerTwoField() {
        return playerTwoField;
    }

}
