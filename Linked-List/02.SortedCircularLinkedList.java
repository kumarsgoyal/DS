import java.util.*;

// insert in circular linkedlist in sorted order

class SortedCircularLinkedList {
	
	// head of linkedlist
	Node head;
	Node last;

	SortedCircularLinkedList() {
		head = null;
		last = null;
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElement(int num) {
		Node temp = new Node(num);
		if(head == null) {
			head = last = temp;
			head.next = head;
		}
		else {
			Node curr = head;
			if(num < head.data) {
				temp.next = head;
				head = temp;
				last.next =temp;
			}
			else {
				while(curr.next != head && num > curr.next.data) {
					curr = curr.next;
				}
				temp.next = curr.next;
				curr.next = temp;
			}
		}
	}


	public void printList() {
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while(temp != head);
	}

	public static void main(String[] args) {
		SortedCircularLinkedList cl = new SortedCircularLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			cl.addElement(num);
		}

		cl.printList();
		
	}
}