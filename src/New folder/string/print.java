package string;

public class print {
    static void main(String[] args) {
        String str = new String("hello world");
        for(int i= 0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
}
