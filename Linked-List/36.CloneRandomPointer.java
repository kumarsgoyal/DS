import java.util.*;

// Program for clone a linked list with next and random pointer

class CloneRandomPointer {
	
	// head of linkedlist
	Node head;
	Node clone;

 	CloneRandomPointer() {
		head = null;
		clone = null;
	}

	class Node {
		int data;
		Node next;
		Node random;

		Node(int a) {
			data = a;
			next = null;
			random = null;
		}
	}

	public void addElementEnd(int a) {
		Node temp = head;
		if(head == null) {
			head = new Node(a);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(a);
		}
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.println(temp + " " + temp.data + " " + temp.random);
			temp = temp.next;
		}
	}

	public Node getRandomPointer(int size) {
		Node curr = head; 
		Random rand = new Random(); 
		int random = rand.nextInt(100) % size; 

		while(random > 0) {
			curr = curr.next;
			random--;
		}

		return curr;
	}

	public void setRandomPointer(int size) {
		Node curr = head;
		for(int i = 0; i < size && curr != null; i++) {
			curr.random = getRandomPointer(size-1);
			curr = curr.next;
		}
	}

	public void cloneRandomPointer() {
		if(head == null) {
			return;
		}

		Node curr = head;

		while(curr != null) {
			Node temp = new Node(curr.data);
			temp.next = curr.next;
			curr.next = temp;
			curr = curr.next.next;
		}

		curr = head;

		while(curr != null) {
			curr.next.random = (curr.random != null) ? curr.random.next 
				: curr.random;
			curr = curr.next.next;
		}

		clone = head.next;

		curr = head;
		Node currClone = head.next;
		while(curr != null && currClone != null) {
			curr.next = curr.next.next;
			// if clone list pointer is on last node
			currClone.next = (currClone.next != null) ? currClone.next.next 
				: null;

			curr = curr.next;
			currClone = currClone.next;
		}
	}


	public static void main(String[] args) {
	 	CloneRandomPointer ll = new CloneRandomPointer();

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

		ll.setRandomPointer(size);
		ll.cloneRandomPointer();

		System.out.println("");
		ll.printList(ll.head);
		System.out.println("");
		ll.printList(ll.clone);
	}
}
