import java.util.*; 

// Ceil from a BST
// Ceil Value Node: Node with smallest data larger than or equal to key value.

class CeilFromBst {  

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

    CeilFromBst() {
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

    public  int ceilFromBst(Node root, int key) {
        if(root == null) {
            return -1;
        }

        if(root.data == key) {
            return root.data;
        }

        // key is present in right subtree
        if(root.data < key) {
            return ceilFromBst(root.right, key);
        }

        // key is smaller than roor.data
        // there are two case
        // 1. root.data can be ceil
        // 2. ceil is from left sub tree
        int ceil = ceilFromBst(root.left, key);

        return (ceil >= key) ? ceil : root.data;

    }

    public static void main(String[] args) {  
        CeilFromBst tree = new CeilFromBst();  
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

        System.out.println("Enter value to find ceil");
        int ceil = sc.nextInt();
        System.out.println(tree.ceilFromBst(tree.root, ceil));
    }  
};  
     