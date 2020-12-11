import java.util.*;

// Program for Add two numbers represented by linked lists


class AddNumberLinkedLists {
	
	// head of linkedlist
	Node listA;
	Node listB;
	Node head;

	AddNumberLinkedLists() {
		listA = new Node(0);
		listB = new Node(0);
		head = new Node(0);
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(Node temp, int num) {
		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(num);
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node reverseList(Node curr) {
		Node next = null;
		Node prev = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public void addNumberLinkedLists() {
		listA = reverseList(listA);
		listB = reverseList(listB);

		Node lista = listA;
		Node listb = listB;

		int rem = 0;
		int sum = 0;
		while(lista != null && listb != null) {
			sum = lista.data + listb.data + rem;
			rem = 0;
			if(sum >= 10) {
				rem = 1;
				sum = sum % 10;
			}
			addElementEnd(head, sum);
			lista = lista.next;
			listb = listb.next;
		}

		while(lista != null) {
			sum = lista.data + rem;
			rem = 0;
			if(sum >= 10) {
				rem = 1;
				sum = sum % 10;
			}
			addElementEnd(head, sum);
			lista = lista.next;
		}

		while(listb != null) {
			sum = listb.data + rem;
			rem = 0;
			if(sum >= 10) {
				rem = 1;
				sum = sum % 10;
			}
			addElementEnd(head, sum);
			listb = listb.next;
		}

		if(rem > 0) {
			addElementEnd(head, rem);
		}

	}



	public static void main(String[] args) {
		AddNumberLinkedLists ll = new AddNumberLinkedLists();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list A");
		int n1 = sc.nextInt();

		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.listA, num);
		}

		System.out.println("Enter the number of element in list B");
		int n2 = sc.nextInt();

		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.listB, num);
		}
		ll.listA = ll.listA.next;
		ll.listB = ll.listB.next;

		System.out.println("\nElement in list A");
		ll.printList(ll.listA);
		System.out.println("\nElement in list B");
		ll.printList(ll.listB);
		
		ll.addNumberLinkedLists();
		System.out.println("\nList Sum");

		ll.head = ll.head.next;
		ll.printList(ll.head);
	}
}