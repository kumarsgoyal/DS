import java.util.*; 

// Transform a BST to greater sum tree

class GreaterSumBST {  

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

    GreaterSumBST() {
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

    public void greaterSumBSTUtil(Node root) {
        if(root == null) {
            return;
        }

        greaterSumBSTUtil(root.right);
        sum = sum + root.data;
        root.data = sum - root.data;
        greaterSumBSTUtil(root.left);
    }

    public  void greaterSumBST() {
        if(root == null) 
            return ;
        greaterSumBSTUtil(root);
    }

    public static void main(String[] args) {  
        GreaterSumBST tree = new GreaterSumBST();  
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

        tree.greaterSumBST();

        tree.preOrder(tree.root);
    }  
};  
     