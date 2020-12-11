import java.util.*;

// Program for Reverse a given linked list


class ReverseLinkedList {
	
	// head of linkedlist
	Node head;
	Node newHead;

	ReverseLinkedList() {
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

	public void reverseLinkedList() {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void reverseLinkedListRecurUtil(Node temp, Node prev) {
		if(temp.next == null) {
			newHead = temp;
			temp.next = prev;
			return;
		}

		reverseLinkedListRecurUtil(temp.next, temp);
		temp.next = prev;
	}

	public void reverseLinkedListRecur() {
		reverseLinkedListRecurUtil(head, null);
		head = newHead;
	}

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();

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

		ll.reverseLinkedList();
		System.out.println("");
		ll.printList(ll.head);

		ll.reverseLinkedListRecur();
		System.out.println("");
		ll.printList(ll.head);
	}
}