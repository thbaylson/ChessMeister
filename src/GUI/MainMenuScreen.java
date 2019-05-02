package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * @author Caleb Tupone
 */
public class MainMenuScreen extends BorderPane implements EventHandler<ActionEvent>{

    private static MainMenuScreen instance;

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


    ScreenChangeHandler GUI;

    private MainMenuScreen() {

        settingsAndExit = new HBox();
        centerButtonList = new VBox();

        title = new Label("Chess-Meister");
        title.setScaleX(8);
        title.setScaleY(8);
        title.setPadding(new Insets(25,0,0,0));

        //Add buttons to the root.
        twoPlayerButton = addButton(centerButtonList, "Player vs Player");
        cpuPlayerButton = addButton(centerButtonList, "Player vs CPU");
        onlinePlayButton = addButton(centerButtonList, "Online Play");
        rulesButton = addButton(centerButtonList, "Rules of chess");
        tutorialButton = addButton(centerButtonList, "Tutorial");

        settingsButton = addButton(settingsAndExit, "Settings");
        exitButton = addButton(settingsAndExit, "Exit");

        setTop(title);
        setAlignment(title, Pos.CENTER);
        setCenter(centerButtonList);
        setBottom(settingsAndExit);
    }

    /**
     *
     */
    private void createButtons(){
        //Add a button to the root.
        twoPlayerButton = addButton(centerButtonList, "Player vs Player");
        cpuPlayerButton = addButton(centerButtonList, "Player vs CPU");
        onlinePlayButton = addButton(centerButtonList, "Online Play");
        rulesButton = addButton(centerButtonList, "Rules of chess");
        tutorialButton = addButton(centerButtonList, "Tutorial");

        settingsButton = addButton(settingsAndExit, "Settings");
        exitButton = addButton(settingsAndExit, "Exit");
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
            GUI.switchScreen(ScreenChangeHandler.Screens.PLAYERNAMESCREEN);
        }
        else if(event.getSource() == cpuPlayerButton){
            System.out.println("MainMenu: Player vs CPU");
            GUI.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == onlinePlayButton){
            System.out.println("MainMenu: Online");
            GUI.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == rulesButton){
            System.out.println("MainMenu: Rules");
            GUI.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == tutorialButton){
            System.out.println("MainMenu: Tutorial");
            GUI.switchScreen(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == exitButton){
            System.out.println("MainMenu: Exit");
            System.exit(0);
        }
        else if(event.getSource() == settingsButton){
            GUI.switchScreen(ScreenChangeHandler.Screens.OPTIONS);
        }

    }

    /**Get a singleton instance of this class**/
    static MainMenuScreen getInstance(){
        if(instance == null)
            instance = new MainMenuScreen();

        return instance;
    }

    void register(ScreenChangeHandler screen){
        GUI = screen;
    }

}
