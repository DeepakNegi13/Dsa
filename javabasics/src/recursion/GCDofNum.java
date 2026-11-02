package recursion;

public class GCDofNum {
    //first method
    public static int GCD(int n1,int n2,int r){
        if (r>Math.min(n1,n2)) return 1;
        if (n2%r==0 && n1%r==0) return r*GCD(n1/r,n2/r,r);
        else return GCD(n1,n2,r+1);

    }

    //second method
    public static int HCF(int n1,int n2){
        if (n2%n1==0) return n1;
        return HCF(n2%n1,n1);
    }
    public static void main(String[] args) {
        int n1 = 16;
        int n2 =8;
        int r =2;
        System.out.println(GCD(n1,n2,r));
        System.out.println(HCF(n1,n2));

    }
}
