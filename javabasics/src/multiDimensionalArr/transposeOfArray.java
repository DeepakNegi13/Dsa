package multiDimensionalArr;

public class transposeOfArray {
    public static void print(int[][] arr) {
        for (int m = 0;m<arr.length;m++){
            for (int n = 0 ;n<arr[0].length;n++){
                System.out.print(arr[m][n]+" ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,5},{2,5,7,8},{9,0,8,3},{1,2,3,4}};
        // 1,2,3,5
        // 2,5,7,8
        // 9,0,8,3
        // 1,2,3,4
        int i =0;
        int j =-1;
        while (i<arr[0].length){
            j++;
            int k = j;
            while (k<arr.length){
                int temp = arr[i][k];
                arr[i][k]=arr[k][i];
                arr[k][i]=temp;
                k++;
            }
            i++;
        }
        print(arr);

    }
}
