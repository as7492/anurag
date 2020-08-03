package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DiagonalTraversal {
	
	public static void traverse(Node node, int slope, HashMap<Integer, ArrayList<Integer>> map) {
		if(node == null) {
			return;
		}
		ArrayList<Integer> list = map.get(slope);
		if(list == null)
			list = new ArrayList<Integer>();
		
		list.add(node.data);
		
		map.put(slope, list);
		
		traverse(node.right, slope, map);
		traverse(node.left, slope+1, map);
		
	}

	public static void main(String[] args) {
		Node node = Tree.createTree();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		traverse(node, 0, map);
		
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
	}

}
