import java.util.*;

// count node in circular linkedlist

class CountCircularLinkedList {
	
	// head of linkedlist
	Node head;
	Node last;

	CountCircularLinkedList() {
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

	public int countCircularLinkedList() {
		Node curr = head;
		int count = 0;
		if(curr == null) {
			return count;
		}

		do {
			count++;
			curr = curr.next;
		} while(curr != head);

		return count;
	}

	public static void main(String[] args) {
		CountCircularLinkedList cl = new CountCircularLinkedList();

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
		System.out.println(cl.countCircularLinkedList());
		
	}
}
