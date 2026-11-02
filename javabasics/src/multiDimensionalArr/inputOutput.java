package multiDimensionalArr;
import java.util.Scanner;
public class inputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {{1,2,3,5},{2,5,7,8},{9,0,8,3}};
//        for (int i = 0;i<3;i++){
//            for (int j = 0 ;j<4;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }

        for (int i = 0;i<4;i++){
            for (int j = 0 ;j<3;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println("\n");
        }
        for (int i = 0;i<3;i++){
            for (int j = 0 ;j<4;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }
        for( int[] ele:arr){
            for (int a :ele){
                System.out.print(a+" ");

            }
            System.out.println();
        }



        int sum = 0;
        for (int i = 0 ;i<arr.length;i++){
            for (int j = 0 ;j<arr[0].length;j++){
                sum+=arr[i][j];
            }
        }
        System.out.println(sum);
        int max  = Integer.MIN_VALUE;
        for (int i = 0 ;i<arr.length;i++){
            for (int j = 0 ;j<arr[0].length;j++){
                max = Math.max(max,arr[i][j]);
            }
        }
        System.out.println("max value = "+max);
        max  = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0 ;i<arr.length;i++){
            int rowSum = 0;
            for (int j = 0 ;j<arr[0].length;j++){
                rowSum+=arr[i][j];
            }
            if (rowSum>max){
                row++;
            }
            max = Math.max(max,rowSum);
        }
        System.out.println("max row sum = "+max);
        System.out.println("row number of max sum = "+row);

    }
}
