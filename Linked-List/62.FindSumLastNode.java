import java.util.*;

// Write a function to Find the sum of last n nodes of the given Linked List

class FindSumLastNode {
	
	// head of linkedlist
	Node head;

	FindSumLastNode() {
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

	public void findSumLastNode(int n, int len) {
		if(head == null) {
			// len == 0
			System.out.println("List is empty");
		}
		else if(n == 0) {
			System.out.println("0");
		}
		else if(len < n){
			System.out.println("Size of linked list small");	
		}
		else {
			Node curr = head;
			int t = len - n;
			int sum = 0;

			while(t > 0) {
				t--;
				curr = curr.next;
			}

			while(curr != null) {
				sum = sum + curr.data;
				curr = curr.next;
			}

			System.out.print("Sum :" + sum);

		}

	}

	public static void main(String[] args) {
		FindSumLastNode ll = new FindSumLastNode();

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

		System.out.println("Enter the number nodes");
		int n1 = sc.nextInt();

		ll.findSumLastNode(n1, n);
	}
}