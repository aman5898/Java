package linkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_270IntersectionOfLinkedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		HashMap<Integer, Node> map = new HashMap<>();
		map.put(a1, head);
		for (Node node = head.next; node != null; node = node.next) {
			map.put(node.data, node);
		}
		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		insert2(a2);
		Node prev=head2;
		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			if(map.containsKey(a)) {
				prev.next=map.get(a);
				break;
			}
			prev=insert2(a);

		}

		System.out.println(findIntersectionPoint(head, head2).data);


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
	static Node head2;
	static Node tail2;
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

	public static Node insert2(int data) {

		Node nn = new Node(data, null);
		if (head2 == null) {
			head2 = nn;
			tail2 = nn;
		} else {
			tail2.next = nn;
			tail2 = nn;
		}
		size++;
		return nn;
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	public static Node findIntersectionPoint(Node headA, Node headB) {
		
		
        int asize=0;
         int bsize=0;
         Node temp=headA;
         while(temp!=null){
             asize++;
             temp=temp.next;
         }
         
         
         temp=headB;
         while(temp!=null){
             bsize++;
             temp=temp.next;
         }
         
         System.out.println(asize+" "+bsize);
         
         Node a=headA;
         Node b=headB;
         
         if(asize>bsize){
             int diff=asize-bsize;
             System.out.println(diff);
             while(diff-->0){
                 a=a.next;
             }
             
         }else{
             int diff=bsize-asize;
             while(diff-->0){
                 b=b.next;
             }
         }
         
         while(a!=null&&b!=null){
                 if(a.data==b.data){
                     return a;
                 }
                 a=a.next;
                 b=b.next;
        }
        return null;
	
	}


	// -----------------------------------------------------

}