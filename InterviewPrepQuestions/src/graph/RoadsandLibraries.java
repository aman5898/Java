package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RoadsandLibraries {
	

	public static void main(String[] args) {
		int n = 9;
		int m = 2;
		int c_lib = 91;
		int c_road = 84;
		int[][] cities = { { 8, 2 }, { 2, 9 } };
		Integer[][] graph = new Integer[n][n];
		for (int i = 0; i < cities.length; i++) {
			graph[cities[i][0] - 1][cities[i][1] - 1] = 1;
			graph[cities[i][1] - 1][cities[i][0] - 1] = 1;
		}
		
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph.length;j++) {
				System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}
		int x = roadsAnsLibrarieshelper(n, c_lib, c_road, graph);
		System.out.println(x);
	}

	public static int roadsAnsLibrarieshelper(int cities, int libCost, int roadCost, Integer[][] graph) {

		if (libCost <= roadCost) {
			return libCost * cities;
		} else if (libCost > roadCost) {

			ArrayList<String> list = gcc(graph);
			System.out.println(list);
			int ans = 0;
			for (String str : list) {
				int size = str.length();
				ans += (1 * libCost) + ((size - 1) * roadCost);
			}
			return ans;
		}
		return 0;
	}

	public static ArrayList<String> gcc(Integer[][] graph) {
		HashSet<Integer> visited = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (visited.contains(i) == false) {
				list.add(gccHelper(i, visited, graph));
			}
		}

		return list;
	}

	public static String gccHelper(int s, HashSet<Integer> visited, Integer[][] graph) {
		String ans = "";
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (stack.size() > 0) {
			int rem = stack.pop();
			if (visited.contains(rem)) {
				continue;
			}
			ans += rem;
			visited.add(rem);
			for (int j = 0; j < graph.length; j++) {
				if (graph[rem][j] != null) {
					if (visited.contains(j) == false) {
						stack.push(j);
					}
				}
			}
		}
		return ans;
	}
}
