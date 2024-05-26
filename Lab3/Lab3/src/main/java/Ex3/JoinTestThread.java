package Ex3;

public class JoinTestThread extends Thread {
    Thread t;

    String name;

    JoinTestThread(String n, Thread t){

        this.setName(n);

        this.t=t;

        name=this.getName();
    }

    public void run() {

        System.out.println("Thread "+name+" has entered the run() method");

        try {

            if (t != null) t.join();

            System.out.println("Thread "+name+" executing operation.");

            Thread.sleep(3000);

            System.out.println("Thread "+name+" has terminated operation.");

        }

        catch(Exception e){e.printStackTrace();}

    }
}
