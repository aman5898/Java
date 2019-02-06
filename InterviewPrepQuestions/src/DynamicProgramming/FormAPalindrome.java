package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

class FormAPalindrome {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String str = scn.next();
			int[][] strg = new int[str.length()][str.length()];
			int x = minPalindrome(str, strg, 0, str.length() - 1);

			System.out.println(x);
		}
	}

	public static int minPalindrome(String str, int[][] strg, int row, int col) {
		if (row == col) {
			return strg[row][col] = 0;
		}
		if (isPalindrome(str.substring(row, col + 1))) {
			return strg[row][col] = 0;
		}

		if (strg[row][col] != 0) {
			return strg[row][col];
		}

		if (str.charAt(row) == str.charAt(col)) {
			return strg[row][col] = minPalindrome(str, strg, row + 1, col - 1);
		}
		return strg[row][col] = Math.min(minPalindrome(str, strg, row, col - 1), minPalindrome(str, strg, row + 1, col))
				+ 1;
	}

	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}