package trie;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
//		Trie t=new Trie();
//		t.addWord("as");
//		t.addWord("ask");
//		t.addWord("ant");
//		t.addWord("an");
//		t.removeWord("ant");
//		t.removeWord("an");
//		t.displayTrie();
//		t.displayAllWords();
//		t.displayAllWords();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int x = maxSumIS(arr, arr.length);
		System.out.println(x);
	}

	static int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		/*
		 * Initialize msis values for all indexes
		 */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/*
		 * Compute maximum sum values in bottom up manner
		 */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/*
		 * Pick maximum of all msis values
		 */
		for (i = 0; i < n; i++) {
			System.out.println(msis[i]+" "+i+" "+arr[i]);
			if (max < msis[i]) {
				max = msis[i];
			}
		}
		return max;
	}

}
