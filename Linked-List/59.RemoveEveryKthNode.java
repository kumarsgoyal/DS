import java.util.*;

// Write a function to Remove every k-th node of the linked list

class RemoveEveryKthNode {
	
	// head of linkedlist
	Node head;

	RemoveEveryKthNode() {
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
		System.out.println("\n");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void removeEveryKthNode(int k) {
		if(k == 1 || head == null) {
			head = null;
			return;
		}
		Node curr = head; 
		Node prev = null;
		int count = 0;

		while(curr != null) {
			count++;

			if(count == k) {
				count = 0;
				prev.next = curr.next;
				curr = prev.next;
			}
			else {
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public static void main(String[] args) {
		RemoveEveryKthNode ll = new RemoveEveryKthNode();

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
		System.out.println("Enter the value of k");
		int k = sc.nextInt();
		ll.removeEveryKthNode(k);
		ll.printList();
	}
}