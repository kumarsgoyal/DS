import java.util.*; 

// Write a function to Boundary Traversal of binary tree



class BoundaryTraversal {  

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

    BoundaryTraversal() {
        root = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void boundaryTraversalLeft(Node root) {
        if(root == null) {
            return;
        }

        // to avoid print leaf node
        if(root.left != null) {
            System.out.print(root.data + " ");
            boundaryTraversalLeft(root.left);
        }
        else if(root.right != null) {
            System.out.print(root.data + " ");
            boundaryTraversalLeft(root.right);
        }
    }

    public void boundaryTraversalRight(Node root) {
        if(root == null) {
            return;
        }

        // to avoid print leaf nodes
        if(root.right != null) {
            boundaryTraversalRight(root.right);
            System.out.print(root.data + " ");
        }
        else if(root.left != null) {
            boundaryTraversalRight(root.left);
            System.out.print(root.data + " ");
        }
    } 

    public void boundaryTraversalLeaf(Node root) {
        if(root == null) {
            return;
        }

        boundaryTraversalLeaf(root.left);
        if(root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        boundaryTraversalLeaf(root.right);
    }

    public void boundaryTraversal() {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        boundaryTraversalLeft(root.left);
        boundaryTraversalLeaf(root.left);
        boundaryTraversalLeaf(root.right);
        boundaryTraversalRight(root.right);
    }
    
    public void preOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderPrint(root.left);   
        preOrderPrint(root.right);
    }

    public static void main(String[] args) {  
        BoundaryTraversal tree = new BoundaryTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }


        tree.preOrderPrint(tree.root);
        System.out.println("");
        tree.boundaryTraversal();
    }  
};  
     