package binaryTree;


public class CountSubtreesThatSumUpToGivenValue {
	private Node root;

	public CountSubtreesThatSumUpToGivenValue() {
		root = new Node();
		root.data = 1;
		Node left = new Node();
		left.data = 2;
		Node right = new Node();
		right.data = 3;
		root.left = left;
		root.right = right;
	}

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public static int counter = 0;

	int countSubtreesWithSumX(int x) {
		return countSubtreesWithSumX(root,x);
	}
	int countSubtreesWithSumX(Node root, int x) {
		sum(root, x);
		return counter;
	}

	private int sum(Node node, int x) {
		if (node == null) {
			return 0;
		}
		int lsum = sum(node.left, x);
		int rsum = sum(node.right, x);
		int mysum = lsum + rsum + node.data;
		if (mysum == x) {
			counter++;
		}
		return mysum;
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
	
	public CountSubtreesThatSumUpToGivenValue(int[] preorder, int[] inorder) {
		root = helperPreIn(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
	}

	private Node helperPreIn(int preStart, int preEnd, int inStart, int inEnd, int[] pre, int[] in) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		Node node = new Node();
		node.data = pre[preStart];
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
}
