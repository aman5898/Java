package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {

	static class Activity implements Comparable<Activity> {
		int startTime;
		int endTime;

		public Activity(int a, int b) {
			this.startTime = a;
			this.endTime = b;
		}

		// assuming if other is large return smaller than 0
		@Override
		public int compareTo(Activity o) {
			return this.endTime - o.endTime;
		}
	}

	// int arr=new int

	public static void activitySelectionProblem(int[] sTime, int[] eTime) {
		Activity[] activity = new Activity[sTime.length];
		for (int i = 0; i < sTime.length; i++) {
			activity[i] = new Activity(sTime[i], eTime[i]);
		}

		// sort acivities
		Arrays.sort(activity);

		ArrayList<Activity> ans = new ArrayList<>();

		ans.add(activity[0]);

		for (int i = 1; i < activity.length; i++) {
			if (isOverlap(ans, activity[i]) == false) {
				ans.add(activity[i]);
			}
		}

		for (Activity act : ans) {
			System.out.print(act.startTime + "-" + act.endTime + " ");
		}
	}

	private static boolean isOverlap(ArrayList<Activity> arraylist, Activity activity) {
		// you dont need to do this for all just do it for the last
		for (int i = arraylist.size() - 1; i >= 0; i--) {
			if (arraylist.get(i).endTime > activity.startTime) {
				return true;
			}
		}
		return false;
	}

	public static void minPlatformRequired(int[] startTime, int[] endTime) {
		int count = 0;
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		Arrays.sort(startTime);
		Arrays.sort(endTime);

		while (true) {
			if (startTime[i] < endTime[j]) {
				count++;
				max = Math.max(max, count);
				i++;
			} else {
				count--;
				j++;
			}

			if (i == startTime.length || j == endTime.length) {
				break;
			}
		}

		System.out.println(max);
	}

	static class Items implements Comparable<Items> {
		int weight;
		int value;
		double vTow;

		public Items(int w, int v) {
			this.weight = w;
			this.value = v;
			vTow = (double) v / w;
		}

		@Override
		public int compareTo(Items o) {
			if (this.vTow - o.vTow > 0) {
				return 1;
			} else if (this.vTow - o.vTow < 0) {
				return -1;
			}
			{
				return 0;
			}
		}
	}

	public static void fractionalKnapsack(int[] wts, int[] val, int capacity) {
		Items[] items = new Items[wts.length];
		for (int i = 0; i < wts.length; i++) {
			items[i] = new Items(wts[i], val[i]);
		}

		double ans = 0;

		Arrays.sort(items);

		for (int i = items.length - 1; i >= 0; i--) {
			if (capacity > items[i].weight) {
				ans += items[i].value;
				capacity -= items[i].weight;
				// System.out.println(ans);
			} else {
				ans += items[i].vTow * capacity;
				break;
			}
		}
		System.out.println(ans);
	}

	static class Job implements Comparable<Job> {
		int deadline;
		int profit;

		public Job(int d, int p) {
			this.deadline = d;
			this.profit = p;
		}

		@Override
		public int compareTo(Job o) {
			return this.profit - o.profit;
		}
	}

	public static void jobSequencing(int[] deadline, int[] profit) {
		Job[] jobs = new Job[deadline.length];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(deadline[i], profit[i]);
		}

		Arrays.sort(jobs);
		boolean[] time = new boolean[deadline.length];
		int ans = 0;
		ans += jobs[jobs.length - 1].profit;
		time[jobs[jobs.length - 1].deadline - 1] = true; // make its size maximum of deadline size

		for (int i = jobs.length - 2; i >= 0; i--) {
			for (int j = jobs[i].deadline - 1; j >= 0; j--) {
				if (time[j] == false) {
					ans += jobs[i].profit;
					time[j] = true;
					break;
				}
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
//		 int[] startTime = { 3, 0, 1, 8, 5, 5 };
//		 int[] endTime = { 4, 6, 2, 9, 9, 7 };
//		 activitySelectionProblem(startTime, endTime);

		int[] startTime = { 900, 940, 950, 1100, 1500, 1800 };
		int[] endTime = { 910, 1200, 1120, 1130, 1900, 2000 };
		minPlatformRequired(startTime, endTime);

		// int[] wts={10,40,20,30};
		// int[] val={60,40,100,120};
		// fractionalKnapsack(wts,val,50);
//		int[] deadline = { 2, 1, 2, 1, 3 };
//		int[] profit = { 100, 19, 27, 25, 15 };
//		jobSequencing(deadline, profit);
	}

}
