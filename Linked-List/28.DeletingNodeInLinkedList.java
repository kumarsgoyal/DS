import java.util.*;

// Write a function to delete node in a Linked List
// 1) It must accept a pointer to the start node as the first parameter and 
// node to be deleted as the second parameter i.e., a pointer to head node is
// not global.
// 2) It should not return a pointer to the head node.
// 3) It should not accept pointer to pointer to the head node.


class DeletingNodeInLinkedList {
	
	// head of linkedlist
	Node head;

	DeletingNodeInLinkedList() {
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

	public void deleteNode(Node key) {

		if(head == null || head == null) {
			return;
		}
		else if(head == key && head.next == null) {
			head = null;
		}
		else if(head == key && head.next != null) {
			head.data = head.next.data;
			head.next = head.next.next;
		}
		else {
			Node temp = head;
			while(temp != null && temp.next != null && temp.next != key) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
	}

	public Node getNode(int size) {
		Random rand = new Random(); 
		int rand_int = rand.nextInt(100);
		rand_int = rand_int % size;

		Node curr = head; 
		while(curr != null && rand_int > 0) {
			curr = curr.next;
			rand_int--;
		}
		return curr;
	}

	public static void main(String[] args) {
		DeletingNodeInLinkedList ll = new DeletingNodeInLinkedList();

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
		
		System.out.println("\nEnter the element to delete");
		Node key = ll.getNode(n);
		ll.deleteNode(key);
		ll.printList();
	}
}