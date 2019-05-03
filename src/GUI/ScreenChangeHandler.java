package GUI;

/**
 * @author Caleb Tupone
 */
public interface ScreenChangeHandler {

    enum Screens {MAINMENU, GAMESCREEN, OPTIONS, NOTYETIMPLEMENTED,
        PLAYERNAMESCREEN, SQUARECOLORCHOOSER}


    /**Sub screens must call this to switch screen.
     * @param screen The screen to show**/
    void switchScreen(Screens screen);
}
