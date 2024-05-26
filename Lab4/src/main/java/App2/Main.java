package App2;


public class Main {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();


        new ExecutionThread(monitor, 5, 2, 3, 6).start();
        new ExecutionThread(monitor, 3, 3, 4, 7).start();
        new ExecutionThread(monitor, 6, 6, 5, 7).start();

    }

}
