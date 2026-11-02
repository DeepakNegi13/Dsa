package forEachLoop;

public class basic {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        for (int element : arr){
            System.out.println(element + " ");
            // working
            // element ki copy element nam ke variable me gyi or print ho gyi
            //for each loop me elements ke sath iski madad se changes nahi kar sakte hai

        }
    }

}
