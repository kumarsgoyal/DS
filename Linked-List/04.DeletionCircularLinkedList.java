import java.util.*;

// delete element from circular linkedlist

class DeletionCircularLinkedList {
	
	// head of linkedlist
	Node head;
	Node last;

	DeletionCircularLinkedList() {
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
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
	}


	public void printList(Node head) {
		Node temp = head;
		if(temp == null) {
			System.out.println("List is Empty");
			return;
		}
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while(temp != head);
		System.out.println("");
	}

	public void deleteValue(int num) {
		Node curr = head;

		// list is empty
		if(head == null) {
			return;
		}
		// if single value in list is num
		else if(head.next == head && head.data == num){
			head = null;
			return;
		}
		// if single value in list and is not num
		else if(head.next == head) {
			return;
		}
		// if list is having values more than 1 and head is num
		else if(head.data == num) {
			head = head.next;
			last.next = head;
		}
		else {
			while(curr.next != head && curr.next.data != num) {
				curr = curr.next;
			}

			if(curr.next != head) {
				curr.next = curr.next.next;
			}
		}

	}

	public static void main(String[] args) {
		DeletionCircularLinkedList cl = new DeletionCircularLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			cl.addElement(num);
		}

		cl.printList(cl.head);
		System.out.println("Delete element from linkedlist enter value");
		int del = sc.nextInt();
		cl.deleteValue(del);
		cl.printList(cl.head);
		
	}
}
