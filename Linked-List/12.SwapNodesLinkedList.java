import java.util.*;

// Program for Swap nodes in a linked list


class SwapNodesLinkedList {
	
	// head of linkedlist
	Node head;

	SwapNodesLinkedList() {
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

	public void swapNodesLinkedList(Integer a, Integer b) {
		if(a == b) {
			return;
		}
		else if(head == null) {
			return;
		}
		else {
			Node dummy = new Node(-1);
			dummy.next = head;

			Node aAddress = null, bAddress = null;
			Node curr = dummy;

			while(curr.next != null) {
				if(curr.next.data == a) {
					aAddress = curr;
				}
				else if(curr.next.data == b) {
					bAddress = curr;
				}

				curr = curr.next;
			}

			if(a != null && b != null) {
				Node temp = bAddress.next;
				bAddress.next = aAddress.next;
				aAddress.next = temp;

				temp = bAddress.next.next;
				bAddress.next.next = aAddress.next.next;
				aAddress.next.next = temp;
			}

			head = dummy.next;
		}
	}

	public static void main(String[] args) {
		SwapNodesLinkedList ll = new SwapNodesLinkedList();

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

		System.out.println("\nEnter value of a and b want to swap");
		ll.swapNodesLinkedList(sc.nextInt(), sc.nextInt());

		ll.printList();
	}
}