import java.util.*;

// Write a function to Move all occurrences of an element to end in a linked 
// list that linked list.

class MoveToLast {
	
	// head of linkedlist
	Node head;

	MoveToLast() {
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

	public void moveToLast(int key) {
		Node curr = head;
		Node tail = null;
		if(curr == null || curr.next == null) {
			return;
		}

		while(curr.next != null) {
			curr = curr.next;
		}
		tail = curr;
		curr = head;

		Node last = tail;
		Node prev = null;
		while(curr != tail) {
			if(curr.data == key && prev == null) {
				prev = curr;
				curr = curr.next;
				head = curr;
				last.next = prev;
				last = last.next;
				last.next = null;
				prev = null;
			}
			else if(curr.data == key && prev != null) {
				Node temp = curr;
				prev.next = curr.next;
				last.next = temp;
				last = last.next;
				last.next = null;
				curr = prev.next;
			}
			else {
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public static void main(String[] args) {
		MoveToLast ll = new MoveToLast();

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
		System.out.println("\nEnter the number");
		int num = sc.nextInt();
		ll.moveToLast(num);
		ll.printList();
	}
}