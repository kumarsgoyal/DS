import java.util.*;

// Write a function to Merge two sorted linked lists

class MergeTwoSortedLinkedList {
	
	// head of linkedlist
	Node head1;
	Node head2;
	Node finalList;

	MergeTwoSortedLinkedList() {
		head1 = new Node(0);
		head2 = new Node(0);
		finalList = null;
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

	public void mergeTwoSortedLinkedList() {
		Node curr1 = head1;
		Node curr2 = head2;
		Node dummy = new Node(0);
		Node ptr = dummy;

		while(curr1 != null && curr2 != null) {
			if(curr1.data <= curr2.data) {
				ptr.next = curr1;
				curr1 = curr1.next;
			}
			else {
				ptr.next = curr2;
				curr2 = curr2.next;
			}
			ptr = ptr.next;
		}

		while(curr1 != null) {
			ptr.next = curr1;
			ptr = ptr.next;
			curr1 = curr1.next;
		}

		while(curr2 != null) {
			ptr.next = curr2;
			ptr = ptr.next;
			curr2 = curr2.next;
		}

		finalList = dummy.next;
	}

	// pass head1 and head2 as argument
	public Node mergeTwoSortedLinkedListRec(Node curr1, Node curr2) {
		if(curr1 == null) {
			return curr2;
		}
		if(curr2 == null) {
			return curr1;
		}

		if (curr1.data < curr2.data) { 
            curr1.next = merge(curr1.next, h2); 
            return curr1; 
        } 
        else { 
            curr2.next = merge(curr1, curr2.next); 
            return curr2; 
        } 
	}

	public static void main(String[] args) {
		MergeTwoSortedLinkedList ll = new MergeTwoSortedLinkedList();

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

		ll.mergeTwoSortedLinkedList();

		ll.printList(ll.finalList);
	}
}