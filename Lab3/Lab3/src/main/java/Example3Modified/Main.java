package Example3Modified;

public class Main {

    public static void main(String[] args){

        int sum=0;

        JoinTestThread w1 = new JoinTestThread("Thread 1",null, 60000);
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1,20000);

        w1.start();
        w2.start();



    }

}
