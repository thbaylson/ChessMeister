package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MaxNumOfUndoPanel extends HBox {

    private Label title;


    MaxNumOfUndoPanel(String desc){
        this.title = new Label(desc);

        TextField numOfUndos = new TextField("0");
        getChildren().addAll(title, numOfUndos);
        setSpacing(10);
    }
}
