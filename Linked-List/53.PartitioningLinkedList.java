import java.util.*;

// Write a function to Partitioning a linked list around a given value and 
// keeping the original order
// Input : 1->4->3->2->5->2->3, 
//         x = 3
// Output: 1->2->2->3->3->4->5

// Input : 1->4->2->10 
//         x = 3
// Output: 1->2->4->10

// Input : 10->4->20->10->3 
//         x = 3
// Output: 3->10->4->20->10 


class PartitioningLinkedList {
	
	// head of linkedlist
	Node head;

	PartitioningLinkedList() {
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
		System.out.println("\n");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void partitioningLinkedList(int x) {
		// Initialize first and last nodes of below three linked lists as NULL.
		// Linked list of values smaller than x.
		// Linked list of values equal to x.
		// Linked list of values greater than x.
		// Now iterate through the original linked list. If a node’s value is 
		// less than x then append it at the end of smaller list. If the value
		// is equal to x, then at the end of equal list. And if value is 
		// greater, then at the end of greater list.
		// Now concatenate three lists.
		
		Node smallHead = new Node(0);
		Node equalHead = new Node(0);
		Node greaterHead = new Node(0);
		Node smallLast = smallHead, equalLast = equalHead, greaterLast = greaterHead;

		Node curr = head;

		while(curr != null) {
			if(curr.data < x) {
				smallLast.next = curr;
				smallLast = smallLast.next;
			}
			else if(curr.data == x) {
				equalLast.next = curr;
				equalLast = equalLast.next;
			}
			else {
				greaterLast.next = curr;
				greaterLast = greaterLast.next;
			}
			curr = curr.next;
		}

		greaterLast.next = null;
		equalLast.next = greaterHead.next;
		smallLast.next = equalHead.next;
		head = smallHead.next;

	}

	public static void main(String[] args) {
		PartitioningLinkedList ll = new PartitioningLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}
		System.out.println("Enter the value");
		int x = sc.nextInt();

		ll.printList();
		ll.partitioningLinkedList(x);

		ll.printList();
	}
}