package orderStatisticsHashAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KmaxSum {

	public static void main(String args[]) {
		int numr = 1;
		int denr = 28;

		String res = ftod(numr, denr);

		if ("".equals(res))

			System.out.println("No recc");

		else

			System.out.println(res);

	}

	private static String ftod(int numr, int denr) {

		String res = "";

		TreeMap<Integer, Integer> mp = new TreeMap<>();

		int rem = numr % denr;

		while ((rem != 0) && (!mp.containsKey(rem))) {

			mp.put(rem, res.length());

			rem = rem * 10;

			int res_Part = rem / denr;

			res += Integer.toString(res_Part);

			rem = rem % denr;

		}

		return (rem == 0) ? "" : res.substring(mp.get(rem));

	}

	public static void kMaximumSum(int[] arr1, int[] arr2, int k) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int val : arr1) {
			pq1.add(val);
		}

		for (int val : arr2) {
			pq2.add(val);
		}

		while (k-- > 0) {
			System.out.println(pq1.peek() + pq2.peek());
			if (pq1.peek() < pq2.peek()) {
				pq1.remove();
			} else {
				pq2.remove();
			}
		}
	}

}
