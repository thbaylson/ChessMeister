package GUI;

import Interfaces.SquareColorHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SquareColorPanel extends HBox{


    private Button coloredButton;
    private String selectedColor;


    SquareColorPanel(String desc){
        Label title = new Label(desc);
        getChildren().add(title);
        coloredButton = addButton(this, "");
        setSpacing(10);

    }

    /**
     *
     * @param pane
     * @param text
     * @return
     */
    private Button addButton(Pane pane, String text){
        Button btn = new Button(text);
        btn.setPrefSize(50, 20);
        pane.getChildren().add(btn);
        return btn;
    }


    void setColorOfButton(String colorSelection){
        selectedColor = colorSelection;
        coloredButton.setStyle("-fx-background-color: #"+ colorSelection);
    }

    String getColor(){
        return selectedColor;
    }


    public Button getColoredButton(){
        return this.coloredButton;
    }

}
