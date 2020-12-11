import java.util.*;

// Program for Move last element to front of a given Linked List


class MoveLastToFront {
	
	// head of linkedlist
	Node head;

	MoveLastToFront() {
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

	public void moveLastToFront() {
		Node curr = head;
		Node prev = null;
		if(curr != null && curr.next != null) {
			while(curr != null && curr.next != null) {
				prev = curr;
				curr = curr.next;
			}

			prev.next.next = head;
			head = prev.next;
			prev.next = null;

		}
	}



	public static void main(String[] args) {
		MoveLastToFront ll = new MoveLastToFront();

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

		ll.moveLastToFront();
		System.out.println("");
		ll.printList();

	}
}