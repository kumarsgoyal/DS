import java.util.*; 

// Sorted Array to Balanced BST


class ArrayToBST {  

    Node root;

    // tree
    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    ArrayToBST() {
        root = null;
    }

    public Node arrayToBSTUtil(int[] arr, int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = (end + start) / 2;
        Node root = new Node(arr[mid]);

        root.left = arrayToBSTUtil(arr, start, mid - 1);
        root.right = arrayToBSTUtil(arr, mid + 1, end);

        return root;
    }

    public Node arrayToBST(int[] arr) {
        return arrayToBSTUtil(arr, 0, arr.length - 1);
    }


    public void printInOrder(Node root) {
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {  
        ArrayToBST tree = new ArrayToBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Start enter elements in sorted order");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        tree.root = tree.arrayToBST(arr);
        tree.printInOrder(tree.root);


    }  
};  
     