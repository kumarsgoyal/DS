import java.util.*;

// Add 1 to a number represented as linked list

// Below are the steps :
// 1) Reverse given linked list. For example, 1-> 9-> 9 -> 9 is converted to
// 9-> 9 -> 9 ->1.
// 2) Start traversing linked list from leftmost node and add 1 to it.
//    If there is a carry, move to the next node.
//    Keep moving to the next node while there is a carry.
// 3) Reverse modified linked list and return head.



class AddOneLinkedList {
	
	// head of linkedlist
	Node head;

	AddOneLinkedList() {
		head = null;
	}

	class Node {
		int data;
		Node next;

		Node(int a) {
			data = a;
			next = null;
		}
	}

	public void addElementEnd(int a) {
		if(head == null) {
			head = new Node(a);
		}
		else{
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(a);
		}
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node reverse(Node temp) {
		Node prev = null;
		Node curr = temp;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}


	public void addOneLinkedList() {
		Node temp = reverse(head);
		Node curr = temp;
		Node prev = null;
		int sum = 0;
		int rem = 1;

		while(curr != null) {
			sum = rem + curr.data;
			rem = 0;

			if(sum >= 10) {
				sum = sum - 10;
				rem = 1;
			}

			curr.data = sum;
			prev = curr;
			curr = curr.next;
		}

		if(rem != 0) {
			prev.next = new Node(rem);
		}
		
		head = reverse(temp);

	}

	public static void main(String[] args) {
	 	AddOneLinkedList ll = new AddOneLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int a = sc.nextInt();
			ll.addElementEnd(a);
		}

		ll.printList(ll.head);

		ll.addOneLinkedList();

		System.out.println("");
		ll.printList(ll.head);
	}
}
