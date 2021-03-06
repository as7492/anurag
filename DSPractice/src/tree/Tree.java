package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	
	public static Node createTree() {
		Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(4);
		node.left.left.left = new Node(8);
		node.left.left.right = new Node(9);
		node.left.right = new Node(5);
		
		node.right = new Node(3);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		return node;
	}
	
	public static void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public static void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");
	}
	
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	public static int height(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right)); 
	}
	
	public static void printLevel(Node node, int level) {
		if(node == null) {
			return;
		}
		if(level == 1) {
			System.out.print(node.data+" ");
			return;
		}
		printLevel(node.left, level-1);
		printLevel(node.right, level-1);
	}
	
	public static void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.data+" ");
			if(curr.left != null) {
				queue.add(curr.left);
			}
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
	}
	
	public static void levelOrderLineByLine(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(null);

		while (!queue.isEmpty()) {

			Node curr = queue.poll();

			if (curr == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
					System.out.println();
				}
			} else {
				
				System.out.print(curr.data + " ");
				
				if (curr.left != null)
					queue.add(curr.left);

				if (curr.right != null)
					queue.add(curr.right);

			}
		}
	}
	
	public static void spiralOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		
		while(!queue.isEmpty() || !stack.isEmpty()) {
			
			while(!stack.isEmpty()) {
				Node curr = stack.pop();
				System.out.print(curr.data+" ");
				if(curr.left != null) {
					queue.add(curr.left);
				}
				if(curr.right != null) {
					queue.add(curr.right);
				}
			}
			
			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				System.out.print(curr.data+" ");
				if(curr.left != null) {
					stack.add(curr.left);
				}
				if(curr.right != null) {
					stack.add(curr.right);
				}
			}
		}
	}
	
	public static Node findLCA(Node node, int data1, int data2) {
		if(node == null) {
			return null;
		}
		if(node.data == data1 || node.data == data2) {
			return node;
		}
		Node leftNode = findLCA(node.left, data1, data2);
		Node rightNode = findLCA(node.right, data1, data2);
		
		if(leftNode != null && rightNode != null) {
			return node;
		}
		
		return leftNode != null ? leftNode : rightNode;
	}
	
	public static void boundryTraversal(Node node) {
		if(node == null) {
			return;
		}
		printLeftSide(node);
		printLeafs(node);
		printRightSide(node);
	}
	
	public static void printLeftSide(Node node) {
		if(node.left != null) {
			System.out.println(node.data);
			printLeftSide(node.left);
		}
	}
	
	public static void printRightSide(Node node) {
		if(node.right != null) {
			printLeftSide(node.right);
			System.out.println(node.data);
		}
	}
	
	public static void printLeafs(Node node) {
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
			return;
		}
		if(node.left != null) {
			printLeafs(node.left);
		}
		if(node.right != null) {
			printLeafs(node.right);
		}
	}
	
	
	
	public static void main(String args[]) {
		Node node = createTree();
		
		System.out.println("Inorder Traversal : ");
		inorder(node);
		System.out.println("\n----------------------------");
		
		System.out.println("Pre-Order Traversal : ");
		preorder(node);
		System.out.println("\n----------------------------");
		
		System.out.println("Post-Order Traversal : ");
		postorder(node);
		System.out.println("\n----------------------------");
		
		System.out.print("Height : "+height(node));
		System.out.println("\n----------------------------");
		
		System.out.println("Print Level 4 : ");
		printLevel(node, 4);
		
		System.out.println("\n----------------------------");
		System.out.println("Print Level Order : ");
		levelOrder(node);
		
		System.out.println("\n----------------------------");
		System.out.println("Print Level Order Line By Line : ");
		levelOrderLineByLine(node);
		
		System.out.println("\n----------------------------");
		System.out.println("Spiral Order : ");
		spiralOrder(node);
		
		System.out.println("\n----------------------------");
		System.out.println("LCA of (5,8) : ");
		System.out.println(findLCA(node, 5, 8).data);
		
		System.out.println("\n----------------------------");
		System.out.println("Boundry");
		boundryTraversal(node);
	}

}
