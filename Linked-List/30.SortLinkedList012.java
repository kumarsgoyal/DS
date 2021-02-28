import java.util.*;

// Program for Sort a linked list of 0s, 1s and 2s by changing links


class SortLinkedList012 {
	
	// head of linkedlist
	Node head;

	SortLinkedList012() {
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

	public void sortLinkedList012() {
		Node zeroDummy = new Node(-1);
		Node oneDummy = new Node(-1);
		Node twoDummy = new Node(-1);
		Node zero = zeroDummy;
		Node one = oneDummy;
		Node two = twoDummy;
		Node curr = head;

		while(curr != null) {
			if(curr.data == 0) {
				zero.next = curr;
				zero = zero.next;
			}
			else if(curr.data == 1) {
				one.next = curr;
				one = one.next;
			}
			else if(curr.data == 2){
				two.next = curr;
				two = two.next;
			}
			curr = curr.next;
		}

		two.next = null;
		one.next = twoDummy.next;
		zero.next = oneDummy.next;
		head = zeroDummy.next;

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