package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };

		BinaryTree bt = new BinaryTree(arr);
		 bt.display();
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
//		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
//		int[] in = { 12, 25, 37, 50, 62, 75, 87 };
////		int[] post = { 12, 37, 25, 62, 87, 75, 50 };
//
////		int[] pre = { 50, 25, 12, 37, 30, 24, 32, 40, 38, 42, 75, 62, 87 };
////		int[] in = { 12, 25, 24, 30, 32, 37, 38, 40, 42, 50, 62, 75, 87 };
//		BinaryTree bt = new BinaryTree(pre, in);
////		bt.display();
////		BinaryTree bt = new BinaryTree(post, in, 7);
//		bt.display();
////		System.out.println(bt.largestBstNode());
//////		printBinaries(5);
////		bt.inIter();
//		bt.transform();
//		System.out.println("aman");
//		bt.display();
//		bt.transform2();
//		System.out.println("aman");
//		bt.display();
	}

	public static void printBinaries(int n) {
		Pair root = new Pair(1, "1");
		LinkedList<Pair> q = new LinkedList<>();
		// q add = add last
		// q remove = remove first
		int counter = 1;
		q.addLast(root);
		while (q.size() != 0) {
			Pair p = q.removeFirst();
			System.out.println(p.data + " " + p.bin);
			Pair left = new Pair(p.data * 2, p.bin + "0");
			Pair right = new Pair(p.data * 2 + 1, p.bin + "1");
			q.addLast(left);
			q.addLast(right);
			counter++;
			if (counter > n) {
				break;
			}
		}
	}

	private static class Pair {
		int data;
		String bin;

		public Pair(int d, String s) {
			this.data = d;
			this.bin = s;
		}
	}

}
