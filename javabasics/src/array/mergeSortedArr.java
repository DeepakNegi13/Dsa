package array;

public class mergeSortedArr {
    public static void main(String[] args) {
        int[]  arr1 = {1,2,34,45,56,78,89,99};
        int[]  arr2 = {1,2,35,46,57,68,98,99};
        int n1 = arr1.length, n2 = arr2.length;
        int[] arr3 = new int[n1+n2];
        int i = 0, j = 0 , k = 0;
        while(i<n1 || j<n2){
            if(i<n1 && j<n2){
                if (arr1[i]<arr2[j]){
                    arr3[k]=arr1[i];
                    i++;
                    k++;
                }else if (arr1[i]>arr2[j]){
                    arr3[k]=arr2[j];
                    j++;
                    k++;
                }else if (arr1[i]==arr2[j]){
                    arr3[k]=arr2[j];
                    j++;
                    k++;
                    arr3[k]=arr1[i];
                    i++;
                    k++;
                }
            }
            if (i>=n1 && j<n2){
                arr3[k]=arr2[j];
                j++;
                k++;
            }
            if (j>=n2 && i<n1){
                arr3[k]=arr2[i];
                i++;
                k++;
            }
        }
        for (int l = 0;l<n1+n2;l++){
            System.out.print(arr3[l]+" ");
        }
    }
}
