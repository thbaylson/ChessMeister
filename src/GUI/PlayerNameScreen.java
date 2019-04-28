package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 * Author: Tyler Baylson
 */
public class PlayerNameScreen extends VBox implements EventHandler<ActionEvent> {

    private static PlayerNameScreen instance;

    private ScreenChangeHandler GUI;

    private Button playButton;
    private Button exitButton;

    private PlayerNameScreen(){

        // Labels
        Label title;
        Label playerOneEnterName;
        Label playerTwoEnterName;

        // TextFields
        TextField playerOneName;
        TextField playerTwoName;

        // Sets alignment and spacing for the VBox
        setAlignment(Pos.CENTER);
        setSpacing(50);

        // Title of the screen
        title = new Label("Enter Player Names");
        title.setScaleX(4);
        title.setScaleY(4);

        // Player One Label
        playerOneEnterName = new Label("Player 1 Name");
        playerOneEnterName.setScaleX(3);
        playerOneEnterName.setScaleY(3);

        // Player One TextField
        playerOneName = new TextField();
        playerOneName.setMaxSize(200, 10);

        // Player Two Label
        playerTwoEnterName = new Label("Player 2 Name");
        playerTwoEnterName.setScaleX(3);
        playerTwoEnterName.setScaleY(3);

        // Player Two TextField
        playerTwoName = new TextField();
        playerTwoName.setMaxSize(200, 10);



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
                playerOneEnterName,
                playerOneName,
                playerTwoEnterName,
                playerTwoName,
                buttonHolder);
    }

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
