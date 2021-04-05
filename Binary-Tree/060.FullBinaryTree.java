import java.util.*; 

// Print all full nodes in a Binary Tree

// Given a binary tree, print all nodes will are full nodes. Full Nodes are 
// nodes which has both left and right children as non-empty.


class FullBinaryTree {  
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

    FullBinaryTree() {
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

    public void fullBinaryTree(Node root) {

        if(root != null) {
            fullBinaryTree(root.left);  

            if(root.left != null && root.right != null) {
                System.out.print(root.data + "  ");
            }

            fullBinaryTree(root.right);
        }
    }     

    public static void main(String[] args) {  
        FullBinaryTree tree = new FullBinaryTree();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.fullBinaryTree(tree.root);
    }  
};  
     