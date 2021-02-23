import java.util.*; 

// Write a function to print level order traversal

class SpiralLevelOrderTraversal {  

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

    SpiralLevelOrderTraversal() {
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

    public int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh > rh) 
            return (lh + 1);
        return (rh + 1);
    }

    public void spiralLevelOrderTraversalUtil(Node root, boolean flag, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data + " ");
        }
        else if(level > 1) {
            if(flag == true) {
                spiralLevelOrderTraversalUtil(root.left, flag, level - 1);
                spiralLevelOrderTraversalUtil(root.right, flag, level - 1);
            }
            else {
                spiralLevelOrderTraversalUtil(root.right, flag, level - 1);
                spiralLevelOrderTraversalUtil(root.left, flag, level - 1);
            }
        }
    }

    public void spiralLevelOrderTraversal() {
        int h = height(root);
        boolean flag = true;

        for(int i = 1; i <= h; i++) {
            spiralLevelOrderTraversalUtil(root, flag, i);
            flag = !flag;
            System.out.println("");
        }
    } 
    

    public static void main(String[] args) {  
        SpiralLevelOrderTraversal tree = new SpiralLevelOrderTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("");
        tree.spiralLevelOrderTraversal();
    }  
};  
     