package linkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_273DeleteNodesGreaterOnRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		deletenodes();
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(int data) {

		Node nn = new Node(data, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		size++;
	}

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// ---------------------------------------------------------
	// This is a functional problem. Only these functions have to be written.

	private static class heapmover {
		Node left;
	}

	public static void reverseaList() {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		head = prev;
	}

	private static void deletenodes() {
		reverseaList();
		Node prev=null;
		Node curr=head;
		int max=Integer.MIN_VALUE;
		while(curr!=null) {
			if(curr.data<max) {
				prev.next=curr.next;
				curr=curr.next;
			}else {
				max=Math.max(max,curr.data);
				prev=curr;
				curr=curr.next;
			}
		}
		reverseaList();
		display(head);
		
	}

	// --------------------------------------------------------

}