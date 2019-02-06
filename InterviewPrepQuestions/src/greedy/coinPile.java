package greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

class coinPile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();

		while (testCases-- > 0) {

			int size = sc.nextInt();
			int k = sc.nextInt();

			int a[] = new int[size];

			for (int i = 0; i < size; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			int minOverall = Integer.MAX_VALUE;
			int removal = 0;
			for (int j = 0; j < size - 1; j++) {
				int min = a[j];
				int counter = 0;
				if (j > 0) {
					removal += a[j - 1];
					counter += removal;
				}
				for (int i = j + 1; i < size; i++) {
					if ((a[i] - min) > k) {
						counter += a[i] - min - k;
					}
				}
				minOverall = Math.min(minOverall, counter);
			}
			System.out.println(minOverall);
		}

	}

	public static int minRemoves(int[] arr, int k) {
		int ans = 0;
		while (true) {
			int maxIdx = max(arr);
			int minIdx = min(arr);
			if (arr[maxIdx] - arr[minIdx] <= k) {
				return ans;
			} else {
				arr[maxIdx] -= (arr[maxIdx] - arr[minIdx]);
				ans++;
			}
		}
	}

	public static int max(int[] arr) {
		int ans = Integer.MIN_VALUE;
		int maxIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > ans) {
				ans = arr[i];
				maxIdx = i;
			}
		}

		return maxIdx;
	}

	public static int min(int[] arr) {
		int ans = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < ans) {
				ans = arr[i];
				minIdx = i;
			}
		}

		return minIdx;
	}
}