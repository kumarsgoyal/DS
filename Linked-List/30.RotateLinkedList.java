import java.util.*;

// Program for rotate a linked list


class RotateLinkedList {
	
	// head of linkedlist
	Node head;

	RotateLinkedList() {
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

	public void rotateLinkedList(int k) {
		if(k == 0) {
			return;
		}

		Node curr = head;
		int count = 1;
		while(curr != null && count < k) {
			count++;
			curr = curr.next;
		}

		// value of k >= size of linked list
		if(curr == null) {
			return;
		}

		Node kthNode = curr; // kth node

		while(curr.next != null) {
			curr = curr.next;
		}

		curr.next = head;
		head = kthNode.next;
		kthNode.next = null;

	}


	public static void main(String[] args) {
		RotateLinkedList ll = new RotateLinkedList();

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

		System.out.println("\nEnter the value of k");
		int k = sc.nextInt();

		ll.rotateLinkedList(k);

		System.out.println("");
		ll.printList();
	}
}