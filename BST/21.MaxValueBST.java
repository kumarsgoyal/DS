import java.util.*; 

// Find the node with maximum value in a Binary Search Tree

class MaxValueBST {  

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

    MaxValueBST() {
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

    public  void maxValueBST() {
        if(root == null) {
            System.out.println("Tree is empty. ");
            return ;
        }

        while(root.right != null) {
            root = root.right;
        }
        System.out.println("Maximum value is: " + root.data);
    }

    public static void main(String[] args) {  
        MaxValueBST tree = new MaxValueBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preOrder(tree.root);
        System.out.println("");

        tree.maxValueBST();
    }  
};  
     