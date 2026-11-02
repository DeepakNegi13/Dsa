package OOPS;
import java.util.*;
public class complexNumClass {
    public static class ComplexNum{
        int a;
        int b;
        ComplexNum(int a,int b){
            this.a = a;
            this.b = b;
        }
        void getCN(){
            if (b>=0)System.out.println(a +" + " +b +"i");
            else System.out.println(a + " - " + (-1)*(b)+"i");
        }


        public String add(ComplexNum CN2) {
            if (this.b+CN2.b>=0) return this.a + CN2.a +" + "+ this.b+CN2.b+"i";
            else return this.a + CN2.a +" - "+ (-1)*(this.b+CN2.b)+"i";
        }
        String  multiply(ComplexNum CN2){
            int real =  (this.a)*(CN2.a)-(this.b)*(CN2.b);
            int comp = (this.a)*(CN2.b)+(this.b)*(CN2.a);
            if (comp>=0) return real  +" + "+comp+"i" ;
            else return real  +" - "+(-1)*(comp)+"i" ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplexNum CN1 = new ComplexNum(sc.nextInt(),sc.nextInt());
        CN1.getCN();
        ComplexNum CN2 = new ComplexNum(sc.nextInt(),sc.nextInt());
        CN1.getCN();
        System.out.println(CN1.multiply(CN2));;
        System.out.println(CN1.add(CN2));;

    }
}
