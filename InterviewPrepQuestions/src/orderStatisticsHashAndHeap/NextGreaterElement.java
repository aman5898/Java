package orderStatisticsHashAndHeap;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.add(40);
//		pq.add(50);
//		pq.remove(50);
//		System.out.println(pq);
//		nextLargerElement2(new int[] { 4, 5, 2, 25 });
		smallestPositiveNumber(new int[] {  2, 3, -7, 6, 8, 1, -10, 15});
		
	}

	public static void smallestPositiveNumber(int[] arr) {
		int k = partitionArray(arr);

		for (int i = 0; i < k; i++) {
			if (Math.abs(arr[i]) < k) {
				arr[Math.abs(arr[i])] = -1 * Math.abs(arr[Math.abs(arr[i])]);
			}
		}

		int ans = k;
		for (int i = 1; i < k; i++) {
			if (arr[i] > 0) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

	private static int partitionArray(int[] arr) {
		int j = -1;// index for positive element
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				j++;
				swap(arr, i, j);
			}
		}
		return j + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int ith = arr[i];
		arr[i] = arr[j];
		arr[j] = ith;
	}

	public static void nextLargerElement2(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[arr.length - 1]);
		System.out.println(arr[arr.length - 1] + " -1");
		for (int i = arr.length - 2; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() < arr[i]) {
				stack.pop();
			}
			if (stack.size() > 0) {
				System.out.println(arr[i] + " " + stack.peek());
			} else {
				System.out.println(arr[i] + " -1");
			}
			stack.push(arr[i]);
		}
	}

	public static void nextLargerElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length - 1; i++) {
			st.push(arr[i]);
			int next = arr[i + 1];
			while (st.size() > 0) {
				if (st.peek() < next) {
					st.pop();
					System.out.print(next + " ");
				} else {
					break;
				}
			}
		}

		System.out.print((-1));
	}

}
