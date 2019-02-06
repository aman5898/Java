package genericTree;

import java.util.ArrayList;
import java.util.Stack;

import genricTree.GenericTree;
import genricTree.GenericTree.Node;

public class GenericTree {
	private Node root;
	private int size;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public GenericTree(int[] arr) {
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = arr[i];
				this.size++;
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
			size += size2(child);
		}

		return size + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			max = Math.max(max, max(child));
		}
		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int height = 0;
		for (Node child : node.children) {
			height = Math.max(height, height(child));
		}
		return height + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		boolean found = false;
		for (Node child : node.children) {
			found = found || find(child, data);
		}

		return found;
	}

	public ArrayList<Integer> nodeToRooTPath(int data) {
		return nodeToRooTPath(root, data);
	}

	private ArrayList<Integer> nodeToRooTPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> arrlist = new ArrayList<>();
			arrlist.add(data);
			return arrlist;
		}

		for (Node child : node.children) {
			ArrayList<Integer> arrlist = nodeToRooTPath(child, data);
			if (arrlist.size() > 0) {
				arrlist.add(child.data);
				return arrlist;
			}
		}
		return new ArrayList<>();
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (Node child : node.children) {
			if (child.children.size() == 0) {
				node.children.remove(child);
			}
		}

		for (Node child : node.children) {
			removeLeaves(child);
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
			Node lnode = node.children.get(left);
			Node rnode = node.children.get(right);
			node.children.set(left, rnode);
			node.children.set(right, lnode);
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
			Node currChild = node.children.get(i);
			Node prevChild = node.children.get(i - 1);
			Node prevTail = getTail(prevChild);
			prevTail.children.add(currChild);
			node.children.remove(i);
		}

	}

	private Node getTail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node res = node.children.get(0);
		return res;
	}

	public static boolean areSimilarShaped(GenericTree gt1, GenericTree gt2) {
		return areSimilarShaped(gt1.root, gt2.root);
	}

	private static boolean areSimilarShaped(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		for (int i = 0; i < n1.children.size(); i++) {
			boolean bl = areSimilarShaped(n1.children.get(i), n2.children.get(i));
			if (bl == false) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean areMirrorImages(GenericTree gt1, GenericTree gt2) {
		return areMirrorImages(gt1.root, gt2.root);
	}

	private static boolean areMirrorImages(Node n1, Node n2) {
		
		return false;
	}
}
