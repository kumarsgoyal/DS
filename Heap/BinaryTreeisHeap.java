import java.util.*;


class BinaryTreeisHeap {

	// heap should statisfy 2 properties 
	// 1. complete binary tree
	// 2. min heap or max heap

	static int countNode(BinaryTree root) {
		if(root == null) {
			return 0;
		}

		return (1 + countNode(root.left) + countNode(root.right));
	}

	static boolean isCompleteUtil(BinaryTree root, int index, int count) {
		if(root == null) {
			return true;
		}

		if(index >= count) {
			return false;
		}

		return isCompleteUtil(root.left, index*2 + 1, count) && 
			isCompleteUtil(root.right, index*2 + 2, count);
	}

	static boolean isHeapUtil(BinaryTree root) {
		if(root.left == null && root.right == null) {
			return true;
		}

		if(root.right != null && root.left != null) {
			return ((root.data >= root.left.data &&
						root.data >= root.right.data) && isHeapUtil(root.left) 
						&& isHeapUtil(root.right));
		}
		else if(root.right == null) {
			return root.data >= root.left.data;
		}
		else {
			return false;
		}
	}

	static void isHeap(BinaryTree root) {
		int count = countNode(root);

		if(isCompleteUtil(root, 0, count) && isHeapUtil(root)) {
			System.out.println("Yes it is heap");
		}
		else {
			System.out.println("No it is not heap");
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		
		BinaryTree root = new BinaryTree(10); 
        root.left = new BinaryTree(9); 
        root.right = new BinaryTree(8); 
        root.left.left = new BinaryTree(7); 
        root.left.right = new BinaryTree(6); 
        root.right.left = new BinaryTree(5); 
        root.right.right = new BinaryTree(4); 
        root.left.left.left = new BinaryTree(3); 
        root.left.left.right = new BinaryTree(2); 
        root.left.right.left = new BinaryTree(1); 

        isHeap(root);
	}
}

class BinaryTree {
	int data;
	BinaryTree left, right;

	BinaryTree(int data) {
		this.data = data;
		left = right = null;
	}

}