package Greedy;

import java.util.Arrays;

public class Practice {

	static class Activity implements Comparable<Activity> {
		int sTime;
		int eTime;

		public Activity(int x, int y) {
			this.sTime = x;
			this.eTime = y;
		}

		@Override
		public int compareTo(Activity o) {
			return this.eTime - o.eTime;
		}
	}

	public static void ActivitySelection(int[] sTime, int[] eTime) {
		Activity[] activities = new Activity[sTime.length];
		for (int i = 0; i < sTime.length; i++) {
			activities[i] = new Activity(sTime[i], eTime[i]);
		}
		Arrays.sort(activities);

		String ans = activities[0].sTime + "-" + activities[0].eTime + " ";
		int lastEndT = activities[0].eTime;
		for (int i = 1; i < activities.length; i++) {
			if (activities[i].sTime >= lastEndT) {
				ans = ans + "" + activities[i].sTime + "-" + activities[i].eTime + " ";
				lastEndT = activities[i].eTime;
			}
		}
		System.out.println(ans);
	}

	public static void minPlatformRequired(int[] sTime, int[] eTime) {
		int i = 0, j = 0, count = 0;
		int max=Integer.MIN_VALUE;
		while (true) {
			if (sTime[i] < eTime[j]) {
				i++;
				count++;
				max=Math.max(max,count);
			} else {
				j++;
				count--;
			}

			if (i == sTime.length || j == eTime.length) {
				break;
			}
		}

		System.out.println(max);
	}

	public static void main(String[] args) {
//		int[] startTime = { 3, 0, 1, 8, 5, 5 };
//		int[] endTime = { 4, 6, 2, 9, 9, 7 };
//		ActivitySelection(startTime, endTime);

		int[] startTime = { 900, 940, 950, 1100, 1500, 1800 };
		int[] endTime = { 910, 1200, 1120, 1130, 1900, 2000 };
		minPlatformRequired(startTime, endTime);
	}

}
