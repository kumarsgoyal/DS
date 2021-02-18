import java.util.*;

// Program for Identical Linked Lists


class IdenticalLinkedLists {
	
	// head of linkedlist
	Node listA;
	Node listB;

	IdenticalLinkedLists() {
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

	public boolean identicalLinkedListsItr() {
		Node currA = listA;
		Node currB = listB;

		while(currA != null && currB != null) {
			if(currA.data != currB.data) {
				return false;
			}
			currA = currA.next;
			currB = currB.next;
		}

		return (currA == null && currB == null);
	}

	public boolean identicalLinkedListsRec(Node lista, Node listb) {
		if(lista == null && listb == null) {
			return true;
		}
		return ((lista.data == listb.data) && 
			identicalLinkedListsRec(lista.next, listb.next));
	}


	public static void main(String[] args) {
		IdenticalLinkedLists ll = new IdenticalLinkedLists();

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

		System.out.println("\nElement in list A");
		ll.printList(ll.listA);
		System.out.println("\nElement in list B");
		ll.printList(ll.listB);
		
		System.out.println("\n" + ll.identicalLinkedListsItr());
		System.out.println(ll.identicalLinkedListsRec(ll.listA, ll.listB));
	}
}