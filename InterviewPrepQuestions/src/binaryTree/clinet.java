package binaryTree;

public class clinet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
//
//		BinaryTree bt = new BinaryTree(arr);
//		 bt.display();
//		 System.out.println("*****************************************************************");
//		 bt.printsinglechild();

		/*
		 * System.out.println(bt.size1()); System.out.println(bt.max());
		 * System.out.println(bt.min()); System.out.println(bt.height());
		 */
		// bt.removeLeafs();

		// bt.display();
//		bt.printpath(150,250);

//		 System.out.println(bt.NodeToRoot(30));

//		int[] arr1 = { 0, 11, 21, 31, 41, -1, 42, -1, -1, 32, 43, 51, 61, -1,
//				-1, 52, 62, -1, 63, 71, -1, 72, -1, -1, -1, -1, 44, 53, 64, -1,
//				65, -1, -1, 54, -1, -1, -1, -1, 22, 33, 45, -1, 46, -1, -1, 34,
//				47, -1, 48, -1, -1, -1, -1, 12, 23, -1, 24, -1, -1, -1 };
//		BinaryTree bt1 = new BinaryTree(arr1);
//		bt1.display();
//		bt1.printsinglechild();
//		System.out
//				.println("*****************************************************************");
////		bt1.printkaway(43, 3);
		int[] pre = { 10,12,25,30,15,36};
		int[] in = { 25,12,30,10,36,15 };
////		int[] post = { 12, 37, 25, 62, 87, 75, 50 };
//
////		int[] pre = { 50, 25, 12, 37, 30, 24, 32, 40, 38, 42, 75, 62, 87 };
////		int[] in = { 12, 25, 24, 30, 32, 37, 38, 40, 42, 50, 62, 75, 87 };
		BinaryTree bt = new BinaryTree(pre, in);
////		bt.display();
////		BinaryTree bt = new BinaryTree(post, in, 7);
//		bt.display();
////		System.out.println(bt.largestBstNode());
//////		printBinaries(5);
////		bt.inIter();
//		bt.specificOrdreLevelTraversal2();
//		int[] pre = { 10, 30, 20, 5, 15 };
//		char[] preLN = { 'N', 'N', 'L', 'L', 'L' };
//		BinaryTree bt = new BinaryTree();
//		bt.specialTreeFromGivenPreorderTraversal(pre,preLN);
		bt.display();
//		bt.binaryTreeToDoublyLinkedList();
		System.out.println("aman");
		bt.leftSumTree();
		bt.display();
//		bt.display();
	}

}
