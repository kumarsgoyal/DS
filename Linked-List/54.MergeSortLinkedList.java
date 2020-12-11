import java.util.*;

// Write a function to Merge Sort for Linked Lists

class MergeSortLinkedList {
	
	// head of linkedlist
	Node head;

	MergeSortLinkedList() {
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

	public Node getMiddle(Node node) {
		if(node == null) {
			return null;
		}

		Node slow = node;
		Node fast = node;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	// public Node mergeSortedLinkedList(Node a, Node b) {
	// 	Node result = null; 
	// 	if (a == null) 
	// 		return b; 
	// 	if (b == null) 
	// 		return a; 

	// 	if (a.data <= b.data) { 
	// 		result = a; 
	// 		result.next = sortedMerge(a.next, b); 
	// 	} 
	// 	else { 
	// 		result = b; 
	// 		result.next = sortedMerge(a, b.next); 
	// 	}
	// 	return result; 
	// }

	public Node mergeSortedLinkedList(Node a, Node b) {
		if (a == null) 
            return b; 
        if (b == null) 
            return a; 

		Node result = new Node(0); 
		Node ptr = result;

		while(a != null && b != null) {
			if(a.data <= b.data) {
				ptr.next = a;
				a = a.next;
			}
			else {
				ptr.next = b;
				b = b.next;
			}
			ptr = ptr.next;
		}

		while(a != null) {
			ptr.next = a;
			a = a.next;
			ptr = ptr.next;
		}
  		
  		while(b != null) {
  			ptr.next = b;
  			b = b.next;
  			ptr = ptr.next;
  		}
        return result.next; 
	}

	public Node mergeSortLinkedList(Node node) {
		if(node == null || node.next == null) {
			return node;
		}

		Node middle = getMiddle(node);
		Node nextofMiddle = middle.next;
		middle.next = null;

		Node left = mergeSortLinkedList(node);
		Node right = mergeSortLinkedList(nextofMiddle);

		return mergeSortedLinkedList(left, right);

	}

	public static void main(String[] args) {
		MergeSortLinkedList ll = new MergeSortLinkedList();

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
		ll.head = ll.mergeSortLinkedList(ll.head);

		ll.printList();
	}
}