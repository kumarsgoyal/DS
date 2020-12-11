import java.util.*;

// Program for Reverse a Linked List in groups


class ReverseLinkedListGroups {
	
	// head of linkedlist
	Node head;

	ReverseLinkedListGroups() {
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

	public Node reverseLinkedListGroupsRecUtil(Node currHead, int k) {
		
		// this case coverted in below program
		// if(currHead == null) {
		// 	return currHead;
		// }

		Node curr = currHead;
		Node prev = null;
		Node next = null;
		int count = 0;

		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if(curr != null) {
			currHead.next = reverseLinkedListGroupsRecUtil(next, k);
		}

		return prev;
	}

	public void reverseLinkedListGroupsRec(int k) {
		head = reverseLinkedListGroupsRecUtil(head, k);
	}

	public void reverseLinkedListGroupsItr(int k) {
		Node curr = head;
		Stack<Node> stk = new Stack<>();
		Node prev = null;

		while(curr != null) {
			int count = 0;
			while(curr != null && count < k) {
				stk.push(curr);
				curr = curr.next;
				count++;
			}

			while(stk.size() > 0) {
				if(prev == null) {
					prev = stk.pop();
					head = prev;
				}
				else {
					prev.next = stk.pop();
					prev = prev.next;
				}
			}
		}

		prev.next = null;
	}

	public static void main(String[] args) {
		ReverseLinkedListGroups ll = new ReverseLinkedListGroups();

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
		
		ll.reverseLinkedListGroupsRec(size);
		System.out.println("");
		ll.printList();

		ll.reverseLinkedListGroupsItr(size);
		System.out.println("");
		ll.printList();
	}
}