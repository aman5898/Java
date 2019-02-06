package graph;

import java.util.Collections;
import java.util.PriorityQueue;

public class JobSequencing {
	

	public static void main(String[] args) {
		int[] LastDate = { 4, 2, 3, 1, 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 };
		int[] Salary = { 100, 69, 94, 54, 33, 77, 11, 99, 37, 76, 34, 47, 78, 45, 39, 75, 49, 34, 48, 92, 44, 90 };
		char[] Job = { 'a', 'b', 'd', 'e', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v' };
		jobsequencing(Job, LastDate, Salary);
	}

	public static void jobsequencing(char[] activities, int[] deadlines, int[] profits) {
		int maxTime = Integer.MIN_VALUE;
		PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < activities.length; i++) {
			maxTime = Math.max(maxTime, deadlines[i]);
			pq.add(new pair(activities[i], deadlines[i], profits[i]));
		}

		int[] timeslot = new int[maxTime + 1];
		for (int i = 0; i < timeslot.length; i++) {
			timeslot[i] = i;
		}

		while (pq.size() > 0) {
			pair rem = pq.remove();
			int rf = find(rem.deadline, timeslot);
			if (rf > 0) {
				int rfp = find(rf-1, timeslot);
				timeslot[rf] = rfp;
				System.out.println(rem.profit + "-" + rem.actname + "-" + rf);
			}
		}
	}

	private static int find(int i, int[] timeslot) {
		if (timeslot[i] == i) {
			return i;
		} else {
			int pidx = find(timeslot[i], timeslot);
			timeslot[i] = pidx;
			return pidx;
		}
	}

	private static class pair implements Comparable<pair> {
		char actname;
		int deadline;
		int profit;

		public pair(char n, int d, int p) {
			this.actname = n;
			this.deadline = d;
			this.profit = p;
		}

		@Override
		public int compareTo(pair o) {
			return this.profit - o.profit;
		}
	}
}
