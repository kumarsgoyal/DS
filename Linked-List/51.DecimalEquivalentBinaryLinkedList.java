import java.util.*;

// Write a function to Decimal Equivalent of Binary Linked List
// Input  : 0->0->0->1->1->0->0->1->0
// Output : 50   


class DecimalEquivalentBinaryLinkedList {
	
	// head of linkedlist
	Node head;

	DecimalEquivalentBinaryLinkedList() {
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
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void decimalEquivalentBinaryLinkedList() {
		int res = 0;  
  		Node curr = head;

  		while(curr != null) {
        	res = (res << 1) + ((curr.data == 1) ? 1 : 0);  
        	curr = curr.next;
  		}

  		System.out.println(res);
	}

	public static void main(String[] args) {
		DecimalEquivalentBinaryLinkedList ll = 
			new DecimalEquivalentBinaryLinkedList();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}

		ll.decimalEquivalentBinaryLinkedList();
	}
}