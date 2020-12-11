import java.util.*;

// Write a function  to subtract two numbers represented as linked lists
// num1 = 100 : 1->0->0->null;
// num2 = 12: 1->2->null;

class SubtractTwoNumbersLinkedLists {
	
	// head of linkedlist
	Node head1;
	Node head2;
	Node result;
	boolean borrow;

	SubtractTwoNumbersLinkedLists() {
		head1 = new Node(-1);
		head2 = new Node(-1);
		result = null;
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
		System.out.println("\n");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node paddZero(Node curr, int num) {
		while(num > 0) {
			num--;
			Node temp = new Node(0);
			temp.next = curr;
			curr = temp;
		}

		return curr;
	}

	public Node subtractTwoNumbersLinkedListsUtil(Node curr1, Node curr2) {
		if(curr1 == null && curr2 == null) {
			return null;
		}

		Node prev = subtractTwoNumbersLinkedListsUtil(curr1.next, curr2.next);

		int num1 = curr1.data;
		int num2 = curr2.data;

		if(borrow == true) {
			num1--;
			borrow = false;
		}

		if(num1 < num2) {
			borrow = true;
			num1 = num1 + 10;
		}

		int sub = num1 - num2;

		Node curr = new Node(sub);
		curr.next = prev;

		return curr;

	}

	public Node subtractTwoNumbersLinkedLists(Node curr1, Node curr2, int n1, int n2) {
		if(curr1 == null && curr2 == null) {
			return new Node(0);
		}
		else if(curr1 == null || curr2 == null) {
			if(curr1 != null) {
				return curr1;
			}
			else {
				return curr2;
			}
		}
		else {
			Node large = null; 
			Node small = null; 
			int flag = 0;

			// length is not same
			if(n1 != n2) { 
				large = n1 > n2 ? curr1 : curr2; 
				small = n1 < n2 ? curr1 : curr2; 

				small = paddZero(small, Math.abs(n1 - n2));
			}
			else {
				while(curr1 != null && curr2 != null) {
					if(curr1.data != curr2.data) {
						small = curr1.data < curr2.data ? head1 : head2;
						large = curr1.data > curr2.data ? head1 : head2;
						flag = 1;
						break;
					}
					curr1 = curr1.next;
					curr2 = curr2.next;
				}

				if(flag == 0) {
					large = head1;
					small = head2;
				}
			}
			return subtractTwoNumbersLinkedListsUtil(large, small);
		}
	}

	public static void main(String[] args) {
		SubtractTwoNumbersLinkedLists ll = new SubtractTwoNumbersLinkedLists();

		// scanner object
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of digit in element");
		int n1 = sc.nextInt();
		System.out.println("Enter the digit of element in list one by one");
		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head1, num);
		}

		System.out.println("Enter the number of digit in element");
		int n2 = sc.nextInt();
		System.out.println("Enter the digit of element in list one by one");
		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head2, num);
		}

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);
		ll.result = ll.subtractTwoNumbersLinkedLists(ll.head1, ll.head2, n1, n2);
		System.out.print("\nresult:");
		ll.printList(ll.result);
	}
}