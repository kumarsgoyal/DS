import java.util.*;

// Program for Swap nodes in a linked list


class PairWiseSwapNodesLinkedList {
	
	// head of linkedlist
	Node head;
	Node currrec;

	PairWiseSwapNodesLinkedList() {
		head = null;
		currrec = null;
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

	public void swapNodesLinkedListItr() {
		Node curr = head;
		
		while(curr != null && curr.next != null) {
			int k = curr.data;
			curr.data = curr.next.data;
			curr.next.data = k;

			curr = curr.next.next;
		}
	}

	public void swapNodesLinkedListRcrUtil() {
		if(currrec != null && currrec.next != null) {
			int k = currrec.data;
			currrec.data = currrec.next.data;
			currrec.next.data = k;

			currrec = currrec.next.next;
			swapNodesLinkedListRcrUtil();
		}
	}

	public void swapNodesLinkedListRcr() {
		currrec = head;
		swapNodesLinkedListRcrUtil();
	}

	public static void main(String[] args) {
		PairWiseSwapNodesLinkedList ll = new PairWiseSwapNodesLinkedList();

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

		ll.swapNodesLinkedListItr();
		System.out.println("");
		ll.printList();

		ll.swapNodesLinkedListRcr();
		System.out.println("");
		ll.printList();
	}
}