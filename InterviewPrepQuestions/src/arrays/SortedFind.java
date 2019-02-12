package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class SortedFind {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			int x = minElement(0, arr.length - 1, arr);
			System.out.println(x);
		}
	}

	public static int minElement(int lo, int hi, int[] arr) {
		while (lo < hi) {
			System.out.println(lo + " " + hi);
			if (lo + 1 == hi) {
				return Math.min(arr[lo],arr[hi]);
			}
			int mid = (lo + hi) / 2;
			if (arr[lo] < arr[mid]) {
				if (arr[mid] > arr[mid + 1]) {
					return arr[mid + 1];
				} else {
					lo = mid + 1;
				}
			} else {
				if (arr[mid] < arr[mid - 1]) {
					return arr[mid];
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}
}