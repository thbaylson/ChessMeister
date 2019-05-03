package GUI;

import Interfaces.ScreenChangeHandler;
import Interfaces.SquareColorHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

/**A simple color chooser using three SliderPanes**/
public class SquareColorChooser extends GridPane implements EventHandler<ActionEvent> /*Any more needed??*/ {

    /**
     * The selected color as a hex value (RGB)
     **/
    String selectedColor;

    /**
     * Red color slider panel
     **/
    private SliderPanel red;

    /**
     * Green color slider panel
     **/
    private SliderPanel green;

    /**
     * Blue color slider panel
     **/
    private SliderPanel blue;

    private Button select;

    private Button exit;

    StackPane color;


    /**
     * Maximum color intensity
     **/
    private final int MAX_INTEN = 255;

    /**
     * Minimum color intensity
     **/
    private final int MIN_INTEN = 0;

    ScreenChangeHandler sch;

    SquareColorHandler squareColor;


    /**
     * The singleton instance of this class
     **/
    private static SquareColorChooser instance;


    /**
     * Create a singleton instance of a ColorChooser
     **/
    public static SquareColorChooser getInstance() {
        if (instance == null) instance = new SquareColorChooser();
        return instance;
    }//end getInstance

    /**
     * Construct a color chooser.
     */
    private SquareColorChooser() {


        this.setVgap(20);

        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(40);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(50);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);

        this.getRowConstraints().addAll(row0, row1, row2);
        this.getColumnConstraints().addAll(col0, col1);


        color = new StackPane();
        color.getStyleClass().add("color");
        setBackround(0, 0, 0);//set to black


        //Create Panel for sliders with centered layout
        HBox sliders = new HBox();
        sliders.setSpacing(20.0);
        sliders.setAlignment(Pos.TOP_CENTER);

        //Construct 3 sliders for RGB
        red = new SliderPanel("Red", MIN_INTEN, MIN_INTEN, MAX_INTEN);
        green = new SliderPanel("Green", MIN_INTEN, MIN_INTEN, MAX_INTEN);
        blue = new SliderPanel("Blue", MIN_INTEN, MIN_INTEN, MAX_INTEN);

        //Add the sliders
        sliders.getChildren().add(red);
        sliders.getChildren().add(green);
        sliders.getChildren().add(blue);


        select = new Button("Select");
        exit = new Button("Exit");
        select.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        exit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        sliders.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        color.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //col, row, colspan, rowspan
        this.add(color, 0, 0, 2, 1);
        this.add(sliders, 0, 1, 2, 1);
        this.add(exit, 0, 2, 1, 1);
        this.add(select, 1, 2, 1, 1);

        select.setOnAction(this);
        exit.setOnAction(this);


        red.getSliderNumber().addListener(sliderListener);
        green.getSliderNumber().addListener(sliderListener);
        blue.getSliderNumber().addListener(sliderListener);


    }//end constructor

    /**
     * Set the background color of the  chooser
     *
     * @param r The red intensity 0..255
     * @param g The blue intensity 0..255
     * @param b The green intensity 0..255
     */
    public void setBackround(int r, int g, int b) {
        //Avoid invalid values
        if (r > 255 || g > 255 || b > 255) return;

        String hr = Integer.toHexString(r);
        String hg = Integer.toHexString(g);
        String hb = Integer.toHexString(b);

        //Add preceeding 0 if only 1 char
        if (hr.length() == 1)
            hr = 0 + hr;
        if (hg.length() == 1)
            hg = 0 + hg;
        if (hb.length() == 1)
            hb = 0 + hb;

        selectedColor = hr + hg + hb;

        color.setStyle("-fx-background-color: #" + selectedColor);


    }

    /**
     * The method of the button EventHandler insterface implementation that this class has
     **/
    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == select) {
            squareColor.changeColor(selectedColor);
            sch.switchScreen(ScreenChangeHandler.Screens.OPTIONS);

        } else if (event.getSource() == exit) {
            sch.switchScreen(ScreenChangeHandler.Screens.OPTIONS);
        }
    }//end handle


    ChangeListener<Number> sliderListener = new ChangeListener<Number>() {


        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            setBackround(red.getValue(), green.getValue(), blue.getValue());
        }
    };

    void register(ScreenChangeHandler screen) {
        sch = screen;
    }

    void colorRegister(SquareColorHandler handler){
        squareColor = handler;
    }
}
