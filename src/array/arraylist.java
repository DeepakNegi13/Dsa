package array;

import java.util.ArrayList;
import java.util.List;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        int i = arr.size()-1;
        while(i>=0){
            if (arr.get(i)!=9){
                arr.set(i,arr.get(i)+1);
                break;
            }else{
                arr.set(i,0);
            }
            if (arr.getFirst()==0){
                arr.addFirst(1);
            }
            i--;

        }
        System.out.println(arr);
        


    }


}
