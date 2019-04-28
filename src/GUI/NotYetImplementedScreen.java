package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author Tyler Baylson
 */
public class NotYetImplementedScreen extends VBox implements EventHandler<ActionEvent>{

    /** Singleton instance of this object**/
    private static NotYetImplementedScreen instance;

    /** The observer pattern implementation**/
    private ScreenChangeHandler GUI;

    /** Private constructor, adheres to singleton pattern**/
    private NotYetImplementedScreen(){
        setAlignment(Pos.CENTER);
        setSpacing(50);

        // Label informing the user that this feature in not yet implemented
        Label label = new Label("Feature Not Yet Implemented");
        label.setScaleX(4);
        label.setScaleY(4);

        // The back button. Sends the user to the main menu
        Button btn = new Button("Back");// To make button text bigger, use CSS
        btn.setPrefSize(100, 50);
        btn.setOnAction(this);

        getChildren().addAll(label, btn);
    }//End NotYetImplementedScreen Constructor

    /**
     * handle- Handles button press
     * @param ae The ActionEvent to be handled
     */
    public void handle(ActionEvent ae){
        System.out.println("NotYetImplementedAction: Back");
        GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
    }//End handle()

    /**
     * register- Registers an observer
     * @param gui An object that can handle screen changes. Here, this is Gui
     */
    void register(ScreenChangeHandler gui){
        this.GUI = gui;
    }//End register()

    /**
     * getInstance- Returns a singleton instance of 'this'
     * @return An instance of this screen
     */
    static NotYetImplementedScreen getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new NotYetImplementedScreen();
            return instance;
        }//End if/else
    }//End getInstance()
}//End NotYetImplemented Class