package Example3Modified;

class JoinTestThread extends Thread {

    int sum;
    int num;

    JoinTestThread t;

    JoinTestThread(String n, JoinTestThread t, int num) {

        this.num = num;

        this.setName(n);

        this.t = t;

    }

    public int determineDivisor(int num) {

        int count = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                count = count + 2;
            }
        }
        return count;
    }

    public void run() {

        System.out.println("Thread " + this.getName() + " has entered the run() method");

        try {
            synchronized (this) {
            if (t != null) {
                t.join();
                sum = t.sum;
            }

                System.out.println("Thread " + this.getName() + " executing operation.");

                sum += determineDivisor(num);

                System.out.println("Thread " + this.getName() + " has terminated operation.");

                System.out.println("The number of divisiors is: " + sum);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
