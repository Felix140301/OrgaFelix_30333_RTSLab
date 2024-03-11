package org.example;
import java.util.*;

public class Model extends Observable {

    private int id;
    private int val;

    public void setId(int id) {
        this.id = id;
    }

    public void setVal(int val) {

        setChanged();
        notifyObservers();
        this.val = val;

    }

    public int getId() {
        return id;
    }

    public int getVal() {
        return val;
    }
}
