package binaryTree;

public class MorrisTraversal {

	private Node root;

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public void morrisTraversal() {
		Node current = this.root;
		Node pred = null;
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.data);
				current = current.right;
			} else {

				pred = current.left;
				while (pred.right != null && pred.right != current) {
					pred = pred.right;
				}
				if (pred.right == null) {
					pred.right = current;
					current = current.left;
				} else {
					pred.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	public MorrisTraversal(int[] preorder, int[] inorder) {
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

	public void display() {

		display(root);

	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left != null ? node.left.data + "->" : ".->";

		str += node.right != null ? node.data + "<- " + node.right.data : node.data + "<- .";
		System.out.println(str);
		display(node.left);
		display(node.right);

	}
}
