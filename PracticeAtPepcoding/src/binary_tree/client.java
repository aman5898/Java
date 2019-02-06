package binary_tree;


public class client {

	public static void main(String[] args) {
//		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
//
//		BinaryTree bt = new BinaryTree(arr);
//		bt.display();
//		bt.removeLeafs();
//		System.out.println("*****************************************************************");
//		bt.display();
//		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
//
//		BinaryTree bt = new BinaryTree(arr);
//		bt.printpath(150,250);
		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
		int[] in = { 12, 25, 37, 50, 62, 75, 87 };
		int[] post = { 12, 37, 25, 62, 87, 75, 50 };
		
		BinaryTree bt = new BinaryTree(post, in, 7);
		bt.display();
		bt.preIter();
	}

}
