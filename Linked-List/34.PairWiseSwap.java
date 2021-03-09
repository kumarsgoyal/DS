import java.util.*;

// Program for Pairwise swap node of linked list

class PairWiseSwap {
	
	// head of linkedlist
	Node head;

	PairWiseSwap() {
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

	public Node pairWiseSwapRecr(Node node) {

		if(node == null || node.next == null) {
			return node;
		}

		Node newHead = node.next;
		Node remain = node.next.next;
		node.next = pairWiseSwapRecr(remain);
		newHead.next = node;
		return newHead;
	}

	public Node pairWiseSwapItr(Node node) {
		if(node == null || node.next == null) {
			return null;
		}

		Node prev = node;
		Node curr = node.next;
		node = curr;

		while(true) {
			Node next = curr.next;
			curr.next = prev;

			if(next == null || next.next == null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			curr = prev.next;	
		}

		return node;
	}


	public static void main(String[] args) {
		PairWiseSwap ll = new PairWiseSwap();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}

		ll.printList();

		ll.head = ll.pairWiseSwapRecr(ll.head);
		ll.head = ll.pairWiseSwapItr(ll.head);
		System.out.println("");
		ll.printList();
	}
}