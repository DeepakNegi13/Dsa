package array;

public class MooresAlgorithem {
    public static void main(String[] args) {
        //MOORE'S VOTING ALGORITHEM
        //majority element are greater than [n/2]
        int[] arr = {1,34,2,2,3,3,9,0,0,0,8,8,7,2,2,2,2,5,6,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        int freq = 0;
        int num = 0;

        for(int i = 0;i<arr.length;i++){
            if(freq==0) num = arr[i];
            if(num==arr[i]) freq++;
            else freq--;
        }
        System.out.println(num);

    }
}
