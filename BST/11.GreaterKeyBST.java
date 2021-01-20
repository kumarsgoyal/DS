import java.util.*; 

// Convert a BST to a Binary Tree such that sum of all greater keys is added 
// to every key


class GreaterKeyBST {  

    Node root;
    int sum;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    GreaterKeyBST() {
        root = null;
        sum = 0;
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

    public void greaterKeyBSTUtil(Node root) {
        if(root == null) {
            return;
        }

        greaterKeyBSTUtil(root.right);
        sum = sum + root.data;
        root.data = sum;
        greaterKeyBSTUtil(root.left);
    }

    public  void greaterKeyBST() {
        if(root == null) 
            return ;
        greaterKeyBSTUtil(root);
    }

    public static void main(String[] args) {  
        GreaterKeyBST tree = new GreaterKeyBST();  
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

        tree.greaterKeyBST();

        tree.preOrder(tree.root);
    }  
};  
     