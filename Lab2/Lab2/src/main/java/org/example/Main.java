package org.example;


public class Main {

    private static final int noOfThreads=2;

    private static final int processorLoad=1000000;

    public static void main(String args[]){

        View view=new View(noOfThreads);

        for(int i =0; i<noOfThreads; i++){
            Model model=new Model();
            new Controller(i,i+2, model, view,processorLoad).start();


        }

    }

}