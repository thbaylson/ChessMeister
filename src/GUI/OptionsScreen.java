package GUI;

import Model.Square;
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

public class OptionsScreen extends BorderPane implements
        EventHandler<ActionEvent>, SquareColorHandler{

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

    SquareColorPanel blackSquareField;
    SquareColorPanel whiteSquareField;

    int currentButton;


    private CheckBox showMoves;
    private CheckBox enabled;
    private CheckBox unlimitedUndo;
    private TextField maxUndo;


    private OptionsScreen(){


        setTitle();
        setCenterSection(setLeftSide(), setRightSide());
        SquareColorChooser.getInstance().colorRegister(this);






    }

//    /**
//     *
//     * @param labelText
//     * @return
//     */
//    private HBox maxUndoNumCreator(String labelText){
//        maxUndoNum = new HBox(25);
//        Label desc = new Label(labelText);
//        maxUndoNum.getChildren().addAll(desc);
//
//
//        return maxUndoNum;
//    }

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
     *
     */
    private VBox setLeftSide() {
        leftSide = new VBox();

        colors = new Label("Colors:");
        colors.getStyleClass().add("my-label");

        blackSquareField = new SquareColorPanel("Black Squares: ");
        blackSquareField.getStyleClass().add("my-label");

        whiteSquareField = new SquareColorPanel("White Squares: ");
        whiteSquareField.getStyleClass().add("my-label");

        blackSquareField.getColoredButton().setOnAction(this);
        whiteSquareField.getColoredButton().setOnAction(this);

        undo = new Label("Undo");
        undo.getStyleClass().add("my-label");

        leftSide.setAlignment(Pos.CENTER_LEFT);
        enabled = new CheckBox("Enabled");
        enabled.getStyleClass().add("my-label");

        unlimitedUndo = new CheckBox("Unlimited Undo");
        unlimitedUndo.getStyleClass().add("my-label");


        maxUndo = new TextField();

        leftSide.getChildren().addAll(colors, blackSquareField,
                whiteSquareField, undo, enabled, unlimitedUndo, maxUndo);
        leftSide.setSpacing(20);

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
        btn.setPrefWidth(100);
        btn.setOnAction(this);
        pane.getChildren().add(btn);
        return btn;
    }


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

    /**Get a singleton instance of this class**/
    static OptionsScreen getInstance(){
        if(instance == null)
            instance = new OptionsScreen();

        return instance;
    }

    void register(ScreenChangeHandler screen){
        GUI = screen;
    }


    @Override
    public void changeColor(String color) {
        if (currentButton == 0)
            whiteSquareField.setColorOfButton(color);
        else{
            blackSquareField.setColorOfButton(color);
        }
    }
}
