package linkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_271RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		removeDuplicates(head);
		display();

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

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	public static void removeDuplicates(Node head) {
	    Node curr=head;
        Node prev=null;
        HashMap<Integer,Integer> map=new HashMap();
        while(curr!=null){            
            if(map.containsKey(curr.data)){
                prev.next=curr.next;
                curr=curr.next;
            }else{
                map.put(curr.data,1);
                prev=curr;
                curr=curr.next;
            }    
            
        }
	}
	// -----------------------------------------------------

}