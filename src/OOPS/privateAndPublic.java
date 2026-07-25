package OOPS;
class Student{
    String name;
    private int rollnum = 56;
    double cgpa;
    void getrollnum(){
        System.out.println(rollnum);
    }
}
public class privateAndPublic {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name= "deepak";
        s1.cgpa = 8.7;
        System.out.println(s1.cgpa);
        System.out.println(s1.name);
        s1.getrollnum();
    }
}
