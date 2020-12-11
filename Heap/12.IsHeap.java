import java.util.*;

// Check if a given Binary Tree is Heap
// heap follow two property
// 1.) it is complete binary tree
// 2.) it should follow min heap heap or max heap property

class  IsHeap {

	Tree root;

	static class Tree {
		int data;
		Tree left, right;

		Tree(int key) {
			data = key;
			left = right = null;
		}
	}

	public int getCount(Tree root) {
		if(root == null) {
			return 0;
		}

		return (1 + getCount(root.left) + getCount(root.right));
	}

	public boolean isCompleteTree(Tree root, int index, int count) {
		if(root == null) {
			return true;
		}

		if(index >= count) {
			return false;
		}

		return (isCompleteTree(root.left, 2 * index + 1, count) &&
			isCompleteTree(root.right, 2 * index + 2, count));
	}

	public boolean isHeapUtil(Tree root) {
		if(root.left == null && root.right == null) {
			return true;
		}
		else if(root.right == null) {
			return root.data <= root.left.data; 
		}
		else {
			return (root.data <= root.left.data && root.data <= root.right.data) && 
			 (isHeapUtil(root.left) && isHeapUtil(root.right));
		}
	}

	public boolean isHeap() {
		if(root == null) {
			return true;
		}	

		int count = getCount(root);

		return (isCompleteTree(root, 0, count) && isHeapUtil(root));
	}

    public static void main(String[] args) {
    	IsHeap heap = new IsHeap();
    	Scanner sc = new Scanner(System.in);

    	heap.root = new Tree(1);
    	heap.root.left = new IsHeap.Tree(2);
    	heap.root.right = new Tree(3);
    	heap.root.left.left = new Tree(4);
    	heap.root.left.right = new Tree(5);
    	heap.root.right.left = new Tree(6);
    	heap.root.right.right = new Tree(7);
    	// heap.root.left.left.left = new Tree(3);

    	System.out.println(heap.isHeap());


    }
}