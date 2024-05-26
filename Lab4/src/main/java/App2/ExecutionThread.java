package App2;


public class ExecutionThread extends Thread {

    Monitor monitor;
    int sleep_min, sleep_max, activity_min, activity_max;


    public ExecutionThread(Monitor monitor, int sleep_min, int sleep_max, int activity_min, int activity_max) {

        this.monitor = monitor;

        this.sleep_min = sleep_min;

        this.sleep_max = sleep_max;

        this.activity_min = activity_min;

        this.activity_max = activity_max;

    }

    public void action(int activity_max, int activity_min) {

        synchronized (this) {
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
    }

    public void sleep(int sleep_max, int sleep_min) {

        synchronized (this) {
            try {
                Thread.sleep(Math.round(Math.random() * sleep_min) * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {

        while (true) {

            System.out.println(this.getName() + "is in State 1");

            synchronized (monitor) {

                this.action(activity_max,activity_min);
                System.out.println(this.getName() + "is in state 2");

            }

            System.out.println(this.getName() + "is in state 3");

            this.sleep(sleep_max,sleep_min);

            System.out.println(this.getName() + " is in state 4");



        }

    }
}
