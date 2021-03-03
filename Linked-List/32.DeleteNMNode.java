import java.util.*;

// Program for Delete N nodes after M nodes of a linked list


class DeleteNMNode {
	
	// head of linkedlist
	Node head;

	DeleteNMNode() {
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

	public void deleteNMNode(int n, int m) {

		Node curr = head;
		int count;
		if(n == 0) {
			for(count = 1; count <= m && curr != null; count++) {
				curr = curr.next;
			}
			head = curr;
		}
		else {
			for(count = 1; count < n && curr != null; count++) {
				curr = curr.next;
			}

			// number of nodes skip is larger than size of linked list
			if(curr == null) {
				return;
			}

			Node temp = curr.next;
			for(count = 1; count <= m && temp != null; count++) {
				temp = temp.next;
			}

			curr.next = temp;
		}

	}


	public static void main(String[] args) {
		DeleteNMNode ll = new DeleteNMNode();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(num);
		}

		ll.printList();
		System.out.println("Enter the number of element to skip and" +
			"number element to Delete");
		 int N = sc.nextInt();
		 int M = sc.nextInt();

		ll.deleteNMNode(N, M);

		System.out.println("");
		ll.printList();
	}
}