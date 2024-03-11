package org.example;

import java.util.*;

public class Controller extends Thread implements Observer {

    Model model;
    View view;
    private int processorLoad;

    Controller(int id, int priority, Model model, View view, int procLoad) {

        this.model = model;

        this.view = view;

        this.processorLoad = procLoad;

        this.setPriority(priority);

        this.setThreadId(id);

        model.addObserver(this);
    }

    public void setThreadId(int id) {
        model.setId(id);
    }

    public int getThreadId() {
        return model.getId();
    }

    public void setThreadVal(int val) {
        model.setVal(val);
    }

    public int getThreadVal() {
        return model.getVal();
    }

    public void run() {

        int c = 0;

        while (c < 1000) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            c++;
            setThreadVal(c);

        }
    }

    @Override
    public void update(Observable o, Object arg) {

        this.view.setProgressValue(getThreadId(), getThreadVal());
    }
}

