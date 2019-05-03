package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MaxNumOfUndoPanel extends HBox {

    private Label title;
    private TextField numofUndos;

    MaxNumOfUndoPanel(String desc){
        this.title = new Label(desc);

        numofUndos = new TextField("0");
        getChildren().addAll(title, numofUndos);
        setSpacing(10);
    }
}
