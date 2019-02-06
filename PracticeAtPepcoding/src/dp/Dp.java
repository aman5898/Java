package dp;

public class Dp {

	public static int climbDownT(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 1;
		strg[1] = 1;
		strg[2] = 2;
		for (int i = 3; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2] + strg[i - 3];
		}

		return strg[n];
	}

	public static int countMazePath(int dr, int dc) {
		int[][] strg = new int[dr + 1][dc + 1];
		for (int i = dr; i >= 0; i--) {
			for (int j = dc; j >= 0; j--) {
				if (i == dr && j == dc) {
					strg[i][j] = 1;
				} else if (i == dr) {
					strg[i][j] = strg[i][j + 1];
				} else if (j == dc) {
					strg[i][j] = strg[i + 1][j];
				} else {
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
				}
			}
		}
		return strg[0][0];
	}

	public static int minCostPath(int[][] costs) {
		int[][] strg = new int[costs.length][costs[0].length];

		for (int i = strg.length - 1; i >= 0; i--) {
			for (int j = strg.length - 1; j >= 0; j--) {
				if (i == strg.length - 1 && j == strg.length - 1) {
					strg[i][j] = costs[i][j];
				} else if (i == strg.length - 1) {
					strg[i][j] = strg[i][j + 1] + costs[i][j];
				} else if (j == strg[0].length - 1) {
					strg[i][j] = strg[i + 1][j] + costs[i][j];
				} else {
					strg[i][j] = Math.min(strg[i + 1][j], strg[i][j + 1])
							+ costs[i][j];
				}
			}
		}

		return strg[0][0];
	}

	public static int goldMine(int[][] mine) {
		int[][] strg = new int[mine.length][mine[0].length];
		for (int i = 0; i < mine.length; i++) {
			strg[i][mine[0].length - 1] = mine[i][mine[0].length - 1];
		}

		for (int j = mine[0].length - 2; j >= 0; j--) {
			for (int i = 0; i < mine.length; i++) {
				if (i == 0) {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j + 1])
							+ mine[i][j];
				} else if (i == mine.length - 1) {
					strg[i][j] = Math.max(strg[i][j + 1], strg[i - 1][j + 1])
							+ mine[i][j];
				} else {
					strg[i][j] = Math.max(strg[i][j + 1],
							Math.max(strg[i + 1][j + 1], strg[i - 1][j + 1]))
							+ mine[i][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mine.length; i++) {
			max = Math.max(max, strg[i][0]);
		}

		return max;
	}

	public static int minJumps(int[] jumps) {
		int[] strg = new int[jumps.length];
		strg[0] = 0;
		for (int i = 1; i < strg.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if ((i - j) <= jumps[j]) {
					min = Math.min(min, strg[j] + 1);
				}
			}
			strg[i] = min;
		}

		return strg[strg.length - 1];
	}

	public static int Lis(int[] arr) {
		int[] strg = new int[arr.length];
		strg[0] = 1;
		for (int i = 1; i < strg.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					max = Math.max(strg[j], max);
				}
				strg[i] = max + 1;
			}
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < strg.length; i++) {
			res = Math.max(res, strg[i]);
		}

		return res;
	}

	public static int rodCutting(int[] rod) {
		int[] strg = new int[rod.length];
		strg[0] = 0;
		strg[1] = rod[1];
		for (int i = 1; i < rod.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j <= i; j++) {
				max = Math.max(strg[j] + strg[i - j], max);
			}
			strg[i] = Math.max(max, rod[i]);
		}

		return strg[strg.length - 1];
	}

	public static void TargetSumSubset(int[] arr, int target) {
		boolean[][] strg = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0 && j == 0) {
					strg[i][j] = true;
				} else if (j == 0) {
					strg[i][j] = true;
				} else if (i == 0) {
					strg[i][j] = false;
				} else {
					if (strg[i - 1][j]) {
						strg[i][j] = true;
					} else if (j - arr[i - 1] >= 0) {
						{
							if (strg[i - 1][j - arr[i - 1]]) {
								strg[i][j] = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				System.out.print(strg[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void coinChangePermutation(int[] arr, int target) {
		int[] strg = new int[target + 1];
		strg[0] = 1;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i - arr[j] >= 0) {
					strg[i] += strg[i - arr[j]];
				}
			}
		}
		System.out.println(strg[strg.length - 1]);
	}

	public static void unboundedKnapsack(int[] wts, int[] price, int cap) {
		int[] strg = new int[cap + 1];
		strg[0] = 0;
		for (int i = 1; i < strg.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < wts.length; j++) {
				if (i - wts[j] >= 0) {
					max = Math.max(max, strg[i - wts[j]] + price[j]);
				}
			}
			strg[i] = max;
		}

		System.out.println(strg[strg.length - 1]);
	}

	public static void zeroOneKnapsack(int[] wts, int[] prices, int cap) {
		int[][] strg = new int[wts.length + 1][cap + 1];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
				} else {
					strg[i][j] = strg[i - 1][j];
					if (j - wts[i - 1] >= 0) {
						strg[i][j] = Math.max(strg[i][j], strg[i - 1][j
								- wts[i - 1]]
								+ prices[i - 1]);
					}
				}
			}
		}
		System.out.println(strg[strg.length - 1][strg[0].length - 1]);
	}

	public static int LongPalinSubseqMemo(int sIdx, int lIdx, String str,
			int[][] qb) {
		if (sIdx == lIdx) {
			return 1;
		}
		if (sIdx > lIdx) {
			return 0;
		}

		if (qb[sIdx][lIdx] != 0) {
			return qb[sIdx][lIdx];
		}

		char ch1 = str.charAt(sIdx);
		char ch2 = str.charAt(lIdx);
		if (ch1 == ch2) {
			return qb[sIdx][lIdx] = LongPalinSubseqMemo(sIdx + 1, lIdx - 1,
					str, qb) + 2;
		} else {
			return qb[sIdx][lIdx] = Math.max(
					LongPalinSubseqMemo(sIdx + 1, lIdx, str, qb),
					LongPalinSubseqMemo(sIdx, lIdx - 1, str, qb));
		}
	}

	public static int LongPalinSubsequenceTabul(String str) {
		int[][] strg = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 2;
					} else {
						strg[i][j] = 0;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = strg[i + 1][j - 1] + 2;
					} else {
						strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
					}

				}
			}
		}
		return strg[0][strg[0].length - 1];
	}

	public static boolean[][] longestPalindromicSuubstring(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];
		// i represent gap
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = strg[i + 1][j - 1];
					} else {
						strg[i][j] = false;
					}
				}
			}
		}

		int counter = 0;
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (strg[i][j]) {
					counter++;
				}
			}
		}
		System.out.println(counter);
		outer: for (int gap = str.length() - 1; gap >= 0; gap--) {
			for (int i = 0, j = gap; j < str.length(); i++, j++) {
				if (strg[i][j]) {
					System.out.println(str.substring(i, j + 1));
					break outer;
				}
			}

		}

		return strg;
	}

	public static void minCutPalindrome(String str) {
		int[][] strg = new int[str.length()][str.length()];
		boolean[][] isPalin = longestPalindromicSuubstring(str);
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = gap; j < strg.length; i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (isPalin[i][j]) {
						strg[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						// for(int k=j-gap, c = 1;k<j;k++,c++){
						// min=Math.min(strg[i][k]+strg[i+c][j],min);
						// }
						for (int idash = i + 1, jdash = j - gap; jdash < j; idash++, jdash++) {
							min = Math.min(min, strg[i][jdash] + strg[idash][j]
									+ 1);
						}
						strg[i][j] = min;
					}
				}
			}
		}
		System.out.println(strg[0][strg.length - 1]);
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg.length; j++) {
				System.out.print(strg[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void mcm(int[] dims) {
		int[][] strg = new int[dims.length - 1][dims.length - 1];
		for (int gap = 0; gap < strg.length; gap++) {
			for (int i = 0, j = i + gap; j < strg[0].length; i++, j++) {
				if (gap == 0) {
					strg[i][j] = 0;
				} else if (gap == 1) {
					strg[i][j] = dims[i] * dims[j] * dims[j + 1];
				} else {
					strg[i][j] = Integer.MAX_VALUE;
					for (int idash = i + 1, jdash = j - gap; jdash < j; idash++, jdash++) {
						strg[i][j] = Math.min(strg[i][j], strg[i][jdash]
								+ strg[idash][j] + dims[i] * dims[idash]
								* dims[j + 1]);
					}
				}
			}
		}
		System.out.println(strg[0][strg.length - 1]);
	}

	public static int eggDrop(int e, int f, int[][] qb) {
		if (e == 1) {
			return f;
		}
		if (f == 0) {
			return 0;
		}

		if (f == 1) {
			return 1;
		}
		if(qb[e][f]!=0){
			return qb[e][f];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= f; i++) {
			min = Math.min(min,
					Math.max(eggDrop(e - 1, i - 1, qb), eggDrop(e, f - i, qb)));
		}

		return qb[e][f]= min + 1;
	}
	
	static int max=Integer.MIN_VALUE;
	
	public static void maxSumNoAdjacentElement(int vidx, int ans, boolean prev,
			int[] arr) {
		if(vidx==arr.length){
			max = Math.max(max, ans);
			System.out.println(ans+" "+max);
			return;
		}
		if(prev==true){
			maxSumNoAdjacentElement(vidx+1, ans, false, arr);
		}else{
			maxSumNoAdjacentElement(vidx+1, ans+arr[vidx],true, arr);
			maxSumNoAdjacentElement(vidx+1, ans, false, arr);
		}
	}
	
	public static void maxSumNoAdjacentElementsGreedy(int[] arr) {
		int include=arr[0];
		int exclude=0;
		for(int i=1;i<arr.length;i++){
			int temp=Math.max(include,exclude);
			include=exclude+arr[i];
			exclude=temp;
		}
		
		System.out.println(Math.max(include,exclude));
	}

	public static void main(String[] args) {
		// int[] arrJump = { 3, 2, 0, 2, 3, 1, 0, 1, 2, 0, 1 };
		// System.out.println(minJumps(arrJump));
		// int[] arr={10,22,9,33,21,50,41,60,80,1};
		// // System.out.println();
		// System.out.println(Lis(arr));
		// int[] arr={0,3,5,6,15,10,25,12,24};
		// System.out.println(rodCutting(arr));
		// int[] arr = { 2, 3, 1, 5, 6 };
		// TargetSumSubset(arr, 10);
		// int[] coins={2,3,5};
		// coinChangePermutation(coins, 7);
		// int[] wts = { 2, 5, 1, 3, 4 };
		// int[] prices = { 15, 14, 10, 45, 30 };
		// zeroOneKnapsack(wts, prices, 7);
		// String str = "abkccbc";
		// longestPalindromicSuubstring(str);
		// int x=LongPalinSubseqMemo(0,str.length()-1,str,new int[7][7]);
		// int x = LongPalinSubsequenceTabul(str);
		// System.out.println(x);
		// minCutPalindrome("abccbc");
		// mcm(new int[] { 10, 20, 30, 40, 50, 60 });
//		int eggs = 2;
//		int floors = 100;
//		int x = eggDrop(2, 100, new int[eggs + 1][floors + 1]);
//		System.out.println(x);
		int[] arr = { 5, 6, 10, 100, 10, 5 };
//		maxSumNoAdjacentElement(0, 0, false, arr);
		maxSumNoAdjacentElementsGreedy(arr);
	}

}
