import java.util.*;

// Write a function to adding two polynomials using Linked List
// Input:
//      1st number = 5x^2 + 4x^1 + 2x^0
//      2nd number = 5x^1 + 5x^0
// Output:
//         5x^2 + 9x^1 + 7x^0
// Input:
//      1st number = 5x^3 + 4x^2 + 2x^0
//      2nd number = 5x^1 + 5x^0
// Output:
//         5x^3 + 4x^2 + 5x^1 + 7x^0


class AddingTwoPolynomial {
	
	// head of linkedlist
	Node head1;
	Node head2;
	Node head3;

	AddingTwoPolynomial() {
		head1 = null;
		head2 = null;
		head3 = null;
	}

	class Node {
		int coeff;
		int pow;
		Node next;

		Node(int a, int b) {
			coeff = a;
			pow = b;
			next = null;
		}
	}

	public Node addElementEnd(Node head, int a, int b) {
		if(head == null) {
			return new Node(a, b);
		}
		else{
			if(head.pow < b) {
				Node temp = new Node(a, b);
				temp.next = head;
				head = temp;
			}
			else {
				Node curr = head;
				while(curr.next != null && curr.next.pow > b) {
					curr = curr.next;
				}

				Node next = curr.next;
				curr.next = new Node(a, b);
				curr.next.next = next;
			}
			return head;
		}
	}

	public void printList(Node temp) {
		System.out.println("\n");
		while(temp != null) {
			System.out.println(temp.coeff + "x^" + temp.pow);
			temp = temp.next;
		}
	}

	public Node addingTwoPolynomial(Node a, Node b) {
		Node dummy = new Node(0,0);
		Node ptr = dummy;
		while(a != null && b != null) {
			if(a.pow == b.pow) {
				ptr.next = new Node(a.coeff + b.coeff, a.pow);
				a = a.next;
				b = b.next;
			}
			else if(a.pow > b.pow) {
				ptr.next = new Node(a.coeff, a.pow);
				a = a.next;
			}
			else {
				ptr.next = new Node(b.coeff, b.pow);
				b = b.next;
			}
			ptr = ptr.next;
		}

		while(a != null) {
			ptr.next = new Node(a.coeff, a.pow);
			a = a.next;
			ptr = ptr.next;
		}

		while(b != null) {
			ptr.next = new Node(b.coeff, b.pow);
			b = b.next;
			ptr = ptr.next;
		}


		return dummy.next;
	}

	public static void main(String[] args) {
		AddingTwoPolynomial ll = new AddingTwoPolynomial();

		// ll.addElementEnd(coeff, power);
		ll.head1 = ll.addElementEnd(ll.head1, 1, 0);
		ll.head1 = ll.addElementEnd(ll.head1, 3, 2);
		ll.head1 = ll.addElementEnd(ll.head1, 5, 3);

		ll.head2 = ll.addElementEnd(ll.head2, 2, 1);
		ll.head2 = ll.addElementEnd(ll.head2, 5, 2);
		ll.head2 = ll.addElementEnd(ll.head2, 1, 0);

		ll.printList(ll.head1);
		ll.printList(ll.head2);
		ll.head3 = ll.addingTwoPolynomial(ll.head1, ll.head2);

		ll.printList(ll.head3);
	}
}