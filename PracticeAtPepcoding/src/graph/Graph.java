package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (containsVertex(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public int countEdges() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		int count = 0;
		for (String vname : vnames) {
			count += vces.get(vname).size();
		}

		return count / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		if (containsVertex(v1name) == false || containsVertex(v2name) == false) {
			return false;
		}
		return vces.get(v1name).containsKey(v2name); //
	}

	public void addEdge(String v1name, String v2name, int wt) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void removeVertex(String vname) {
		if (containsVertex(vname)) {
			ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
			for (String nbr : nbrs) {
				removeEdge(nbr, vname);
			}
			vces.remove(vname);
		}
	}

	public void display() {
		System.out.println("------------------------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			System.out.println(vname + "-" + vces.get(vname));
		}
	}

	public boolean hasPath(String source, String destination) {
		HashSet<String> visited = new HashSet<>();
		return hasPath(source, destination, visited);
	}

	private boolean hasPath(String source, String destination, HashSet<String> visited) {
		if (source.equals(destination)) {
			System.out.println(visited);
			return true;
		}
		visited.add(source);
		boolean found = false;
		for (String nbr : vces.get(source).keySet()) {
			if (visited.contains(nbr) == false) {
				found = found || hasPath(nbr, destination, visited);
			}
		}

		return found;
	}

	public void printAllPath(String source, String destination) {
		HashSet<String> visited = new HashSet<>();
		printAllPath(source, destination, visited, source);
	}

	private void printAllPath(String source, String destination, HashSet<String> visited, String asf) {
		if (source.equals(destination)) {
			System.out.println(asf);
			return;
		}
		visited.add(source);
		for (String nbr : vces.get(source).keySet()) {
			if (visited.contains(nbr) == false) {
				printAllPath(nbr, destination, visited, asf + nbr);
			}
		}

		visited.remove(source);

	}

	private class Tpair implements Comparable<Tpair> {
		String v;
		String p;
		int w;

		public Tpair(String v, String p, int w) {
			this.v = v;
			this.p = p;
			this.w = w;
		}

		@Override
		public int compareTo(Tpair o) {
			return this.w - o.w;
		}
	}

	public boolean bfs(String s, String d) {
		Tpair pair = new Tpair(s, s, 0);
		LinkedList<Tpair> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		queue.addLast(pair);
		// addLast removeFirst
		while (queue.size() > 0) {
			Tpair rem = queue.removeFirst();

			System.out.println(rem.v + "@" + rem.p);
			if (rem.v.equals(d)) {
				return true;
			}

			visited.add(rem.v);
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(new Tpair(nbr, rem.p + nbr, rem.w + vces.get(rem.v).get(nbr)));
				}
			}
		}
		return false;
	}

	public boolean dfs(String s, String d) {
		Tpair pair = new Tpair(s, s, 0);
		LinkedList<Tpair> stack = new LinkedList<>();
		stack.addFirst(pair);
		HashSet<String> visited = new HashSet<>();
		while (stack.size() > 0) {
			Tpair rem = stack.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + "@" + rem.p);
			if (rem.v.equals(d)) {
				return true;
			}
			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
					stack.addFirst(npair);
				}
			}
		}

		return false;
	}

	public void gcc() {
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> visited = new HashSet<>();
		for (String vertices : vces.keySet()) {
			if (visited.contains(vertices) == false) {
				list.add(gcchelper(vertices, visited));
			}
		}
		System.out.println(list);
	}

	public String gcchelper(String s, HashSet<String> visited) {
		String ans = "";
		LinkedList<String> stack = new LinkedList<>();
		stack.add(s);
		while (stack.size() > 0) {
			String rem = stack.removeFirst();
			if (visited.contains(rem)) {
				continue;
			}
			ans += rem;
			visited.add(rem);
			for (String nbr : vces.get(rem).keySet()) {
				if (visited.contains(nbr) == false) {
					stack.addFirst(nbr);
				}
			}
		}
		return ans;
	}

	public boolean isBipartite() {
		HashMap<String, Integer> visited = new HashMap<>();
		for (String vertex : vces.keySet()) {
			if (visited.containsKey(vertex) == false) {
				boolean b = isBipartite(vertex, visited);
				if (b == false) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isBipartite(String s, HashMap<String, Integer> visited) {
		LinkedList<String> curr = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();
		int level = 1;
		curr.add(s);
		while (curr.size() > 0) {
			String rem = curr.removeFirst();
			if (visited.containsKey(rem) == true) {
				int oldLevel = visited.get(rem);
				if (oldLevel % 2 != level % 2) {
					return false;
				}
			}

			visited.put(rem, level);
			for (String nbr : vces.get(rem).keySet()) {
				if (visited.containsKey(nbr) == false) {
					next.addLast(nbr);
				}
			}
			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<>();
				level++;
			}
		}
		return true;
	}

	public void hamiltonianPath(String s) {
		HashSet<String> visited = new HashSet<>();
		hamiltonianPath(s, visited, s);
	}

	private void hamiltonianPath(String s, HashSet<String> visited, String psf) {
		visited.add(s);
		if (visited.size() == vces.size()) {
			System.out.println(psf);
		}
		for (String nbr : vces.get(s).keySet()) {
			if (visited.contains(nbr) == false) {
				hamiltonianPath(nbr, visited, psf + nbr);
			}
		}
		visited.remove(s);
	}

	public void dijkstra(String s) {
		PriorityQueue<Tpair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();
		pq.add(new Tpair(s, s, 0));
		while (pq.size() > 0) {
			Tpair rem = pq.remove();
			if (visited.contains(rem.v)) {
				continue;
			}
			System.out.println(rem.v + "via" + rem.p + "@" + rem.w);
			visited.add(rem.v);
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {
					pq.add(new Tpair(nbr, rem.p + nbr, rem.w + vces.get(rem.v).get(nbr)));
				}
			}
		}
	}

	private class Ppair implements Comparable<Ppair> {
		String v;
		String ae;
		int aew;

		public Ppair(String v, String ae, int aew) {
			this.v = v;
			this.ae = ae;
			this.aew = aew;
		}

		@Override
		public int compareTo(Ppair o) {
			return this.aew - o.aew;
		}
	}

	public Graph prims() {
		Graph mst = new Graph();
		PriorityQueue<Ppair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();
		pq.add(new Ppair("A", null, 0));
		while (pq.size() > 0) {
			Ppair rem = pq.remove();
			if (visited.contains(rem.v)) {
				continue;
			}
			mst.addVertex(rem.v);
			if (rem.ae != null) {
				mst.addEdge(rem.v, rem.ae, rem.aew);
			}
			visited.add(rem.v);
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {
					pq.add(new Ppair(nbr, rem.v, vces.get(rem.v).get(nbr)));
				}
			}
		}
		return mst;
	}
}
