package aVl;

public class Avl {
	private Node root;
	private int size = 0;

	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		int bal;
	}

	public Avl(int[] sa) {
		root = construct(0, sa.length - 1, sa);
	}

	private Node construct(int sIdx, int eIdx, int[] sa) {
		if (sIdx > eIdx) {

			return null;
		}
		Node node = new Node();
		this.size++;
		int mid = (sIdx + eIdx) / 2;
		node.data = sa[mid];
		node.left = construct(sIdx, mid - 1, sa);
		node.right = construct(mid + 1, eIdx, sa);
		setHnB(node);
		return node;
	}

	private void setHnB(Node node) {
		int lh = node.left != null ? node.left.height : 0;
		int rh = node.right != null ? node.right.height : 0;
		node.height = Math.max(lh, rh) + 1;
		node.bal = lh - rh;
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left != null ? node.left.data + " <- " : ". <- ";
		str += node.data + "[" + node.height + "," + node.bal + "]";
		str += node.right != null ? " -> " + node.right.data : " -> .";
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

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			this.size++;
			Node temp = new Node();
			temp.data = data;
			temp.height = 1;
			temp.bal = 0;
			return temp;
		}
		if (data > node.data) {
			node.right = add(node.right, data);
		} else if (data < node.data) {
			node.left = add(node.left, data);
		}

		setHnB(node);
		if (node.bal > 1 && data < node.left.data) {
			node = rightRotation(node);
		} else if (node.bal > 1 && data > node.left.data) {
			node.left = leftRotation(node.left);
			node = rightRotation(node);
		} else if (node.bal < -1 && data < node.right.data) {
			node.right = rightRotation(node.right);
			node = leftRotation(node);
		} else if (node.bal < -1 && data > node.right.data) {
			node = leftRotation(node);
		}

		return node;
	}

	private Node leftRotation(Node z) {
		Node y = z.right;
		Node t3 = y.left;
		y.left = z;
		z.right = t3;
		setHnB(z);
		setHnB(y);
		return y;

	}

	private Node rightRotation(Node z) {
		Node y = z.left;
		Node t3 = y.right;
		y.right = z;
		z.left = t3;
		setHnB(z);
		setHnB(y);
		return y;
	}

	public void remove(int data) {
		root = remove(root, data);
	}

	private Node remove(Node node, int data) {
		if (data < node.data) {
			node.left = remove(node.left, data);
		} else if (data > node.data) {
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
		setHnB(node);

		if (node.bal > 1 && node.left.bal >= 0) {
			node = rightRotation(node);
		} else if (node.bal > 1 && node.left.bal < 0) {
			node.left = leftRotation(node.left);
			node = rightRotation(node);
		} else if (node.bal < -1 && node.right.bal < 0) {
			node = leftRotation(node);
		} else if (node.bal < -1 && node.right.bal >= 0) {
			node.right = rightRotation(node.right);
			node = leftRotation(node);
		}
		return node;
	}
}
