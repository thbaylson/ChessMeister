package Interfaces;

/**
 * This method is used to create and observer pattern to change screens
 * @author Caleb Tupone 100%
 */
public interface ScreenChangeHandler {
    /**
     * A list of all the screens this application can access.
     */
    enum Screens {MAINMENU, GAMESCREEN, OPTIONS, NOTYETIMPLEMENTED,
        PLAYERNAMESCREEN, SQUARECOLORCHOOSER}


    /**Sub screens must call this to switch screen.
     * @param screen The screen to show**/
    void switchScreen(Screens screen);
}
