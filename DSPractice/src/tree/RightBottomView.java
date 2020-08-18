package tree;

public class RightBottomView {

	class Max_level { 		  
	    int max_level; 
	}
	
	public static void print(Node node, int level, Max_level max_level) {
		if(node == null) {
			return;
		}
		if(node.right != null) {
			print(node.right, level, max_level);
		}
		if(max_level.max_level < level) {
			System.out.println(node.data);
			max_level.max_level = level;
		}
		print(node.left, level+1, max_level);
		
	}

	public static void main(String[] args) {
		Node node = Tree.createTree();
		Max_level max_level = new RightBottomView().new Max_level();
		print(node,1,max_level);
	}

}
