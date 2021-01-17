import java.util.*;

// Program for Detect loop length in a linked list


class FindLoopLength {
	
	// head of linkedlist
	Node head;

	FindLoopLength() {
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


	public int detectLoop() {
		Node fast = head;
		Node slow = head;
		if(head == null) {
			System.out.println("\nLinked list is empty");
			return -1;
		}
		else {
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if(slow == fast) {
					return findLoopLength(slow, fast);
				}
			}
		}
		return 0;
	}

	public int findLoopLength(Node first, Node second) {
		int len = 0;
		do{
			len++;
			first = first.next;
		}while(first != second);

		return len;
	}

	public void insertLoop(int n) {
		Node temp = head;
		Node storeLoopAdd = null;

		if(n == 0) {
			n++;
		}

		while(n > 0) {
			n--;
			storeLoopAdd = temp;
			temp = temp.next;
		}
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = storeLoopAdd;
	}

	public static void main(String[] args) {
		FindLoopLength ll = new FindLoopLength();

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

		if(n > 0) {
			Random rand = new Random(); 
			ll.insertLoop(rand.nextInt(100)%n);
		}
		System.out.println("\n" + ll.detectLoop());

	}
}