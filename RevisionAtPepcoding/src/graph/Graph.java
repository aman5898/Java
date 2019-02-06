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
		HashSet<String> isVisited = new HashSet<>();
		return hasPath(source, destination, isVisited);
	}

	private boolean hasPath(String vname, String destination, HashSet<String> isVisited) {

		if (vname.equals(destination)) {
			return true;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr)) {
				continue;
			}
			boolean b1 = hasPath(nbr, destination, isVisited);
			if (b1 == true) {
				return true;
			}
		}
		return false;
	}

	public void printHasPath(String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		printHasPath(source, destination, isVisited, source);
	}

	private void printHasPath(String vname, String destination, HashSet<String> isVisited, String asf) {

		if (vname.equals(destination)) {
			System.out.println(asf);
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			printHasPath(nbr, destination, isVisited, asf + nbr);
		}
		isVisited.remove(vname);
	}

	private static String smallestPath;
	private static int smallerswt = Integer.MAX_VALUE;

	public void smallerPW(String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		smallerPW(source, destination, isVisited, source, 0);
		System.out.println(smallestPath + "aman" + smallerswt);
	}

	private void smallerPW(String vname, String destination, HashSet<String> isVisited, String asf, int wt) {

		if (vname.equals(destination)) {
			if (smallerswt > wt) {
				smallerswt = wt;
				smallestPath = asf;
			}
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			smallerPW(nbr, destination, isVisited, asf + nbr, wt + vces.get(vname).get(nbr));
		}
		isVisited.remove(vname);
	}

	private static String largestPath;
	private static int largerwt = Integer.MIN_VALUE;

	public void largerPW(String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		largerPW(source, destination, isVisited, source, 0);
		System.out.println(largestPath + " " + largerwt);
	}

	private void largerPW(String vname, String destination, HashSet<String> isVisited, String asf, int wt) {

		if (vname.equals(destination)) {
			if (largerwt < wt) {
				largerwt = wt;
				largestPath = asf;
			}
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			largerPW(nbr, destination, isVisited, asf + nbr, wt + vces.get(vname).get(nbr));
		}
		isVisited.remove(vname);
	}

	private static String ceilPath;
	private static int ceilwtmin = Integer.MAX_VALUE;

	public void ceilPW(int factor, String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		ceilPW(factor, source, destination, isVisited, source, 0);
		System.out.println(ceilPath + " " + ceilwtmin);
	}

	private void ceilPW(int factor, String vname, String destination, HashSet<String> isVisited, String asf, int wt) {

		if (vname.equals(destination)) {
			if (wt > factor) {
				if (ceilwtmin > wt) {
					ceilwtmin = wt;
					ceilPath = asf;
				}
			}
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			ceilPW(factor, nbr, destination, isVisited, asf + nbr, wt + vces.get(vname).get(nbr));
		}
		isVisited.remove(vname);
	}

	private static String floorPath;
	private static int foorwtmax = Integer.MIN_VALUE;

	public void floorPW(int factor, String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		floorPW(factor, source, destination, isVisited, source, 0);
		System.out.println(floorPath + " " + foorwtmax);
	}

	private void floorPW(int factor, String vname, String destination, HashSet<String> isVisited, String asf, int wt) {

		if (vname.equals(destination)) {
			if (wt < factor) {
				if (foorwtmax < wt) {
					foorwtmax = wt;
					floorPath = asf;
				}
			}
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			floorPW(factor, nbr, destination, isVisited, asf + nbr, wt + vces.get(vname).get(nbr));
		}
		isVisited.remove(vname);
	}

	private class pair implements Comparable<pair> {
		String path;
		int wt;

		@Override
		public int compareTo(pair o) {
			return this.wt - o.wt;
		}
	}

	static PriorityQueue<pair> pq = new PriorityQueue<>();

	public void klargestPW(int k, String source, String destination) {
		HashSet<String> isVisited = new HashSet<>();
		klargestPW(k, source, destination, isVisited, source, 0);
		while (pq.size() != 0) {
			System.out.println(pq.peek().path + " " + pq.remove().wt);
		}
	}

	private void klargestPW(int k, String vname, String destination, HashSet<String> isVisited, String asf, int wt) {

		if (vname.equals(destination)) {
			if (pq.size() < k) {
				pair p = new pair();
				p.path = asf;
				p.wt = wt;
				pq.add(p);
			} else {
				pair top = pq.peek();
				if (top.wt < wt) {
					pq.remove();
					pair p = new pair();
					p.path = asf;
					p.wt = wt;
					pq.add(p);
				}
			}
			return;
		}
		isVisited.add(vname);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			if (isVisited.contains(nbr) == true) {
				continue;
			}
			klargestPW(k, nbr, destination, isVisited, asf + nbr, wt + vces.get(vname).get(nbr));
		}
		isVisited.remove(vname);
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
		LinkedList<Tpair> q = new LinkedList<>();
		q.addLast(pair);
		HashSet<String> visited = new HashSet<>();
		while (q.size() > 0) {
			Tpair rem = q.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + "@" + rem.p);
			if (rem.v.equals(d)) {
				return true;
			}
			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
					q.addLast(npair);
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

	// write this component in gcc(return type arraylist) and gcc helper return type
	// string)(argument me hash set)
	public void gcc() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> paths = new ArrayList<>();
		for (String vertex : vces.keySet()) {
			if (visited.contains(vertex)) {
				continue;
			}
			String s = "";
			Tpair pair = new Tpair(vertex, vertex, 0);
			LinkedList<Tpair> q = new LinkedList<>();
			q.addLast(pair);

			while (q.size() > 0) {

				Tpair rem = q.removeFirst();
				if (visited.contains(rem.v)) {
					continue;
				}
				visited.add(rem.v);
				s += rem.v;
				for (String n : vces.get(rem.v).keySet()) {
					if (visited.contains(n) == false) {
						Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
						q.addLast(npair);
					}
				}
			}
			paths.add(s);
		}
		System.out.println(paths);
	}

	public boolean isCyclic() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> paths = new ArrayList<>();
		for (String vertex : vces.keySet()) {
			if (visited.contains(vertex)) {
				continue;
			}
			String s = "";
			Tpair pair = new Tpair(vertex, vertex, 0);
			LinkedList<Tpair> q = new LinkedList<>();
			q.addLast(pair);

			while (q.size() > 0) {

				Tpair rem = q.removeFirst();
				if (visited.contains(rem.v)) {
					return true;
				}
				visited.add(rem.v);
				s += rem.v;
				for (String n : vces.get(rem.v).keySet()) {
					if (visited.contains(n) == false) {
						Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
						q.addLast(npair);
					}
				}
			}
			paths.add(s);
		}
		return false;
	}

	public boolean isConnected() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> paths = new ArrayList<>();
		for (String vertex : vces.keySet()) {
			if (visited.contains(vertex)) {
				continue;
			}
			String s = "";
			Tpair pair = new Tpair(vertex, vertex, 0);
			LinkedList<Tpair> q = new LinkedList<>();
			q.addLast(pair);

			while (q.size() > 0) {

				Tpair rem = q.removeFirst();
				if (visited.contains(rem.v)) {
					continue;
				}
				visited.add(rem.v);
				s += rem.v;
				for (String n : vces.get(rem.v).keySet()) {
					if (visited.contains(n) == false) {
						Tpair npair = new Tpair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
						q.addLast(npair);
					}
				}
			}
			paths.add(s);
		}
		return paths.size() == 1;
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
		curr.addLast(s);
		int level = 1;
		while (curr.size() > 0) {
			String v = curr.removeFirst();
			if (visited.containsKey(v) == true) {
				int oldLevel = visited.get(v);
				if (oldLevel % 2 != level % 2) {
					return false;
				}
			}
			visited.put(v, level);
			for (String nbr : vces.get(v).keySet()) {
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
		hamiltonianPath(s, new HashSet<>(), s, s);
	}

	public void hamiltonianPath(String source, HashSet<String> visited, String psf, String oSource) {

		visited.add(source);
		if (visited.size() == vces.size()) {
			if (containsEdge(oSource, source)) {
				System.out.println("Path for Hamiltonian cycle is " + psf);
			}
			System.out.println(psf);
//			return; ye nhi aayega
		}
		for (String nbr : vces.get(source).keySet()) {
			if (visited.contains(nbr) == false) {
				hamiltonianPath(nbr, visited, psf + nbr, oSource);
			}
		}
		visited.remove(source);
	}

	public void dijkstra(String source) {
		HashSet<String> visited = new HashSet<>();
		Tpair p = new Tpair(source, source, 0);
		PriorityQueue<Tpair> pq = new PriorityQueue<>();
		pq.add(p);
		while (pq.size() > 0) {
			Tpair rem = pq.remove();
			if (visited.contains(rem.v)) {
				continue;
			}
			System.out.println(rem.p + "@" + rem.w);

			visited.add(rem.v);
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {
					pq.add(new Tpair(nbr, rem.p + nbr, rem.w + vces.get(nbr).get(rem.v)));
				}
			}
		}
	}

	private class PPair implements Comparable<PPair> {
		String v;
		String av;
		int aew;

		public PPair(String v, String av, int aew) {
			this.v = v;
			this.av = av;
			this.aew = aew;
		}

		@Override
		public int compareTo(PPair o) {
			return this.aew - o.aew;
		}
	}

	public Graph prims() {
		Graph mst = new Graph();
		ArrayList<String> allvces = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();
		String s = allvces.get(0);
		PriorityQueue<PPair> pq = new PriorityQueue<>();
		pq.add(new PPair(s, null, 0));
		while (pq.size() > 0) {
			PPair rem = pq.remove();
			if (visited.contains(rem.v)) {
				continue;
			}
			mst.addVertex(rem.v);
			if (rem.av != null) {
				mst.addEdge(rem.v, rem.av, vces.get(rem.v).get(rem.av));
			}
			visited.add(rem.v);
			for (String nbr : vces.get(rem.v).keySet()) {
				if (visited.contains(nbr) == false) {
					pq.add(new PPair(nbr, rem.v, vces.get(rem.v).get(nbr)));
				}
			}

		}
		return mst;
	}
}
