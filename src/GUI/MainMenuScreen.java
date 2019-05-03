package GUI;

import Interfaces.ScreenChangeHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Caleb Tupone
 */
public class MainMenuScreen extends BorderPane implements EventHandler<ActionEvent>{

    private static MainMenuScreen instance;

    private HBox settingsAndExit;

    private VBox centerButtonList;

    private Label title;

    private Button twoPlayerButton;
    private Button cpuPlayerButton;
    private Button onlinePlayButton;
    private Button rulesButton;
    private Button tutorialButton;
    private Button settingsButton;
    private Button exitButton;

    ScreenChangeHandler GUI;

    private MainMenuScreen() {
        getStyleClass().add("menu");

        centerButtonList = new VBox();
        centerButtonList.getStyleClass().add("vertical-group");

        settingsAndExit = new HBox();
        settingsAndExit.getStyleClass().add("horizontal-group");

        title = new Label("Chess-Meister");
        title.getStyleClass().add("title");
        setAlignment(title, Pos.CENTER);

        createButtons();


        setTop(title);
        setLeft(getImage("king"));
        setRight(getImage("queen"));
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
        btn.getStyleClass().add("button");
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }

    private Pane getImage(String image){
        Pane picture = new Pane();
        FileInputStream file;
        try{
            switch(image.toLowerCase()){
                case "king":
                    System.out.println(new File(".").getAbsolutePath());
                    file = new FileInputStream("images/WK_smooth.png");
                    picture.getChildren().add(new ImageView(new Image(file)));
                    break;
                case "queen":
                    file = new FileInputStream("./images/WQ_smooth.png");
                    picture.getChildren().add(new ImageView(new Image(file)));
                    break;
            }
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        picture.getStyleClass().add("image");
        return picture;
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
