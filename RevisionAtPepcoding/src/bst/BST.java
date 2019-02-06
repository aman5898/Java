package bst;

public class BST {
	Node root;
	int size;

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		Node node = new Node();
		int mid = (lo + hi) / 2;
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		return node;
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left != null ? node.left.data + "-> " : ".-> ";

		str += node.right != null ? node.data + "<- " + node.right.data : node.data + "<- .";
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return min(node.left);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}

		if (data > node.data) {
			return find(node.right, data);
		} else {
			return find(node.left, data);
		}
	}

	public void pir(int lo, int hi) {
		pir(root, lo, hi);
	}

	private void pir(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data > hi) {
			pir(node.left, lo, hi);
		} else if (node.data >= lo && node.data <= hi) {
			pir(node.left, lo, hi);
			System.out.println(node.data);
			pir(node.right, lo, hi);

		} else {
			pir(node.right, lo, hi);
		}
	}

	public void replaceWithSumOfLargerNodes() {
		replaceWithSumOfLargerNodes(root);
	}

	private int sum = 0;

	private void replaceWithSumOfLargerNodes(Node node) {
		if (node == null) {
			return;
		}

		replaceWithSumOfLargerNodes(node.right);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		replaceWithSumOfLargerNodes(node.left);

	}

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			Node temp = new Node();
			temp.data = data;
			return temp;
		}
		if (data > node.data) {
			node.right = add(node.right, data);
		} else {
			node.left = add(node.left, data);
		}

		return node;
	}

	public void remove(int data) {
		root = remove(root, data);
	}

	private Node remove(Node node, int data) {
		if (node.data > data) {
			node.left = remove(node.left, data);
		} else if (node.data < data) {
			node.right = remove(node.right, data);
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);

			}
		}
		return node;

	}

	public int lowestCommonAncestor(int d1, int d2) {
		return lowestCommonAncestor(root, d1, d2);
	}

	private int lowestCommonAncestor(Node node, int d1, int d2) {
		if (d1 > node.data && d2 > node.data) {
			return lowestCommonAncestor(node.right, d1, d2);
		} else if (d2 < node.data && d1 < node.data) {
			return lowestCommonAncestor(node.left, d1, d2);
		} else {
			return node.data;
		}
	}

	public void targetSumPair(int sum) {
		targetSumPair(root, sum);
	}

	private void targetSumPair(Node node, int sum) {

		if (node == null) {
			return;
		}
		if (find(sum - node.data)) {
			if (node.data < (sum - node.data)) {
				System.out.println(node.data + " " + (sum - node.data));
			}
		}
		targetSumPair(node.left, sum);
		targetSumPair(node.right, sum);

	}

}
