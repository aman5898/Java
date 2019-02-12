package string;

import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveAdjacentDuplicate {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			String str = scn.nextLine();
			System.out.println(removeDuplicate(str));
		}
	}

	public static String removeDuplicate(String str) {
		if (str.length() == 1) {
			return str;
		}
		int leftchIdx = 0;
		int rightchIdx = 1;
		if (str.charAt(leftchIdx) != str.charAt(rightchIdx)) {
			return str.charAt(0) + removeDuplicate(str.substring(1));
		} else {
			while (rightchIdx < str.length() && str.charAt(leftchIdx) == str.charAt(rightchIdx)) {
				rightchIdx++;
			}
			str = str.substring(rightchIdx);
			return str.charAt(0) + removeDuplicate(str.substring(1));
		}
	}

	public static boolean checkDuplicate(String str) {
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				return true;
			}
		}

		return false;
	}
}