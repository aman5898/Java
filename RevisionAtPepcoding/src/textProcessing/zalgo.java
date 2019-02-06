package textProcessing;

public class zalgo {

	public static void main(String[] args) {
		String s = "abababab";
		String p="aba";
		patternMatching(s, p);
	}

	public static void patternMatching(String s, String p) {
		String con = p + "$" + s;
		Integer[] zarr = preprocess(con);
		for (int i = 1; i < zarr.length; i++) {
			if (zarr[i] == p.length()) {
				System.out.println(p + " found at " + (i - p.length() - 1));
			}
		}
	}

	private static Integer[] preprocess(String con) {
		Integer[] zarr = new Integer[con.length()];
		int l = 0;
		int r = 0;
		for (int i = 1; i < zarr.length; i++) {
			int k = i - l;
			if (i > r) {
				r = i;
				l = i;
				while (r < con.length() && con.charAt(r) == con.charAt(r - l)) {
					r++;
				}
				r--;
				zarr[i] = r - l + 1;
			} else {
				if (zarr[k] < r - i + 1) {
					zarr[i] = zarr[k];
				} else {
					l = i;
					while (r < con.length() && con.charAt(r) == con.charAt(r - l)) {
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
