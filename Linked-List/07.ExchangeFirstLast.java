import java.util.*;

// Exchange first and last nodes in Circular Linked List

class ExchangeFirstLast {
	
	// head of linkedlist
	Node head;
	Node last;

	ExchangeFirstLast() {
		head = null;
		last = null;
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElement(int num) {
		Node temp = new Node(num);
		if(head == null) {
			head = last = temp;
			head.next = head;
		}
		else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
	}


	public void printList(Node head) {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is Empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while(temp != head);
		System.out.println("");
	}

	public void exchangeFirstLast() {
		if(head == null) {
			return;
		}
		if(head.next == head) {
			return;
		}
		if(head.next.next == head) {
			Node curr = head;
			head = last;
			head.next = curr;
			curr.next = head;
			last = curr;
		}
		else {
			Node curr = head;
			while(curr.next != last) {
				curr = curr.next;
			}
			// curr is now second last node

			last.next = head.next;
			curr.next = head;
			head = last;
			last = curr.next;
			last.next = head;
		}
	}

	public static void main(String[] args) {
		ExchangeFirstLast cl = new ExchangeFirstLast();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			cl.addElement(num);
		}

		cl.printList(cl.head);
		cl.exchangeFirstLast();
		cl.printList(cl.head);
		
	}
}
