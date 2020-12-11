import java.util.*;

// Program for Alternating split of a given Singly Linked


class AlternatingSplitLinkedList {
	
	// head of linkedlist
	Node head;
	Node listA;
	Node listB;

	AlternatingSplitLinkedList() {
		head = null;
		listA = new Node(-1);
		listB = new Node(-1);
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

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void alternatingSplitLinkedList() {
		Node curr = head;
		int count = 1;
		Node currA = listA;
		Node currB = listB;

		while(curr != null) {
			if(count % 2 == 1) {
				currA.next = curr;
				currA = currA.next;
			}
			else {
				currB.next = curr;
				currB = currB.next;
			}
			count++;
			curr = curr.next;
		}

		currA.next = null;
		currB.next = null;

		listA = listA.next;
		listB = listB.next;
	}


	public static void main(String[] args) {
		AlternatingSplitLinkedList ll = new AlternatingSplitLinkedList();

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
		
		ll.alternatingSplitLinkedList();

		System.out.println("\nlistA");
		ll.printList(ll.listA);
		System.out.println("\nlistB");
		ll.printList(ll.listB);
	}
}