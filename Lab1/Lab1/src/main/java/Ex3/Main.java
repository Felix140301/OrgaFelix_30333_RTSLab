package Ex3;
import  java.util.Random;
public class Main {
    public static void main(String[] args) {
Random rand=new Random();
        int []array=new int[10];
        for (int i=0;i<10;i++){
            array[i]=rand.nextInt(25);
            System.out.print(array[i]+" ");
        }
        System.out.println();

        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        for (int i=0;i<10;i++){

            System.out.print(array[i]+" ");
        }
    }
}




