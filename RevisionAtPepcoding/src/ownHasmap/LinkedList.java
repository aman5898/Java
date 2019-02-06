package ownHasmap;

public class LinkedList<T> {

	private class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public T getfirst() {
		if (size == 0) {
			return null;

		} else
			return head.data;
	}

	public T getlast() {
		if (size == 0)
			return null;
		else
			return tail.data;
	}

	public T getat(int idx) {
		if (idx < 0 || idx >= size) {
			return null;

		} else {

			Node temp = head;
			for (int i = 0; i < idx; i++) {

				temp = temp.next;

			}

			return temp.data;

		}

	}

	public Node getNodeAt(int idx) {

		if (idx < 0 || idx >= size) {
			return null;

		} else if (idx == 0) {
			return head;

		} else if (idx == size - 1) {
			return tail;
		} else {
			Node temp = head;

			for (int i = 0; i < idx; i++) {

				temp = temp.next;

			}

			return temp;
		}
	}

	public void addfirst(T data) {
		Node node = new Node();
		node.data = data;
		if (this.size() == 0) {
			head = tail = node;

		} else {

			node.next = head;
			head = node;
		}
		size++;

	}

	public void addlast(T data) {

		Node node = new Node();
		node.data = data;
		if (this.size() == 0) {

			head = tail = node;

		} else {

			tail.next = node;
			tail = node;

		}

		size++;

	}

	public void addat(T data, int idx) {
		if (idx < 0 | idx > size) {
			return;
		}

		else if (idx == 0) {
			addfirst(data);

		} else if (idx == size) {
			addlast(data);
		} else {
			Node node = new Node();
			node.data = data;

			Node temp = head;

			for (int i = 0; i < idx - 1; i++) {

				temp = temp.next;

			}
			node.next = temp.next;
			temp.next = node;
			size++;

		}
	}

	public T removefirst() {
		if (size == 0) {
			return null;
		}

		T ret = head.data;
		head = head.next;
		size--;

		if (size == 0) {
			head = tail = null;

		}

		return ret;

	}

	public T removelast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			T a = head.data;
			head = tail = null;
			size--;
			return a;
		} else {
			Node temp = head;
			Node ret = tail;
			for (int i = 0; i < size - 2; i++) {

				temp = temp.next;

			}
			temp.next = null;
			tail = temp;
			size--;

			return ret.data;

		}

	}

	public T removeat(int idx) {
		if (idx < 0 | idx >= size) {
			return null;
		} else if (idx == 0) {
			return removefirst();
		} else if (idx == size - 1) {
			return removelast();
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

}
