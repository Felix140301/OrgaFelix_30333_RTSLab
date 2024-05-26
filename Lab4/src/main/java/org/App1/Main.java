package org.example;

public class Main {

        public static void main(String[] args) {
            Integer monitor = new Integer(1);
            Integer monitor2 = new Integer(2);

            new ExecutionThread(monitor,null, 4, 4, 2, 4).start();
            new ExecutionThread(monitor,monitor2, 3, 3, 3, 6).start();
            new ExecutionThread(null,monitor2,5,5,2,5).start();
        }

}