package com.onmo.linkedkist;

public class Reverse {
	
	public static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            System.out.println(prev);
        }
        node = prev;
        return node;
    }
	
	public static Node reverseTwo(Node node) {
       Node node2 = new Node(node.data);
       while(node.next != null){
    	   node = node.next;
    	   Node node3 = new Node(node.data);
    	   node3.next = node2;
    	   node2 = node3;
       }
       return node2;
    }

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.push(18);
		list1.push(12);
		list1.push(9);
		list1.push(3);
		
		System.out.println(list1.head);
		System.out.println(reverse(list1.head));
	}

}
