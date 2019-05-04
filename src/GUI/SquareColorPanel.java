package GUI;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * This is a panel that has a label and a button
 * @author Caleb Tupone 100%
 */
public class SquareColorPanel extends HBox{

    /**The botton of the panel**/
    private Button coloredButton;
    /**The color of the button**/
    private String selectedColor;

    /**
     * This creates a panel that has a label and a button
     * @param desc the text to put for the label
     */
    SquareColorPanel(String desc){
        Label title = new Label(desc);
        title = new Label(desc);
        title.getStyleClass().add("my-label");
        getChildren().add(title);
        coloredButton = addButton(this, "");
        setSpacing(10);

    }

    /**
     * This method adds the button to the panel
     * @param pane the panel to add to
     * @param text the text for the button
     * @return the new button
     */
    private Button addButton(Pane pane, String text){
        Button btn = new Button(text);
        btn.setPrefSize(50, 20);
        pane.getChildren().add(btn);
        return btn;
    }

    /**
     * This is used to change the color fo the button
     * @param colorSelection the hexvalue to change the color to
     */
    void setColorOfButton(String colorSelection){
        selectedColor = colorSelection;
        coloredButton.setStyle("-fx-background-color: #"+ colorSelection);
    }

    /**
     * This is used to get the selected color of the button
     * @return the selected color
     */
    String getColor(){
        return selectedColor;
    }

    /**
     * this is used to reference the button
     * @return the colored button
     */
    public Button getColoredButton(){
        return this.coloredButton;
    }

}
