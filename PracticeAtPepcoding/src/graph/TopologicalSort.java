package graph;

import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		boolean[][] graph = { { false, true, false, true, false, false }, { false, false, true, false, false, false },
				{ false, false, false, true, false, false }, { false, false, false, false, false, false },
				{ false, false, false, true, false, true }, { false, false, true, false, false, false } };
		topologicalSort(graph);
	}

	public static void topologicalSort(boolean[][] graph) {
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			if (visited.contains(i) == false) {
				topologicalSort(graph, i, visited, stack);
			}
		}
		System.out.println(stack);
	}

	private static void topologicalSort(boolean[][] graph, int source, HashSet<Integer> visited, Stack<Integer> stack) {
		visited.add(source);
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[source][j] == true) {
				if (visited.contains(j) == false) {
					topologicalSort(graph, j, visited, stack);
				}
			}
		}
		stack.add(source);
	}
	
	

}
