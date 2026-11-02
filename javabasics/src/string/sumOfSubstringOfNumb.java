package string;

public class sumOfSubstringOfNumb {
    public static void main(String[] args) {
        String s = "123";
        int n = s.length();
        int sum = 0;
        for (int i = 0;i<s.length();i++){
            for (int j = i+1;j<=s.length();j++){
                sum+=Integer.parseInt(s.substring(i,j));
            }
        }
        System.out.println(sum);
    }
}
