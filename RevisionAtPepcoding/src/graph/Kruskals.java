package graph;

import java.util.HashMap;
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

	public static class DSNode {
		int vtx;
		DSNode parent;
		int rank;

		public DSNode(int vtx) {
			this.vtx = vtx;
			this.rank = 1;
			this.parent = this;
		}
	}

	public static Integer[][] kruskal(Integer[][] graph) {
		HashMap<Integer, DSNode> djset = new HashMap<>();
		Integer[][] mst = new Integer[graph.length][graph.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int u = 0; u < graph.length; u++) {
			djset.put(u, new DSNode(u));
			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] != null) {
					pq.add(new Edge(u, v, graph[u][v]));
				}
			}
		}

		while (pq.size() > 0) {
			Edge rem = pq.remove();
			DSNode ulead = find(djset.get(rem.u));
			DSNode vlead = find(djset.get(rem.v));
			if (ulead != vlead) {
				mst[rem.u][rem.v] = rem.wt;
				merge(ulead, vlead);
			}
		}
		return mst;
	}

	private static void merge(DSNode uleadNode, DSNode vleadNode) {
		if (uleadNode.rank < vleadNode.rank) {
			uleadNode.parent = vleadNode;
		} else if (uleadNode.rank > vleadNode.rank) {
			vleadNode.parent = uleadNode;
		} else {
			uleadNode.parent = vleadNode;
			vleadNode.rank++;
		}
	}

	private static DSNode find(DSNode vnode) {
		if (vnode.parent == vnode) {
			return vnode;
		} else {
			DSNode pnode = find(vnode.parent);
			vnode.parent = pnode;
			return pnode;
		}
	}

}
