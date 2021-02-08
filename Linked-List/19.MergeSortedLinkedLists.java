import java.util.*;

// Program for Merge two sorted linked lists such that merged list is in 
// reverse order


class MergeSortedLinkedLists {
	
	// head of linkedlist
	Node headFirst;
	Node headSecond;
	Node newHead;

	MergeSortedLinkedLists() {
		headFirst = new Node(-1);
		headSecond = new Node(-1);
		newHead = null;
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
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void mergeSortedLinkedLists() {
		newHead = headFirst;
		headFirst = headFirst.next;
		headSecond = headSecond.next;
		Node curr = newHead;

		while(headFirst != null && headSecond != null) {
			if(headFirst.data == headSecond.data) {
				curr.next = headFirst;
				headFirst = headFirst.next;
				curr = curr.next;
				curr.next = headSecond;
				headSecond = headSecond.next;
			}
			else if(headFirst.data < headSecond.data) {
				curr.next = headFirst;
				headFirst = headFirst.next;
			}
			else{
				curr.next = headSecond;
				headSecond = headSecond.next;
			}
			curr = curr.next;
		}

		while(headFirst != null) {
			System.out.println("b");
			curr.next = headFirst;
			headFirst = headFirst.next;
			curr = curr.next;
		}
		while(headSecond != null) {
			System.out.println("c");
			curr.next = headSecond;
			headSecond = headSecond.next;
			curr = curr.next;
		}

		newHead = newHead.next;
	}

	public void reverseLinkedList() {
		Node curr = newHead;
		Node prev = null;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		newHead = prev;
	}

	public static void main(String[] args) {
		MergeSortedLinkedLists ll = new MergeSortedLinkedLists();
		
		// scanner object
		Scanner sc = new Scanner(System.in);


		// size of linked list
		System.out.println("Enter the number of element in list");
		int n1 = sc.nextInt();

		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt(); 
			ll.addElementEnd(ll.headFirst, num); 
		}

		System.out.println("Enter the number of element in list");
		int n2 = sc.nextInt();

		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.headSecond, num);
		}

		ll.printList(ll.headFirst);
		System.out.println("");
		ll.printList(ll.headSecond);

		ll.mergeSortedLinkedLists();
		ll.reverseLinkedList();
		System.out.println("");
		ll.printList(ll.newHead);

	}
}