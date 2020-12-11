import java.util.*;

// Write a function to Check whether the length of given linked list is Even 
// or Odd

class CheckLengthOddEven {
	
	// head of linkedlist
	Node head;

	CheckLengthOddEven() {
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
		System.out.println("\n");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void checkLengthOddEven() {
		if(head == null) {
			System.out.println("List is empty");
		}

		Node fast = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
		}

		if(fast != null) {
			System.out.println("Length of list is odd");
		}
		else {
			System.out.println("Length of list is even");
		}
	}

	public static void main(String[] args) {
		CheckLengthOddEven ll = new CheckLengthOddEven();

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

		ll.checkLengthOddEven();
		ll.printList();
	}
}