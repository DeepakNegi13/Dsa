package loops;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class numOfDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number ");
        int num = sc.nextInt();
//        int j=1;
//        for (int i = 1;num>0  ;i++){
//            num=num/10;
//            j=i;
//            if (num==0){
//                break;
//            }
//        }
//        System.out.println(j);
        int i = 0;
        while (num!=0){
            i++;
            num=num/10;

        }
        System.out.println(i);






    }

}
