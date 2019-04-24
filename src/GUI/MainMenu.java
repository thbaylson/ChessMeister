package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * @author Caleb Tupone
 */
public class MainMenu extends VBox implements EventHandler<ActionEvent>{

    private static MainMenu mainMenu;

    Button twoPlayerButton;
    Button cpuPlayerButton;
    Button onlinePlayButton;
    Button rulesButton;
    Button tutorialButton;


    ScreenChangeHandler sch;

    private MainMenu() {


        setAlignment(Pos.CENTER);
        setSpacing(50);

        //Add a button to the root.
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
        Button btn = new Button();
        btn.setPrefHeight(30);
        btn.setPrefWidth(200);
        btn.setText(text);
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }

    @Override
    public void handle(ActionEvent event) {

        if(event.getSource() == twoPlayerButton){
            sch.switchScreen(ScreenChangeHandler.Screens.GAMESCREEN);

        }
        else if(event.getSource() == cpuPlayerButton){
            //sch.switchUI(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == onlinePlayButton){
            //sch.switchUI(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == rulesButton){
            //sch.switchUI(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }
        else if(event.getSource() == tutorialButton){
            //sch.switchUI(ScreenChangeHandler.Screens.NOTYETIMPLEMENTED);
        }

    }

    /**Get a singleton instance of this class**/
    static MainMenu getInstance(){
        if(mainMenu == null)
            mainMenu = new MainMenu();

        return mainMenu;
    }

    void register(ScreenChangeHandler screen){
        sch = screen;
    }

}
