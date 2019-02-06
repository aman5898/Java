package binaryTree;

import java.util.HashMap;

public class CloneATreeWithRandomPointers {
	
	private Node root;
	
	private class Node{
		int key;
		Node left;
		Node right;
		Node random;
	}
	
	
	public Node cloneTree(){
		HashMap<Node, Node> map=new HashMap<>();
		Node cloneRoot=cloneTreeLeftRight(root,map);
		cloneTreeRandom(root,cloneRoot,map);
		return cloneRoot;
	}
	
	
	private void cloneTreeRandom(Node node, Node cloneNode, HashMap<Node, Node> map) {
		if(node==null) {
			return;
		}
		cloneNode.random=map.get(node.random);
		cloneTreeRandom(node.left, cloneNode.left, map);
		cloneTreeRandom(node.right, cloneNode.right, map);
	}


	public Node cloneTreeLeftRight(Node node,HashMap<Node, Node> map) {
		if(node==null) {
			return null;
		}
		Node cloneNode = new Node();
		cloneNode.key=node.key;
		cloneNode.left=cloneTreeLeftRight(node.left,map);
		cloneNode.right=cloneTreeLeftRight(node.right,map);
		map.put(node, cloneNode);
		return cloneNode;
	}
}
