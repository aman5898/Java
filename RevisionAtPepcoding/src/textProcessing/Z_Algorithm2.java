package textProcessing;

public class Z_Algorithm2 {

	public static void main(String[] args) {
		String s = "abababab";
		String p = "aba";
		patternmatching(s, p);
	}

	public static void patternmatching(String s, String p) {
		String con = p + "$" + s;
		Integer[] zarr = preprocess(con);
		for (int i = 1; i < zarr.length; i++) {
			if (zarr[i] == p.length()) {
				System.out.println(p + " found at " + (i - p.length() - 1));
			}
		}
	}

	public static Integer[] preprocess(String s) {
		int l = 0;
		int r = 0;
		Integer[] zarr = new Integer[s.length()];
		for (int i = 1; i < zarr.length; i++) {
			int k = i - l;
			if (i > r) {
				l = i;
				r = i;
				while (r < s.length() && s.charAt(r) == s.charAt(r - l)) {
					r++;
				}
				r--;
				zarr[i] = r - l + 1;
			} else {
				if (zarr[k] < r - i + 1) { // think why
					zarr[i] = zarr[k];
				} else {
					l = i;
					while (r < s.length() && s.charAt(r) == s.charAt(r - l)) {
						r++;
					}
					r--;
					zarr[i] = r - l + 1;
				}
			}
		}
		return zarr;
	}
}
