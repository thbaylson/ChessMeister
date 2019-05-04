package GUI;

import Interfaces.ScreenChangeHandler;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Caleb Tupone 85%
 * @author Tyler Baylson 15% CSS
 */
public class Gui extends Application implements ScreenChangeHandler {

    static final int WIDTH = 800, HEIGHT = 800;

    private static Gui instance;

    private Pane root;

    private Scene scene;

    /**
     * start- Sets the primary stage and registers screens to observe
     * @param primaryStage The stage that will represent the application's
     *                     primary window
     */
    @Override
    public void start(Stage primaryStage) {
        try{
            //primaryStage.setResizable(false);
            switchScreen(Screens.MAINMENU);

            MainMenuScreen.getInstance().register(this);
            NotYetImplementedScreen.getInstance().register(this);
            PlayerNameScreen.getInstance().register(this);
            GameScreen.getInstance().register(this);
            OptionsScreen.getInstance().register(this);
            SquareColorChooser.getInstance().register(this);



            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(instance == null)
            instance = this;
    }

    /**
     * Calls launch
     * @param args Command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }

    /**
     * When called by a screen, this will change the root to a new screen
     * @param screen The screen to show
     */
    @Override
    public void switchScreen(Screens screen) {

        switch (screen) {
            case MAINMENU:
                root = MainMenuScreen.getInstance();
                break;
            case PLAYERNAMESCREEN:
                root = PlayerNameScreen.getInstance();
                break;
            case GAMESCREEN:
                root = GameScreen.getInstance();
                break;
            case OPTIONS:
                root = OptionsScreen.getInstance();
                break;
            case NOTYETIMPLEMENTED:
                root = NotYetImplementedScreen.getInstance();
                break;
            case SQUARECOLORCHOOSER:
                root = SquareColorChooser.getInstance();
                break;
        }

        //Change the screen
        if (scene == null)
            scene = new Scene(root, WIDTH, HEIGHT);
        else
            scene.setRoot(root);
    }


}
