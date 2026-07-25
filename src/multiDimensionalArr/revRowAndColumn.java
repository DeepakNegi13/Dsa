package multiDimensionalArr;

public class revRowAndColumn {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,5},{2,5,7,8},{9,0,8,3}};
        //1,2,3,5
        //2,5,7,8
        //9,0,8,3
        for (int i = 0;i<arr.length;i++){
            int start = 0;
            int end = arr[0].length-1;
            while(start<end){
                int temp = arr[i][start];
                arr[i][start]=arr[i][end];
                arr[i][end]=temp;
                start++;
                end--;
            }
        }
        for (int i = 0;i<arr[0].length;i++){
            int start = 0;
            int end = arr.length-1;
            while(start<end){
                int temp = arr[start][i];
                arr[start][i]=arr[end][i];
                arr[end][i]=temp;
                start++;
                end--;
            }
        }
        for (int i = 0;i<arr.length;i++){
            for (int j = 0 ;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }





    }
}
