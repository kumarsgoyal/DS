import java.util.*;

// Program for intersection of two Sorted Linked Lists


class IntersectionLinkedLists {
	
	// head of linkedlist
	Node headFirst;
	Node headSecond;
	Node newHead;

	IntersectionLinkedLists() {
		headFirst = null;
		headSecond = null;
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

	public void intialise() {
		headFirst = new Node(-1);
		headSecond = new Node(-1);
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

	public void intersectionLinkedLists() {

		newHead = headFirst;
		headFirst = headFirst.next;
		headSecond = headSecond.next;
		Node curr = newHead;

		while(headFirst != null && headSecond != null) {
			if(headFirst.data == headSecond.data) {
				curr.next = headFirst;
				headFirst = headFirst.next;
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
			curr.next = headFirst;
			headFirst = headFirst.next;
			curr = curr.next;
		}
		while(headSecond != null) {
			curr.next = headSecond;
			headSecond = headSecond.next;
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		IntersectionLinkedLists ll = new IntersectionLinkedLists();
		
		// scanner object
		Scanner sc = new Scanner(System.in);

		ll.intialise();

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
		ll.printList(ll.headSecond);

		ll.intersectionLinkedLists();
		System.out.println("");
		ll.printList(ll.newHead);

	}
}