import java.util.*;

// Convert singly linked list into circular linked list

class SinglytoCircular {
	
	// head of linkedlist
	Node head;

	SinglytoCircular() {
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

	public void printList(Node curr) {
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while(curr != head);

		System.out.println("");
	}

	public void converttoCircular() {
		Node curr = head;

		if(curr == null) {
			return;
		}

		while(curr.next != null) {
			curr = curr.next;
		}

		curr.next = head;
	}

	public static void main(String[] args) {
		SinglytoCircular ll = new SinglytoCircular();

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
		ll.converttoCircular();
		ll.printList(ll.head);
		
	}
}