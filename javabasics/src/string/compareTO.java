package string;

public class compareTO {
    public static int compareTo(String a , String b){
        int diff = 0;
        int aL=a.length();
        int bL=b.length();
        for (int i = 0;i<aL && i<bL;i++){
            diff = a.charAt(i)-b.charAt(i);
            if (diff!=0){
                break;
            }
        }
        if (diff==0){
            diff = aL-bL;
        }
        return diff;



    }

    public static void main(String[] args) {
        String a = "deepak";
        String b = "deepika";
        System.out.println(compareTo(a,b));

    }
}
