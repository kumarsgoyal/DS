import java.util.*;

// Write a function to get Nth node in a Linked List


class GetNthLinkedList {
	
	// head of linkedlist
	Node head;

	GetNthLinkedList() {
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

	public void addElementFront(int num) {
		if(head == null) {
			head = new Node(num);
		}
		else {
			Node next = head;
			head = new Node(num);
			head.next = next;
		}
	}

	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public int findLengthfunc() {
		int len = 0;
		Node temp = head;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	public int getNthElement(int pos) {
		Node temp = head;
		int element = 0;
		while(temp != null && pos > 0) {
			pos--;
			element = temp.data;
			temp = temp.next;
		}

		if(pos == 0) {
			return element;
		}
		else {
			return -1;
		}
	}


	public static void main(String[] args) {
		GetNthLinkedList ll = new GetNthLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ll.addElementFront(num);
		}

		ll.printList();
		System.out.println("\n Enter the postion to get element 1th based indexing");
		int pos = sc.nextInt();
		System.out.print(ll.getNthElement(pos));	
	}
}