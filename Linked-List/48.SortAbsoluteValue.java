import java.util.*;

// Program for sort linked list which is already sorted on absolute values
// Input : 1 -> -2 -> -3 -> 4 -> -5 
// output: -5 -> -3 -> -2 -> 1 -> 4 

class SortAbsoluteValue {
	
	// head of linkedlist
	Node head;


	SortAbsoluteValue() {
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

	public void sortAbsoluteValue() {
		Node curr = head.next;
		Node prev = head;

		while(curr != null) {
			if(curr.data < prev.data) {
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev;
			}
			else {
				prev = curr;
			}
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		SortAbsoluteValue ll = new SortAbsoluteValue();

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

		ll.sortAbsoluteValue();
		System.out.println("");
		ll.printList();

	}
}