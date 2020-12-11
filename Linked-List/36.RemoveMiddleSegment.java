import java.util.*;

// given a linked list of line segments, remove middle points


class RemoveMiddleSegment {
	
	// head of linkedlist
	Node head;

 	RemoveMiddleSegment() {
		head = null;
	}

	class Node {
		int x,y;
		Node next;

		Node(int a, int b) {
			x = a;
			y = b;
			next = null;
		}
	}

	public void addElementEnd(int a, int b) {
		Node temp = head;
		if(head == null) {
			head = new Node(a, b);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(a, b);
		}
	}

	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.x + " " + temp.y);
			temp = temp.next;
		}
	}

	public Node removeMiddleSegment(Node node) {
		if(node == null || node.next == null || node.next.next == null) {
			return node;
		}
		System.out.println(node.x + " " + node.y);

		Node next = node.next;
		Node nextNext = node.next.next;

		if(node.x == next.x) {
			System.out.println("a");
			while(nextNext != null && next.x == nextNext.x) {
				System.out.println("aa");
				node.next = nextNext;

				next = nextNext;
				nextNext = next.next;
			}
		}
		else if(node.y == next.y) {
			System.out.println("b");
			while(nextNext != null && next.y == nextNext.y) {
				System.out.println("bb");
				node.next = nextNext;

				next = nextNext;
				nextNext = next.next;
			}
		}
		else {
			System.out.println("List is not valid");
			return null;
		}

		node.next = removeMiddleSegment(node.next);

		return node;

	}


	public static void main(String[] args) {
	 RemoveMiddleSegment ll = new RemoveMiddleSegment();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ll.addElementEnd(a, b);
		}

		ll.printList();

		ll.head = ll.removeMiddleSegment(ll.head);
		System.out.println("");
		ll.printList();
	}
}


/*
	Input:  (0,10)->(1,10)->(5,10)->(7,10)
	                                  |
	                                (7,5)->(20,5)->(40,5)
	Output: Linked List should be changed to following
	        (0,10)->(7,10)
	                  |
	                (7,5)->(40,5) 
	The given linked list represents a horizontal line from (0,10) 
	to (7, 10) followed by a vertical line from (7, 10) to (7, 5), 
	followed by a horizontal line from (7, 5) to (40, 5).

	Input:     (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
	Output: Linked List should be changed to following
	    (2,3)->(12,3) 
	There is only one vertical line, so all middle points are removed.
*/