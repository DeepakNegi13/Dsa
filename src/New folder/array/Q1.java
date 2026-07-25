package array;

public class Q1 {
    static void main(String[] args) {
        int[] arr = {1, 2, 3, 56, 5};
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += 10;
            } else {
                arr[i] *= 2;
            }
        }
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }
}
