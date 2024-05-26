package App3;

public class Monitor {

    int active = 1;

    public synchronized void consume() {

        if (active == 1)
            active = 0;

    }

    public synchronized void generate() {

        if (active == 0)
            active = 1;
    }

}
