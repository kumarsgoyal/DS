import java.util.*;

// porgram for Sort a linked list that is sorted alternating
//  ascending and descending orders
// Input List: 10 -> 40 -> 53 -> 30 -> 67 -> 12 -> 89 -> NULL
// Output List: 10 -> 12 -> 30 -> 43 -> 53 -> 67 -> 89 -> NULL
// 
// Input List: 1 -> 4 -> 3 -> 2 -> 5 -> NULL
// Output List: 1 -> 2 -> 3 -> 4 -> 5 -> NULL

// 1) Find the middle point using tortoise and hare method.
// 2) Split the linked list into two halves using found middle point in step 1.
// 3) Reverse the second half.
// 4) Do alternate merge of first and second halves. 



class SortedAlternating {
	
	// head of linkedlist
	Node head;
	Node listA;
	Node listB;

	SortedAlternating() {
		head = null;
		listA = null;
		listB = null;
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

	public void contcat() {
		Node currA = listA;
		Node currB = listB;
		Node dummy = new Node(-1);
		Node ptrDummy = dummy;
		while(currA != null && currB != null) {
			if(currA.data <= currB.data) {
				ptrDummy.next = currA;
				currA = currA.next;
			}
			else {
				ptrDummy.next = currB;
				currB = currB.next;
			}
			ptrDummy = ptrDummy.next;
		}

		while(currA != null) {
			ptrDummy.next = currA;
			currA = currA.next;
			ptrDummy = ptrDummy.next;
		}

		while(currB != null) {
			ptrDummy.next = currB;
			currB = currB.next;
			ptrDummy = ptrDummy.next;
		}

		head = dummy.next;
	}

	public void split() {
		Node dummyA = new Node(-1);
		Node dummyB = new Node(-1);
		Node curr = head;
		boolean flag = true;
		listA = dummyA;
		listB = dummyB;

		while(curr != null) {
			if(flag == true) {
				listA.next = curr;
				listA = listA.next;
			}
			else {
				listB.next = curr;
				listB = listB.next;
			}
			curr = curr.next;
			flag = !flag;
		}
		listB.next = null;
		listA.next = null;

		listA = dummyA.next;
		listB = dummyB.next;
	}

	public void sortedAlternating() {
		split();
		listB = reverse(listB);
		contcat();
		listA = null;
		
		listB = null;
	}

	public static void main(String[] args) {
	 	SortedAlternating ll = new SortedAlternating();

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

		ll.sortedAlternating();

		System.out.println("");
		ll.printList(ll.head);
	}
}
