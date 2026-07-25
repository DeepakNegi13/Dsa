package basicsOfSorting;

public class _0inRight {
    public static void main(String[] args) {
        int[] arr = {1,2,90,0,23,0,54,0,76,2,45,0,9,0,9};
        int n = arr.length;
//        for (int i = 1 ; i<=n-1;i++){
//            for (int j=0;j<n-i;j++){
//                if (arr[j]==0){
//                    int temp;
//                    temp = arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }



        int i = 0;
        for (int j = 0 ;j<n;j++){
            if (arr[j]!=0){
                if (i!=j){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                i++;
            }
        }
        for (int k = 0 ;k<n;k++){
            System.out.print(arr[k]+" ");
        }

    }
}
