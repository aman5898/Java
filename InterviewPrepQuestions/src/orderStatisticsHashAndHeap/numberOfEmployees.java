package orderStatisticsHashAndHeap;

import java.util.HashMap;

public class numberOfEmployees {

	public static void main(String[] args) {
		HashMap<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		populateResult(dataSet);

	}

	private static void populateResult(HashMap<String, String> dataSet) {
		HashMap<String, Integer> ans = new HashMap<>();
		for (String cand : dataSet.keySet()) {
			String manager = dataSet.get(cand);
			if (ans.containsKey(manager)) {
				ans.put(manager, ans.get(manager) + 1);
			} else {
				ans.put(manager, 1);
			}
		}
		System.out.println(ans);
	}

}
