package OOPS;

public class basicsOfOOPS {
    // CLASS
    public static class  Student {
        String name;
        int rollnum;
        double cgpa;
    }
    public static void main(String[] args) {
        //object s1,s2,s3
        Student s1  = new Student();
        s1.name = "deepak";
        s1.rollnum = 13;
        s1.cgpa = 8.7;

        Student s2 = new Student();
        s2.name = "amit";
        s2.rollnum = 9;
        s2.cgpa = 8.2;

        Student s3  = new Student();
        s3.name = "srijal";
        s3.rollnum = 97;
        s3.cgpa = 8.4;
        // we can take input and should give output
        System.out.println(s1.name + " " + s1.rollnum + " " + s1.cgpa);
        change(s1);
        System.out.println(s1.name + " " + s1.rollnum + " " + s1.cgpa);
    }
    // methods pass by reference
    private static void change(Student sx) {
        sx.cgpa = 9.6;
        sx.name = "maggi";
    }
}
