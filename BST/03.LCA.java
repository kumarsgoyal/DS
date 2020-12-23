import java.util.*; 

// Kth ancestor of a node in binary tree

// Create a recursive function that takes a node and the two values n1 and n2.
// If the value of the current node is less than both n1 and n2, then LCA lies 
// in the right subtree. Call the recursive function for thr right subtree.
// If the value of the current node is greater than both n1 and n2, then LCA 
// lies in the left subtree. Call the recursive function for thr left subtree.
// If both the above cases are false then return the current node as LCA.

class LCA {  

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

    LCA() {
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

    public Node lcaUtil(Node root, int a, int b) {
        if(root == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if(root.data > a && root.data > b) {
            return lcaUtil(root.left , a, b);
        }
        if(root.data <  a && root.data < b) {
            return lcaUtil(root.right, a, b);
        }

        return root;
    }


    public void lca(int a,int b) {
        if(root == null) {
            return;
        }

        Node lcaNode = lcaUtil(root, a, b);
        if(lcaNode == null) {
            System.out.println("Node not found");
        }
        else {
            System.out.println("LCA Node:  " + lcaNode.data);
        }
    } 
    

    public static void main(String[] args) {  
        LCA tree = new LCA();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter a value 1 to find lca");
        int a = sc.nextInt();
        System.out.println("Enter a value 1 to find lca");
        int b = sc.nextInt();

        tree.lca(a, b);
    }  
};  
     