import java.util.*;

// Write a function to Multiply two numbers represented by Linked Lists

class MultiplyTwoNumbers {
	
	// head of linkedlist
	Node head1;
	Node head2;

	MultiplyTwoNumbers() {
		head1 = new Node(0);
		head2 = new Node(0);
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

	public void multiplyTwoNumbers() {
		Node curr1 = head1;
		Node curr2 = head2;
		long num1 = 0, num2 = 0;

		while(curr1 != null || curr2 != null) {
			if(curr1 != null) {
				num1 = num1 * 10 + curr1.data;
				curr1 = curr1.next;
			}
			if(curr2 != null) {
				num2 = num2 * 10 + curr2.data;
				curr2 = curr2.next;
			}
		}

		System.out.println("\n" + num1*num2);
	}

	public static void main(String[] args) {
		MultiplyTwoNumbers ll = new MultiplyTwoNumbers();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n1 = sc.nextInt();
		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head1, num);
		}

		System.out.println("Enter the number of element in list");
		int n2 = sc.nextInt();
		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head2, num);
		}

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);

		ll.multiplyTwoNumbers();
	}
}