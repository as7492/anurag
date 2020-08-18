package linkedlist;

public class LinkedList {
	Node head;

	public boolean add(int data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return true;
	}

	public boolean addFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		return true;
	}

	public void reverse() {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
}
