package com.onmo.linkedkist;

class LinkedList
{
    Node head;
    
    public void push(int data){
    	Node newNode = new Node(data);
    	newNode.next = head;
    	head = newNode;
    }
    
    public void push(Node newNode){
    	newNode.next = head;
    	head = newNode;
    }

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
    
}