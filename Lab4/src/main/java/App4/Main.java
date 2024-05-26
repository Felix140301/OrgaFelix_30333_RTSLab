package App4;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Monitor monitor = new Monitor(1);
        Monitor monitor2 = new Monitor(2);

        NotifierThread notifierThread = new NotifierThread(monitor, monitor2);
        ExecutionThread executionThread1 = new ExecutionThread(monitor, 3, 4, 2, 4);
        ExecutionThread executionThread2 = new ExecutionThread(monitor2, 3, 5, 5, 2);

        notifierThread.start();
        executionThread1.start();
        executionThread2.start();

        executionThread2.join();
        executionThread1.join();
        notifierThread.join();

        System.out.println("The threads joined");
    }
}
