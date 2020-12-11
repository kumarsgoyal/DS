import java.util.*;

// Delete all odd or even positioned nodes from Circular Linked List

class DeleteOddEvenPostionNodes {
	
	// head of linkedlist
	Node head;
	Node last;

	DeleteOddEvenPostionNodes() {
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

	public void deleteEvenPostionNodes() {
		
	}

	public void deleteOddPostionNodes() {
		if(head == null) {
			return;
		}
		else if(head.next == head) {
			head = null;
			return;
		}
		else {
			Node dummy = new Node(0);
			dummy.next = head;

			
		}
	}

	public static void main(String[] args) {
		DeleteOddEvenPostionNodes cl = new DeleteOddEvenPostionNodes();

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

		System.out.println("Enter 1 for odd or 2 for even");
		int choice = sc.nextInt();
		if(choice == 1) {
			cl.deleteOddPostionNodes();
		}
		else if(choice == 2) {
			cl.deleteEvenPostionNodes();
		}
		cl.deleteOddPostionNodes();
		cl.printList(cl.head);
		
	}
}

