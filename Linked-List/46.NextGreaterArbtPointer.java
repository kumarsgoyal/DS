import java.util.*;

// Point arbt pointer to greatest value right side node in a linked list

// Given singly linked list with every node having an additional “arbitrary” 
// pointer that currently points to NULL. We need to make the “arbitrary” 
// pointer to greatest value node in a linked list on its right side.



class NextGreaterArbtPointer {
	
	// head of linkedlist
	Node head;
	Node reverseHead;

	NextGreaterArbtPointer() {
		head = null;
		reverseHead = null;
	}

	class Node {
		int data;
		Node next;
		Node arbt;

		Node(int a) {
			data = a;
			next = null;
			arbt = null;
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
			System.out.print("\n" + temp.data + " ");
			if(temp.arbt != null) {
				System.out.print(temp.arbt.data + " ");
			}
			else {
				System.out.print("- ");
			}
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


	public void nextGreaterArbtPointer() {
		reverseHead = reverse(head);
		Node curr = reverseHead;
		Node nextarbt = null;

		while(curr != null) {
			if(nextarbt == null) {
				nextarbt = curr;
			}
			else {
				curr.arbt = nextarbt;
				if(curr.data > nextarbt.data) {
					nextarbt = curr;
				}
			}

			curr = curr.next;
		}
		
		head = reverse(reverseHead);

	}

	public static void main(String[] args) {
	 	NextGreaterArbtPointer ll = new NextGreaterArbtPointer();

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

		ll.nextGreaterArbtPointer();

		System.out.println("");
		ll.printList(ll.head);
	}
}
