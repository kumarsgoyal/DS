import java.util.*;

// Program for Reverse alternate odd and even a Linked List


class AlternateOddEvenGroups {
	
	// head of linkedlist
	Node head;

	AlternateOddEvenGroups() {
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

	public void printList(Node temp) {
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void alternateOddEvenGroups() {
		Node newNode = new Node(-1);
		Node dummyOdd = new Node(-1);
		Node dummyEven = new Node(-1);

		Node tempodd = dummyOdd;
		Node tempeven = dummyEven;
		Node curr = head;

		while(curr != null) {
			if(curr.data % 2 == 0) {
				tempeven.next = curr;
				tempeven = tempeven.next;
			}
			else {
				tempodd.next = curr;
				tempodd = tempodd.next;
			}
			curr = curr.next;
		}

		tempodd.next = null;
		tempeven.next = null;

		tempodd = dummyOdd.next;
		tempeven = dummyEven.next;

		curr = newNode;
		while(tempodd != null && tempeven != null) {
			curr.next = tempodd;
			tempodd = tempodd.next;
			curr = curr.next;

			curr.next = tempeven;
			tempeven = tempeven.next;
			curr = curr.next;
		}

		head = newNode;
		while(tempodd != null) {
			curr.next = tempodd;
			tempodd = tempodd.next;
			curr = curr.next;
		}
		while(tempeven != null) {
			curr.next = tempeven;
			tempeven = tempeven.next;
			curr = curr.next;
		}

	}


	public static void main(String[] args) {
		AlternateOddEvenGroups ll = new AlternateOddEvenGroups();

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
		
		ll.alternateOddEvenGroups();
		System.out.println("");
		ll.printList();
	}
}