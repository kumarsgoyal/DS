import java.util.*;

// Program for Segregate even and odd nodes in a linked list


class SegregateEvenOdd {
	
	// head of linkedlist
	Node head, newHead;

	SegregateEvenOdd() {
		head = null;
		newHead = null;
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

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void segregateEvenOdd() {
		Node dummyOdd = new Node(-1);
		Node dummyEven = new Node(-1);

		Node tempodd = dummyOdd;
		Node tempeven = dummyEven;
		Node curr = head;

		while(curr != null) {
			if(curr.data % 2 == 0) {
				tempeven.next = curr;
				tempeven = tempeven.next;
			}
			else {
				tempodd.next = curr;
				tempodd = tempodd.next;
			}
			curr = curr.next;
		}

		newHead = dummyEven.next;
		tempeven.next = dummyOdd.next;
		tempodd.next = null;

	}

	public static void main(String[] args) {
		SegregateEvenOdd ll = new SegregateEvenOdd();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}

		ll.printList(ll.head);

		ll.segregateEvenOdd();

		System.out.println("");
		ll.printList(ll.newHead);
	}
}