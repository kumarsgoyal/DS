import java.util.*;

// Write a function to Remove all occurrences of duplicates from a sorted
// Linked List

class RemoveDuplicatesSorted {
	
	// head of linkedlist
	Node head;

	RemoveDuplicatesSorted() {
		head = null;
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(int num) {
		Node temp = head;
		if(head == null) {
			head = new Node(num);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(num);
		}
	}

	public void printList() {
		System.out.println("\n");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void removeDuplicatesSorted() {
		Node dummy = new Node(0);
		dummy.next = head;

		Node prev = dummy;
		Node curr = head;

		while(curr != null) {
			while(curr.next != null && prev.next.data == curr.next.data) {
				curr = curr.next;
			}

			if(prev.next == curr) {
				prev = prev.next;
				curr = curr.next;
			}
			else {
				prev.next = curr.next;
				curr = curr.next;
			}
		}

		head = dummy.next;

	}

	public static void main(String[] args) {
		RemoveDuplicatesSorted ll = new RemoveDuplicatesSorted();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}
		ll.printList();
		ll.removeDuplicatesSorted();
		ll.printList();
	}
}