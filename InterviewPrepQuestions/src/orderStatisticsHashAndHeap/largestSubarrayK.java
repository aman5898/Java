package orderStatisticsHashAndHeap;

import java.util.HashMap;
import java.util.LinkedList;

public class largestSubarrayK {

	public static void main(String[] args) {
//		LargestSubarrayZero(new int[] { -4, -2, 2, 4, 0 });
//		countDistinctelementK(new int[] { 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27 }, 4);
//		groupShiftedString(new String[] { "acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs" });
		abcd(new int[] {3, 4, 7, 1, 12, 9});
	}

	private static class pair {
		int i;
		int j;

		public pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void abcd(int[] arr) {
		HashMap<Integer, pair> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (map.containsKey(sum)) {
					pair p = map.get(sum);
					System.out.println("{" + p.i + "," + p.j + "} {" + arr[i] + "," + arr[j] + "}");
				} else {
					map.put(sum, new pair(arr[i], arr[j]));
				}
			}
		}
	}

	public static void groupShiftedString(String[] arr) {
		HashMap<String, LinkedList<String>> hmap = new HashMap<>();
		for (String str : arr) {
			String code = generateCode(str);
			if (hmap.containsKey(code) == false) {
				LinkedList<String> ll = new LinkedList<>();
				ll.addLast(str);
				hmap.put(code, ll);
			} else {
				hmap.get(code).addLast(str);
			}
		}
		System.out.println(hmap);
	}

	public static String generateCode(String str) {
		if (str.length() == 1) {
			return "a";
		}
		String ans = "";
		for (int i = str.length() - 1; i > 0; i--) {
			int dif = (str.charAt(i) - str.charAt(i - 1));
			if (dif < 0) {
				dif += 26;
			}
			ans += dif;
		}

		return ans;
	}

	public static void countDistinctelementK(int[] arr, int k) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				freqMap.put(arr[i], freqMap.containsKey(arr[i]) ? freqMap.get(arr[i]) + 1 : 1);
				if (i == k - 1) {
					System.out.print(freqMap.size() + " ");
				}
			} else {
				int remElemFreq = freqMap.get(arr[i - k]);
				if (remElemFreq == 1) {
					freqMap.remove(arr[i - k]);
				} else {
					freqMap.put(arr[i - k], remElemFreq - 1);
				}

				freqMap.put(arr[i], freqMap.containsKey(arr[i]) ? freqMap.get(arr[i]) + 1 : 1);
				System.out.print(freqMap.size() + " ");
			}
		}
	}

	public static void LargestSubarrayZero(int[] arr) {
		int sum = 0;
		int maxLength = 0;
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxLength = i + 1;
			}
			if (sumMap.containsKey(sum) == false) {
				sumMap.put(sum, i);
			} else {
				maxLength = Math.max(maxLength, i - sumMap.get(sum));
			}
		}

		System.out.println(maxLength);
	}
}
