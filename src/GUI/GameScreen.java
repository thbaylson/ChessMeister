package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;

/**
 * Author: Tyler Baylson
 */
public class GameScreen extends BorderPane implements EventHandler<ActionEvent> {

    private static GameScreen instance;
    private ScreenChangeHandler GUI;

    private Button exitButton;
    private Button loadButton;
    private Button saveButton;
    private Button undoButton;
    private Button redoButton;
    private Button settingsButton;

    private GameScreen(){
        setHeaderBar();
        setPlayerOnePane(1);
        setPlayerOnePane(2);

        //Below Player 2 Pane, but not apart of it
        exitButton = new Button("Exit");
        exitButton.setOnAction(this);
        setRight(exitButton);

        setBoard();
        SetFooterBar();
    }//End GameScreen Constructor

    private void setHeaderBar() {
        HBox tabs = new HBox();
        tabs.setAlignment(Pos.CENTER);
        tabs.setSpacing(50);

        loadButton = new Button("Load");
        saveButton = new Button("Save");
        undoButton = new Button("Undo");
        redoButton = new Button("Redo");
        settingsButton = new Button("Settings");

        tabs.getChildren().addAll(
                loadButton,
                saveButton,
                undoButton,
                redoButton,
                settingsButton);

        //tabs.setMinWidth(Double.MAX_VALUE);
        setTop(tabs);
    }//End setHeaderBar

    private void setPlayerOnePane(int player) {
        HBox playerInfo = new HBox();
        Label title = new Label("Player " + player);
        Label playerName = new Label("P" + player);

    }//End setPlayerOnePane

    private void setBoard() {
    }//End setBoard

    private void SetFooterBar() {
    }//End SetFooterBar

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == exitButton) {
            System.out.println("PlayerNameScreen: Back");
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }// End if
    }// End handle()

    void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }// End register()

    static GameScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new GameScreen();
            return instance;
        }
    }//End getInstance()
}//End GameScreen Class
