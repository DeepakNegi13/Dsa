package recursion;

public class newQuestion {
	public static void incDec(int n) {
		if (n == 0) return;
		System.out.print(n + " ");
		incDec(n - 1);
		if (n == 1) return;
		System.out.print(n + " ");
	}

	public String helper(int k, String st) {
		if (k == 0) return st;
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String newSt = "";
		for (int i = 0; i < st.length(); i++) {
			for (int j = 0; j < alpha.length(); j++) {
				if (alpha.charAt(j) == st.charAt(i)) {
					newSt = newSt + alpha.charAt(j + 1);
					break;
				}
			}
		}
		st = st + newSt;
		st = helper(k - 1, st);
		return st;
	}

	public static void main(String[] args) {
		char a = 'a';
		String b = "b";
		System.out.println(a + b);
//		incDec(8);
	}
}
