import java.util.*;

// Program for n’th node from the end of a Linked List



class GetLastNthLinkedList {
	
	// head of linkedlist
	Node head;

	GetLastNthLinkedList() {
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
	public int getLength() {
		Node temp = head;
		int len = 0;
		while(temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}

	public int getLastNthElement(int pos) {
		// calculate the length of Linked List. Let the length be len.
		// print the (len – n + 1)th node from the beginning of the LinkedList.
		
		int len = getLength();
		int result = -1;

		if(len == 0) {
			System.out.print("\nLinked List is empty");
		}
		else if(pos == len) {
			result = head.data;
		}
		else if(pos > len) {
			System.out.print("\nPosition is greater than list length");
			result = -1;
		}
		else {
			int i = len - pos + 1;
			Node temp = head;
			while(i > 0) {
				result = temp.data;
				temp = temp.next;
				i--;
			}
		}

		return result;
	}

	public int getLastNthElementfunc(int pos) {
		// maintain two pointers – reference pointer and main pointer.
		// Initialize both reference and main pointers to head. First, move
		// reference pointer to n nodes from head. Now move both pointers one 
		// by one until the reference pointer reaches the end. Now the main 
		// pointer will point to nth node from the end. Return the main
		// pointer.

		Node first = head;
		Node second = head;
		if(first == null) {
			System.out.println("\n Linked List is empty");
			return -1;
		}
		else {
			int count = 0;
			while(count < pos && first != null) {
				first = first.next;
				count++;
			}
			if(first == null && count < pos) {
				System.out.print("\nPosition is greater than list length");
				return - 1;
			}
			else {
				while(first != null) {
					first = first.next;
					second = second.next;
				}
				return second.data;
			}
		}

	}

	public static void main(String[] args) {
		GetLastNthLinkedList ll = new GetLastNthLinkedList();

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

		System.out.println("\nEnter the nth pos from last 1th based indexing");
		int nth = sc.nextInt();
		System.out.println(ll.getLastNthElement(nth));
		System.out.println(ll.getLastNthElementfunc(nth));
		
	}
}