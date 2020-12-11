import java.util.*;

// Program for Reverse alternate a Linked List in groups


class ReverseAlternateGroups {
	
	// head of linkedlist
	Node head;

	ReverseAlternateGroups() {
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

	public Node reverseAlternateGroupsUtil(Node currHead, int k, boolean flag) {

		if(currHead == null) {
			return null;
		}

		Node curr = currHead;
		Node prev = null;
		Node next = null;
		int count = 0;

		while(count < k && curr != null) {
			next = curr.next;

			if(flag == true) {
				curr.next = prev;
			}

			prev = curr;
			curr = next;
			count++;
		}

		if(flag == true) {
			currHead.next = reverseAlternateGroupsUtil(curr, k, !flag);
			return prev;
		}
		else {
			prev.next = reverseAlternateGroupsUtil(curr, k, !flag);
			return currHead;
		}

	}

	public void reverseAlternateGroups(int k) {
		head = reverseAlternateGroupsUtil(head, k, true);
	}


	public static void main(String[] args) {
		ReverseAlternateGroups ll = new ReverseAlternateGroups();

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
		System.out.println("Enter the size of group");
		int size = sc.nextInt();
		
		ll.reverseAlternateGroups(size);
		System.out.println("");
		ll.printList();
	}
}