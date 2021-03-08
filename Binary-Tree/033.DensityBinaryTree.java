import java.util.*; 

// Write a function to find Density of Binary Tree in One Traversal
// Formula: Density of Binary Tree = Size / Height 



class DensityBinaryTree {  

    Node root;
    int size;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    DensityBinaryTree() {
        root = null;
        size = 0;
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

    public int densityBinaryTreeUtil(Node root) {
        if(root == null)
            return 0;

        size += 1;
        int l = densityBinaryTreeUtil(root.left);
        int r = densityBinaryTreeUtil(root.right);

        if(l > r) 
            return l + 1;
        return r + 1;
    }

    public void densityBinaryTree() {
        if(root == null) {
            return;
        }

        int height = densityBinaryTreeUtil(root);
        System.out.println((double)size / height);
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
        DensityBinaryTree tree = new DensityBinaryTree();  
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
        tree.densityBinaryTree();
    }  
};  
     