package genricTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree(int[] arr) {
		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];

				if (stack.size() > 0) {
					stack.peek().children.add(node);
				} else {
					root = node;
				}

				stack.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String s = node.data + " -> ";
		for (Node child : node.children) {
			s += child.data + ", ";
		}
		s += ".";
		System.out.println(s);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int size = 0;

		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}

		size++; // for the node itself

		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;

		for (Node child : node.children) {
			int cmax = max(child);
			max = Math.max(max, cmax);
		}

		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = 0;

		for (Node child : node.children) {
			int cht = height(child);
			ht = Math.max(ht, cht);
		}

		ht++;

		return ht;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean childres = find(child, data);
			if (childres == true) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<Integer> nodeToRooTPath(int data) {
		return nodeToRooTPath(root, data);
	}

	private ArrayList<Integer> nodeToRooTPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> bres = new ArrayList<>();
			bres.add(node.data);
			return bres;
		}

		ArrayList<Integer> mres = new ArrayList<>();
		for (Node child : node.children) {
			ArrayList<Integer> rres = nodeToRooTPath(child, data);
			if (rres.size() > 0) {
				mres = rres;
				mres.add(node.data);
				return mres;
			}
		}

		return new ArrayList<>();
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);

			if (child.children.size() > 0) {
				removeLeaves(child);
			} else {
				node.children.remove(child);
			}
		}
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {
			Node leftnode = node.children.get(left);
			Node rightnode = node.children.get(right);
			node.children.set(left, rightnode);
			node.children.set(right, leftnode);

			left++;
			right--;
		}
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		for (int i = node.children.size() - 1; i > 0; i--) {
			Node lr = node.children.remove(i);
			Node sl = node.children.get(i - 1);
			Node sltail = getTail(sl);
			sltail.children.add(lr);
		}
	}

	private Node getTail(Node node) {
		Node tail = node;
		while (tail.children.size() != 0) {
			tail = tail.children.get(0);
		}
		return tail;
	}

	public void linearize2() {
		linearize2(root);
	}

	// linearizes and returns tail
	private Node linearize2(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node ltail = linearize2(node.children.get(node.children.size() - 1));
		while (node.children.size() > 1) {
			Node lr = node.children.remove(node.children.size() - 1);
			Node sl = node.children.get(node.children.size() - 1);
			Node sltail = linearize2(sl);
			sltail.children.add(lr);
		}
		return ltail;
	}

	public static boolean areSimilarShaped(GenericTree gt1, GenericTree gt2) {
		return areSimilarShaped(gt1.root, gt2.root);
	}

	private static boolean areSimilarShaped(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(i);

			boolean acss = areSimilarShaped(c1, c2);
			if (acss == false) {
				return acss;
			}
		}

		return true;
	}

	public static boolean areMirrorImages(GenericTree gt1, GenericTree gt2) {
		return areMirrorImages(gt1.root, gt2.root);
	}

	private static boolean areMirrorImages(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		int left = 0;
		int right = n1.children.size() - 1;
		while (left < n1.children.size()) {
			Node lc = n1.children.get(left);
			Node rc = n2.children.get(right);

			boolean acmi = areMirrorImages(lc, rc);
			if (acmi == false) {
				return acmi;
			}

			left++;
			right--;
		}

		return true;
	}

	// isFoldable
	public boolean isSymmetric() {
		return GenericTree.areMirrorImages(this, this);
	}

	// size, min, max, height
	public void multiSolver() {
		msSize = 0;
		msMin = Integer.MAX_VALUE;
		msMax = Integer.MIN_VALUE;
		msHeight = 0;
		multiSolver(root, 0);
		System.out.println("Size = " + msSize);
		System.out.println("Min = " + msMin);
		System.out.println("Max = " + msMax);
		System.out.println("Height = " + msHeight);
	}

	private int msSize = 0;
	private int msMin = Integer.MAX_VALUE;
	private int msMax = Integer.MIN_VALUE;
	private int msHeight = 0;

	private void multiSolver(Node node, int depth) {
		msSize++;
		msMin = Math.min(msMin, node.data);
		msMax = Math.max(msMax, node.data);
		msHeight = Math.max(depth, msHeight);

		for (Node child : node.children) {
			multiSolver(child, depth + 1);
		}
	}

	// ceil, floor
	public void mutliSolver2(int data) {
		ms2Ceil = null;
		ms2Floor = null;
		multiSolver2(root, data);
		System.out.println("Ceil = " + ms2Ceil);
		System.out.println("Floor = " + ms2Floor);
	}

	private Integer ms2Ceil = null;
	private Integer ms2Floor = null;

	private void multiSolver2(Node node, int data) {
		if (node.data > data) {
			ms2Ceil = ms2Ceil == null ? node.data : Math.min(ms2Ceil, node.data);
		}

		if (node.data < data) {
			ms2Floor = ms2Floor == null ? node.data : Math.max(ms2Floor, node.data);
		}

		for (Node child : node.children) {
			multiSolver2(child, data);
		}
	}

	// pred, succ
	public void mutliSolver3(int data) {
		prev = null;
		curr = null;
		pred = null;
		succ = null;
		multiSolver3(root, data);
		System.out.println("Pred = " + pred);
		System.out.println("Succ = " + succ);
	}

	private Integer prev = null;
	private Integer curr = null;
	private Integer pred = null;
	private Integer succ = null;

	private void multiSolver3(Node node, int data) {
		prev = curr;
		curr = node.data;
		if (curr == data) {
			pred = prev;
		}
		if (prev != null && prev == data) {
			succ = curr;
		}

		if (succ != null) {
			return;
		}

		for (Node child : node.children) {
			multiSolver3(child, data);
		}
	}

	// pred, succ
	public void mutliSolver4(int data) {
		ms4flag = 0;
		pred = null;
		succ = null;
		multiSolver4(root, data);
		System.out.println("Pred = " + pred);
		System.out.println("Succ = " + succ);
	}

	private int ms4flag = 0;

	private void multiSolver4(Node node, int data) {
		if (node.data == data) {
			ms4flag++;
		}

		if (ms4flag == 0) {
			pred = node.data;
		} else if (ms4flag == 1) {
			ms4flag++;
		} else if (ms4flag == 2) {
			succ = node.data;
			ms4flag++;
		}

		for (Node child : node.children) {
			multiSolver4(child, data);
		}
	}
}