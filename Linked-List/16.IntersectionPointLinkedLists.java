import java.util.*;

// Program for intersection point of two Sorted Linked Lists


class IntersectionPointLinkedLists {
	
	// head of linkedlist
	Node headFirst;
	Node headSecond;

	IntersectionPointLinkedLists() {
		headFirst = null;
		headSecond = null;
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

	public int findLength(Node temp) {
		int len = 0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}

		return len;
	}

	public void intersectionLinkedListsUtil(int len1, int len2, Node head1,
	 	Node head2) {

		int abs = len2 - len1;
		int result = -1;
		while(abs > 0) {
			head2 = head2.next;
			abs--;
		}

		while(head1 != null && head2 != null) {
			if(head1.data != head2.data) {
				result = -1;
			}
			else if(head1.data == head2.data && result == -1) {
				result = head1.data;
			}

			head1 = head1.next;
			head2 = head2.next;
		}

		System.out.println("\n" + result);

	}

	public void intersectionLinkedLists() {
		int len1 = findLength(headFirst);
		int len2 = findLength(headSecond);

		if(len1 < len2) {
			intersectionLinkedListsUtil(len1, len2, headFirst, headSecond);
		}
		else {
			intersectionLinkedListsUtil(len2, len1, headSecond, headFirst);
		}
		
	}

	public static void main(String[] args) {
		IntersectionPointLinkedLists ll = new IntersectionPointLinkedLists();
		
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
		System.out.println("");
		ll.printList(ll.headSecond);

		ll.intersectionLinkedLists();

	}
}