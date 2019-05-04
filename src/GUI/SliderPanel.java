package GUI;


import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * This class is used to create a panel with a slider, textfield, and label
 * @author Caleb Tupone 100% (with help from the homework)
 */
public class SliderPanel extends VBox {

    /** the title of the slider**/
    private Label title;
    /** the valueTitle of the slider**/
    private Label valueTitle;
    /** the value in the box above the slider**/
    private TextField value;
    /** the slider functionality**/
    private Slider slider;
    /** the minimum value allowed**/
    private int min;
    /** the maximum value allowed**/
    private int max;




    /**
     * Construct a slider
     * @param titleText The title of the slider.
     * @param initVal The initial value of the slider.
     * @param min The minimum value on the slider.
     * @param max The maximum value on  the slider
     */
    public SliderPanel(String titleText, int initVal, int min , int max){

        this.min = min;
        this.max = max;

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);


        title = new Label(titleText);
        valueTitle = new Label("value");
        value = new TextField(initVal+"");
        slider = new Slider();
        slider.setOrientation(Orientation.VERTICAL);


        this.getChildren().add(title);
        this.getChildren().add(valueTitle);
        this.getChildren().add(value);
        this.getChildren().add(slider);


        slider.setMin(min);
        slider.setMax(max);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(max);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);

        slider.valueProperty().addListener(valueChangeListener);
        value.textProperty().addListener(textValueChangeListener);


    }


    /**
     * This sets the new value
     * @param newValue the new value read from the slider
     */
    public void set(int newValue){
        value.setText(newValue+"");
        slider.setValue(newValue);



    }

    /**
     * This method returns the value of the slider in the form of an int
     * @return
     */
    public int getValue(){
        return (int) slider.getValue();
    }//end getValue


    ChangeListener<Number> valueChangeListener = new ChangeListener<Number>(){

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            if(!oldValue.equals(newValue))
                set(newValue.intValue());

        }

    };

    ChangeListener<String> textValueChangeListener = new ChangeListener<String>(){

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            // TODO Auto-generated method stub
            if(!oldValue.equals(newValue)){
                try{
                    int n = Integer.parseInt(newValue);
                    set(n);
                }
                catch(NumberFormatException ex){

                }

            }

        }
    };

    /**
     * returns a double from the slider
     * @return the double value that the slider is currently set at
     */
    public DoubleProperty getSliderNumber(){
        return slider.valueProperty();
    }





}//end SliderPanel
