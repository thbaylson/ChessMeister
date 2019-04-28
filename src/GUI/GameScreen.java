package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;

/**
 * Author: Tyler Baylson
 */
public class GameScreen extends BorderPane implements EventHandler<ActionEvent> {

    private static GameScreen instance;
    private ScreenChangeHandler GUI;

    private GameScreen(){
        setHeaderBar();
        setPlayerOnePane();
        setPlayerTwoPane();
        setBoard();
        SetFooterBar();
    }

    private void setHeaderBar() {
    }

    private void setPlayerOnePane() {
    }

    private void setPlayerTwoPane() {
    }

    private void setBoard() {
    }

    private void SetFooterBar() {
    }

    @Override
    public void handle(ActionEvent event) {

    }

    void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }

    static GameScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new GameScreen();
            return instance;
        }
    }
}
