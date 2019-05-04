package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * a HBox with a label and a textField
 * @author Caleb Tupone 100%
 */
public class MaxNumOfUndoPanel extends HBox {

    /**The text next to the textfield**/
    private Label title;

    /**
     * This constructor creates a HBox with a label and a textField
     * @param desc the text that is shown by the label
     */
    MaxNumOfUndoPanel(String desc){
        this.title = new Label(desc);

        TextField numOfUndos = new TextField("0");
        getChildren().addAll(title, numOfUndos);
        setSpacing(10);
    }
}
