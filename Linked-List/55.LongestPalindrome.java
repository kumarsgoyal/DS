import java.util.*;

// Write a function to find length of the longest palindrome list that exist in
// that linked list.

class LongestPalindrome {
	
	// head of linkedlist
	Node head;

	LongestPalindrome() {
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

	public int getCount(Node a, Node b) { 
		int count = 0;

		while(a != null && b != null) {
			if(a.data != b.data) {
				break;
			}
			count++;
			a = a.next;
			b = b.next;
		}
  
		return count; 
	}

	public void longestPalindrome() {
		int result = 0;
		Node prev = null, curr = head;

		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;

			result = Math.max(result, 2*getCount(prev, next) + 1);
			result = Math.max(result, 2*getCount(curr, next));
			
			prev = curr;
			curr = next;
		}

		System.out.println("Longest length of palindrome " + result);

	}

	public static void main(String[] args) {
		LongestPalindrome ll = new LongestPalindrome();

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
		ll.longestPalindrome();
	}
}