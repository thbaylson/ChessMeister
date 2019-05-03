package GUI;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Caleb Tupone
 */
public class Gui extends Application implements ScreenChangeHandler {

    static final int WIDTH = 800, HEIGHT = 800;

    private static Gui instance;

    private Pane root;

    private Scene scene;


    @Override
    public void start(Stage primaryStage) {
        try{
            primaryStage.setResizable(false);
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


    public static void main(String[] args) {
       launch(args);
    }



    public void startGui(String[] args){
        main(args);
    }

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
