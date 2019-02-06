package arrays;

//Java program to remove nodes on root to leaf paths of length < k 

/* Class containing left and right child of current 
node and key value*/
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	void removeShortPathNodes(Node node, int k) {
		removeShortPathNodesUtil(node, 1, k);
	}

	private int removeShortPathNodesUtil(Node node, int level, int k) {
		if (node == null) {
			return 0;
		}
		int lheight = removeShortPathNodesUtil(node.left, level + 1, k);
		int rheight = removeShortPathNodesUtil(node.right, level + 1, k);
		if (level + lheight < k) {
			node.left = null;
		}

		if (level + rheight < k) {
			node.right = null;
		}

		return 1 + Math.max(lheight, rheight);
	}

	void printInorder(Node node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}

	// Driver program to test for samples
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		int k = 4;
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);
		tree.root.right.right = new Node(6);
		tree.root.right.right.left = new Node(8);
		System.out.println("The inorder traversal of original tree is : ");
		tree.printInorder(tree.root);
		tree.removeShortPathNodes(tree.root, k);
		System.out.println("");
		System.out.println("The inorder traversal of modified tree is : ");
		tree.printInorder(tree.root);
	}
}

//This code has been contributed by Mayank Jaiswal 
