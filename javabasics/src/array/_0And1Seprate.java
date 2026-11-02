package array;

public class _0And1Seprate {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,0,0};
        int n = arr.length;
        int noOf0= 0;
        int noOf1= 0;
//      two pass solution
//        for (int i =0;i<n;i++){
//            if (arr[i]==0){
//                noOf0++;
//            }else {
//                noOf1++;
//            }
//        }
//        for (int i = 0;i<n;i++){
//            if (i<noOf0) arr[i]=0;
//            else  arr[i]=1;
//        }


        // two pointers technique
        int i = 0;
        int j = n-1;
        while(i<j){
            if (arr[i]==1 && arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
                i++;
                j--;
            }else if (arr[i]==0 && arr[j]==1){
                i++;
                j--;
            }else if (arr[i]==0 && arr[j]==0){
                i++;
            }else if (arr[i]==1 && arr[j]==1){
                j--;

            }
        }






//        for (int i = 1;i<n;i++){
//            boolean flag = true;
//            for (int j = 0 ;j<n-1;j++){
//                if (arr[j]==1 && arr[j+1]==0){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1]=temp;
//                    flag = false;
//
//                }
//            }
//            if (flag){
//                break;
//            }
//        }
        for (int k = 0 ;k<n ;k++){
            System.out.print(arr[k]+" ");
        }
    }
}
