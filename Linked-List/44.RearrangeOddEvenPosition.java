import java.util.*;

// Rearrange a linked list such that all even and odd positioned nodes are 
// together
// Input:   1->2->3->4
// Output:  1->3->2->4

// Input:   10->22->30->43->56->70
// Output:  10->30->56->22->43->70



class RearrangeOddEvenPosition {
	
	// head of linkedlist
	Node head;
	Node listA;
	Node listB;

	RearrangeOddEvenPosition() {
		head = null;
		listA = null;
		listB = null;
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

	public Node reverse(Node temp) {
		Node prev = null;
		Node curr = temp;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public void contcat() {
		Node dummy = new Node(-1);
		Node ptrDummy = dummy;

		Node curr = listA;
		while(curr != null) {
			ptrDummy.next = curr;
			curr = curr.next;
			ptrDummy = ptrDummy.next;
		}

		curr = listB;
		while(curr != null) {
			ptrDummy.next = curr;
			curr = curr.next;
			ptrDummy = ptrDummy.next;
		}

		head = dummy.next;
	}

	public void split() {
		Node dummyA = new Node(-1);
		Node dummyB = new Node(-1);
		Node curr = head;
		boolean flag = true;

		listA = dummyA;
		listB = dummyB;

		while(curr != null) {
			if(flag == true) {
				listA.next = curr;
				listA = listA.next;
			}
			else {
				listB.next = curr;
				listB = listB.next;
			}
			curr = curr.next;
			flag = !flag;
		}
		listB.next = null;
		listA.next = null;

		listA = dummyA.next;
		listB = dummyB.next;
	}

	public void rearrangeOddEvenPosition() {
		split();
		contcat();
		listA = null;
		listB = null;
	}

	public static void main(String[] args) {
	 	RearrangeOddEvenPosition ll = new RearrangeOddEvenPosition();

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

		ll.rearrangeOddEvenPosition();

		System.out.println("");
		ll.printList(ll.head);
	}
}
