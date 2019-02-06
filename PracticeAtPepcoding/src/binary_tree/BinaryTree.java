package binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {

	private Node root;
	private int size;

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public BinaryTree(int[] arr) {
		Stack<Node> s = new Stack<>();
		Node node = new Node();
		node.data = arr[0];
		this.root = node;
		s.push(node);
		this.size++;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != -1) {
				Node temp = new Node();
				temp.data = arr[i];
				Node tp = s.peek();
				this.size++;
				if (tp.left == null) {
					tp.left = temp;
					s.push(temp);
				} else {
					tp.right = temp;
					s.push(temp);
				}
			} else {
				s.pop();
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.left.data);
		}
		System.out.print("=>" + node.data + "<=");
		if (node.right != null) {
			System.out.print(node.right.data);
		}
		System.out.println();
		display(node.left);
		display(node.right);
	}

	public int size1() {
		return size1(root);

	}

	private int size1(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size1(node.left);
		int rs = size1(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);

	}

	private int max(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = max(node.left);
		int rs = max(node.right);
		int mx = Math.max(ls, rs);

		return Math.max(mx, node.data);
	}

	public int min() {
		return min(root);

	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int ls = min(node.left);
		int rs = min(node.right);
		int mx = Math.min(ls, rs);

		return Math.min(mx, node.data);
	}

	public int height() {
		return height(root);

	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = height(node.left);
		int rs = height(node.right);
		int mx = Math.max(ls, rs);

		return mx + 1;
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
		boolean found = find(node.left, data);
		if (found == true) {
			return true;
		}
		boolean found1 = find(node.right, data);
		if (found1) {

			return true;

		}

		return false;

	}

	public void removeLeafs() {

		removeLeafs(root, root.left);
		removeLeafs(root, root.right);

	}

	private void removeLeafs(Node parent, Node child) {
		if (child == null) {
			return;
		}
		if (child.left == null && child.right == null) {
			if (parent.left == child) {
				parent.left = null;
			} else if (parent.right == child) {
				parent.right = null;
			}
		}

		removeLeafs(child, child.left);
		removeLeafs(child, child.right);
	}

	public void printpath(int lo, int hi) {
		printpath(root, lo, hi, "", 0);
	}

	private void printpath(Node node, int lo, int hi, String ans, int sum) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sum += node.data;
			ans += " " + node.data;
			if (sum >= lo && sum <= hi) {
				System.out.println(ans);
			}
			return;
		}
		printpath(node.left, lo, hi, ans + " " + node.data, sum + node.data);
		printpath(node.right, lo, hi, ans + " " + node.data, sum + node.data);
	}

	public ArrayList<Node> NodeToRoot(int data) {

		return NodeToRoot(root, data);

	}

	private ArrayList<Node> NodeToRoot(Node node, int data) {

		if (node == null) {
			return new ArrayList<Node>();
		}
		if (node.data == data) {
			ArrayList<Node> br = new ArrayList<>();
			br.add(node);
			return br;
		}

		ArrayList<Node> mleft = NodeToRoot(node.left, data);
		if (mleft.size() > 0) {
			mleft.add(node);
			return mleft;
		}

		ArrayList<Node> mright = NodeToRoot(node.right, data);
		if (mright.size() > 0) {
			mright.add(node);
			return mright;
		}

		return new ArrayList<Node>();

	}

	private void printkdown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
		}
		printkdown(node.left, k - 1);
		printkdown(node.right, k - 1);
	}

	public void printkaway(int data, int k) {
		ArrayList<Node> path = NodeToRoot(data);
		printkdown(path.get(0), k);
		for (int i = 1; i < path.size() && i < k; i++) {
			Node parent = path.get(i);
			Node child = path.get(i - 1);
			if (parent.left == child) {
				printkdown(parent.right, k - i - 1);
			} else if (parent.right == child) {
				printkdown(parent.left, k - i - 1);
			}
		}

		System.out.println(path.get(k).data);
	}

	public BinaryTree(int[] postorder, int[] inorder, int x) {
		root = helperPostIn(0, postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
	}

	private Node helperPostIn(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		Node node = new Node();
		node.data = postorder[postEnd];
		int pos = -1;
		this.size++;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == node.data) {
				pos = i;
			}
		}
		int lhs = pos - inStart;
		node.left = helperPostIn(postStart, postStart + lhs - 1, inStart, pos - 1, postorder, inorder);
		node.right = helperPostIn(postStart + lhs, postEnd - 1, pos + 1, inEnd, postorder, inorder);
		return node;
	}

	public BinaryTree(int[] preorder, int[] inorder) {
		root = helperPreIn(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
	}

	private Node helperPreIn(int preStart, int preEnd, int inStart, int inEnd, int[] pre, int[] in) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		Node node = new Node();
		node.data = pre[preStart];
		this.size++;
		int pos = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == node.data) {
				pos = i;
				break;
			}
		}
		int lhs = pos - inStart;
		node.left = helperPreIn(preStart + 1, preStart + lhs, inStart, pos - 1, pre, in);
		node.right = helperPreIn(preStart + lhs + 1, preEnd, pos + 1, inEnd, pre, in);
		return node;
	}

	public class pair {
		Node node;
		int wc = 0;

		public pair(Node node, int wc) {
			this.node = node;
			this.wc = wc;
		}
	}

	public void preIter() {
		Stack<pair> s = new Stack<>();
		s.add(new pair(this.root, 0));
		while (s.size() != 0) {
			pair top = s.peek();
			if (top == null) {
				continue;
			}
			if (top.wc == 0) {
				System.out.println(top.node.data);
				top.wc++;
			} else if (top.wc == 1) {
				if (top.node.left != null) {
					s.push(new pair(top.node.left, 0));
				}
				top.wc++;
			} else if (top.wc == 2) {
				if (top.node.right != null) {
					s.push(new pair(top.node.right, 0));
				}
				top.wc++;
			} else {
				s.pop();
			}
		}

	}
}
