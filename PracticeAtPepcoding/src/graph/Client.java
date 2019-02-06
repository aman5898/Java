package graph;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
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
//		g.hamiltonianPath("A");
//		g.dijkstra("A");
		Graph mst=g.prims();
		mst.display();
//		System.out.println(g.hasPath("A", "G"));
//		g.printAllPath("A","G");
//		System.out.println(g.dfs("A","G"));
//		g.gcc();

	}

}
