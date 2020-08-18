package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintTreeLeafPaths {
	
	public static List<String> printNodePaths(Node node){
		if(node.left == null && node.right == null ){
	    	List<String> newList = new ArrayList<String>();
	    	newList.add(node.data+"");
	        return newList;
	    }
		
		List<String> finalList = new ArrayList<String>();
		if(node.left!=null) {
			finalList.addAll(printNodePaths(node.left));
		}
		if(node.right!=null) {
			finalList.addAll(printNodePaths(node.right));
		}
		
		for (int i = 0; i < finalList.size(); i++) {
			finalList.set(i, node.data+finalList.get(i));
		}
	    return finalList;
	}
	
	

	public static void main(String[] args) {
		Node node = Tree.createTree();
		System.out.println(printNodePaths(node));
		
		
	}

}
