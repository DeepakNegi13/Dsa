package OOPS;

import java.util.ArrayList;

class Arraylist<Integer>{
    private int[] arr;
    private int idx;
    private int capacity;
    private int size;
    // constructor1
    Arraylist(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }
    //constructor2
    Arraylist(){
        arr = new int[10];
    }


    //increasing the capacity of arr
    private  void incSize(){
        int[] arr2 = new int[2*capacity];
        int i = 0;
        for (int ele : arr){
            arr2[i] = ele;
            i++;
        }
        this.arr = arr2;
    }

    //add the element in arraylist
    void add(int ele){
        if(idx==capacity) incSize();
        arr[idx++] = ele;
        size++;
    }

    //get the element in index number idx
    int get(int idx){
        return arr[idx];
    }

    // get the element in first index number idx
    int getfirst(){
        return arr[0];
    }

    // get the size of the element
    int size(){
        return size;
    }

    // get the capacity of the element
    int capacity (){
        return capacity;
    }

    // is element inside the arr or not
    boolean contains(int ele){
        for (int i = 0;i<size;i++){
            if(arr[i]==ele) return true;
        }
        return false;
    }
    int indexOf(int ele){
        for(int i = 0;i<size;i++){
            if(arr[i]==ele) return i;
        }
        return -1;
    }

    //check two array are equals or not
    boolean equals(Arraylist<Integer> arr2){
        if (this.size != arr2.size()) return false;
        for (int i = 0;i<this.size;i++){
            if (arr[i]!=arr2.get(i)) return false;
        }
        return true;
    }

    public void print() {
        for (int i = 0;i<size;i++) {
            if (i==0) System.out.print("[ ");
            System.out.print(arr[i]+", ");
            if (i==size-1) System.out.print("]");

        }
    }
}
public class UserDefinedDataStructure {
    public static void main(String[] args) {
        //original arraylist
        ArrayList<Integer> orgArr = new ArrayList<>(10);


        //my arraylist
        Arraylist<Integer> arr = new Arraylist<>(10);
        arr.add(3);arr.add(4);arr.add(5);arr.add(6);arr.add(3);arr.add(8);arr.add(1);arr.add(0);arr.add(9);
        arr.add(3);arr.add(4);arr.add(5);arr.add(6);arr.add(3);arr.add(8);arr.add(1);arr.add(0);arr.add(9);

        Arraylist<Integer> arr2 = new Arraylist<>(10);
        arr2.add(3);arr2.add(4);arr2.add(5);arr2.add(6);arr2.add(3);arr2.add(8);arr2.add(1);arr2.add(0);arr2.add(9);
        arr2.add(3);arr2.add(4);arr2.add(5);arr2.add(6);arr2.add(3);arr2.add(8);arr2.add(1);arr2.add(0);arr2.add(9);

        System.out.println(arr.get(4));
        System.out.println(arr.get(4));
        System.out.println(arr.size());
        System.out.println(arr.capacity());
        System.out.println(arr.contains(0));
        System.out.println(arr.contains(78));
        System.out.println(arr.indexOf(0));
        arr.print();

        String str = new String("deepak"+"negi");
        String str1 = new String("deepak"+"negi");

        System.out.println(str.equals(str1));

    }
}
