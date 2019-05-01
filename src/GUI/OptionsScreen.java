package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.xml.soap.Text;

public class OptionsScreen extends BorderPane implements EventHandler<ActionEvent> {

    private static OptionsScreen instance;
    private ScreenChangeHandler GUI;

    private Label title;
    private Label colors;
    private Label undo;

    private HBox maxUndoNum;
    private HBox squareColorField;
    private HBox center;
    private VBox leftSide;
    private VBox rightSide;

    private Button saveButton;
    private Button exitButton;
//    private Button blackSquareButton;
//    private Button whiteSquareButton;

    private CheckBox showMoves;
    private CheckBox enabled;
    private CheckBox unlimitedUndo;
    private TextField maxUndo;


    private OptionsScreen(){


        setTitle();
        setCenterSection(setLeftSide(), setRightSide());




    }

    /**
     *
     * @param labelText
     * @return
     */
    private HBox squareColorCreator(String labelText){
        squareColorField = new HBox(25);
        Label desc = new Label(labelText);
        squareColorField.getChildren().addAll(desc);
        Button btn = addButton(squareColorField, "");


        return squareColorField;
    }

    /**
     *
     * @param labelText
     * @return
     */
    private HBox maxUndoNumCreator(String labelText){
        maxUndoNum = new HBox(25);
        Label desc = new Label(labelText);
        maxUndoNum.getChildren().addAll(desc);


        return maxUndoNum;
    }

    /**
     *
     */
    private void setCenterSection(VBox leftSide, VBox rightSide) {
        center = new HBox(350);
        center.getChildren().addAll(leftSide, rightSide);
        center.setAlignment(Pos.CENTER);

        setCenter(center);
    }


    /**
     *
     */
    private VBox setRightSide() {

        rightSide = new VBox();

        showMoves = new CheckBox("Show Moves");
        rightSide.getChildren().add(showMoves);

        saveButton = addButton(rightSide, "Save");
        exitButton = addButton(rightSide, "Exit");

        rightSide.setAlignment(Pos.CENTER);


        return rightSide;
    }


    /**
     *
     */
    private VBox setLeftSide() {

        leftSide = new VBox();

        colors = new Label("Colors:");
        HBox blackSquareField = squareColorCreator("Black Squares: ");
        HBox whiteSquareField = squareColorCreator("White Squares: ");


        undo = new Label("Undo");

        leftSide.setAlignment(Pos.CENTER_LEFT);
        enabled = new CheckBox("Enabled");
        unlimitedUndo = new CheckBox("Unlimited Undo");

        maxUndo = new TextField();

        leftSide.getChildren().addAll(colors, blackSquareField,
                whiteSquareField, undo, enabled, unlimitedUndo, maxUndo);


        return leftSide;


    }

    /**
     *
     */
    private void setTitle(){
        title = new Label("Settings");
        setTop(title);
        title.setScaleX(6);
        title.setScaleY(6);
        title.setPadding(new Insets(15,0,0,0));
        setAlignment(title, Pos.CENTER);
    }

    /**
     *
     * @param pane
     * @param text
     * @return
     */
    private Button addButton(Pane pane, String text){
        Button btn = new Button(text);
        btn.setPrefSize(30, 5);
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }


    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == exitButton)
            GUI.switchScreen(ScreenChangeHandler.Screens.MAINMENU);
        else if(event.getSource() == saveButton)
            System.out.println("Saving Game (Not Really)");

    }

    /**Get a singleton instance of this class**/
    static OptionsScreen getInstance(){
        if(instance == null)
            instance = new OptionsScreen();

        return instance;
    }

    void register(ScreenChangeHandler screen){
        GUI = screen;
    }



}
