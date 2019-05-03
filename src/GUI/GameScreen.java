package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

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
        //getStyleClass().add("menu");

        setPrefSize(800, 800);
        setPadding(new Insets(20,20,20,20));
        //This needs to be created here before setPlayerPane call
        exitButton = new Button("Exit");
        exitButton.setOnAction(this);

        setHeaderBar();
        setPlayerPane(1);
        setPlayerPane(2);

        setBoard();
        SetFooterBar();
    }//End GameScreen Constructor

    /**
     * The header bar that contains various buttons for different actions.
     * Actions include: load game, save game, undo move,
     * redo move, and open settings window.
     */
    private void setHeaderBar() {
        HBox tabs = new HBox(50);
        tabs.setMinSize(800, 50);
        tabs.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tabs.setAlignment(Pos.CENTER);

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

    /**
     * Sets the left and right player panes for players one and two
     * @param player The number representation of the player, ie: 1 for player
     *               one and 2 for player two.
     */
    private void setPlayerPane(int player) {
        VBox container = new VBox();
        container.getChildren().add(new PlayerPane(player));
        if(player == 1){
            //container.getChildren().add(showButton);
            setLeft(container);
        }else{
            container.getChildren().add(exitButton);
            setRight(container);
        }
    }//End setPlayerOnePane

    /**
     * The board on which players will play on. This may need to be its own class
     */
    private void setBoard() {
        TilePane board = new TilePane();
        board.setMinSize(400, 500);
        board.setMaxSize(400, 500);
        board.setPrefColumns(8);
        board.setHgap(1);
        board.setVgap(1);

        Button tmp;
        for(int i = 0; i < 64; i++){
            tmp = new Button("0");
            tmp.setPrefSize(45, 45);
            board.getChildren().add(tmp);
        }

        setCenter(board);
    }//End setBoard

    /**
     * The bottom of the screen that will display info about the game
     */
    private void SetFooterBar() {
        HBox container = new HBox();
        container.setAlignment(Pos.TOP_CENTER);
        Label info = new Label("GameStart");
        info.getStyleClass().add("label");
        info.setScaleX(1.5);
        info.setScaleY(1.5);

        container.getChildren().add(info);
        setBottom(container);
    }//End SetFooterBar

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == exitButton) {
            System.out.println("GameScreen: Exit");
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == loadButton) {
            System.out.println("GameScreen: Load");
            //GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == saveButton) {
            System.out.println("GameScreen: Save");
            //GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == undoButton) {
            System.out.println("GameScreen: Undo");
            //GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == redoButton) {
            System.out.println("GameScreen: Redo");
            //GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        }else if(event.getSource() == settingsButton) {
            System.out.println("GameScreen: Settings");
            //GUI.switchScreen(ScreenChangeHandler.Screens.SETTINGS);
        }//End if/else
    }//End handle()

    void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }//End register()

    static GameScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new GameScreen();
            return instance;
        }
    }//End getInstance()
}//End GameScreen Class