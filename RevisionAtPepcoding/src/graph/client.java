package graph;

public class client {

	public static void main(String[] args) {
		Graph g = new Graph();
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("E");
//		g.addVertex("F");
//		
//		g.addEdge("A", "B", 2);
//		g.addEdge("B", "D", 4);
//		g.addEdge("A", "C", 3);
//		g.addEdge("C", "D", 7);
//		g.addEdge("C", "E", 1);
//		g.addEdge("D", "E", 2);
//		g.addEdge("D", "F", 10);
//		g.addEdge("E", "F", 3);

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "D", 40);
		g.addEdge("B", "A", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("F", "E", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);
//		System.out.println(g.bfs("A","G"));
//		g.addEdge("F", "C", 3); // add this to make a hamiltonian cycle
//		g.dijkstra("A");
		Graph mst=g.prims();
		mst.display();

//		g.display();
//		System.out.println(g.dfs("A", "G"));
//		System.out.println(g.isBipartite());
//		g.hamiltonianPath("C");
//		g.gcc();
//		g.removeEdge("B", "C");
//		g.display();
//		g.removeVertex("D");
//		g.display();
//		System.out.println(g.hasPath("A","G"));
//		g.printHasPath("A", "G");
//		g.klargestPW(3,"A", "F");
//		System.out.println(g.printHasPath(), destination););
//		boolean bl = isKnightsTour(new int[5][5], 1, 3, 1);
//		System.out.println(bl);
	}

	static int[] rowmove = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] colmove = { 1, -1, 1, -1, 2, -2, 2, -2 };

	public static boolean isKnightsTour(int[][] chess, int row, int col, int moveno) {

		if (row < 0 || row >= chess.length) {
			return false;
		}
		if (col < 0 || col >= chess[0].length) {
			return false;
		}
		if (chess[row][col] != 0) {
			return false;
		}
		chess[row][col] = moveno;
		if (moveno == chess.length * chess.length) {
			System.out.println("------------------------------");
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess[0].length; j++) {
					System.out.print(chess[i][j] + "\t");
				}
				System.out.println();
			}
			return true;
		}

		boolean found = false;

		for (int i = 0; i < 8; i++) {

			found = found || isKnightsTour(chess, row + rowmove[i], col + colmove[i], moveno + 1);

		}
		chess[row][col] = 0;
		return found;
	}

}
