package com.onmo.linkedkist;

public class Test {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		list.head.next = second;
		
		Node third = new Node(3);
		second.next = third;
		
		System.out.println(list);
		
		Node fourth = new Node(4);
		fourth.next = list.head;
		list.head = fourth;
		
		System.out.println(list);
		
		int insertIndex = 1;
		Node newNode = new Node(5);
		
		Node currentNode = list.head;
		
		while(insertIndex > 1){
			currentNode = currentNode.next;
			insertIndex--;
		}
		
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		
		System.out.println(list);
		System.out.println("----------");
		
		Node endNode = new Node(6);
		currentNode = list.head;
		while(currentNode.next != null){
			currentNode = currentNode.next;
		}
		currentNode.next = endNode;
		
		System.out.println(list);
		
		Node deleteNode = list.head;
		int deleteIndex = 1;
		while(deleteIndex > 1){
			deleteNode = deleteNode.next;
			deleteIndex--;
		}
		
		deleteNode.next = deleteNode.next.next;
		
		System.out.println(list);
		
		int length = 1;
		
		currentNode = list.head;
		while(currentNode.next != null){
			currentNode = currentNode.next;
			length++;
		}
		System.out.println(length);
		
		Node slowPointer = list.head;
		Node fastPointer = list.head;
		
		while(fastPointer.next != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		System.out.println(slowPointer.data);
	}

}
