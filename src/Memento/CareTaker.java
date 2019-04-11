package Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker<T> {

    /**A pointer for the currently selected memento*/
    private int pointer = -1;

    /**A list of the previous states of the chess board*/
    private List<Memento<T>> mementoList = new ArrayList<>();

    /**
     * Adds a memento to the mementoList
     *
     * @param state - The memento to add to the list
     */
    public void add(Memento<T> state){
        //Remove any mementos after the add
        List<Memento<T>> newList = new ArrayList<>();
        for (int i = 0; i <= pointer; i++){
            newList.add(mementoList.get(i));
        }
        mementoList = newList;
        mementoList.add(state);//add memento
        pointer++;
    }

    /**
     * Gets the memento at the specified spot in the mementoList
     *
     * @param index - The index of the memento to get
     * @return The desired memento
     */
    public Memento<T> get(int index){
        return mementoList.get(index);//gets memento
    }

    /**
     * undoes the memento at the current pointer location
     *
     * @return The memento at the current pointer location
     */
    public Memento<T> undo(){
        pointer --;
        return get(pointer);
    }

    /**
     * Goes forward in the mementoList if there has been one or more
     * undos performed
     *
     * @return Returns the memento that was most recently undone or null
     * if there is no mementos to redo
     */
    public Memento<T> redo(){
        if(pointer < mementoList.size() -1) {
            pointer++;
        }
        return get(pointer);
    }
}
