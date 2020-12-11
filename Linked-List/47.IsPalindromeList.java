import java.util.*;

// Program for check if a linked list of strings forms a palindrome


class IsPalindromeList {
	
	// head of linkedlist
	Node head;
	Node firstHalf, secondHalf;


	IsPalindromeList() {
		head = null;
		firstHalf = null;
		secondHalf = null;
	}

	class Node {
		char data;
		Node next;

		Node(char val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(char c) {
		Node temp = head;
		if(head == null) {
			head = new Node(c);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(c);
		}
	}

	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void reverse() {
		Node curr = secondHalf;
		Node prev = null;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		secondHalf = prev;
	}

	public void listCompare() {
		Node firstList = firstHalf;
		Node secondList =secondHalf;

		while(firstList != null && secondList != null && firstList.data ==
			secondList.data) {
			firstList = firstList.next;
			secondList = secondList.next;
		} 

		if(firstList == secondList && firstList == null) {
			System.out.println("List is Palindrome");
		}
		else {
			System.out.println("List is not Palindrome");
		}
	}

	public void isPalindromeListReverseListMethod() {
		// Get the middle of the linked list.
		// Reverse the second half of the linked list.
		// Check if the first half and second half are identical.
		// Construct the original linked list by reversing the second half
		// again and attaching it back to the first half

		Node slow = head, fast = head;
		Node middleHalf = null, prev = null;

		if(head == null) {
			System.out.println("\n List is empty");
		}
		else if(head != null && head.next == null) {
			System.out.println("\n List is Palindrome");
		}
		else{
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				prev = slow;
				slow = slow.next;
			}

			// odd number of element in list
			if(fast != null) {
				middleHalf = slow;
				slow = slow.next;
			}

			secondHalf = slow;
			firstHalf = head;
			prev.next = null;
			
			reverse();
			listCompare();
			reverse();

			if(middleHalf != null) {
				prev.next = middleHalf;
				middleHalf.next = secondHalf;
			}
			else {
				prev.next = secondHalf;
			}
		}
	}

	public static void main(String[] args) {
		IsPalindromeList ll = new IsPalindromeList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			char c = sc.next().charAt(0);
			ll.addElementEnd(c);
		}

		ll.printList();

		// this method uses O(1) extra space for stack and O(n) time.
		ll.isPalindromeListReverseListMethod();

	}
}