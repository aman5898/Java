package trie;

import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;

		public String toString() {
			return eow ? data + "*" : data + "";
		}
	}

	private Node root;
	private int words;
	private int nodes;

	public Trie() {
		root = new Node();
		root.data = '$';
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		if (node.children.containsKey(ch)) {
			return searchWord(node.children.get(ch), ros);
		} else {
			return false;
		}
	}

	public void addWord(String word) {
		if (searchWord(word) == true) {
			return;
		}
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			this.words++;
			return;
		}
		char ch = word.charAt(0);
		if (node.children.containsKey(ch)) {
			addWord(node.children.get(ch), word.substring(1));
		} else {
			Node temp = new Node();
			this.nodes++;
			temp.data = ch;
			node.children.put(ch, temp);
			addWord(temp, word.substring(1));
		}
	}

	public void displayAllWords() {
		displayAllWords(root, "");
	}

	private void displayAllWords(Node node, String asf) {
		if (node.eow == true) {
			System.out.println(asf);
		}
		for (Character child : node.children.keySet()) {
			displayAllWords(node.children.get(child), asf + child);
		}
	}

	public void displayTrie() {
		displayTrie(root);
	}

	private void displayTrie(Node node) {

		System.out.print(node.data + "->" + node.children);

		System.out.println();
		for (Character child : node.children.keySet()) {
			displayTrie(node.children.get(child));
		}
	}

	public void removeWord(String word) {
		if (searchWord(word) == false) {
			return;
		}
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = false;
			this.words--;
			return;
		}
		char ch = word.charAt(0);
		if (node.children.containsKey(ch)) {
			Node child = node.children.get(ch);
			removeWord(child, word.substring(1));
			if (child.children.size() == 0 && child.eow == false) {
				this.nodes--;
				node.children.remove(ch);
			}
		}
	}
}