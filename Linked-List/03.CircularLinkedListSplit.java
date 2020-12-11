import java.util.*;

// split circular into two

class CircularLinkedListSplit {
	
	// head of linkedlist
	Node head;
	Node head1;
	Node head2;
	Node last;

	CircularLinkedListSplit() {
		head = null;
		last = null;
		head1 = null;
		head2 = null;
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


	public void printList(Node temp, Node head) {
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

	public void splitHalf() {

		if(head.next == head) {
			head1 = head;
			head2 = null;
			return;
		}
		Node slow = head;
		Node fast = head;
		Node middle = null;

		while(fast.next != head && fast.next.next != head) {
			middle = slow; 
			fast = fast.next.next; 
			slow = slow.next; 
		} 

		if(fast.next != head) {
			middle = slow;
			slow = slow.next;
		}

		head1 = head;
		middle.next = head1;

		head2 = slow;
		last.next = head2;

	}

	public static void main(String[] args) {
		CircularLinkedListSplit cl = new CircularLinkedListSplit();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			cl.addElement(num);
		}

		cl.printList(cl.head, cl.head);
		cl.splitHalf();
		cl.printList(cl.head1, cl.head1);
		cl.printList(cl.head2, cl.head2);
		
	}
}




/*
	1----->2----->3----->4----->5
	c      c      c
	f             f             f
	1----->2----->3----->4----->5----->6
	c      c      c
	f             f             f 		      
*/