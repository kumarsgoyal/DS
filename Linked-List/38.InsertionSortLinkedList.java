import java.util.*;

// porgram for insertion sort for singly linked list


class InsertionSortLinkedList {
	
	// head of linkedlist
	Node head;
	Node sorted;

 	InsertionSortLinkedList() {
		head = null;
		sorted = null;
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

	public void sortedinsert(Node curr) {
		if(sorted == null || sorted.data >= curr.data) {
			curr.next = sorted;
			sorted = curr;
		}
		else {
			Node temp = sorted;

			while(temp.next != null && temp.next.data < curr.data) {
				temp = temp.next;
			}

			curr.next = temp.next;
			temp.next = curr;
		}
	}

	public void insertionSortLinkedList() {
		Node curr = head;

		while(curr != null) {
			Node next = curr.next;
			
			sortedinsert(curr);
			curr = next;
		}
	}


	public static void main(String[] args) {
	 	InsertionSortLinkedList ll = new InsertionSortLinkedList();

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

		ll.insertionSortLinkedList();

		System.out.println("");
		ll.printList(ll.sorted);
	}
}
