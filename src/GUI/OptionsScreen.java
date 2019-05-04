package GUI;

import Interfaces.BoardManagerInterface;
import Interfaces.ScreenChangeHandler;
import Interfaces.SquareColorHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This class is the options screen of the application
 * @author Caleb Tupone 90%
 * @author Tyler Baylson 10% CSS
 */
public class OptionsScreen extends BorderPane implements EventHandler<ActionEvent>, SquareColorHandler {

    /** The singleton instance of this class**/
    private static OptionsScreen instance;

    /** An observer to listen to screen change requests**/
    private ScreenChangeHandler GUI;

    private Button saveButton;
    private Button exitButton;

    private SquareColorPanel blackSquareField;
    private SquareColorPanel whiteSquareField;

    private String whiteSquareColor = "785000";
    private String blackSquareColor = "b49646";

    private int currentButton;

    private BoardManagerInterface bmi;



    /**
     * Creates an OptionsScreen object. Here lives all the settings
     * for the application
     */
    private OptionsScreen(){
        getStyleClass().add("menu");

        setTitle();
        setCenterSection(setLeftSide(), setRightSide());
        SquareColorChooser.getInstance().colorRegister(this);
    }

    /**
     * setCenterSection- A helper method to set the center of the border pane
     */
    private void setCenterSection(VBox leftSide, VBox rightSide) {

        HBox center = new HBox(350);
        center.getChildren().addAll(leftSide, rightSide);
        center.setAlignment(Pos.CENTER);

        setCenter(center);
    }


    /**
     * setRightSide- A helper method to set the right side of the border pane
     */
    private VBox setRightSide() {
        VBox rightSide = new VBox();

        CheckBox showMoves = new CheckBox("Show Moves");
        showMoves.getStyleClass().add("my-label");

        rightSide.getChildren().add(showMoves);

        saveButton = addButton(rightSide, "Save");
        exitButton = addButton(rightSide, "Exit");
        saveButton.getStyleClass().add("my-button");
        exitButton.getStyleClass().add("my-button");

        rightSide.setAlignment(Pos.CENTER);
        rightSide.setSpacing(20);

        return rightSide;
    }


    /**
     * setLeftSide- A helper method to set the left side of the border pane
     */
    private VBox setLeftSide() {
        VBox leftSide = new VBox();

        Label colors = new Label("Colors:");
        colors.getStyleClass().add("my-label");

        blackSquareField = new SquareColorPanel("Black Squares: ");
        whiteSquareField = new SquareColorPanel("White Squares: ");

        blackSquareField.getColoredButton().setOnAction(this);
        whiteSquareField.getColoredButton().setOnAction(this);

        Label undo = new Label("Undo");
        undo.getStyleClass().add("my-label");

        leftSide.setAlignment(Pos.CENTER_LEFT);
        CheckBox enabled = new CheckBox("Enabled");
        enabled.getStyleClass().add("my-label");

        CheckBox unlimitedUndo = new CheckBox("Unlimited Undo");
        unlimitedUndo.getStyleClass().add("my-label");


        MaxNumOfUndoPanel maxUndo = new MaxNumOfUndoPanel("Max num of undos");

        leftSide.getChildren().addAll(colors, blackSquareField,
                whiteSquareField, undo, enabled, unlimitedUndo, maxUndo);
        leftSide.setSpacing(20);

        return leftSide;


    }

    /**
     * setTitle- A helper method to set the top of the border pane
     */
    private void setTitle(){
        Label title = new Label("Settings");
        setTop(title);
        title.setScaleX(6);
        title.setScaleY(6);
        title.setPadding(new Insets(15,0,0,0));
        setAlignment(title, Pos.CENTER);

        setTop(title);
    }

    /**
     * Allows for rapid creation of similar buttons
     * @param pane the current pane
     * @param text the text to be assigned to the button
     * @return returns a button
     */
    private Button addButton(Pane pane, String text){
        Button btn = new Button(text);
        btn.setPrefWidth(100);
        btn.setOnAction(this);
        btn.setPrefSize(50, 20);
        pane.getChildren().add(btn);
        return btn;
    }


    /**
     * handle- Handles a series of button presses. Handles back, save,
     * whiteSquareField, and blackSquareField
     * @param event The ActionEvent to be handled
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == exitButton)
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        else if(event.getSource() == saveButton)
            System.out.println("Saving Options (Not Really)");
        else if(event.getSource() == whiteSquareField.getColoredButton()){
            currentButton = 0;
            GUI.switchScreen(ScreenChangeHandler.Screens.SQUARECOLORCHOOSER);

        }
        else if(event.getSource() == blackSquareField.getColoredButton()){
            currentButton = 1;
            GUI.switchScreen(ScreenChangeHandler.Screens.SQUARECOLORCHOOSER);
        }


    }

    /**
     * getInstance- Gets a singleton instance of this class
     * @return a singleton instance of this class
     */
    static OptionsScreen getInstance(){
        if(instance == null)
            instance = new OptionsScreen();

        return instance;
    }

    /**
     * register- Registers the Gui screen change handler as an observer
     * @param screen An observer
     */
    void register(ScreenChangeHandler screen){
        GUI = screen;
    }

    /**
     * changeColor- Changes the colors of the white or black SquareFields
     * @param color The color to change to
     */
    @Override
    public void changeColor(String color) {
        if (currentButton == 0) {
            whiteSquareField.setColorOfButton(color);
            whiteSquareColor = color;
            bmi.reDraw();
        }
        else{
            blackSquareField.setColorOfButton(color);
            blackSquareColor = color;
            bmi.reDraw();
        }
    }


    public String getWhiteSquareColor() {
        return whiteSquareColor;
    }

    public String getBlackSquareColor() {
        return blackSquareColor;
    }

    public void setManager(BoardManager manager){
        this.bmi = manager;
    }
}
