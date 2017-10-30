package com.onmo.linkedkist;

public class DetectLoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node node1 = new Node(4);
		list.push(node1);
		list.push(3);
		list.push(2);
		list.push(1);
		list.head.next.next.next.next = list.head;
		
		Node slow_p = list.head;
		Node fast_p = list.head;
		while(slow_p != null && fast_p != null){
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			System.out.println(slow_p.data+"--"+fast_p.data);
			if(slow_p == fast_p){
				System.out.println("LOOP FOUND");
				break;
			}
		}
		
		//System.out.println(list);
		
	}

}
