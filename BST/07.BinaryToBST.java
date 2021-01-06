import java.util.*; 

// Binary Tree to Binary Search Tree Conversion
// Given a Binary Tree, convert it to a Binary Search Tree.The conversion must 
// be done in such a way that keeps the original structure of Binary Tree.


class BinaryToBST {  

    Node root;
    PriorityQueue<Integer> pQueue;

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

    BinaryToBST() {
        root = null;
        pQueue = new PriorityQueue<Integer>(); 
    }

    public void addNode() {
        root = new Node(6);
        root.left = new Node(7);
        root.left.right = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.right = new Node(14);
        root.right.left = new Node(16);
        root.right.left.left = new Node(18);
        root.right.left.left.left = new Node(19);
        root.right.left.left.right = new Node(17);
        root.right.left.right = new Node(20);
    }

    public void getinOrder(Node root) {
        if(root == null) {
            return;
        }

        getinOrder(root.left);
        pQueue.add(root.data);
        getinOrder(root.right);
    }

    public void setInorder(Node root) {
        if(root == null) {
            return;
        }

        setInorder(root.left);
        root.data = pQueue.poll();
        setInorder(root.right);
    }

    public void binaryToBST() {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
        getinOrder(root);
        setInorder(root);

    }

    public void printPreOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {  
        BinaryToBST tree = new BinaryToBST();  
        Scanner sc = new Scanner(System.in);

        tree.addNode();
        tree.printPreOrder(tree.root);
        System.out.println("");
        tree.binaryToBST();
        tree.printPreOrder(tree.root);
    }  
};  
     