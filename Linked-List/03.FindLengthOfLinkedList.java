import java.util.*;

// Write a function to get length of a Linked List



class FindLengthOfLinkedList {
	
	// head of linkedlist
	Node head;

	FindLengthOfLinkedList() {
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

	public int findLengthfunc() {
		int len = 0;
		Node temp = head;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	public int findLengthrecur(Node temp) {
		if(temp == null) {
			return 0;
		}
		return (1 + findLengthrecur(temp.next));
	}

	public static void main(String[] args) {
		FindLengthOfLinkedList ll = new FindLengthOfLinkedList();

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
		
		int len1 = ll.findLengthfunc();
		int len2 = ll.findLengthrecur(ll.head);
		System.out.println("\n" + len1 + "," + len2);
	}
}