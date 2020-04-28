/*
A Binary Heap is a Binary Tree with following properties.

1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.


The root element will be at Arr[0].

Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
Arr[(i-1)/2]	Returns the parent node
Arr[(2*i)+1]	Returns the left child node
Arr[(2*i)+2]	Returns the right child node

*/

import java.util.*;

class  MaxHeap {
	static int size;
	static ArrayList<Integer> heap;

	static int getLeftchild(int pos) {
		if(pos > size) {
			// System.out.println("Out of Bound");
			return -1;
		}
		int leftchildpos = (pos  * 2) + 1;

		if(leftchildpos > size) {
			// System.out.println("No left child");
			return -1;
		}
		else {
			return leftchildpos;
		}
	}

	static int getRightchild(int pos) {
		if(pos > size) {
			// System.out.println("Out of Bound");
			return -1;
		}
		int rightchildpos = (pos  * 2) + 2;

		if(rightchildpos > size) {
			// System.out.println("No right child");
			return -1;
		}
		else {
			return rightchildpos;
		}
	}

	static boolean isLeaf(int pos) {
		if(size % 2 == 1) {
			if(size / 2 > pos) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			if(size / 2 >= pos) {
				return false;
			}
			else {
				return true;
			}
		}

		// or you can find if it is left child then it is not leaf child
	}

	static void swapElement(int pos1, int pos2) {
		int temp = heap.get(pos1);
		heap.set(pos1, heap.get(pos2));
		heap.set(pos2, temp);
	}

	static void insert(int value) {
		size++;
		heap.add(value);
	}

	// static void heapify(int pos) {
	// 	if(!isLeaf(pos)) {
	// 		int leftchild = getLeftchild(pos);
	// 		int rightchild = getRightchild(pos);
	// 		// it is leaf child and having both left and right child
	// 		if(leftchild != -1 && rightchild != -1) {
	// 			if((heap.get(leftchild) > heap.get(pos)) || 
	// 				(heap.get(rightchild) > heap.get(pos))) {
	// 				if(heap.get(leftchild) > heap.get(rightchild)) {
	// 					// System.out.print("swap with left child");
	// 					swapElement(pos, leftchild); 
	// 					heapify(leftchild);
	// 				}
	// 				else {
	// 					// System.out.print("swap with right child");
	// 					swapElement(pos, rightchild);
	// 					heapify(rightchild);
	// 				}
	// 			}
	// 		}
	// 		// it is not left child and having only one child i.e. left child
	// 		// no need to call maxheapify futher
	// 		else if(leftchild != -1 && heap.get(leftchild) > heap.get(pos)){
	// 			// System.out.print("swap with left child");
	// 			swapElement(pos, leftchild);
	// 		}
	// 	}
	// }

	static void heapify(int pos) {
		
	}

	static void print() {
		System.out.print(heap);
	}

	static void heapsort() {
		for(int i = size/2 ; i >= 0; i--) {
			heapify(i);
		}

		int sizeofheap = size;
		for(int i = sizeofheap; i > 0; i--) {
			swapElement(0, i);
			size--;
			heapify(0);
		}

		size = sizeofheap;
	}

	public static void main(String[] args) {
		size = -1;
		heap = new ArrayList<Integer> ();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of element in heap");
		int t = sc.nextInt();

		for(int i = 0; i < t; i++) {
			int temp = sc.nextInt();
			insert(temp);
		}
		heapsort();
		print();

	}
}

/*

10 // no of node in heap
10
20
35
30
23
19
25
15
39
40
*/