import java.util.*; 

// BST to a Tree with sum of all smaller keys



class SmallerKeyBST {  

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

    SmallerKeyBST() {
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

    public void smallerKeyBSTUtil(Node root) {
        if(root == null) {
            return;
        }

        smallerKeyBSTUtil(root.left);
        sum = sum + root.data;
        root.data = sum;
        smallerKeyBSTUtil(root.right);
    }

    public  void smallerKeyBST() {
        if(root == null) 
            return ;
        smallerKeyBSTUtil(root);
    }

    public static void main(String[] args) {  
        SmallerKeyBST tree = new SmallerKeyBST();  
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

        tree.smallerKeyBST();

        tree.preOrder(tree.root);
    }  
};  
     