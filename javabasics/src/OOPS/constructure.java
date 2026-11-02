package OOPS;
import java.util.Scanner;
class bio{
    String name;
    int age ;
    String bloodGroup;
    //constructor overloading
    bio(String s,int i ,String c){
        name = s;
        age = i;
        bloodGroup = c;
    }
    bio(){

    }
}
public class constructure {


    public static void main(String[] args) {
        bio s = new bio("deepak",19,"A+");
        System.out.println(s.age);
        System.out.println(s.bloodGroup);
        System.out.println(s.name);

    }
}
