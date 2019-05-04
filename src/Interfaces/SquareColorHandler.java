package Interfaces;

/**
 * This is used to created an observer pattern for listening for color change
 * @author Caleb Tupone 100%
 */
public interface SquareColorHandler {

    /**
     * A method that will change colors
     * @param color the hexvalue to change the color to
     */
    void changeColor(String color);

}
