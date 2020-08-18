package linkedlist;

public class MergeSortedLinkedList {
	
	public static Node merge(Node a, Node b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		if(a.data <= b.data) {
			a.next = merge(a.next, b);
			return a;
		}else {
			b.next = merge(a, b.next);
			return b;
		}
		
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.add(1);
		list2.add(2);
		list1.add(3);
		list2.add(4);
		list1.add(5);
		list2.add(6);
		
		
		Node node = merge(list1.head, list2.head);
		System.out.println(node);

	}

}
