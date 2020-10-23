package tree;

public class Mirror {
	
	public static boolean checkForMirror(Node root) {
		if(root == null) {
			return true;
		}else {
			return isMirror(root.left, root.right);
		}
	}
	
	public static boolean isMirror(Node node1, Node node2) {
		if(node1 == null && node2 == null) {
			return true;
		}else if(node1 != null && node2 != null && node1.data == node2.data) {
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
		}
		
		return false;
	}
	
	

	public static void main(String[] args) {
		Node node = new Node(1);
		
		node.left = new Node(2);
		node.left.left = new Node(3);
		node.left.right = new Node(4);
		
		node.right = new Node(2);
		node.right.left = new Node(4);
		node.right.right = new Node(3);
		
		
		System.out.println("Is given tree is mirror tree");
		

	}

}
