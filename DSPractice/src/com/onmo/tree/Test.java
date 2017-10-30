package com.onmo.tree;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		root.right.right.right.left = new Node(16);
		root.right.right.right.left.left = new Node(17);
		root.right.right.right.left.left.left = new Node(18);
		root.right.right.right.left.left.left.left = new Node(19);
		System.out.println(root);
		
		System.out.println(height(root));
		printLevel(root, 4);
		inorderTraversal(root);
	}
	
	public static int height(Node root){
		if(root == null){
			return 0;
		}else{
			int rheight = height(root.right);
			int lheight = height(root.left);
			if(rheight > lheight){
				return rheight+1;
			}else{
				return lheight+1;
			}
		}
	}
	
	public static void printLevel(Node node, int level){
		if(node == null){
			return;
		}else if(level == 1){
			System.out.print(node.data+" ");
		}else if(level > 1){
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}
	
	public static void inorderTraversal(Node root){
		if(root==null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true){
			if(node.left != null){
				stack.push(node);
				node = node.left;
				continue;
			}else{
				System.out.print(node.data);
				node = stack.pop();
				System.out.print(node.data);
			}
			
			
			
			if(node.right != null){
				node = node.right;
				continue;
			}else{
				System.out.print(node.data);
			}
			
			if(node.left != null){
				continue;
			}else{
				System.out.print(node.data);
			}
		}
	}
	
	

}
