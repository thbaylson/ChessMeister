package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author Caleb Tupone
 */
public class MainMenuScreen extends VBox implements EventHandler<ActionEvent>{

    private static MainMenuScreen mainMenuScreen;

    Label title;

    Button twoPlayerButton;
    Button cpuPlayerButton;
    Button onlinePlayButton;
    Button rulesButton;
    Button tutorialButton;


    ScreenChangeHandler sch;

    private MainMenuScreen() {
        title = new Label("Chess-Meister");
        title.setScaleX(8);
        title.setScaleY(8);
        title.setPadding(new Insets(0,0,30,0));

        getChildren().add(title);
        setAlignment(Pos.CENTER);
        setSpacing(50);

        //Add buttons to the root.
        twoPlayerButton = addButton(this, "Player vs Player");
        cpuPlayerButton = addButton(this, "Player vs CPU");
        onlinePlayButton = addButton(this, "Online Play");
        rulesButton = addButton(this, "Rules of chess");
        tutorialButton = addButton(this, "Tutorial");
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
