import java.util.*;

// Program for middle of a given linked list


class GetMiddleLinkedList {
	
	// head of linkedlist
	Node head;

	GetMiddleLinkedList() {
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
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}


	public int getMiddleLElement() {
		

		Node fast = head;
		Node slow = head;
		if(fast == null) {
			System.out.println("\nLinked list is empty");
			return -1;
		}
		else {
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow.data;
		}

	}

	public static void main(String[] args) {
		GetMiddleLinkedList ll = new GetMiddleLinkedList();

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
		System.out.println("\n" + ll.getMiddleLElement());

	}
}