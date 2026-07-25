package recursion;

public class uniquePath {
    public static int uniquePaths(int m, int n) {
        if(n==1||m==1) return 1;
        return uniquePaths(m,n-1) + uniquePaths(m-1,n);
    }
    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        System.out.println(uniquePaths(m,n));
    }
}
