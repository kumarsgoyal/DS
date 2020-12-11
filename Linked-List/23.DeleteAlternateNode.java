import java.util.*;

// Program for Delete alternate nodes of a Linked List


class DeleteAlternateNode {
	
	// head of linkedlist
	Node head;

	DeleteAlternateNode() {
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

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void deleteAlternateNodeRecr(Node node) {
		if((node == null) || node.next == null) {
			return;
		}

		node.next = node.next.next;
		deleteAlternateNodeRecr(node.next);
	}

	public void deleteAlternateNode() {
		Node curr = head;
		while(curr != null && curr.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
		}
	}


	public static void main(String[] args) {
		DeleteAlternateNode ll = new DeleteAlternateNode();

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
		
		// ll.deleteAlternateNode();
		ll.deleteAlternateNodeRecr(ll.head);
		System.out.println("");
		ll.printList();
	}
}