import java.util.*;

// Write a function to Merge k sorted linked lists

class MergeKSortedLinkedList {
	
	// head of linkedlist
	Node head1;
	Node head2;
	Node head3;
	Node finalList;

	MergeKSortedLinkedList() {
		head1 = new Node(0);
		head2 = new Node(0);
		head3 = new Node(0);
		finalList = null;
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(Node temp, int num) {
		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(num);
	}

	public void printList(Node temp) {
		System.out.println("\n");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void mergeKSortedLinkedList() {

		PriorityQueue<Node> pq = new PriorityQueue<> (new Comparator<Node> () {
			public int compare(Node a, Node b) {
				return a.data - b.data;
			}
		}); 
  

		pq.add(head1);
		pq.add(head2);
		pq.add(head3);

		Node last = null;

		while(pq.isEmpty() == false) {
			Node temp = pq.peek();
			pq.remove();

			if(temp.next != null) {
				pq.add(temp.next);
			}

			if(finalList == null) {
				finalList = temp;
				last = temp;
			}
			else {
				last.next = temp;
				last = last.next;
			}
		}
	}


	public static void main(String[] args) {
		MergeKSortedLinkedList ll = new MergeKSortedLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n1 = sc.nextInt();
		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head1, num);
		}

		System.out.println("Enter the number of element in list");
		int n2 = sc.nextInt();
		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head2, num);
		}


		System.out.println("Enter the number of element in list");
		int n3 = sc.nextInt();
		for(int i = 0; i < n3; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head3, num);
		}

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;
		ll.head3 = ll.head3.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);
		ll.printList(ll.head3);

		ll.mergeKSortedLinkedList();

		ll.printList(ll.finalList);
	}
}