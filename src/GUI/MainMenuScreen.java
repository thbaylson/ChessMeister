package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import sun.plugin.javascript.navig.Anchor;

/**
 * @author Caleb Tupone
 */
public class MainMenuScreen extends BorderPane implements EventHandler<ActionEvent>{

    private static MainMenuScreen mainMenuScreen;

    HBox settingsAndExit;

    VBox centerButtonList;

    Label title;

    Button twoPlayerButton;
    Button cpuPlayerButton;
    Button onlinePlayButton;
    Button rulesButton;
    Button tutorialButton;
    Button settingsButton;
    Button exitButton;


    ScreenChangeHandler sch;

    private MainMenuScreen() {

        settingsAndExit = new HBox();
        centerButtonList = new VBox();

        title = new Label("Chess-Meister");
        title.setScaleX(8);
        title.setScaleY(8);
        title.setPadding(new Insets(25,0,0,0));

        //Add a button to the root.
        twoPlayerButton = addButton(centerButtonList, "Player vs Player");
        cpuPlayerButton = addButton(centerButtonList, "Player vs CPU");
        onlinePlayButton = addButton(centerButtonList, "Online Play");
        rulesButton = addButton(centerButtonList, "Rules of chess");
        tutorialButton = addButton(centerButtonList, "Tutorial");
        centerButtonList.setAlignment(Pos.CENTER);
        centerButtonList.setSpacing(50);

        settingsButton = addButton(settingsAndExit, "Settings");
        exitButton = addButton(settingsAndExit, "Exit");
        settingsAndExit.setAlignment(Pos.TOP_CENTER);
        settingsAndExit.setSpacing(200);
        settingsAndExit.setPadding(new Insets(0, 0, 50, 0));

        setTop(title);
        setAlignment(title, Pos.CENTER);
        setCenter(centerButtonList);
        setBottom(settingsAndExit);
    }

    /**
     * Allows for rapid creation of similar buttons
     * @param pane the current pane
     * @param text the text to be assigned to the button
     * @return returns a button
     */
    private Button addButton(Pane pane, String text){
        Button btn = new Button(text);
        btn.setPrefSize(200, 30);
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }

    @Override
    public void handle(ActionEvent event) {

        if(event.getSource() == twoPlayerButton){
            System.out.println("MainMenu: Player vs Player");
            sch.switchScreen(ScreenChangeHandler.Screens.PLAYERNAMESCREEN);
        }
        else if(event.getSource() == cpuPlayerButton){
            sch.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == onlinePlayButton){
            sch.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == rulesButton){
            sch.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == tutorialButton){
            sch.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }

    }

    /**Get a singleton instance of this class**/
    static MainMenuScreen getInstance(){
        if(mainMenuScreen == null)
            mainMenuScreen = new MainMenuScreen();

        return mainMenuScreen;
    }

    void register(ScreenChangeHandler screen){
        sch = screen;
    }

}
