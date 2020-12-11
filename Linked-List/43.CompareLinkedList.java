import java.util.*;

// porgram for Compare two strings represented as linked lists


class CompareLinkedList {
	
	// head of linkedlist
	Node listA;
	Node listB;

 	CompareLinkedList() {
 		listA = new Node('1');
		listB = new Node('1');
	}

	class Node {
		char data;
		Node next;

		Node(char a) {
			data = a;
			next = null;
		}
	}

	public void addElementEnd(Node temp, char a) {
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(a);
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}


	public void compareLinkedList() {
		Node currA = listA.next;
		Node currB = listB.next;
		int flag = 0;
		while(currA != null && currB != null) {
			if(currA.data != currB.data) {
				flag = 1;
				break;
			}
			currA = currA.next;
			currB = currB.next;
		}

		if(flag == 1 || currA != null || currB != null) {
			System.out.println("\nList is not same");
		}
		else {
			System.out.println("\nList is same");
		}	
	}


	public static void main(String[] args) {
	 	CompareLinkedList ll = new CompareLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of elements in list");
		int size1 = sc.nextInt();

		for(int i = 0; i < size1; i++) {
			char a = sc.next().charAt(0);
			ll.addElementEnd(ll.listA, a);
		}

		System.out.println("Enter the number of elements in list");
		int size2 = sc.nextInt();

		for(int i = 0; i < size2; i++) {
			char a = sc.next().charAt(0);
			ll.addElementEnd(ll.listB, a);
		}

		System.out.println("");
		ll.printList(ll.listA);
		System.out.println("");
		ll.printList(ll.listB);

		ll.compareLinkedList();
	}
}
