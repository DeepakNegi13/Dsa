package sorting;

public class sorting {
    public static void main(String[] args) {
        int[] arr = {1,3,7,4,2,8,9,5,3,66,45,34,6,0,0,7,7,7,9,8,7,6,5,5,4,3,3,3,3,4,5,2,2,3,4,5,6,7,8,9,0,8,8,7,6,5,4,3,2,3,3,4,5,6,6,7,9,9,0,97,1,5,3,6,54,55,7,8,7,9,8,7,7,6,7,6,6,6,6,6,5,4,4,3,3,3,4,4,5,6,6,3,7,8,7,6,6,5,5,6,2,3,4,5,6,7,8,8,9,0,8,8,87,8,7,7,7,6,6,6,6,7,5,5,4,4,3,34,5,5,6,7,7,7,6,6,6,6,6,6,66,};
        boolean flag = false;
        //bubble sort (assending order)
        for(int i = 0;i<arr.length;i++){
            int swap = 0;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            if (swap == 0) break;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
//        in descending order
        for(int i = 0;i<arr.length;i++){
            int swap = 0;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            if (swap == 0) break;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
