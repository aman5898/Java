package graph;

import java.util.PriorityQueue;

public class Kruskals {

	public static void main(String[] args) {
		Integer[][] graph = new Integer[6][6];
		graph[0][1] = 2;
		graph[0][2] = 3;
		graph[1][3] = 5;
		graph[3][5] = 2;
		graph[2][3] = 1;
		graph[2][4] = 3;
		graph[4][5] = 7;

		Integer[][] mst = kruskal(graph);
		for (int u = 0; u < mst.length; u++) {
			for (int v = 0; v < mst.length; v++) {
				System.out.print(mst[u][v] + "\t");
			}
			System.out.println();
		}
	}

	private static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int wt;

		public Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}

	}

	private static class DSNode {
		int vtx;
		DSNode parent;
		int rank;

		public DSNode(int vtx) {
			this.vtx = vtx;
			this.rank = 1;
			this.parent = this;
		}
	}

	private static Integer[][] kruskal(Integer[][] graph) {
		Integer[][] mst = new Integer[graph.length][graph.length];
		DSNode[] djset = new DSNode[graph.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < graph.length; i++) {
			djset[i] = new DSNode(i);
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] != null) {
					pq.add(new Edge(i, j, graph[i][j]));
				}
			}
		}
		while (pq.size() > 0) {
			Edge rem = pq.remove();
			DSNode uparent = find(djset[rem.u]);
			DSNode vparent = find(djset[rem.v]);
			if (uparent != vparent) {
				mst[rem.u][rem.v] = graph[rem.u][rem.v];
				merge(djset[rem.u], djset[rem.v]);
			}
		}
		return mst;
	}

	private static void merge(DSNode uNode, DSNode vNode) {
		if (uNode.rank > vNode.rank) {
			vNode.parent = uNode;
		} else if (uNode.rank < vNode.rank) {
			uNode.parent = vNode;
		} else {
			vNode.parent = uNode;
			uNode.rank++;
		}
	}

	private static DSNode find(DSNode node) {
		if (node.parent == node) {
			return node;
		} else {
			DSNode parent = find(node.parent);
			node.parent = parent;
			return parent;
		}
	}

}
