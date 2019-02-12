package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LexicographSubset {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			Arrays.sort(arr);
			String s = "";
			for (int i = 0; i < n; i++) {
				s += arr[i] + "";
			}
			ArrayList<String> list = new ArrayList<>();
			for (String str : lexicographSubsets(s)) {
				if (list.contains(str) == false) {
					list.add(str);
				}
			}
			System.out.print("()");
			for (String str : list) {
				System.out.print("(");
				for (int i = 0; i < str.length(); i++) {
					if (i != str.length() - 1) {
						System.out.print(str.charAt(i) + " ");
					} else {
						System.out.print(str.charAt(i));
					}
				}
				System.out.print(")");
			}
			System.out.println();
		}
	}

	public static ArrayList<String> lexicographSubsets(String str) {
		if (str.length() == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(str);
			return list;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = lexicographSubsets(ros);
		ArrayList<String> mr = new ArrayList<>();
		mr.add(ch + "");
		for (String s : rr) {
			mr.add(ch + s);
		}
		for (String s : rr) {
			mr.add(s);
		}

		return mr;
	}
}
