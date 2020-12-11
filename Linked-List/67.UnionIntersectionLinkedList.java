import java.util.*;

// Write a function to Merge two sorted linked lists

class UnionIntersectionLinkedList {
	
	// head of linkedlist
	Node head1;
	Node head2;
	Node union;
	Node interSection;

	UnionIntersectionLinkedList() {
		head1 = new Node(0);
		head2 = new Node(0);
		union = null;
		interSection = null;
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

	public void unionLinkedList() {
		Node dummy = new Node(0);
		Node ptr = dummy;

		Node curr1 = head1;
		Node curr2 = head2;

		while(curr1 != null && curr2 != null) {
			if(ptr.data == curr1.data) {
				curr1 = curr1.next;
			}
			if(ptr.data == curr2.data) {
				curr2 = curr2.next;
			}
			else if(ptr.data != curr1.data && curr1.data == curr2.data) {
				ptr.next = new Node(curr1.data);
				curr1 = curr1.next;
				curr2 = curr2.next;
				ptr = ptr.next;
			}
			else if(curr1.data < curr2.data && curr1.data != ptr.data) {
				ptr.next = new Node(curr1.data);
				curr1 = curr1.next;
				ptr = ptr.next;
			}
			else if(curr2.data < curr1.data && curr2.data != ptr.data){
				ptr.next = new Node(curr2.data);
				curr2 = curr2.next;
				ptr = ptr.next;
			}
		}

		while(curr1 != null) {
			if(ptr.data == curr1.data) {
				curr1 = curr1.next;
			}
			else {
				ptr.next = new Node(curr1.data);
				curr1 = curr1.next;
				ptr = ptr.next;
			}
		}

		while(curr2 != null) {
			if(ptr.data == curr2.data) {
				curr2 = curr2.next;
			}
			else {
				ptr.next = new Node(curr2.data);
				curr2 = curr2.next;
				ptr = ptr.next;
			}
		}
		ptr.next = null;

		union = dummy.next;
	}

	public void intersectionLinkedList() {
		Node dummy = new Node(0);
		Node ptr = dummy;

		Node curr1 = head1;
		Node curr2 = head2;

		while(curr1 != null && curr2 != null) {
			if(curr1.data == curr2.data) {
				ptr.next = new Node(curr1.data);
				ptr = ptr.next;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			else if(curr1.data < curr2.data) {
				curr1 = curr1.next;
			}
			else {
				curr2 = curr2.next;
			}
		}
		ptr.next = null;
		interSection = dummy.next;
	}


	public static void main(String[] args) {
		UnionIntersectionLinkedList ll = new UnionIntersectionLinkedList();

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

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);

		ll.head1 = ll.mergeSortLinkedList(ll.head1);
		ll.head2 = ll.mergeSortLinkedList(ll.head2);

		ll.unionLinkedList();
		ll.intersectionLinkedList();

		System.out.println("\nUnion:");
		ll.printList(ll.union);
		System.out.println("\nIntersection:");
		ll.printList(ll.interSection);
	}
}