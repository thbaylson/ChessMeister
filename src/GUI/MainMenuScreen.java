package GUI;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import Interfaces.ScreenChangeHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Caleb Tupone 85%
 * @author Tyler Baylson 15% CSS
 */
public class MainMenuScreen extends BorderPane implements EventHandler<ActionEvent>{

    /** The singleton instance of this class**/
    private static MainMenuScreen instance;

    /** A container for the settings and exit buttons**/
    private HBox settingsAndExit;

    /** A container for the main menu buttons**/
    private VBox centerButtonList;

    /** The title of the screen**/
    private Label title;

    /** All of the buttons of the main menu screen**/
    private Button twoPlayerButton;
    private Button cpuPlayerButton;
    private Button onlinePlayButton;
    private Button rulesButton;
    private Button tutorialButton;
    private Button settingsButton;
    private Button exitButton;

    /** An observer to listen to screen change requests**/
    private ScreenChangeHandler GUI;

    /**
     * Creates a MainMenuScreen object. This is the first screen players see
     * upon starting the GUI
     */
    private MainMenuScreen() {
        getStyleClass().add("menu");

        centerButtonList = new VBox();
        centerButtonList.getStyleClass().add("vertical-group");

        settingsAndExit = new HBox();
        settingsAndExit.getStyleClass().add("horizontal-group");

        title = new Label("Chess-Meister");
        title.getStyleClass().add("title");
        setAlignment(title, Pos.CENTER);

        //Add buttons to the root.
        createButtons();

        setTop(title);
        setLeft(getImage("king"));
        setRight(getImage("queen"));
        setCenter(centerButtonList);
        setBottom(settingsAndExit);
    }

    /**
     * createButtons- A helper method to organize the creation of buttons in the scene
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
        btn.getStyleClass().add("my-button");
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }

    /**
     * getImage- Given king or gueen, will return a Pane object containing the
     * ImageView of that chess piece.
     * @param image king or queen, this represents the desired picture piece
     * @return A pane with a chess piece image as a child of the pane
     */
    public static Pane getImage(String image){
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
        picture.setPrefWidth(200);
        return picture;
    }

    /**
     * handle- Handles a series of button presses. Handles player vs player,
     * player vs cpu, online, rules, tutorial, exit, settings
     * @param event The ActionEvent to be handled
     */
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
            System.out.println("MainMenu: Options");
            GUI.switchScreen(ScreenChangeHandler.Screens.OPTIONS);
        }

    }

    /**
     * getInstance- Gets a singleton instance of this class
     * @return a singleton instance of this class
     */
    static MainMenuScreen getInstance(){
        if(instance == null)
            instance = new MainMenuScreen();

        return instance;
    }

    /**
     * register- Registers the Gui screen change handler as an observer
     * @param screen An observer
     */
    void register(ScreenChangeHandler screen){
        GUI = screen;
    }

}
