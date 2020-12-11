import java.util.*;

// porgram for rearrangement of singly linked list
// given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
// rearrange the nodes in the list so that the new formed list is
// : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
// Input:  1 -> 2 -> 3 -> 4
// Output: 1 -> 4 -> 2 -> 3

// Input:  1 -> 2 -> 3 -> 4 -> 5
// Output: 1 -> 5 -> 2 -> 4 -> 3



// Method 1
// 1) Initialize current node as head.
// 2) While next of current node is not null, do following
//     a) Find the last node, remove it from the end and insert it as next
//        of the current node.
//     b) Move current to next to next of current

// Method 2
// 1) Copy contents of given linked list to a deque.
// 2) Rearrange given deque by swapping nodes from both ends.
// 3) Copy the modified deque back to the linked list.



class RearrangelinkedList {
	
	// head of linkedlist
	Node head;
	Node temp;
	int flag = 0;

	RearrangelinkedList() {
		head = null;
		temp = null;
	}

	class Node {
		int data;
		Node next;

		Node(int a) {
			data = a;
			next = null;
		}
	}

	public void addElementEnd(int a) {
		if(head == null) {
			head = new Node(a);
		}
		else{
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(a);
		}
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void rearrangelinkedList() {
		temp = head;
		rearrangelinkedListUtil(head);


	}

	public void rearrangelinkedListUtil(Node curr) {
		if(curr == null) {
			return;
		}

		rearrangelinkedListUtil(curr.next);
		if(flag == 1) {
			return;
		}

		curr.next = null;
		// odd && even
		if((temp == curr) || (temp.next == curr)) {
			// indication that he have reach middle so stop working
			flag = 1;
			return;
		}
		Node next = temp.next;
		temp.next = curr;
		curr.next = next;
		temp = next;
	}


	public static void main(String[] args) {
	 	RearrangelinkedList ll = new RearrangelinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int a = sc.nextInt();
			ll.addElementEnd(a);
		}

		ll.printList(ll.head);

		ll.rearrangelinkedList();

		System.out.println("");
		ll.printList(ll.head);
	}
}
