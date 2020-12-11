import java.util.*;

// Program for Remove duplicates from a unsorted 


class RemoveDuplicatesUnsorted {
	
	// head of linkedlist
	Node head;

	RemoveDuplicatesUnsorted() {
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

	public void removeDuplicates() {
		Node curr = head;

		while(curr != null && curr.next != null) {
			Node temp = curr;

			while(temp.next != null) {
				if(temp.next.data == curr.data) {
					temp.next = temp.next.next;
				}
				else {
					temp = temp.next;
				}
 			}

 			curr = curr.next;
		}

	}

	public void removeDuplicatesHashing() {
		HashSet<Integer> hs = new HashSet<>();

		Node curr = head;
		Node prev = null;
		while(curr != null) {
			if(hs.contains(curr.data) == true) {
				prev.next = curr.next;
			} 
			else{
				hs.add(curr.data);
				prev = curr;
			}

			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesUnsorted ll = new RemoveDuplicatesUnsorted();

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

		// this method takes O(n^2) time and O(1) space
		// ll.removeDuplicates();

		// this method takes O(n) time and O(n) space
		ll.removeDuplicatesHashing();

		System.out.println("");
		ll.printList();

	}
}