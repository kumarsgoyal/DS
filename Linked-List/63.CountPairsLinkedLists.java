import java.util.*;

// Write a function to Count pairs from two linked lists whose sum is equal to 
// a given value

// Another method is add one linkedlist in Hashmap
// iterate over other linked list and if sum - curr.data
// exist in linkedlist count++


class CountPairsLinkedLists {
	
	// head of linkedlist
	Node head1;
	Node head2;

	CountPairsLinkedLists() {
		head1 = new Node(0);
		head2 = new Node(0);
	}

	class Node {
		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public void addElementEnd(Node temp, int num) {
		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(num);
	}

	public void printList(Node temp) {
		System.out.println("\n");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node getMiddle(Node node) {
		if(node == null) {
			return null;
		}

		Node slow = node;
		Node fast = node;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public Node mergeSortedLinkedList(Node a, Node b) {
		if (a == null) 
            return b; 
        if (b == null) 
            return a; 

		Node result = new Node(0); 
		Node ptr = result;

		while(a != null && b != null) {
			if(a.data <= b.data) {
				ptr.next = a;
				a = a.next;
			}
			else {
				ptr.next = b;
				b = b.next;
			}
			ptr = ptr.next;
		}

		while(a != null) {
			ptr.next = a;
			a = a.next;
			ptr = ptr.next;
		}
  		
  		while(b != null) {
  			ptr.next = b;
  			b = b.next;
  			ptr = ptr.next;
  		}
        return result.next; 
	}

	public Node mergeSortLinkedList(Node node) {
		if(node == null || node.next == null) {
			return node;
		}

		Node middle = getMiddle(node);
		Node nextofMiddle = middle.next;
		middle.next = null;

		Node left = mergeSortLinkedList(node);
		Node right = mergeSortLinkedList(nextofMiddle);

		return mergeSortedLinkedList(left, right);

	}

	public Node reverse(Node curr) {
		Node prev = null;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public void countPairsLinkedLists(int sum) {
		head1 = mergeSortLinkedList(head1);
		head2 = mergeSortLinkedList(head2);
		head2 = reverse(head2);

		Node curr1 = head1;
		Node curr2 = head2;
		int count = 0;

		while(curr1 != null && curr2 != null) {
			if((curr1.data + curr2.data) == sum) {
				count++;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}

			else if((curr1.data + curr2.data) > sum) {
				curr2 = curr2.next;
			}
			else {
				curr1 = curr1.next;
			}
		}
	}

	public static void main(String[] args) {
		CountPairsLinkedLists ll = new CountPairsLinkedLists();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int n1 = sc.nextInt();
		for(int i = 0; i < n1; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head1, num);
		}

		System.out.println("Enter the number of element in list");
		int n2 = sc.nextInt();
		for(int i = 0; i < n2; i++) {
			int num = sc.nextInt();
			ll.addElementEnd(ll.head2, num);
		}

		ll.head1 = ll.head1.next;
		ll.head2 = ll.head2.next;

		ll.printList(ll.head1);
		ll.printList(ll.head2);

		System.out.println("Enter the value of sum");
		int sum = sc.nextInt;
		ll.countPairsLinkedLists(sum);
	}
}