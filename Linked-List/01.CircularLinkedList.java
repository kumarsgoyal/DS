import java.util.*;


// implement circular linked list

class CircularLinkedList {
	
	// head of linkedlist
	Node head;
	Node last;

	CircularLinkedList() {
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

	public void addElementFront(int num) {
		Node temp = new Node(num);
		if(head == null) {
			temp.next = temp;
			head = temp;
			last = temp;

		}
		else {
			temp.next = head;
			head = temp;
			last.next = head;
		}
	}

	public void addElementEnd(int num) {
		Node temp = new Node(num);
		if(head == null) {
			temp.next = temp;
			head = temp;
			last = temp;
		}
		else{
			last.next = temp;
			temp.next = head;
			last = temp;
		}
	}

	public void printList() {
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while(temp != head);
	}

	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		boolean flag = true;
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(flag == true) {
				cl.addElementEnd(num);
			}
			else {
				cl.addElementFront(num);
			}
			flag = !flag;;
		}

		cl.printList();
		
	}
}