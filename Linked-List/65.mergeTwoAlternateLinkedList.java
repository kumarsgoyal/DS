import java.util.*;

// Write a function to Merge a linked list into another linked list at 
// alternate positions

class MergeTwoAlternateLinkedList {
	
	// head of linkedlist
	Node head1;
	Node head2;

	MergeTwoAlternateLinkedList() {
		head1 = new Node(0);
		head2 = new Node(0);
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(Node temp, int num) {
		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(num);
	}

	public void printList(Node temp) {
		System.out.println("\n");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void mergeTwoAlternateLinkedList() {
		Node curr1 = head1;
		Node curr2 = head2;
		Node dummy1 = new Node(0);
		Node ptr = dummy1;
		Node dummy2 = new Node(0);

		while(curr1 != null && curr2 != null) {
			ptr.next = curr1;
			curr1 = curr1.next;
			ptr = ptr.next;

			ptr.next = curr2;
			curr2 = curr2.next;
			ptr = ptr.next;
		}

		ptr.next = null;

		if(curr1 != null) {
			dummy2.next = curr1;
		}

		if(curr2 != null) {
			dummy2.next = curr2;
		}

		head1 = dummy1.next;
		head2 = dummy2.next;
	}

	public static void main(String[] args) {
		MergeTwoAlternateLinkedList ll = new MergeTwoAlternateLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n1 = sc.nextInt();
		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head1, num);
		}

		System.out.println("Enter the number of element in list");
		int n2 = sc.nextInt();
		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head2, num);
		}

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);

		ll.mergeTwoAlternateLinkedList();

		ll.printList(ll.head1);
		ll.printList(ll.head2);
	}
}