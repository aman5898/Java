package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQClient {

	public static void main(String[] args) {
//		int[] arr = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
//		printKlargestBetter(arr, 3);
//		int[] arr = { 30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120 };
//		almostSorted(arr, 2);
		MedianPQ mp=new MedianPQ();
		mp.add(10);
		System.out.println(mp.peek());
		mp.add(100);
		System.out.println(mp.peek());
		mp.add(90);
		System.out.println(mp.peek());
		mp.add(80);
		System.out.println(mp.peek());
		mp.add(110);
		System.out.println(mp.peek());
		mp.add(105);
		System.out.println(mp.peek());
		mp.add(120);
		System.out.println(mp.peek());
		System.out.println(mp.remove());
		System.out.println(mp.remove());
		System.out.println(mp.remove());
		System.out.println(mp.remove());
		System.out.println(mp.remove());
		System.out.println(mp.remove());
	
		 mp.add(40);
			System.out.println(mp.peek());
//		mp.add(50);
//		mp.add(30);
//		mp.add(60);
//		mp.add(70);
//		mp.remove();
//		mp.remove();
//		mp.remove();
//		ArrayList<Integer> arr1 = new ArrayList<>();
//		arr1.add(10);
//		arr1.add(20);
//		arr1.add(30);
//		arr1.add(40);
//		ArrayList<Integer> arr2 = new ArrayList<>();
//		arr2.add(22);
//		arr2.add(27);
//		arr2.add(28);
//		arr2.add(35);
//		arr2.add(55);
//		ArrayList<Integer> arr3 = new ArrayList<>();
//		arr3.add(11);
//		arr3.add(32);
//		arr3.add(41);
//		ArrayList<Integer> arr4 = new ArrayList<>();
//		arr4.add(5);
//		arr4.add(12);
//		arr4.add(26);
//		arr4.add(38);
//		ArrayList<ArrayList<Integer>> finalarr = new ArrayList<>();
//		finalarr.add(arr1);
//		finalarr.add(arr2);
//		finalarr.add(arr3);
//		finalarr.add(arr4);
//		// another way of doing the above thing
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		lists.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
//		mergeKSortedLists(finalarr);

	}

	// add and remove of priority queue is logn and peek os o1

	// space on time (n+k)logn
	public static void printKlargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int val : arr) {
			pq.add(val);
		}

		for (int i = 0; i < k; i++) {
			System.out.println(pq.remove());
		}
	}

	// space ok time nlogk
	public static void printKlargestBetter(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			int x = pq.peek();
			if (arr[i] > x) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		System.out.println(pq);
	}

	public static void almostSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < k + 1) {
				pq.add(arr[i]);
			} else {
				arr[i - k - 1] = pq.remove();
				pq.add(arr[i]);
			}

		}

		for (int i = arr.length - k - 1; i < arr.length; i++) {
			arr[i] = pq.remove();
		}

		for (int val : arr) {
			System.out.println(val);
		}
	}

	static class pair implements Comparable<pair> {
		int lIdx;
		int dataIdx;
		int value;

		@Override
		public int compareTo(pair o) {
			return this.value - o.value;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		PriorityQueue<pair> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.size(); i++) {
			pair p = new pair();
			p.dataIdx = 0;
			p.lIdx = i;
			p.value = lists.get(i).get(0);
			pq.add(p);
		}

		while (pq.size() != 0) {
			pair p = pq.remove();
			System.out.println(p.value);
			if (p.dataIdx < lists.get(p.lIdx).size() - 1) {
				pair p2 = new pair();
				p2.dataIdx = p.dataIdx + 1;
				p2.lIdx = p.lIdx;
				p2.value = lists.get(p.lIdx).get(p2.dataIdx);
				pq.add(p2);
			}
		}
	}

}
