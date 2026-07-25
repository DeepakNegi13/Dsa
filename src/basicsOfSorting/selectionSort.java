package basicsOfSorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] nums = { 1,23,0,45,98,345,65,78,23};
        int n = nums.length;
        for (int i = 0;i<n-1;i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i ;j<n; j++){
                if (nums[j]<min){
                    min = nums[j];
                    index = j;
                }

            }
            int temp = nums[i];
            nums[i]=min;
            nums[index]=temp;
        }

        for (int i = 0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
