package graph;

public class floydWarshall {

	public static void main(String[] args) {
		Integer[][] graph = new Integer[6][6];
		graph[0][1] = 2;
		graph[0][2] = 3;
		graph[1][3] = 5;
		graph[3][5] = 2;
		graph[2][3] = 1;
		graph[2][4] = 3;
		graph[4][5] = 7;

		for (int i = 0; i < graph.length; i++) {
			for (int s = 0; s < graph.length; s++) {
				for (int d = 0; d < graph.length; d++) {
					if (s == i || i == d || graph[s][i] == null || graph[i][d] == null || s == d) {
						continue;
					} else {
						if (graph[s][d] == null) {
							graph[s][d] = graph[s][i] + graph[i][d];
						} else {
							graph[s][d] = Math.min(graph[s][d], graph[s][i] + graph[i][d]);
						}
					}
				}
			}
		}
		for (int s = 0; s < graph.length; s++) {
			for (int d = 0; d < graph.length; d++) {
				System.out.print(graph[s][d] + "\t");
			}
			System.out.println();
		}
	}

}
