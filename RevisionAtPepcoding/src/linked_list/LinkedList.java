package linked_list;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	// o1
	public void addLast(int data) {
		Node node = new Node();
		node.data = data;

		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}

		size++;
	}

	private void addLastNode(Node node) {
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}

		size++;
	}

	// o1
	public int size() {
		return size;
	}

	// o1
	public boolean isEmpty() {
		return size == 0;
	}

	// on
	public void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println(".");
	}

	// o1
	public void addFirst(int data) {
		Node node = new Node();
		node.data = data;

		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}

		size++;
	}

	private void addFirstNode(Node node) {
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}

		size++;
	}

	// o1
	public int getFirst() {
		if (size == 0) {
			return -1;
		}
		return head.data;
	}

	// o1
	public int getLast() {
		if (size == 0) {
			return -1;
		}
		return tail.data;
	}

	// on
	public int getAt(int idx) {
		if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return -1;
		}
		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// on
	private Node getNodeAt(int idx) {
		if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return null;
		}
		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	// on
	public void addAt(int idx, int data) {
		if (idx < 0 || idx > size) {
			System.out.println("Index out of bound");
		} else if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;

			Node node = new Node();
			node.data = data;

			m1.next = node;
			node.next = n;
			size++;
		}
	}

	// o1
	public int removeFirst() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			Node node = head;

			head = tail = null;
			size--;

			return node.data;
		} else {
			Node node = head;

			head = head.next;
			size--;

			return node.data;
		}
	}

	private Node removeFirstNode() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node node = head;

			head = tail = null;
			size--;

			return node;
		} else {
			Node node = head;

			head = head.next;
			node.next = null;
			size--;

			return node;
		}
	}

	// on
	public int removeLast() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			Node node = head;

			head = tail = null;
			size--;

			return node.data;
		} else {
			int temp = tail.data;
			Node sl = getNodeAt(size - 2);

			tail = sl;
			sl.next = null; // mandatory to allow tail to get free
			size--;

			return temp;
		}
	}

	// on
	public int removeAt(int idx) {
		if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;
			Node p1 = n.next;

			m1.next = p1;
			size--;

			return n.data;
		}
	}

	public void reverseDI() {
		int left = 0;
		int right = size - 1;
		while (left < right) {
			Node leftnode = getNodeAt(left);
			Node rightnode = getNodeAt(right);

			int temp = leftnode.data;
			leftnode.data = rightnode.data;
			rightnode.data = temp;

			left++;
			right--;
		}
	}

	public void reversePI() {
		if (size == 1) {
			return;
		}

		Node a = head;
		Node b = a.next;
		Node c = b.next;

		while (b != null) {
			b.next = a;
			a = b;
			b = c;
			if (c != null) {
				c = c.next;
			}
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private Node IsPalindromeLeft;

	public boolean IsPalindrome() {
		IsPalindromeLeft = head;
		return IsPalindrome(head);
	}

	private boolean IsPalindrome(Node right) {
		if (right == null) {
			return true;
		}
		boolean recRes = IsPalindrome(right.next);
		if (recRes == true) {
			if (IsPalindromeLeft.data == right.data) {
				IsPalindromeLeft = IsPalindromeLeft.next;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void fold() {
		foldLeft = head;
		fold(head, 0);
	}

	private Node foldLeft;

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.next, floor + 1);
		if (floor > size / 2) {
			Node temp = foldLeft.next;
			foldLeft.next = right;
			right.next = temp;
			foldLeft = temp;
		}

		if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}
	}

	public int mid() {
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthFromLast(int k) {
		Node fast = head;
		Node slow = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
		LinkedList res = new LinkedList();

		Node l1temp = l1.head;
		Node l2temp = l2.head;

		while (l1temp != null && l2temp != null) {
			if (l1temp.data < l2temp.data) {
				res.addLast(l1temp.data);
				l1temp = l1temp.next;
			} else {
				res.addLast(l2temp.data);
				l2temp = l2temp.next;
			}
		}

		while (l1temp != null) {
			res.addLast(l1temp.data);
			l1temp = l1temp.next;
		}

		while (l2temp != null) {
			res.addLast(l2temp.data);
			l2temp = l2temp.next;
		}

		return res;
	}

	public static LinkedList mergeSort(LinkedList list) {
		if (list.head == list.tail) {
			return list;
		}

		// split into two halfs
		Node mid = list.midNode();
		Node midnext = mid.next;

		LinkedList l1 = new LinkedList();
		l1.head = list.head;
		l1.tail = mid;

		LinkedList l2 = new LinkedList();
		l2.head = midnext;
		l2.tail = list.tail;

		mid.next = null;

		// sort the halfs
		l1 = mergeSort(l1);
		l2 = mergeSort(l2);

		// merge the halfs
		LinkedList sorted = mergeTwoSortedLists(l1, l2);

		// restore original list
		mid.next = midnext;

		// return
		return sorted;
	}

	private Node midNode() {
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public void kreverse(int k) {
		LinkedList prev = new LinkedList();
		LinkedList curr = null;

		while (this.size != 0) {
			for (int i = 0; i < k && this.size != 0; i++) {
				prev.addFirstNode(this.removeFirstNode());
			}

			if (curr == null) {
				curr = prev;
			} else {
				curr.tail.next = prev.head;
				curr.tail = prev.tail;
				curr.size += prev.size;
			}

			prev = new LinkedList();
		}

		this.head = curr.head;
		this.tail = curr.tail;
		this.size = curr.size;
	}

	// on, no space
	public void removeDuplicates() {
		LinkedList list = new LinkedList();
		while (this.size != 0) {
			if (list.size == 0 || list.tail.data != this.head.data) {
				list.addLastNode(this.removeFirstNode());
			} else {
				this.removeFirstNode();
			}
		}

		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}

	public void oddEvenSeparation() {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();

		while (this.size > 0) {
			if (this.head.data % 2 == 0) {
				even.addLastNode(this.removeFirstNode());
			} else {
				odd.addLastNode(this.removeFirstNode());
			}
		}

		if (odd.size > 0 && even.size > 0) {
			this.head = odd.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;

			odd.tail.next = even.head;
		} else if (odd.size > 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		}
	}

}