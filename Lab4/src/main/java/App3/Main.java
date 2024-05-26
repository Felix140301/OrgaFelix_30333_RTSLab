package App3;



public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Monitor monitor2 = new Monitor();

        new ExecutionThread(monitor,monitor2,4, 4, 2, 4).start();
        new ExecutionThread(monitor2,monitor, 5, 5, 2, 5).start();
    }
}
