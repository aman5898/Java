package binaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int d = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Arrays.sort(arr);

		int ans = 0;

		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i + 1] - arr[i] <= d) {
				++ans;
				++i;
			}
		}

		System.out.println(ans);

	}
}