import java.util.*;

// Program for clone a linked list with next and random pointer

class CloneRandomPointerHash {
	
	// head of linkedlist
	Node head;
	Node clone;

 	CloneRandomPointerHash() {
		head = null;
		clone = null;
	}

	class Node {
		int data;
		Node next;
		Node random;

		Node(int a) {
			data = a;
			next = null;
			random = null;
		}
	}

	public void addElementEnd(int a) {
		Node temp = head;
		if(head == null) {
			head = new Node(a);
		}
		else{
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(a);
		}
	}

	public void printList(Node temp) {
		while(temp != null) {
			System.out.println(temp + " " + temp.data + " " + temp.random);
			temp = temp.next;
		}
	}

	public Node getRandomPointer(int size) {
		Node curr = head; 
		Random rand = new Random(); 
		int random = rand.nextInt(100) % size; 

		while(random > 0) {
			curr = curr.next;
			random--;
		}

		return curr;
	}

	public void setRandomPointer(int size) {
		Node curr = head;
		for(int i = 0; i < size && curr != null; i++) {
			curr.random = getRandomPointer(size-1);
			curr = curr.next;
		}
	}

	public void cloneRandomPointer() {
		if(head == null) {
			return;
		}

		// Hash map which contains node to node mapping of 
        // original and clone linked list. 
		Map<Node, Node> map = new HashMap<Node, Node> ();

		// list's head. 
        Node curr = head;
        Node currClone = null; 
  
        // Traverse the original list and make a copy of that 
        // in the clone linked list. 
        while (curr != null) 
        { 
            currClone = new Node(curr.data); 
            map.put(curr, currClone); 
            curr = curr.next; 
        } 
  
        curr = head; 
  
        // Traversal of original list again to adjust the next 
        // and random references of clone list using hash map. 
        while (curr != null) 
        { 
            currClone = map.get(curr); 
            currClone.next = map.get(curr.next); 
            currClone.random = map.get(curr.random);
            curr = curr.next; 
        } 
  
		clone =	map.get(head); 

	}


	public static void main(String[] args) {
	 	CloneRandomPointerHash ll = new CloneRandomPointerHash();

		// scanner object
		Scanner sc = new Scanner(System.in);

		// size of linked list
		System.out.println("Enter the number of element in list");
		int size = sc.nextInt();

		for(int i = 0; i < size; i++) {
			int a = sc.nextInt();
			ll.addElementEnd(a);
		}

		ll.printList(ll.head);

		ll.setRandomPointer(size);
		ll.cloneRandomPointer();

		System.out.println("");
		ll.printList(ll.head);
		System.out.println("");
		ll.printList(ll.clone);
	}
}
