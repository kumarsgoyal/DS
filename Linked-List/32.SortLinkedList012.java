import java.util.*;

// Program for Sort a linked list of 0s, 1s and 2s


class SortLinkedList012 {
	
	// head of linkedlist
	Node head;
	int zeroCount, oneCount, twoCount;

	SortLinkedList012() {
		head = null;
		zeroCount = 0;
		oneCount = 0;
		twoCount = 0;
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

	public void sortLinkedList012() {
		Node curr = head;

		while(curr != null) {
			if(curr.data == 0) {
				zeroCount++;
			}
			else if(curr.data == 1) {
				oneCount++;
			} 
			else if(curr.data == 2){
				twoCount++;
			}
			curr = curr.next;
		}

		curr = head;
		while(curr != null) {
			if(zeroCount > 0) {
				zeroCount--;
				curr.data = 0;
			}
			else if(oneCount > 0) {
				oneCount--;
				curr.data = 1;
			}
			else {
				curr.data = 2;
			}
			curr = curr.next;
		}
	}


	public static void main(String[] args) {
		SortLinkedList012 ll = new SortLinkedList012();

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

		ll.sortLinkedList012();

		System.out.println("");
		ll.printList();
	}
}