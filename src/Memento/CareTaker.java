package Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker<T> {

    /**A pointer for the currently selected memento*/
    private int pointer = 0;

    /**A list of the previous states of the chess board*/
    private List<Memento<T>> mementoList = new ArrayList<>();

    /**
     * Adds a memento to the mementoList
     *
     * @param state - The memento to add to the list
     */
    public void add(Memento<T> state){
        mementoList.add(pointer, state);//Adds a memento to the list
        pointer++;
        //Remove any memento ahead of the recently added one
        for (int i = pointer+1; i < mementoList.size(); i++){
            mementoList.remove(i);
        }
    }

    /**
     * Gets the memento at the specified spot in the mementoList
     *
     * @param index - The index of the memento to get
     * @return The desired memento
     */
    public Memento<T> get(int index){
        pointer = index;
        return mementoList.get(pointer);//gets memento
    }

    /**
     * Gets the memento at the current pointer location
     *
     * @return The memento at the current pointer location
     */
    public Memento<T> get(){
        pointer = pointer - 2;
        Memento<T> mem = this.mementoList.get(pointer);//gets memento
        pointer++;
        return mem;
    }

    /**
     * Goes forward in the mementoList if there has been one or more
     * undos performed
     *
     * @return Returns the memento that was most recently undone or null
     * if there is no mementos to redo
     */
    public Memento<T> redo(){
        if (pointer >= mementoList.size()){//Checks there is mementos to redo
            return null;
        }else{
            Memento<T> mem = mementoList.get(pointer);//gets memento4
            pointer++;
            return mem;
        }
    }
}
