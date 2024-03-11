package org.example;
import  java.util.Scanner;
public class Main{


    public static void main(String[] args) {

        Number x = new Number();
        Number y = new Number();
         int choice ;


          Scanner keyboard=new Scanner(System.in);

          System.out.println("Enter the real part of the x and y Numbers");

        System.out.print("x= " );
        x.setReal(keyboard.nextInt());
        System.out.print("y= " );
        y.setReal(keyboard.nextInt());

        System.out.println("Enter the imaginary part of the x and y Numbers");


        System.out.print("x= " );
        x.setImag(keyboard.nextInt());
        System.out.print("y= " );
        y.setImag(keyboard.nextInt());


        System.out.println("Please chose 1 for Addition 2 for Subtraction 3 for Multiplication");

        choice=keyboard.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("The result of the Addition is: "+ (x.getReal()+y.getReal()) + " + " + (x.getImag()+y.getImag()) +"i");
                break;
            }
            case 2: {
                System.out.println("The result of the Subtraction is: "+ (x.getReal()+y.getReal()) + " + " + "("+(x.getImag()-y.getImag()) +"i" +")") ;
                break;
            }
            case 3: {
                System.out.println("The result of the Multiplication is: "+ (x.getReal()*y.getReal() - x.getImag()* y.getImag() ) + " + " + "("+(x.getReal()*y.getImag() + x.getImag()* y.getReal()) +"i" +")");
                break;
            }

        }
    }
}