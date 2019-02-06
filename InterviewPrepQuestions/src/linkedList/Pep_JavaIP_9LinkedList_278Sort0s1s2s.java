package linkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_278Sort0s1s2s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		make3lists(head);
		display(head);
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
	// This is a functional problem. Only this function has to be written.
	
	public static void make3lists(Node node) {
		int zero=0;
        int one=0;
        int two=0;
        
        Node temp=node;
        while(temp!=null){
            if(temp.data==0){
                zero++;
            }else if(temp.data==1){
                one++;
            }else if(temp.data==2){
                two++;
            }
            
            temp=temp.next;
        }
        
        while(zero-->0){
            node.data=0;
            node=node.next;
        }
        
        while(one-->0){
            node.data=1;
            node=node.next;
        }
        
        while(two-->0){
            node.data=2;
            node=node.next;
        }
	}
	// --------------------------------------------------------


}