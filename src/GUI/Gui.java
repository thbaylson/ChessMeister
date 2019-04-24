package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

            MainMenu.getInstance().register(this);

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

        switch(screen){
            case MAINMENU:
                root = MainMenu.getInstance();

                break;
            case GAMESCREEN:
                //GameScreen gs = GameScreen.getInstance();

                //root = gs;
                break;
            case OPTIONS:
                //root = new optionMenu();
                break;
            case NOTYETIMPLEMENTED:
                //root = notYetImplementedScreen.getInstance();
        }

        //Change the screen
        if(scene == null)
            scene = new Scene(root,WIDTH,HEIGHT);
        else
            scene.setRoot(root);

    }
}
