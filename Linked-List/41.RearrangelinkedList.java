import java.util.*;

// porgram for rearrangement of singly linked list
// given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
// rearrange the nodes in the list so that the new formed list is
// : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
// Input:  1 -> 2 -> 3 -> 4
// Output: 1 -> 4 -> 2 -> 3

// Input:  1 -> 2 -> 3 -> 4 -> 5
// Output: 1 -> 5 -> 2 -> 4 -> 3


// 1) Find the middle point using tortoise and hare method.
// 2) Split the linked list into two halves using found middle point in step 1.
// 3) Reverse the second half.
// 4) Do alternate merge of first and second halves. 



class RearrangelinkedList {
	
	// head of linkedlist
	Node head;

	RearrangelinkedList() {
		head = null;
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

	public void contcat(Node a, Node b) {

		Node curr = new Node(-1);
		head = curr;
		while(a != null && b != null) {
			curr.next = a;
			a = a.next;
			curr = curr.next;
			curr.next = b;
			b = b.next;
			curr = curr.next;
		}

		if(a != null) {
			curr.next = a;
			a = a.next;
		}

	}

	public void rearrangelinkedList() {
		Node curr = head;
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = head;

		fast = reverse(fast);

		contcat(slow, fast);
		head = head.next;
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
