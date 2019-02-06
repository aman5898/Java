package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RoadsAndLibrariesHm {

	public static void main(String[] args) {
		int n = 9;
		int m = 2;
		int c_lib = 91;
		int c_road = 84;

		System.out.println(roadsAnsLibrarieshelper(n, c_lib, c_road,
				new int[][] { { 8,2}, { 2,9 } }));
	}

	public static long roadsAnsLibrarieshelper(int n, int c_lib, int c_road, int[][] cities) {

		if (c_lib <= c_road) {
			return (long) c_lib * n;
		} else if (c_lib > c_road) {
			Graph g = new Graph();
			for (int i = 1; i <= n; i++) {
				g.addVertices(i);
			}
			for (int i = 0; i < cities.length; i++) {
				g.addEdge(cities[i][0], cities[i][1]);
			}
			ArrayList<Integer> list = g.gcc();
			System.out.println(list);
			long ans = 0;
			for (int str : list) {
				int size = str;
				long a = (long) c_lib;
				long b = (long) c_road;
				b *= (size - 1);
				ans += a + b;
//				int size = str.length();
//				long a = (long) c_lib;
//				long b = (long) c_road;
//				b *= (size - 1);
//				ans += a + b;
//				ans += (c_lib) + ((size - 1) * c_road);
			}
			return ans;
		}
		return 0;
	}

	static class Graph {
		HashMap<Integer, HashMap<Integer, Integer>> vces = new HashMap<>();

		public void addVertices(int n) {
			vces.put(n, new HashMap<>());
		}

		public void addEdge(int u, int v) {
			vces.get(u).put(v, 1);
			vces.get(v).put(u, 1);
		}

		public ArrayList<Integer> gcc() {
			ArrayList<Integer> list = new ArrayList<>();
			HashSet<Integer> visited = new HashSet<>();
			int oldSize = 0;
			for (int vertices : vces.keySet()) {
				if (visited.contains(vertices) == false) {
					gcchelper(vertices, visited);
					list.add(visited.size() - oldSize);
					oldSize = visited.size();
				}
			}
			return list;
		}

		public void gcchelper(int s, HashSet<Integer> visited) {
			String ans = "";
			LinkedList<Integer> stack = new LinkedList<>();
			stack.add(s);
			while (stack.size() > 0) {
				int rem = stack.removeFirst();
				if (visited.contains(rem)) {
					continue;
				}
				ans += rem;
				visited.add(rem);
				for (int nbr : vces.get(rem).keySet()) {
					if (visited.contains(nbr) == false) {
						stack.addFirst(nbr);
					}
				}
			}
		}

	}

}
