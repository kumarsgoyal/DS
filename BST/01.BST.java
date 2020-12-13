import java.util.*; 

// Write a function to create and find element

class BST {  

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

    BST() {
        root = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else if(root.data > num) {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public  boolean find(Node root, int xele) {
        if(root == null) {
            return false;
        }
        if(root.data == xele) {
            return true;
        }

        if(root.data > xele) {
            return find(root.left, xele);
        }   
        else {
            return find(root.right, xele);
        }
    }

    public static void main(String[] args) {  
        BST tree = new BST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preOrder(tree.root);

        System.out.println("Enter want to find");
        int xele = sc.nextInt();
        
        if(tree.find(tree.root, xele) == true) {
            System.out.println("Element exist");
        }
        else {
            System.out.println("Element not exist");
        }
    }  
};  
     