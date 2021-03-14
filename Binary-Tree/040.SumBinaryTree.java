import java.util.*; 

// Check for Children Sum Property in a Binary Tree

class SumBinaryTree {  

    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    SumBinaryTree () {
        root = null;
    }

    public void addValue() {
        root = new Node(10); 
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.left.right = new Node(5); 
        root.right.right = new Node(2); 
    }
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public boolean sumBinaryTree(Node root) {
        if(root == null) {
            return true;
        } 
        if(root.left == null && root.right == null) {
            return true;
        }

        int left = 0, right = 0;

        if(root.left != null) 
            left = root.left.data;
        if(root.right != null)
            right = root.right.data;

        if((root.data == left + right) && (sumBinaryTree(root.left) == true) && 
            (sumBinaryTree(root.right) == true)) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {  
        SumBinaryTree tree = new SumBinaryTree();  
        Scanner sc = new Scanner(System.in);

        tree.addValue();
        tree.inOrderPrint(tree.root); 
        System.out.println(""); 
        if(tree.sumBinaryTree(tree.root) == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     