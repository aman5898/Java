package orderStatisticsHashAndHeap;

import java.util.HashMap;

public class ArrayDivisibleByK {

	public static void main(String[] args) {
		boolean y = divisibleByk(new int[] { 9, 7, 5, 3,7 }, 6);
		System.out.println(y);
	}

	public static boolean divisibleByk(int[] arr, int k) {
		HashMap<Integer, Integer> remFreqMap = new HashMap<>();
		for (int val : arr) {
			if (remFreqMap.containsKey(val % k)) {
				remFreqMap.put(val % k, remFreqMap.get(val % k) + 1);
			} else {
				remFreqMap.put(val % k, 1);
			}
		}

		for (int rem : remFreqMap.keySet()) {
			int freq = remFreqMap.get(rem);
			if (rem == 0) {
				if (freq % 2 == 0) {
					continue;
				} else {
					return false;
				}
			} else if (k / rem == 2) {
				if (freq % 2 == 0) {
					continue;
				} else {
					return false;
				}
			} else {
				if (remFreqMap.containsKey(k - rem) && remFreqMap.get(k - rem) == freq) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;

	}

}
