package Memento;

/**
 * A Memento class that takes in the previous state of the chess board
 * and saves it so that it may later be returned.
 *
 * @author Dillon Ramsey 100% All
 * @version 1.0
 */
public class Memento<T> {
    /**A previous state of the board*/
    private T state;

    /**
     * Constructs a Memento using the previous state of the chess board
     *
     * @param state - The previous state of the chess board
     */
    public Memento(T state){
        this.state = state;
    }

    /**
     * Returns the previous state of the chess board saved in the memento
     *
     * @return The previous state of the chess board
     */
    public T getState(){
        return this.state;
    }
}
