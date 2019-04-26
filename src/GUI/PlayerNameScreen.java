package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 * Author: Tyler Baylson
 */
public class PlayerNameScreen extends VBox implements EventHandler<ActionEvent> {

    private static PlayerNameScreen instance;

    private ScreenChangeHandler GUI;

    private Label title;
    private Label playerOneEnterName;
    private Label playerTwoEnterName;

    private TextField playerOneName;
    private TextField playerTwoName;

    private Button playButton;
    private Button exitButton;

    private PlayerNameScreen(){

        setAlignment(Pos.CENTER);
        setSpacing(50);

        // Title of the screen
        title = new Label("Enter Player Names");
        title.setScaleX(4);
        title.setScaleY(4);

        // Player One Label
        playerOneEnterName = new Label("Player 1 Name");
        title.setScaleX(3);
        title.setScaleY(3);

        // Player One TextField
        playerOneName = new TextField();
        playerOneName.setPrefSize(500, 10);

        // Player Two Label
        playerTwoEnterName = new Label("Player 2 Name");
        title.setScaleX(3);
        title.setScaleY(3);

        // Player Two TextField
        playerTwoName = new TextField();
        playerTwoName.setPrefSize(500, 10);

        HBox buttonHolder = new HBox();

        // The back button
        playButton = new Button("Play");
        playButton.setPrefSize(100, 50);
        playButton.setOnAction(this);

        // The back button
        exitButton = new Button("Back");
        exitButton.setPrefSize(100, 50);
        exitButton.setOnAction(this);

        buttonHolder.getChildren().addAll(playButton, exitButton);

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
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }
    }

    public static PlayerNameScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new PlayerNameScreen();
            return instance;
        }
    }

    public void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }

}
