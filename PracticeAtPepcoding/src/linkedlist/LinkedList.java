package linkedlist;


public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		int data;
		Node next;
	}

	public int getFirst() {
		if (this.size == 0) {
			return -1;
		}
		return head.data;
	}

	public int getLast() {
		if (this.size == 0) {
			return -1;
		}
		return this.tail.data;
	}

	public int getAt(int idx) {
		if (idx >= size || idx < 0) {
			return -1;
		}
		Node temp = this.head;
		int count = 0;
		while (count < idx) {
			temp = temp.next;
			count++;
		}
		return temp.data;
	}

	public Node getNodeAt(int idx) {
		if (idx >= size || idx < 0) {
			return null;
		}
		Node temp = this.head;
		int count = 0;
		while (count < idx) {
			temp = temp.next;
			count++;
		}
		return temp;
	}

	public void addFirst(int data) {
		Node node = new Node();
		node.data = data;

		if (this.size == 0) {
			this.head = this.tail = node;
			size++;
			return;
		}
		size++;
		node.next = head;
		head = node;

	}

	public void addLast(int data) {
		Node node = new Node();
		node.data = data;

		if (size == 0) {
			this.head = this.tail = node;
			size++;
			return;
		}
		size++;
		tail.next = node;
		tail = node;
	}

	public void addat(int data, int idx) {
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == this.size) {
			addLast(data);
			return;
		}

		if (idx > size || idx < 0) {
			return;
		}

		Node preNode = getNodeAt(idx - 1);
		Node nextNode = preNode.next;
		Node node = new Node();
		node.data = data;
		preNode.next = node;
		node.next = nextNode;
		this.size++;
	}

	public int removeFirst() {
		if (size == 0) {
			return -1;
		}
		int rv = head.data;
		head = head.next;
		this.size--;
		if (size == 0) {
			head = tail = null;

		}
		return rv;
	}

	public int removeLast() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			int rv = head.data;
			head = tail = null;
			size--;
			return rv;
		}
		int rv = tail.data;
		Node secondLNode = getNodeAt(this.size - 2);
		secondLNode.next = null;
		tail = secondLNode;
		this.size--;
		return rv;
	}

	public int removeat(int idx) {
		if (idx < 0 | idx >= size) {
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node temp = head;
			for (int i = 0; i < idx - 1; i++) {
				temp = temp.next;

			}
			Node n = temp;

			temp = temp.next;
			n.next = temp.next;
			size--;
			return temp.data;
		}

	}

	public int size() {

		return this.size;
	}

	public void display() {

		for (Node node = head; node != null; node = node.next) {

			System.out.print(node.data + "->");
		}
		System.out.println();
	}

	public boolean isEmpty() {

		return size == 0;

	}

	public void reverseDI() {
		int left = 0;
		int right = this.size - 1;
		while (left < right) {
			Node lnode = getNodeAt(left);
			Node rnode = getNodeAt(right);
			int temp = lnode.data;
			lnode.data = rnode.data;
			rnode.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node curr = this.head;
		Node prev = null;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;
	}

	public Node left;

	public boolean Ispallindrome() {
		left = head;
		return Ispalindrome(head);
	}

	private boolean Ispalindrome(Node right) {
		if (right == null) {
			return true;
		}
		boolean bl = Ispalindrome(right.next);
		if (bl == false) {
			return false;
		}
		if (right.data != left.data) {
			return false;
		}

		left = left.next;

		return true;
	}

	private Node foldLeft;

	public void fold() {
		foldLeft = head;
		fold(head, 0);
	}

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.next, floor + 1);
		if (floor >= size / 2) {
			Node oleftnext = foldLeft.next;
			foldLeft.next = right;
			right.next = oleftnext;
			foldLeft = oleftnext;
		}

		if (floor == size / 2) {
			tail = right;
			tail.next = null;

		}
	}

	public int mid() {

		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;
	}
	
	public int kelementfromlast(int k) {

		Node fast = head;
		Node slow = head;
		int i = 0;
		while (i < k - 1) {
			fast = fast.next;
			i++;

		}

		while (fast.next != null) {

			slow = slow.next;
			fast = fast.next;

		}

		return slow.data;

	}
	
	public static LinkedList mergeTwosortedLL(LinkedList l1, LinkedList l2) {
		Node temp1=l1.head;
		Node temp2=l2.head;
		LinkedList myList=new LinkedList();
		while(true) {
			if(temp1.data<temp2.data) {
				
			}
		}
	}

}
