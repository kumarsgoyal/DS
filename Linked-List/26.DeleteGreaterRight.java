import java.util.*;

// Program for delete nodes which have a greater value on right side


class DeleteGreaterRight {
	
	// head of linkedlist
	Node head;

	DeleteGreaterRight() {
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

	public void deleteGreaterRight() {
		reverseList();
		deleteGreaterRightUtil();
		reverseList();
	}

	public void deleteGreaterRightUtil() {
		Node maxNode = head;
		Node curr = head;

		while(curr != null && curr.next != null) {
			if(curr.next.data < maxNode.data) {
				curr.next = curr.next.next;
			}
			else {
				maxNode = curr.next;
				curr = curr.next;
			}
		}
	}

	public void reverseList() {
		Node curr = head;
		Node next = null;
		Node prev = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}


	public static void main(String[] args) {
		DeleteGreaterRight ll = new DeleteGreaterRight();

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
		ll.deleteGreaterRight();
		System.out.println("");
		ll.printList();
	}
}