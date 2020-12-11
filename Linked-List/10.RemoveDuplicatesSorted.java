import java.util.*;

// Program for Remove duplicates from a sorted 


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
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void removeDuplicates() {
		// Node curr = head;
		// if(curr == null || curr.next == null) {
		// 	return;
		// }

		// Node prev = head;
		// curr = head.next;

		// while(curr != null) {
		// 	if(curr.data == prev.data) {
		// 		curr = curr.next;
		// 		prev.next = curr;
		// 	}
		// 	else {
		// 		prev = curr;
		// 		curr = curr.next;
		// 	}
		// }
		
		Node curr = head;

		while(curr != null) {
			Node temp = curr;

			while(temp != null && temp.data == curr.data) {
				temp = temp.next;
			}

			curr.next = temp;
			curr = curr.next;
		}
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

		ll.removeDuplicates();

		ll.printList();

	}
}