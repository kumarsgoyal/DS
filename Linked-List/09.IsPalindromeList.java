import java.util.*;

// Program for find given linked list is palindrome or not


class IsPalindromeList {
	
	// head of linkedlist
	Node head;
	Node firstHalf, secondHalf;

	Node left;

	IsPalindromeList() {
		head = null;
		firstHalf = null;
		secondHalf = null;
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

	public void isPalindromeListStackMethod() {
		// Traverse the given list from head to tail and push every visited
		// node to stack.
		// Traverse the list again. For every visited node, pop a node from
		// stack and compare data of popped node with currently visited node.
		// If all nodes matched, then return true, else false.

		Stack<Integer> stk = new Stack<Integer>();

		Node temp = head;
		while(temp != null) {
			stk.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while(temp != null && stk.empty() == false) {
			if(temp.data == stk.peek()) {
				temp = temp.next;
				stk.pop();
			}
			else {
				break;
			}
		}

		if(stk.empty() == true) {
			System.out.println("List is Palindrome");
		}
		else {
			System.out.println("List is not Palindrome");
		}

	}

	public boolean isPalindromeReccursionUtil(Node right) {
		left = head;

		// end of linked list base case
		if(right == null) {
			return true;
		}

		boolean ip = isPalindromeReccursionUtil(right.next);

		if(ip == false) {
			return false;
		}

		boolean ip1 = (right.data == left.data);

		left = left.next;

		return ip1;
	}

	public void isPalindromeReccursion() {
		if(isPalindromeReccursionUtil(head) == true) {
			System.out.println("List is Palindrome");
		}
		else {
			System.out.println("List is not Palindrome");
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
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}

		ll.printList();

		// this method uses O(n) extra space for stack and O(n) time.
		ll.isPalindromeListStackMethod();

		// this method uses O(1) extra space for stack and O(n) time.
		ll.isPalindromeListReverseListMethod();

		ll.isPalindromeReccursion();
	}
}