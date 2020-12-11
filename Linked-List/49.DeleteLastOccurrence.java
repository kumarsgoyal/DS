import java.util.*;

// Program for Delete last occurrence of an item from linked list


class DeleteLastOccurrence {
	
	// head of linkedlist
	Node head;


	DeleteLastOccurrence() {
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

	public void deleteLastOccurrence(int x) {
		Node dummy = new Node(0);
		dummy.next = head;

		Node store = null;
		Node prev = dummy;

		while(prev.next != null) {
			if(prev.next.data == x) {
				store = prev;
			}

			prev = prev.next;
		}

		if(store != null) {
			store.next = store.next.next;
		}

		head = dummy.next;
	}

	public static void main(String[] args) {
		DeleteLastOccurrence ll = new DeleteLastOccurrence();

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
		System.out.println("Enter the element to delete last occurrence");
		int x = sc.nextInt();


		ll.deleteLastOccurrence(x);
		System.out.println("");
		ll.printList();

	}
}