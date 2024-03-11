package Ex2;

public class Main {
    public static void main(String[] args) {
        int [][]matrix1={{2,3,1},{7,1,6},{9,2,4}};
        int [][]matrix2={{8,5,3},{3,9,2},{2,7,3}};
        int [][]result= new int[3][3];
        int [][]resultMult= new int[3][3];

        System.out.println("Result of addition: ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++){
                result[i][j]=matrix1[i][j]+matrix2[i][j];
                System.out.print(result[i][j]  + " " );
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        System.out.println("Result of multiplication: ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++){
                for (int k=0;k<3;k++) {

                    resultMult[i][j] += matrix1[i][k] * matrix2[k][j];

                }
                System.out.print(+resultMult[i][j] + " ");
            }
            System.out.println();
        }

    }
}
