package textProcessing;

public class KMP {

	public static void main(String[] args) {
		String s = "abababab";
		String p="aba";
		solve(s, p);
	}

	public static void solve(String s, String p) {
		int[] lps = preprocess(p);
		int i = 0;
		int j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if (j == p.length()) {
					System.out.println(p + " found at " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private static int[] preprocess(String p) {

		int[] lps = new int[p.length()];
		int l = 0;
		int i = 1;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(l)) {
				l++;
				lps[i] = l;
				i++;
			} else {
				if (l > 0) {
					l = lps[l - 1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}
}
