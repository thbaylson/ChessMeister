package GUI;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
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
            switchScreen(Screens.MAINMENU);

            MainMenuScreen.getInstance().register(this);
            NotYetImplementedScreen.getInstance().register(this);
            PlayerNameScreen.getInstance().register(this);
            GameScreen.getInstance().register(this);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

        if(instance == null)
            instance = this;


        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

    }

    public static Gui getInstance(){
        return instance;
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
                //root = new OptionMenu.getInstance();
                break;
            case NOTYETIMPLEMENTED:
                root = NotYetImplementedScreen.getInstance();
                break;
        }

        //Change the screen
        if (scene == null)
            scene = new Scene(root, WIDTH, HEIGHT);
        else
            scene.setRoot(root);
    }
}
