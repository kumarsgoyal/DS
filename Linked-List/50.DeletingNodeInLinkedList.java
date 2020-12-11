import java.util.*;

// Write a function to delete node at given postion in a Linked List


class DeletingNodeInLinkedList {
	
	// head of linkedlist
	Node head;

	DeletingNodeInLinkedList() {
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

	public void deleteNode(int pos) {
		if(head == null) {
			return;
		}
		else if(pos == 0 && head.next != null) {
			head = head.next;
		}
		else if(pos == 0 && head.next == null) {
			head = null;
		}
		else {
			Node temp = head;
			while(temp != null && pos > 1) {
				pos--;
				temp = temp.next;
			}
			if(temp != null && temp.next != null)  {
				temp.next = temp.next.next;	
			}
		}
	}

	public static void main(String[] args) {
		DeletingNodeInLinkedList ll = new DeletingNodeInLinkedList();

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
		
		System.out.println("\nEnter the postion to delete oth based index");
		int pos = sc.nextInt();
		ll.deleteNode(pos);
		ll.printList();
	}
}