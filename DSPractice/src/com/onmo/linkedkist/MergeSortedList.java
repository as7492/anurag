package com.onmo.linkedkist;

public class MergeSortedList {

	public static Node MergeListsRecursion(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.data < list2.data) {
			list1.next = MergeLists(list1.next, list2);
			return list1;
		} else {
			list2.next = MergeLists(list2.next, list1);
			return list2;
		}
	}

	public static Node MergeLists(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		Node head;
		if (list1.data < list2.data) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		while (list1.next != null) {
			if (list1.next.data > list2.data) {
				Node tmp = list1.next;
				list1.next = list2;
				list2 = tmp;
			}
			list1 = list1.next;
		}
		if (list1.next == null)
			list1.next = list2;
		return head;
	}
	
	public static Node MergeListsTwo(Node list1, Node list2) {
		Node node = null;
		if(list1.data <= list2.data){
			node = new Node(list1.data);
		}else{
			node = new Node(list2.data);
			Node temp = list1;
			list1 = list2;
			list2 = temp;
		}
		
		while(list1.next != null){
			list1 = list1.next;
			Node x = null;
			if(list1.data <= list2.data){
				x = new Node(list1.data);
			}else{
				x = new Node(list2.data);
				Node temp = list1;
				list1 = list2;
				list2 = temp;
			}
			x.next = node;
			node = x;
		}
		
		return node;
	}
	
	public static Node reverse(Node node) {
		Node current = node;
		Node next = null;
		Node prev = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.push(18);
		list1.push(12);
		list1.push(9);
		list1.push(3);

		LinkedList list2 = new LinkedList();
		list2.push(20);
		list2.push(15);
		list2.push(10);
		list2.push(5);

		/*Node node = MergeListsRecursion(list.head, list1.head);
		System.out.println(node);*/
		
		Node node1 = MergeListsTwo(list1.head, list2.head);
		System.out.println("--------------");
		System.out.println(node1);
		System.out.println(reverse(node1));
	}
}
